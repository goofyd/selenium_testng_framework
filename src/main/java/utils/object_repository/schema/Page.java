package utils.object_repository.schema;

import java.util.List;

public class Page {

    private String pageName;
    private List<Element> elements;

    public Page(){ }

    public Page(String pageName, List<Element> elements){
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

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }
}
