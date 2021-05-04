package utils.object_repository.page_objects;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.Annotations;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.util.List;

public class ObjectRepositoryElementLocator implements ElementLocator {
    private final SearchContext context;
    private final Annotations annotation;

    public ObjectRepositoryElementLocator(SearchContext context, Annotations annotation){
        this.context = context;
        this.annotation = annotation;
    }

    @Override
    public WebElement findElement() {
        return this.context.findElement(this.annotation.buildBy());
    }

    @Override
    public List<WebElement> findElements() {
        return this.context.findElements(this.annotation.buildBy());
    }
}
