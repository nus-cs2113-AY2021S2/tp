package seedu.storage;

import seedu.exceptions.NoInputException;
import seedu.exceptions.staff.*;
import seedu.logic.command.StaffAggregation;
import seedu.logic.parser.StaffParser;
import seedu.model.staff.Staff;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class StaffStorage {
    static File saveFile;
    static String filePath;

    public StaffStorage(String filepath) {
        filePath = filepath;
        saveFile = new File(filepath);
    }


    public void fileHandling(StaffAggregation staffAggregation) throws ExcessInputException,
            PositiveNumberOnlyException, BlankInputException, WrongStaffIdException,
            InsufficientInputException, NoInputException {
        try {
            loadFile(staffAggregation);
        } catch (FileNotFoundException e) {
            createFile();
        }
    }

    public void loadTask(StaffAggregation staffAggregation, String line) throws ExcessInputException,
            PositiveNumberOnlyException, BlankInputException, WrongStaffIdException,
            InsufficientInputException, NoInputException {

        StaffParser.checkValidDataForAdd(line);
        String[] arr = line.split("\\|");
        staffAggregation.addStaff(new Staff(arr));
    }

    public void loadFile(StaffAggregation staffAggregation) throws FileNotFoundException, ExcessInputException,
            PositiveNumberOnlyException, BlankInputException, WrongStaffIdException,
            InsufficientInputException, NoInputException {
        File f = new File(filePath);           // create a File for the given file path
        Scanner s = new Scanner(f);            // create a Scanner using the File as the source
        while (s.hasNext()) {
            loadTask(staffAggregation, s.nextLine());
        }
    }

    public void writeToFile(StaffAggregation staffAggregation) throws IOException {
        createFile();
        FileWriter fw = new FileWriter(filePath);
        for (int i = 0; i < StaffAggregation.getNumStaff(); i++) {
            fw.write(staffAggregation.getList().get(i).formWriteData());
        }
        fw.close();
    }

    public static void createFile() {
        try {
            File myObj = new File(filePath);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
