package utils.page_object_factory.annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.Annotations;
import utils.manager.ApplicationPropManager;
import utils.object_repository.JSONRepository;
import utils.object_repository.json_schema.ElementSchema;

import java.lang.reflect.Field;
import java.util.Arrays;

public class DynamicElementAnnotation extends Annotations {
    private final Field field;
    private final JSONRepository jsRepo;

    public DynamicElementAnnotation(Field field){
        super(field);
        this.field = field;
        this.jsRepo = ApplicationPropManager.getJSONRepository();
    }

    @Override
    public By buildBy() {
        By locateBy;
        DynamicElement repo = field.getAnnotation(DynamicElement.class);
        if(repo == null){
            locateBy = super.buildByFromDefault();
            return locateBy;
        }

        ElementSchema elementSchema = jsRepo.root()
                .page()
                .element(
                        jsRepo.root().page().get(repo.page())
                ).get(repo.element());

        Object[] params = Arrays.copyOf(repo.params(), repo.params().length, Object[].class);
        String locatorValue = String.format(elementSchema.getValue(), params);
        if(elementSchema.getLocator().equalsIgnoreCase("name")){
            locateBy = By.name(locatorValue);
        }else if(elementSchema.getLocator().equalsIgnoreCase("css")){
            locateBy = By.cssSelector(locatorValue);
        }else{
            locateBy = By.xpath(locatorValue);
        }
        return locateBy;
    }
}
