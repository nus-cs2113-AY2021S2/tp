package seedu.fridgefriend.utilities;

//@@author kwokyto
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents a logging object with name FridgeFriend.
 */
public class LoggingHandler {
    private static Logger logger = Logger.getLogger("FridgeFriend");
    
    /**
     * Logs a message at level INFO.
     *
     * @param message the message for the logger
     */
    public static void logInfo(String message) {
        logger.setLevel(Level.WARNING);
        logger.log(Level.INFO, message);
    }

    /**
     * Logs a message at level INFO with an exception.
     *
     * @param message the message for the logger
     * @param thrown the throwable associated with the log message
     */
    public static void logInfo(String message, Throwable thrown) {
        logger.setLevel(Level.WARNING);
        logger.log(Level.INFO, message, thrown);
    }

    /**
     * Logs a message at level WARNING.
     *
     * @param message the message for the logger
     */
    public static void logWarning(String message) {
        logger.log(Level.WARNING, message);
    }

    /**
     * Logs a message at level WARNING with an exception.
     *
     * @param message the message for the logger
     * @param thrown the throwable associated with the log message
     */
    public static void logWarning(String message, Throwable thrown) {
        logger.log(Level.WARNING, message, thrown);
    }

    /**
     * Logs a message at level SEVERE.
     *
     * @param message the message for the logger
     */
    public static void logSevere(String message) {
        logger.log(Level.SEVERE, message);
    }

    /**
     * Logs a message at level SEVERE with an exception.
     *
     * @param message the message for the logger
     * @param thrown the throwable associated with the log message
     */
    public static void logSevere(String message, Throwable thrown) {
        logger.log(Level.SEVERE, message, thrown);
    }
}
