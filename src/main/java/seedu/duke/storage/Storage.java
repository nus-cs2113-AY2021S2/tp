package seedu.duke.storage;

import seedu.duke.account.User;
import seedu.duke.exception.TypeException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Objects;

/**
 * Manages the storage of system files.
 */
public class Storage {
    private final FileInfoReader fileInfoReader;
    private final FileInfoWriter fileInfoWriter;

    /**
     * Initializes a storage manager for records & goals.
     *
     * @param recordPath the path of the file that stores records.
     * @param goalPath   the path of the file that stores goals.
     * @throws IOException when the file path or file cannot be read or created.
     */
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

    /**
     * Initializes a storage manager for app time.
     *
     * @param timePath the path of the file that stores the app time.
     * @throws IOException when the file path or file cannot be read or created.
     */
    public Storage(String timePath) throws IOException {
        File timeSource = new File(timePath);
        if (!timeSource.exists()) {
            if (!timeSource.getParentFile().exists()) {
                boolean isPathSuccessfullyCreated = timeSource.getParentFile().mkdirs();
                if (!isPathSuccessfullyCreated) {
                    throw new IOException();
                }
            }
            boolean isFileSuccessfullyCreated = timeSource.createNewFile();
            if (!isFileSuccessfullyCreated) {
                throw new IOException();
            }
        }
        fileInfoWriter = new FileInfoWriter(timePath);
        fileInfoReader = new FileInfoReader(timeSource);
    }

    /**
     * Stores the app time into a file.
     *
     * @param timeStrParams the time string parameters to be stored.
     * @throws IOException when the file path or file cannot be read or written.
     */
    public void storeTime(String[] timeStrParams) throws IOException {
        fileInfoWriter.storeTimeToFile(timeStrParams);
    }

    /**
     * Gets the app time info from file.
     *
     * @return the time string parameters to be used for updating the app time.
     * @throws FileNotFoundException when the file path or file cannot be found.
     */
    public String[] getTimeStrParams() throws FileNotFoundException {
        String[] timeStrParams = fileInfoReader.parseTimeStrParams();
        return Objects.requireNonNullElseGet(timeStrParams, () -> new String[]{"Init"});
    }

    /**
     * Stores the current user's goals and records.
     *
     * @param user the current user.
     * @throws IOException when the file path or file cannot be read or created.
     */
    public void store(User user) throws IOException {
        fileInfoWriter.storeRecordsToFile(user);
        fileInfoWriter.storeGoalsToFile(user);
    }

    /**
     * Reads records of a user from file.
     *
     * @param user the current user.
     * @throws TypeException         when the type of food/workout is invalid for diet/exercise records.
     * @throws NumberFormatException when the number format is not consistent with the format expected.
     * @throws ParseException        when a value cannot be parsed to the desired data type.
     * @throws FileNotFoundException when the file path or file cannot be found.
     */
    public void readRecords(User user) throws TypeException, NumberFormatException, ParseException,
            FileNotFoundException {
        fileInfoReader.parseToRecordList(user);
    }

    /**
     * Reads goals of a user from file.
     *
     * @param user the current user.
     * @throws TypeException         when the type of food/workout is invalid for diet/exercise records.
     * @throws NumberFormatException when the number format is not consistent with the format expected.
     * @throws ParseException        when a value cannot be parsed to the desired data type.
     * @throws FileNotFoundException when the file path or file cannot be found.
     */
    public void readGoals(User user) throws TypeException, NumberFormatException, ParseException,
            FileNotFoundException {
        fileInfoReader.parseToGoal(user);
    }
}
