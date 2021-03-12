package seedu.duke.storage;

import seedu.duke.exception.InvalidFileInputException;
import seedu.duke.record.Expense;
import seedu.duke.record.Loan;
import seedu.duke.record.Record;
import seedu.duke.record.Saving;
import seedu.duke.record.RecordList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Storage {
    private static final Path SAVED_FILE_PATH = Paths.get("finux.txt");
    private static final String REGEX_PATTERN_EXPENSE = "[E]\\s\\|\\s.+";
    private static final String REGEX_PATTERN_LOAN = "[L]\\s\\|\\s.+";
    private static final String REGEX_PATTERN_SAVING = "[S]\\s\\|\\s.+";
    private static final int INDEX_OF_DESCRIPTION = 1;
    private static final int INDEX_OF_AMOUNT = 2;
    private static final int INDEX_OF_DATE = 3;

    public Path dataFilePath;

    public Storage() {
        this(SAVED_FILE_PATH);
    }

    public Storage(Path dataFilePath) {
        this.dataFilePath = dataFilePath;
    }

    private boolean saveFileExists(Path filePath) {
        return Files.exists(filePath);
    }

    /**
     * Saves the records from the RecordList into a .txt file.
     *
     * @param records is the RecordList of all the Record objects
     * @throws IOException when the file is corrupted.
     */
    public void saveFile(ArrayList<Record> records) throws IOException {
        FileWriter fw = new FileWriter(dataFilePath.toString(), false);
        for (Record r : records) {
            fw.write(r.convertFileFormat() + System.lineSeparator());
        }
    }

    public void saveRecordListData(RecordList records) {
        try {
            writeToSaveFile(records);
        } catch (IOException e) {
            System.out.println("Error in writeToSaveFile()");
        }
    }

    private void writeToSaveFile(RecordList records) throws IOException {
        FileWriter fw = new FileWriter(dataFilePath.toString(), false);
        fw.write("Test Save!\n");
        for (int i = 0; i < records.getRecordCount(); i++) {
            Record currentRecord = records.getRecordAt(i);
            fw.write(currentRecord.convertFileFormat() + System.lineSeparator());
        }
        fw.close();
    }

    /**
     * Loads the RecordList from the file into FINUX.
     *
     * @return a RecordList from the loaded file.
     */
    public ArrayList<Record> loadFile() {
        ArrayList<Record> records = new ArrayList<>();
        try {
            File loadFile = dataFilePath.toFile();
            Scanner sc = new Scanner(loadFile);
            while (sc.hasNextLine()) {
                String rawData = sc.nextLine();
                Record record = parseRecord(rawData);
                if (record != null) {
                    records.add(record);
                }
            }
            return records;
        } catch (Exception e) {
            System.exit(-1);
            return records;
        }
    }

    private Record parseRecord(String rawData) {
        try {
            if (Pattern.matches(REGEX_PATTERN_EXPENSE, rawData)) {
                return loadExpense(rawData);
            } else if (Pattern.matches(REGEX_PATTERN_LOAN, rawData)) {
                return loadLoan(rawData);
            } else if (Pattern.matches(REGEX_PATTERN_SAVING, rawData)) {
                return loadSaving(rawData);
            } else {
                throw new InvalidFileInputException("No such Record type!");
            }
        } catch (InvalidFileInputException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private String extractArg(String rawData, int index) throws InvalidFileInputException {
        String[] args = rawData.split("\\|");
        if(index < 0 || index > args.length) {
            throw new InvalidFileInputException("Record has fewer arguments than expected!");
        }
        return args[index].strip();
    }

    private Record loadExpense(String rawData) throws InvalidFileInputException{
        double amount;
        LocalDate issueDate;
        String description = extractArg(rawData, INDEX_OF_DESCRIPTION);

        try {
            amount = Double.parseDouble(extractArg(rawData, INDEX_OF_AMOUNT));
            issueDate = LocalDate.parse(extractArg(rawData, INDEX_OF_DATE),
                    DateTimeFormatter.ofPattern("ddMMyyyy"));
        } catch (NumberFormatException e) {
            throw new InvalidFileInputException("Amount not in recognisable format!");
        } catch (DateTimeParseException e) {
            throw new InvalidFileInputException("Date not in recognisable format!");
        }

        return new Expense(amount, issueDate, description);
    }

    private Record loadLoan(String rawData) throws InvalidFileInputException{
        double amount;
        String description = extractArg(rawData, INDEX_OF_DESCRIPTION);
        LocalDate issueDate = LocalDate.parse(extractArg(rawData, INDEX_OF_DATE),
                DateTimeFormatter.ofPattern("ddMMyyyy"));

        try {
            amount = Double.parseDouble(extractArg(rawData, INDEX_OF_AMOUNT));
        } catch (NumberFormatException e) {
            throw new InvalidFileInputException("Amount not in unrecognisable format!");
        }

        return new Loan(amount, issueDate, description);
    }

    private Record loadSaving(String rawData) throws InvalidFileInputException{
        double amount;
        String description = extractArg(rawData, INDEX_OF_DESCRIPTION);
        LocalDate issueDate = LocalDate.parse(extractArg(rawData, INDEX_OF_DATE),
                DateTimeFormatter.ofPattern("ddMMyyyy"));

        try {
            amount = Double.parseDouble(extractArg(rawData, INDEX_OF_AMOUNT));
        } catch (NumberFormatException e) {
            throw new InvalidFileInputException("Amount not in unrecognisable format!");
        }

        return new Saving(amount, issueDate, description);
    }
}
