package utils.manager.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.manager.ApplicationPropManager;

public class DriverManager {

    public WebDriver createNewDriver(){
        if(ApplicationPropManager.getEnvironment().name().equalsIgnoreCase("local")){
            return createLocalDriver();
        }else{
            throw new RuntimeException("Remote WebDriver is yet to be implemented!");
        }
    }

    protected WebDriver createLocalDriver(){
        WebDriver driver = null;
        if(ApplicationPropManager.getBrowserDriver().getName().equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else{
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }

}
