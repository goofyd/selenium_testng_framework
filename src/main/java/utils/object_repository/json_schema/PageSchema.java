package utils.object_repository.json_schema;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PageSchema {
    private @Getter String pageName;
    private @Getter List<ElementSchema> elements;
}
