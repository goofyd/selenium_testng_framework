package utils.object_repository.json_schema;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PageSchema {
    private @Getter String pageName;
    private @Getter List<ElementSchema> elements;
}
