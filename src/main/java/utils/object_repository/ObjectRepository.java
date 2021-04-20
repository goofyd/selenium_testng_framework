package utils.object_repository;

import utils.object_repository.json_schema.ElementSchema;
import utils.object_repository.json_schema.PageSchema;
import utils.object_repository.json_schema.RootSchema;

public interface ObjectRepository {

    ObjectRepository.Root root();

    public interface Root{
        RootSchema getRoot();
        ObjectRepository.Page page();
    }

    public interface Page{
        PageSchema get(String pageName);
        ObjectRepository.Element element(PageSchema page);
    }

    public interface Element{
        ElementSchema get(String elementName);
    }

}
