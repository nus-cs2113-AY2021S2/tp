package seedu.duke.storage;

import seedu.duke.account.FitCenter;
import seedu.duke.account.User;

import java.io.IOException;

public class FileWriter {
    private String recordFilePath;
    private String goalFilePath;

    public FileWriter(String recordPath, String goalPath) {
        recordFilePath = recordPath;
        goalFilePath = goalPath;
    }

    public void storeRecordsToFile(User user) throws IOException {
        FitCenter fitCenter = user.getFitCenter();
        java.io.FileWriter recordWriter = new java.io.FileWriter(recordFilePath);
        String stringToStore = fitCenter.getRecordListForStore();
        recordWriter.write(stringToStore);
        recordWriter.close();
    }

    public void storeGoalsToFile(User user) throws IOException {
        FitCenter fitCenter = user.getFitCenter();
        java.io.FileWriter recordWriter = new java.io.FileWriter(goalFilePath);
        String stringToStore = fitCenter.getGoalListForStore();
        recordWriter.write(stringToStore);
        recordWriter.close();
    }
}
