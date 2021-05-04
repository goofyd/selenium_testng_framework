package pages.google;

import base.TestRunner;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.object_repository.page_object_factory.JsonRepo;
import utils.page_object_factory.GenericPageFactory;


public class HomePage extends TestRunner {

    @JsonRepo(page = "home", element = "txtSearch")
    private WebElement searchBox;

    public HomePage(WebDriver driver){
        GenericPageFactory.initElements(driver, this);
    }

    public void setSearchBox(String searchText){
        searchBox.sendKeys(searchText);
    }

    public void searchText(){
        searchBox.sendKeys(Keys.ENTER);
    }

    public String getSearchBoxText(){
        return searchBox.getAttribute("value");
    }

}
