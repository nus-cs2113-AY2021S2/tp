package seedu.fridgefriend.utilities;

import java.util.logging.Level;
import java.lang.Throwable;

public class Logger {
    public static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger("FridgeFriend");

    public static java.util.logging.Logger getLogger() {
        return logger;
    }

    public static void logInfo(String message) {
        logger.log(Level.INFO, message);
    }

    public static void logWarning(String message) {
        logger.log(Level.WARNING, message);
    }

    public static void logWarning(String message, Throwable e) {
        logger.log(Level.WARNING, message, e);
    }

    public static void logSevere(String message) {
        logger.log(Level.SEVERE, message);
    }

    public static void logSevere(String message, Throwable e) {
        logger.log(Level.SEVERE, message, e);
    }
}
