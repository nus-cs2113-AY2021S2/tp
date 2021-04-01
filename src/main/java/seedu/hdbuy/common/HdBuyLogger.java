package seedu.hdbuy.common;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HdBuyLogger {

    private static final Logger logger = Logger.getGlobal();

    public static void enableLogger(boolean isEnabled) {
        if (!isEnabled) {
            logger.setLevel(Level.OFF);
        }
    }

    public static void infoLog(String message) {
        logger.info(message);
    }

    public static void warningLog(String message) {
        logger.warning(message);
    }

    public static void errorLog(String message) {
        logger.severe(message);
    }
}
