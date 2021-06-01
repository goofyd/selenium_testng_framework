package utils.page_object_factory;

import lombok.AllArgsConstructor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.pagefactory.Annotations;
import org.openqa.selenium.support.pagefactory.DefaultElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import utils.object_repository.page_object_factory.JsonRepo;
import utils.object_repository.page_object_factory.JsonRepoAnnotation;
import utils.page_object_factory.annotations.DynamicElement;
import utils.page_object_factory.annotations.DynamicElementAnnotation;

import java.lang.reflect.Field;

@AllArgsConstructor
public class GenericElementLocatorFactory implements ElementLocatorFactory {

    private final SearchContext context;

    @Override
    public ElementLocator createLocator(Field field) {
        if(field.isAnnotationPresent(JsonRepo.class)){
            return new GenericElementLocator(this.context, new JsonRepoAnnotation(field));
        }else if(field.isAnnotationPresent(DynamicElement.class)){
               return new GenericElementLocator(this.context, new DynamicElementAnnotation(field));
        }else{
            return new DefaultElementLocator(this.context, new Annotations(field));
        }
    }
}
