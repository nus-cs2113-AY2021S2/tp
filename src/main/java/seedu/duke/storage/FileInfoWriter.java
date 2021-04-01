package seedu.duke.storage;

import seedu.duke.account.FitCenter;
import seedu.duke.account.User;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Writes given information into text file.
 */
public class FileInfoWriter {
    private String recordFilePath;
    private String goalFilePath;
    private String timeFilePath;

    /**
     * Initializes the file writer for records & goals.
     *
     * @param recordPath the path of the file that stores records.
     * @param goalPath   the path of the file that stores goals.
     */
    public FileInfoWriter(String recordPath, String goalPath) {
        recordFilePath = recordPath;
        goalFilePath = goalPath;
    }

    /**
     * Initializes the file writer for app time info.
     *
     * @param timeFilePath the path of the file that stores app time info.
     */
    public FileInfoWriter(String timeFilePath) {
        this.timeFilePath = timeFilePath;
    }

    /**
     * Stores records of the current user into text file in a pre-defined format.
     *
     * @param user the current user.
     * @throws IOException when the file path or file cannot be read or created.
     */
    public void storeRecordsToFile(User user) throws IOException {
        FitCenter fitCenter = user.getFitCenter();
        FileWriter recordWriter = new FileWriter(recordFilePath);
        String stringToStore = fitCenter.getRecordListForStore();
        recordWriter.write(stringToStore);
        recordWriter.close();
    }

    /**
     * Stores goals of the current user into text file in a pre-defined format.
     *
     * @param user the current user.
     * @throws IOException when the file path or file cannot be read or created.
     */
    public void storeGoalsToFile(User user) throws IOException {
        FitCenter fitCenter = user.getFitCenter();
        FileWriter recordWriter = new FileWriter(goalFilePath);
        String stringToStore = fitCenter.getGoalListForStore();
        recordWriter.write(stringToStore);
        recordWriter.close();
    }

    /**
     * Stores the app time info into text file in a pre-defined format.
     *
     * @param timeStrParams the time string parameters to be stored.
     * @throws IOException when the file path or file cannot be read or created.
     */
    public void storeTimeToFile(String[] timeStrParams) throws IOException {
        FileWriter timeWriter = new FileWriter(timeFilePath);
        String separator = " | ";
        String timeStr = timeStrParams[0] + separator + timeStrParams[1];
        timeWriter.write(timeStr);
        timeWriter.close();
    }
}
