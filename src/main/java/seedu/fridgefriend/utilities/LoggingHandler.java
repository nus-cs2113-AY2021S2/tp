package seedu.fridgefriend.utilities;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents a logging object with name FridgeFriend.
 */
public class LoggingHandler {
    private static Logger logger = Logger.getLogger("FridgeFriend");
    
    /**
     * Logs a message at level INFO.
     */
    public static void logInfo(String message) {
        logger.setLevel(Level.WARNING);
        logger.log(Level.INFO, message);
    }

    /**
     * Logs a message at level INFO with an exception.
     */
    public static void logInfo(String message, Throwable e) {
        logger.setLevel(Level.WARNING);
        logger.log(Level.INFO, message, e);
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
