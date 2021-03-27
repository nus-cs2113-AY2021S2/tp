package seedu.duke.command;

import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.io.IOException;

public class FinuxLogger {
    private Logger logger;

    public FinuxLogger(String loggerName) {
        try {
            logger = Logger.getLogger(loggerName);
            FileHandler logFileHandler = new FileHandler("finuxLog.txt", true);
            logFileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(logFileHandler);
            logger.setUseParentHandlers(false);
        } catch (IOException | SecurityException e) {
            System.out.println("Error occurred in setting up finux logger!");
        }
    }

    public void logInfo(String infoMsg) {
        if (logger != null) {
            logger.info(infoMsg);
        }
    }

    public void logWarning(String warningMsg) {
        if (logger != null) {
            logger.warning(warningMsg);
        }
    }
}
