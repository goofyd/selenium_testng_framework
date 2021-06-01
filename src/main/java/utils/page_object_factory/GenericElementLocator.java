package utils.page_object_factory;

import lombok.AllArgsConstructor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.Annotations;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.util.List;

@AllArgsConstructor
public class GenericElementLocator implements ElementLocator {
    private final SearchContext context;
    private final Annotations annotation;

    @Override
    public WebElement findElement() {
        return this.context.findElement(this.annotation.buildBy());
    }

    @Override
    public List<WebElement> findElements() {
        return this.context.findElements(this.annotation.buildBy());
    }
}
