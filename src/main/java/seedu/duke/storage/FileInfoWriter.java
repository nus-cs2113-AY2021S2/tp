package seedu.duke.storage;

import seedu.duke.account.FitCenter;
import seedu.duke.account.User;

import java.io.FileWriter;
import java.io.IOException;

public class FileInfoWriter {
    private String recordFilePath;
    private String goalFilePath;
    private String timeFilePath;

    public FileInfoWriter(String recordPath, String goalPath) {
        recordFilePath = recordPath;
        goalFilePath = goalPath;
    }

    public FileInfoWriter(String timeFilePath) {
        this.timeFilePath = timeFilePath;
    }

    public void storeRecordsToFile(User user) throws IOException {
        FitCenter fitCenter = user.getFitCenter();
        FileWriter recordWriter = new FileWriter(recordFilePath);
        String stringToStore = fitCenter.getRecordListForStore();
        recordWriter.write(stringToStore);
        recordWriter.close();
    }

    public void storeGoalsToFile(User user) throws IOException {
        FitCenter fitCenter = user.getFitCenter();
        FileWriter recordWriter = new FileWriter(goalFilePath);
        String stringToStore = fitCenter.getGoalListForStore();
        recordWriter.write(stringToStore);
        recordWriter.close();
    }

    public void storeTimeToFile(String[] timeStrParams) throws IOException {
        FileWriter timeWriter = new FileWriter(timeFilePath);
        String separator = " | ";
        String timeStr = timeStrParams[0] + separator + timeStrParams[1];
        timeWriter.write(timeStr);
        timeWriter.close();
    }
}
