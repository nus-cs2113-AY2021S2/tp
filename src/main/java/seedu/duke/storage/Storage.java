package seedu.duke.storage;

import seedu.duke.account.User;
import seedu.duke.exception.TypeException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class Storage {
    private final FileInfoReader fileInfoReader;
    private final FileInfoWriter fileInfoWriter;

    public Storage(String recordPath, String goalPath) throws IOException {
        File recordSource = new File(recordPath);
        File goalSource = new File(goalPath);
        if (!recordSource.exists()) {
            if (!recordSource.getParentFile().exists()) {
                boolean isPathSuccessfullyCreated = recordSource.getParentFile().mkdirs();
                if (!isPathSuccessfullyCreated) {
                    throw new IOException();
                }
            }
            boolean isFileSuccessfullyCreated = recordSource.createNewFile();
            if (!isFileSuccessfullyCreated) {
                throw new IOException();
            }
        }
        if (!goalSource.exists()) {
            if (!goalSource.getParentFile().exists()) {
                boolean isPathSuccessfullyCreated = goalSource.getParentFile().mkdirs();
                if (!isPathSuccessfullyCreated) {
                    throw new IOException();
                }
            }
            boolean isFileSuccessfullyCreated = goalSource.createNewFile();
            if (!isFileSuccessfullyCreated) {
                throw new IOException();
            }
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
