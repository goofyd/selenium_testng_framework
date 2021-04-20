package base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.logger.Log;
import utils.manager.webdriver.WebDriverFactory;
import utils.object_repository.*;

import java.io.FileNotFoundException;

public class TestRunner {
    private ObjectRepository repo;

    @BeforeSuite
    public void initApplication() throws FileNotFoundException {
        Log.info("Initializing Object Repository");
        repo = new JSONRepository();
        Log.info("Initialized the Object Repository Successfully");
        WebDriverFactory.getInstance().setDriver();
        WebDriverFactory.getInstance().getDriver().get("https://google.com");
        Log.info(WebDriverFactory.getInstance().getDriver().getTitle());
    }

    @AfterSuite
    public void quitApplication(){
        WebDriverFactory.getInstance().close();
        repo = null;
    }

    public ObjectRepository getRepo() {
        return repo;
    }
}
