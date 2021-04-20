package utils.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Log {

    private Log() {}

    private static final Logger logger = LogManager.getLogger(Log.class.getName());

    public static void startTest(String testName) {
        Log.info("Starting Testcase - " + testName);
    }

    public static void info(String infoText) {
        logger.info(infoText);
    }

    public static void warn(String warnText) {
        logger.warn(warnText);
    }

    public static void error(String errorText) {
        logger.error(errorText);
    }

    public static void debug(String debugText) {
        logger.debug(debugText);
    }
}
