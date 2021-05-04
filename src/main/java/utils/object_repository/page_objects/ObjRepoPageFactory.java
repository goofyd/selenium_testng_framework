package utils.object_repository.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public class ObjRepoPageFactory {

    public static void initElements(final WebDriver driver, final Object page){
        initElements(new ObjectRepositoryElementLocatorFactory(driver), page);
    }

    public static void initElements(final ElementLocatorFactory factory, final Object page){
        PageFactory.initElements(new ObjectRepositoryFieldDecorator(factory), page);
    }
}
