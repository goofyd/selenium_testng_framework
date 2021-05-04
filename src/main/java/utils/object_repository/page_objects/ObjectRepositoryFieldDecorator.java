package utils.object_repository.page_objects;

import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

public class ObjectRepositoryFieldDecorator extends DefaultFieldDecorator implements FieldDecorator {
    public ObjectRepositoryFieldDecorator(ElementLocatorFactory factory) {
        super(factory);
    }
}
