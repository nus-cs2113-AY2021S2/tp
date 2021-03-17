package seedu.fridgefriend.utilities;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents a logging object with name FridgeFriend.
 */
public class LoggingHandler {
    private static final Logger LOGGER = Logger.getLogger("FridgeFriend");
    
    public LoggingHandler() {
        LOGGER.setLevel(Level.OFF);
    }

    public static java.util.logging.Logger getLogger() {
        return LOGGER;
    }
    
    /**
     * Logs a message at level INFO.
     */
    public static void logInfo(String message) {
        LOGGER.log(Level.INFO, message);
    }

    /**
     * Logs a message at level INFO with an exception.
     */
    public static void logInfo(String message, Throwable e) {
        LOGGER.log(Level.INFO, message, e);
    }

    /**
     * Logs a message at level WARNING.
     */
    public static void logWarning(String message) {
        LOGGER.log(Level.WARNING, message);
    }

    /**
     * Logs a message at level WARNING with an exception.
     */
    public static void logWarning(String message, Throwable e) {
        LOGGER.log(Level.WARNING, message, e);
    }

    /**
     * Logs a message at level SEVERE.
     */
    public static void logSevere(String message) {
        LOGGER.log(Level.SEVERE, message);
    }

    /**
     * Logs a message at level SEVERE with an exception.
     */
    public static void logSevere(String message, Throwable e) {
        LOGGER.log(Level.SEVERE, message, e);
    }
}
