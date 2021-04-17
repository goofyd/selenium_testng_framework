package utils.object_repository.schema;

public class Element {

    private String identifier;
    private String locator;
    private String value;

    public Element() { }

    public Element(String identifier, String locator, String value) {
        this.identifier = identifier;
        this.locator = locator;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Element{" +
                "identifier='" + identifier + '\'' +
                ", locator='" + locator + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getLocator() {
        return locator;
    }

    public void setLocator(String locator) {
        this.locator = locator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
