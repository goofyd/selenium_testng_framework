package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.manager.webdriver.WebDriverFactory;

public abstract class Base {
    protected Logger logger = LogManager.getLogger(this.getClass());
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
