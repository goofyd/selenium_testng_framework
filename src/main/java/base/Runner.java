package base;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import utils.object_repository.schema.Element;
import utils.object_repository.schema.ObjectRepository;
import utils.object_repository.schema.Root;
import utils.object_repository.schema.Page;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Runner {

    private static final Logger LOGGER = LogManager.getLogger(Runner.class.getName());

    public static void main(String[] args) {
        ObjectRepository repo = new ObjectRepository();
        LOGGER.info(repo.getRoot());
        LOGGER.info(repo.getPages());
        Element el1 = repo.getElement(repo.getPages().get(1), "lnkResults");
        LOGGER.info(el1.getLocator() + " = " + el1.getValue());
    }
}
