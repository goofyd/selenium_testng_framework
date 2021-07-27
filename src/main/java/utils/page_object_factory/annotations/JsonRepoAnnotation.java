package utils.page_object_factory.annotations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.Annotations;
import utils.manager.ApplicationPropManager;
import utils.object_repository.JSONRepository;
import utils.object_repository.json_schema.ElementSchema;

import java.lang.reflect.Field;


public class JsonRepoAnnotation extends Annotations {
    private final Field field;
    private final JSONRepository jsRepo;
    protected Logger logger = LogManager.getLogger(this.getClass());

    public JsonRepoAnnotation(Field field) {
        super(field);
        this.field = field;
        jsRepo = ApplicationPropManager.getJSONRepository();
    }

    @Override
    public By buildBy() {
        By locateBy;
        JsonRepo repo = field.getAnnotation(JsonRepo.class);
        if(repo == null){
            locateBy = super.buildByFromDefault();
            return locateBy;
        }

        ElementSchema elementSchema = jsRepo.root()
                                .page()
                                .element(
                                        jsRepo.root().page().get(repo.page())
                                ).get(repo.element());

        if(elementSchema.getLocator().equalsIgnoreCase("name")){
            locateBy = By.name(elementSchema.getValue());
        }else if(elementSchema.getLocator().equalsIgnoreCase("css")){
            locateBy = By.cssSelector(elementSchema.getValue());
        }else{
            locateBy = By.xpath(elementSchema.getValue());
        }
        logger.info(String.format("Found Element %s",elementSchema));

        return locateBy;
    }
}
