package utils.object_repository;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.object_repository.json_schema.ElementSchema;
import utils.object_repository.json_schema.PageSchema;
import utils.object_repository.json_schema.RootSchema;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class JSONRepository implements ObjectRepository {

    private final RootSchema root;
    private String objRepoJsonFileName;
    private static final String DEFAULT_FILE_NAME = "objRepository.json";
    protected Logger logger = LogManager.getLogger(this.getClass());

    public JSONRepository() throws FileNotFoundException {
        init();
        this.root = (RootSchema) deserializeJson(Paths.get(getJSONFile()).toFile(), RootSchema.class);
    }

    private void init() throws FileNotFoundException {
        String propertyFileName = System.getProperty("obj.repo.name");
        String tempFileName = (propertyFileName == null)? DEFAULT_FILE_NAME : propertyFileName;
        if(propertyFileName==null)
            logger.warn("No System Property for 'obj.repo.name' set. Using the default file name '" + DEFAULT_FILE_NAME + "' under resource folder");
        try{
            setJSONFile(Objects.requireNonNull(JSONRepository.class.getClassLoader().getResource(tempFileName)).getPath().substring(1));
        }catch(Exception e){
            logger.error(e.toString());
            throw new FileNotFoundException("The File Name " + tempFileName + " doesn't exist in the resource folder!" );
        }
    }

    public void setJSONFile(String objRepoJsonFileName){
        this.objRepoJsonFileName = objRepoJsonFileName;
    }

    public String getJSONFile(){
        return this.objRepoJsonFileName;
    }

    private Object deserializeJson(Object jsonObject, Class<?> className) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        try{
            if(jsonObject instanceof File){
                return mapper.readValue((File)jsonObject, className);
            }
            String jsonValue = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
            return mapper.readValue(jsonValue, className);
        }
        catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Root root() {
        return new JSONRepository.ObjectRepositoryRoot(root);
    }

    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    protected class ObjectRepositoryRoot implements Root{
        private final @Getter RootSchema root;

        @Override
        public Page page() {
            return new JSONRepository.ObjectRepositoryPage(root);
        }
    }

    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    protected class ObjectRepositoryPage implements Page{
        private final @Getter RootSchema root;

        @Override
        public PageSchema get(String pageName) {
            List<PageSchema> page = root.getPages().stream()
                    .filter(x->x.getPageName().equalsIgnoreCase(pageName))
                    .collect(Collectors.toList());
            if(page.isEmpty()){
                throw new IllegalArgumentException("The Page Name " + pageName + " doesn't Exist in the JSON Repository!");
            }
            return page.get(0);
        }

        @Override
        public Element element(PageSchema page) {
            return new JSONRepository.ObjectRepositoryElement(page);
        }
    }

    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    protected class ObjectRepositoryElement implements Element{
        private final @Getter PageSchema page;

        @Override
        public ElementSchema get(String elementName) {
            List<ElementSchema> element = page.getElements()
                    .stream()
                    .filter(x->x.getIdentifier().equalsIgnoreCase(elementName))
                    .collect(Collectors.toList());
            if(element.isEmpty()){
                throw new IllegalArgumentException("The Element Identifier " + elementName + " doesn't Exist under the Page "+page.getPageName()+" in the JSOn Repository!");
            }
            return element.get(0);
        }
    }
}
