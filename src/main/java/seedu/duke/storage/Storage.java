package seedu.duke.storage;

import seedu.duke.account.User;
import seedu.duke.exception.TypeException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class Storage {
    private FileReader fileReader;
    private FileWriter fileWriter;
    private String recordPath;
    private String goalPath;
    private File recordSource;
    private File goalSource;

    public Storage(String recordPath, String goalPath) throws IOException {
        this.recordPath = recordPath;
        this.goalPath = goalPath;
        recordSource = new File(recordPath);
        goalSource = new File(goalPath);

        if (!recordSource.exists()) {
            if (!recordSource.getParentFile().exists()) {
                recordSource.getParentFile().mkdirs();
                recordSource.createNewFile();
            }
        }
        if (!goalSource.exists()) {
            if (!goalSource.getParentFile().exists()) {
                goalSource.getParentFile().mkdirs();
                goalSource.createNewFile();
            }
        }
        fileWriter = new FileWriter(recordPath, goalPath);
        fileReader = new FileReader(recordSource, goalSource);
    }

    public void store(User user) throws IOException {
        fileWriter.storeRecordsToFile(user);
        fileWriter.storeGoalsToFile(user);
    }

    public void readRecords(User user) throws TypeException, NumberFormatException, ParseException, FileNotFoundException {
        fileReader.parseToRecordList(user);
    }

    public void readGoals(User user) throws TypeException, NumberFormatException, ParseException, FileNotFoundException {
        fileReader.parseToGoal(user);
    }
}
