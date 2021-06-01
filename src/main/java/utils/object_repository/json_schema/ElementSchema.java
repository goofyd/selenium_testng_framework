package utils.object_repository.json_schema;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ElementSchema {
    private @Getter String identifier;
    private @Getter String locator;
    private @Getter String value;
}
