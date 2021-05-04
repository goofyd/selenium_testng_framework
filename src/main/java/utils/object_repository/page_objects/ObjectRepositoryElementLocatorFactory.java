package utils.object_repository.page_objects;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.pagefactory.Annotations;
import org.openqa.selenium.support.pagefactory.DefaultElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import utils.object_repository.JsonRepo;

import java.lang.reflect.Field;

public class ObjectRepositoryElementLocatorFactory implements ElementLocatorFactory {

    private final SearchContext context;

    public ObjectRepositoryElementLocatorFactory(SearchContext context){
        this.context = context;
    }

    @Override
    public ElementLocator createLocator(Field field) {
        JsonRepo findByAnnotation = field.getAnnotation(JsonRepo.class);
        if(findByAnnotation == null){
            return new DefaultElementLocator(this.context, new Annotations(field));
        }
        return new ObjectRepositoryElementLocator(this.context, new ObjectRepositoryAnnotation(field));
    }
}
