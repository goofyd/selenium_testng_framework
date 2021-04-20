package utils.manager.webdriver;

public enum BrowserDriver {
    CHROME("chrome"),
    FIREFOX("firefox");

    String browserName;
    BrowserDriver(String browserName){
        this.browserName = browserName;
    }
    public String getName(){
        return browserName;
    }

}
