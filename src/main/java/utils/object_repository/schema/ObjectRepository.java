package utils.object_repository.schema;

import base.Runner;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class ObjectRepository {

    private final String objRepoJsonFileName;
    private final List<Page> pages;
    private final Root root;

    public ObjectRepository() {
        this.objRepoJsonFileName = Objects.requireNonNull(Runner.class.getClassLoader().getResource("objRepository.json")).getPath().substring(1);
        this.root = (Root) deserializeJson(Paths.get(this.objRepoJsonFileName).toFile(), Root.class);
        this.pages = getPageList();
    }

    private Object deserializeJson(Object jsonObject, Class<?> className) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        try{
            if(jsonObject instanceof File){
                return mapper.readValue((File)jsonObject, className);
            }
            String jsonValue = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
            /*if(jsonObject instanceof ArrayList){
                return mapper.readValue(jsonValue, mapper.getTypeFactory()
                        .constructCollectionType(List.class, className));
            }*/
            return mapper.readValue(jsonValue, className);
        }
        catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }

    private List<Page> getPageList() {
        return root.getPages()
                .stream()
                .map(x-> (Page) deserializeJson(x, Page.class))
                .collect(Collectors.toList());
    }

    public List<Page> getPages(){
        return pages;
    }

    private List<Page> filterPage(Page page){
        return getPages()
                .stream()
                .filter(x->x.getPageName().equalsIgnoreCase(page.getPageName()))
                .collect(Collectors.toList());
    }

    public List<Element> getElements(Page page) {
        return filterPage(page).get(0).getElements();
    }

    public Element getElement(Page page, String elementIdentifier){
        List<Element> element = getElements(page)
                .stream()
                .filter(x->x.getIdentifier().equalsIgnoreCase(elementIdentifier))
                .collect(Collectors.toList());
        return element.get(0);
    }


    public Root getRoot(){
        return root;
    }

    public String getObjRepoJsonFileName() {
        return objRepoJsonFileName;
    }

}
