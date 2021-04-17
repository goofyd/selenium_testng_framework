package utils.object_repository.schema;

import java.util.List;

public class Root {

    private String appName;
    private String appURL;
    private List<Page> pages;

    public Root(){ }

    public Root(String appName, String appURL, List<Page> pages){
        this.appName = appName;
        this.appURL = appURL;
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "ObjRepository{" +
                "appName='" + appName + '\'' +
                ", appURL='" + appURL + '\'' +
                ", pages=" + pages +
                '}';
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppURL() {
        return appURL;
    }

    public void setAppURL(String appURL) {
        this.appURL = appURL;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }
}
