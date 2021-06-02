package utils.page_object_factory.annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.Annotations;
import utils.manager.ApplicationPropManager;
import utils.object_repository.JSONRepository;
import utils.object_repository.json_schema.ElementSchema;

import java.lang.reflect.Field;


public class JsonRepoAnnotation extends Annotations {
    private final Field field;
    private final JSONRepository jsRepo;

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

        return locateBy;
    }
}
