package utils.page_object_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public class GenericPageFactory {

    private GenericPageFactory() {}

    public static void initElements(final WebDriver driver, final Object page){
        initElements(new GenericElementLocatorFactory(driver), page);
    }

    public static void initElements(final ElementLocatorFactory factory, final Object page){
        PageFactory.initElements(new GenericFieldDecorator(factory), page);
    }
}
