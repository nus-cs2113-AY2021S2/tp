package seedu.storage;

import seedu.exceptions.HealthVaultException;
import seedu.logger.HealthVaultLogger;
import seedu.logic.errorchecker.StaffChecker;
import seedu.model.staff.StaffList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * StaffStorage Class handles the necessary file I/O operations.
 */
public class StaffStorage {
    static File saveFile;
    static String filePath;
    private StaffChecker staffChecker = new StaffChecker();
    public Logger logger = HealthVaultLogger.getLogger();

    /**
     * Constructor for StaffStorage.
     *
     * @param filepath filepath to create and update the file.
     */
    public StaffStorage(String filepath) {
        filePath = filepath;
        saveFile = new File(filepath);
    }

    /**
     * Loads existing Staff data from a specified text file.
     * Or creates a new text file if no existing text file exists.
     *
     * @param staffList  StallList object to load Staff object data into.
     * @throws HealthVaultException  If any corrupted file data detected.
     */
    public void fileHandling(StaffList staffList) throws HealthVaultException {
        try {
            loadFile(staffList);
        } catch (FileNotFoundException e) {
            logger.log(Level.WARNING, "Unable to find file");
            createFile();
        }
    }

    /**
     * Creates Staff object from data in text file and adds it to StaffList object.
     *
     * @param staffList  StallList object to load Staff object data into.
     * @param line  String of data from text files.
     * @throws HealthVaultException  If any corrupted file data detected.
     */
    public void loadStaff(StaffList staffList, String line) throws HealthVaultException {
        staffChecker.checkValidDataFromStorage(line, staffList.getList());
        String[] arr = staffChecker.invalidCharactersStaffCheckerForStorage(line);
        staffList.add(arr);
    }

    /**
     * Loads data from text file into StaffList.
     *
     * @param staffList  StallList object to load Staff object data into.
     * @throws FileNotFoundException  If file does not exist.
     * @throws HealthVaultException  If any corrupted file data detected.
     */
    public void loadFile(StaffList staffList) throws FileNotFoundException, HealthVaultException {
        File f = new File(filePath);           // create a File for the given file path
        Scanner s = new Scanner(f);            // create a Scanner using the File as the source
        while (s.hasNext()) {
            loadStaff(staffList, s.nextLine());
        }
        logger.log(Level.INFO, "Staff data loaded into system.");
    }

    /**
     * Loads data from StaffList into a specified text file.
     *
     * @param staffList  StallList object where Staff object's data are retrieved.
     * @throws IOException  If unable to write to file.
     */
    public void writeToFile(StaffList staffList) throws IOException {
        createFile();
        FileWriter fw = new FileWriter(filePath);
        for (int i = 0; i < StaffList.getNumStaff(); i++) {
            fw.write(staffList.getList().get(i).formWriteData());
        }
        fw.close();
        logger.log(Level.INFO, "Staff file save successful");
    }

    /**
     * Creates a directory if it does not exist.
     * Creates a file if it does not exist.
     *
     * @throws IOException  If unable to create file/directory.
     */
    public void createFile() {
        try {
            File myObj = new File(filePath);
            saveFile.getParentFile().mkdirs();
            myObj.createNewFile();
            logger.log(Level.INFO, "New Staff file and directory created");
        } catch (IOException e) {
            System.out.println("OOPS! I can't create the directory or file!");
            logger.log(Level.WARNING, "Unable to create file");
        }
    }

}
