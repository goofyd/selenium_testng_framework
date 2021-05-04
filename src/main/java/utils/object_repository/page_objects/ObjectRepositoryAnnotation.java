package utils.object_repository.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.Annotations;
import utils.object_repository.JSONRepository;
import utils.object_repository.JsonRepo;
import utils.object_repository.json_schema.ElementSchema;

import java.io.FileNotFoundException;
import java.lang.reflect.Field;


public class ObjectRepositoryAnnotation extends Annotations {
    private Field field;

    public ObjectRepositoryAnnotation(Field field) {
        super(field);
        this.field = field;
    }

    public By buildBy() {
        By locateBy = null;
        JsonRepo repo = field.getAnnotation(JsonRepo.class);

        if(repo == null){
            locateBy = super.buildByFromDefault();
            return locateBy;
        }
        JSONRepository jsRepo;
        try {
            jsRepo = new JSONRepository();
            ElementSchema elementSchema = jsRepo.root()
                                            .page()
                                            .element(
                                                    jsRepo.root().page().get(repo.page())
                                            ).get(repo.element());
            if(elementSchema.getLocator().equalsIgnoreCase("name")){
                locateBy = By.name(elementSchema.getValue());
            }else{
                locateBy = By.xpath(elementSchema.getValue());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if(locateBy == null){
            throw new IllegalArgumentException("Cannot determine "+field);
        }

        return locateBy;
    }
}
