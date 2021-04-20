package utils.object_repository.json_schema;

import java.util.List;

public class RootSchema {

    private String appName;
    private String appURL;
    private List<PageSchema> pages;

    public RootSchema(){ }

    public RootSchema(String appName, String appURL, List<PageSchema> pages){
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

    public String getAppURL() {
        return appURL;
    }

    public List<PageSchema> getPages() {
        return pages;
    }
}
