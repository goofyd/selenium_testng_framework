package utils.object_repository.page_objects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.manager.webdriver.DriverManager;
import utils.manager.webdriver.WebDriverFactory;
import utils.object_repository.JsonRepo;

public class Sample {

    @SetVal
    private String roadrunner;
    @SetVal
    private String roadrunner2;
    @JsonRepo(page = "home", element = "txtSearch")
    WebElement s2;
    @FindBy(name="q")
    WebElement s3;

    public static void main(String[] args){
        Sample s = new Sample();
        WebDriverFactory.getInstance().setDriver();
        WebDriverFactory.getInstance().getDriver().get("https://google.com");
        Injector.init(s);
        System.out.println(s.roadrunner2);
        ObjRepoPageFactory.initElements(WebDriverFactory.getInstance().getDriver(), s);
        s.s2.sendKeys("dddd");
        System.out.println(s.s2.getText());
        s.s3.sendKeys(Keys.ENTER);
    }
}
