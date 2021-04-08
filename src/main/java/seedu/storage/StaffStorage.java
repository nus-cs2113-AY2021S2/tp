package seedu.storage;

import seedu.exceptions.*;
import seedu.exceptions.IllegalCharacterException;
import seedu.exceptions.staff.InvalidStaffAgeException;
import seedu.exceptions.staff.WrongStaffIdException;
import seedu.logger.HealthVaultLogger;
import seedu.model.staff.StaffList;
import seedu.logic.errorchecker.StaffChecker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class StaffStorage {
    static File saveFile;
    static String filePath;
    private StaffChecker staffChecker = new StaffChecker();
    public Logger logger = HealthVaultLogger.getLogger();

    public StaffStorage(String filepath) {
        filePath = filepath;
        saveFile = new File(filepath);
    }


    public void fileHandling(StaffList staffList) throws
            ExcessInputException, InvalidIntegerException, WrongStaffIdException,
            InsufficientInputException, NoInputException, DuplicateIDException,
            IllegalCharacterException, InvalidStaffAgeException {
        try {
            loadFile(staffList);
        } catch (FileNotFoundException e) {
            logger.log(Level.WARNING, "Unable to find file");
            createFile();
        }
    }

    public void loadStaff(StaffList staffList, String line) throws
            ExcessInputException, InvalidIntegerException, WrongStaffIdException,
            InsufficientInputException, NoInputException, DuplicateIDException,
            IllegalCharacterException, InvalidStaffAgeException {
        staffChecker.checkValidDataFromStorage(line, staffList.getList());
        String[] arr = staffChecker.invalidCharactersStaffCheckerForStorage(line);
        staffList.add(arr);
    }

    public void loadFile(StaffList staffList) throws FileNotFoundException,
            ExcessInputException, InvalidIntegerException, WrongStaffIdException,
            InsufficientInputException, NoInputException, DuplicateIDException,
            IllegalCharacterException, InvalidStaffAgeException {
        File f = new File(filePath);           // create a File for the given file path
        Scanner s = new Scanner(f);            // create a Scanner using the File as the source
        while (s.hasNext()) {
            loadStaff(staffList, s.nextLine());
        }
        logger.log(Level.INFO, "Staff data loaded into system.");
    }

    public void writeToFile(StaffList staffList) throws IOException {
        createFile();
        FileWriter fw = new FileWriter(filePath);
        for (int i = 0; i < StaffList.getNumStaff(); i++) {
            fw.write(staffList.getList().get(i).formWriteData());
        }
        fw.close();
        logger.log(Level.INFO, "Staff file save successful");
    }

    public void createFile() {
        try {
            File myObj = new File(filePath);
            saveFile.getParentFile().mkdirs();
            if (myObj.createNewFile()) {
            }
            logger.log(Level.INFO, "New Staff file and directory created");
        } catch (IOException e) {
            System.out.println("OOPS! I can't create the directory or file!");
            logger.log(Level.WARNING, "Unable to create file");
        }
    }

}
