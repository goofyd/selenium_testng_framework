package tests;

import base.Base;
import org.testng.annotations.Test;
import pages.google.HomePage;
import utils.manager.webdriver.WebDriverFactory;

public class Test001 extends Base {

    @Test
    public void test_001(){
        logger.info("Test 1");
        HomePage homePage = new HomePage(WebDriverFactory.getInstance().getDriver());
        homePage.setSearchBox("hello");
        homePage.searchText();
        String searchText = homePage.getSearchBoxText();
        logger.info(searchText);
        homePage.getResultText().forEach(logger::info);
        homePage.getTabs().forEach(logger::info);
        logger.info(homePage.getFooterContent());
    }

}
