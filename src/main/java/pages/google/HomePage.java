package pages.google;

import base.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.page_object_factory.annotations.JsonRepo;
import utils.page_object_factory.GenericPageFactory;
import utils.page_object_factory.annotations.DynamicElement;

import java.util.List;
import java.util.stream.Collectors;


public class HomePage extends Base {

    @JsonRepo(page = "home", element = "txtSearch")
    private WebElement searchBox;

    @JsonRepo(page = "search", element = "lnkResults")
    private List<WebElement> results;

    @JsonRepo(page = "search", element = "lnkTabs")
    private List<WebElement> tabs;

    @DynamicElement(page = "search", element = "divFooterContent", params = {"Chennai"})
    private WebElement footerContent;

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

    public List<String> getResultText(){
        return results.stream()
                .map(WebElement::getText)
                .filter(x->(!x.trim().equalsIgnoreCase("")))
                .collect(Collectors.toList());
    }

    public List<String> getTabs(){
        return tabs.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public String getFooterContent(){
        return footerContent.getText();
    }

}
