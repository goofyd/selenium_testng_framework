package utils.manager.webdriver;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {

    private static final WebDriverFactory instance = new WebDriverFactory();
    ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private WebDriverFactory(){ }

    public static WebDriverFactory getInstance(){
        return instance;
    }

    public void setDriver(){
        DriverManager webDriverInstance = new DriverManager();
        this.driver.set(webDriverInstance.createNewDriver());
    }

    public WebDriver getDriver(){
        return this.driver.get();
    }

    public void close(){
        driver.get().quit();
        driver.remove();
    }


}
