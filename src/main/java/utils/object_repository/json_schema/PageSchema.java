package utils.object_repository.json_schema;

import java.util.List;

public class PageSchema {

    private String pageName;
    private List<ElementSchema> elements;

    public PageSchema(){ }

    public PageSchema(String pageName, List<ElementSchema> elements){
        this.pageName = pageName;
        this.elements = elements;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageName='" + pageName + '\'' +
                ", elements=" + elements +
                '}';
    }

    public String getPageName() {
        return pageName;
    }

    public List<ElementSchema> getElements() {
        return elements;
    }
}
