package utils.page_object_factory;

import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

public class GenericFieldDecorator extends DefaultFieldDecorator implements FieldDecorator {
    public GenericFieldDecorator(ElementLocatorFactory factory) {
        super(factory);
    }
}
