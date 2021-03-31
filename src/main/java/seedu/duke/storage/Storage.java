package seedu.duke.storage;

import seedu.duke.account.User;
import seedu.duke.exception.TypeException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class Storage {
    private FileInfoReader fileInfoReader;
    private FileInfoWriter fileInfoWriter;
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
            }
            recordSource.createNewFile();
        }
        if (!goalSource.exists()) {
            if (!goalSource.getParentFile().exists()) {
                goalSource.getParentFile().mkdirs();
            }
            goalSource.createNewFile();
        }
        fileInfoWriter = new FileInfoWriter(recordPath, goalPath);
        fileInfoReader = new FileInfoReader(recordSource, goalSource);
    }

    public void store(User user) throws IOException {
        fileInfoWriter.storeRecordsToFile(user);
        fileInfoWriter.storeGoalsToFile(user);
    }

    public void readRecords(User user) throws TypeException, NumberFormatException, ParseException,
            FileNotFoundException {
        fileInfoReader.parseToRecordList(user);
    }

    public void readGoals(User user) throws TypeException, NumberFormatException, ParseException,
            FileNotFoundException {
        fileInfoReader.parseToGoal(user);
    }
}
