package utils.manager;

import utils.enums.Environment;
import utils.logger.Log;
import utils.manager.webdriver.BrowserDriver;
import utils.object_repository.JSONRepository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ApplicationPropManager {

    private static final String APP_PROP_NAME = "application.properties";
    private static final Properties appProperties = new Properties();
    private static JSONRepository jsonRepo;

    static{
        Log.info("Checking for application.properties file");
        try(FileInputStream file = new FileInputStream(String.valueOf(ApplicationPropManager.class.getClassLoader().getResource(APP_PROP_NAME)).substring(6))){
            appProperties.load(file);
            Log.info("application.properties file is loaded!");
            jsonRepo = getJsonRepo();
        }catch (IOException e){
            Log.error("The application.properties file is not found!");
            Log.error(e.toString());
        }
    }

    private ApplicationPropManager(){ }

    public static BrowserDriver getBrowserDriver(){
        String browserName = appProperties.getProperty("browser.name").toLowerCase().trim();
        Log.info("The Browser is set to "+ browserName);
        if (BrowserDriver.FIREFOX.getName().equalsIgnoreCase(browserName)) {
            return BrowserDriver.FIREFOX;
        }
        return BrowserDriver.CHROME;
    }

    public static Environment getEnvironment(){
        String environment = appProperties.getProperty("env").toLowerCase().trim();
        Log.info("The Environment is set to "+environment);
        if (Environment.REMOTE.name().equalsIgnoreCase(environment)) {
            return Environment.REMOTE;
        }
        return Environment.LOCAL;
    }

    private static JSONRepository getJsonRepo() {
        Log.info("Initializing Object Repository");
        if(appProperties.containsKey("repo.name"))
            System.setProperty("obj.repo.name", appProperties.getProperty("repo.name").trim());
        Log.info("Initialized the Object Repository Successfully");
        try{
            return new JSONRepository();
        }catch(FileNotFoundException e){
            Log.error(e.getMessage());
            return null;
        }
    }

    public static JSONRepository getJSONRepository(){
        return (jsonRepo==null)?getJsonRepo():jsonRepo;
    }

}
