package utils.object_repository.json_schema;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RootSchema {
    private @Getter String appName;
    private @Getter String appURL;
    private @Getter List<PageSchema> pages;
}
