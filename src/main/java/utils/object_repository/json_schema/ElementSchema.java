package utils.object_repository.json_schema;

public class ElementSchema {

    private String identifier;
    private String locator;
    private String value;

    public ElementSchema() { }

    public ElementSchema(String identifier, String locator, String value) {
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

    public String getLocator() {
        return locator;
    }

    public String getValue() {
        return value;
    }
}
