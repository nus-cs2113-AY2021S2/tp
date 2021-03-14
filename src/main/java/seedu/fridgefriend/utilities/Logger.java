package seedu.fridgefriend.utilities;

import java.util.logging.Level;
import java.lang.Throwable;

/**
 * Represents a logging object with name FridgeFriend.
 */
public class Logger {
    public static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger("FridgeFriend");

    public static java.util.logging.Logger getLogger() {
        return logger;
    }
    
    /**
     * Logs a message at level INFO.
     */
    public static void logInfo(String message) {
        logger.log(Level.INFO, message);
    }

    /**
     * Logs a message at level WARNING.
     */
    public static void logWarning(String message) {
        logger.log(Level.WARNING, message);
    }

    /**
     * Logs a message at level WARNING with an exception.
     */
    public static void logWarning(String message, Throwable e) {
        logger.log(Level.WARNING, message, e);
    }

    /**
     * Logs a message at level SEVERE.
     */
    public static void logSevere(String message) {
        logger.log(Level.SEVERE, message);
    }

    /**
     * Logs a message at level SEVERE with an exception.
     */
    public static void logSevere(String message, Throwable e) {
        logger.log(Level.SEVERE, message, e);
    }
}
