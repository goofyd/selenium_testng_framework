package tests;

import base.TestRunner;
import org.testng.annotations.Test;
import pages.google.HomePage;
import utils.logger.Log;
import utils.manager.webdriver.WebDriverFactory;

public class Test001 extends TestRunner {

    @Test
    public void test_001(){
        Log.info("Test 1");
        HomePage homePage = new HomePage(WebDriverFactory.getInstance().getDriver());
        homePage.setSearchBox("hello");
        homePage.searchText();
        String searchText = homePage.getSearchBoxText();
        Log.info(searchText);
        homePage.getResultText().forEach(Log::info);
        homePage.getTabs().forEach(Log::info);
    }

}
