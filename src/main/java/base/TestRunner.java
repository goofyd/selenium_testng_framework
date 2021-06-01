package base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.manager.webdriver.WebDriverFactory;

public class TestRunner {

    @BeforeSuite
    public void initApplication() {
        WebDriverFactory.getInstance().setDriver();
        WebDriverFactory.getInstance().getDriver().get("https://google.com");
    }

    @AfterSuite
    public void quitApplication(){
        WebDriverFactory.getInstance().close();
    }
}
