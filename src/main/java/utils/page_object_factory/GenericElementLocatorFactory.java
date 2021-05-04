package utils.page_object_factory;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.pagefactory.Annotations;
import org.openqa.selenium.support.pagefactory.DefaultElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import utils.object_repository.page_object_factory.JsonRepo;
import utils.object_repository.page_object_factory.ObjectRepositoryAnnotation;

import java.lang.reflect.Field;

public class GenericElementLocatorFactory implements ElementLocatorFactory {

    private final SearchContext context;

    public GenericElementLocatorFactory(SearchContext context){
        this.context = context;
    }

    @Override
    public ElementLocator createLocator(Field field) {
        if(field.isAnnotationPresent(JsonRepo.class)){
            return new GenericElementLocator(this.context, new ObjectRepositoryAnnotation(field));
        }else{
            return new DefaultElementLocator(this.context, new Annotations(field));
        }
    }
}
