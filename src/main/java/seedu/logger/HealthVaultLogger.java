package seedu.logger;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static seedu.duke.Constants.HEALTHVAULT_LOGS_FILE_PATH;

/**
 * Main logger of HealthVault.
 */
public class HealthVaultLogger {
    public static HealthVaultLogger hvLogger = null;
    private Logger logger;

    private HealthVaultLogger() {
        try {
            File file = new File(HEALTHVAULT_LOGS_FILE_PATH);

            if (!(file.exists())) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }

            FileHandler fileHandler = new FileHandler(HEALTHVAULT_LOGS_FILE_PATH);
            fileHandler.setFormatter(new SimpleFormatter());

            logger = Logger.getLogger("HealthVaultLogger");
            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false);
        } catch (IOException | SecurityException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the common logger to the calling class.
     *
     * @return the main HealthVault logger.
     */
    public static Logger getLogger() {
        if (hvLogger == null) {
            hvLogger = new HealthVaultLogger();
        }
        return hvLogger.logger;
    }
}
