package seedu.duke.storage;

import seedu.duke.command.CreditScoreReturnedLoansMap;
import seedu.duke.exception.FileLoadingException;
import seedu.duke.exception.InvalidFileInputException;
import seedu.duke.record.Expense;
import seedu.duke.record.Loan;
import seedu.duke.record.Record;
import seedu.duke.record.RecordList;
import seedu.duke.record.Saving;
import seedu.duke.ui.Ui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

import static seedu.duke.common.Constant.MAX_CREDIT_SCORE;
import static seedu.duke.common.Constant.MIN_CREDIT_SCORE;
import static seedu.duke.common.Constant.FILE_DELIMITER_CHAR;
import static seedu.duke.common.Constant.FINUX_LOGGER;

public class Storage {
    private static final Path SAVED_FILE_PATH = Paths.get("finux.txt");
    private static final String REGEX_PATTERN_EXPENSE = "[E]\\s\\|\\s[^|]+\\s\\|\\s[^|]+\\s\\|\\s[^|]+";
    private static final String REGEX_PATTERN_LOAN =
            "[L]\\s\\|\\s[^|]+\\s\\|\\s[^|]+\\s\\|\\s[^|]+\\s\\|\\s[01]\\s\\|\\s[^|]+\\s\\|\\s[^|]+";
    private static final String REGEX_PATTERN_SAVING = "[S]\\s\\|\\s[^|]+\\s\\|\\s[^|]+\\s\\|\\s[^|]+";
    private static final String REGEX_PATTERN_MAP_ENTRY_RAW_DATA = "[^|]+\\s\\|\\s\\d{1,3}";
    private static final String FILE_DELIMITER_CHAR_REGEX = "\\|";
    private static final String WHITESPACE_CHAR = " ";
    private static final int BORROWER_NAME_INDEX = 0;
    private static final int CREDIT_SCORE_RETURNED_LOANS_INDEX = 1;
    private static final int INDEX_OF_DESCRIPTION = 1;
    private static final int INDEX_OF_AMOUNT = 2;
    private static final int INDEX_OF_DATE = 3;
    private static final int INDEX_OF_IS_RETURN = 4;
    private static final int INDEX_OF_NAME = 5;
    private static final int INDEX_OF_RETURN_DATE = 6;
    private ArrayList<Record> recordList;
    private HashMap<String, Integer> creditScoreReturnedLoansMap;
    private Path dataFilePath;

    public Storage() {
        this(SAVED_FILE_PATH);
    }

    public Storage(Path dataFilePath) {
        this.dataFilePath = dataFilePath;
    }

    private boolean saveFileExists() {
        return Files.exists(SAVED_FILE_PATH);
    }

    /**
     * Saves the data in the recordList and creditScoreRetrunedLoansMap into a local text file.
     *
     * @param recordList is the recordList.
     * @param creditScoreReturnedLoansMap is the creditScoreReturnedLoansMap.
     */
    public void saveData(RecordList recordList, CreditScoreReturnedLoansMap creditScoreReturnedLoansMap) {
        try {
            writeRecordListToSaveFile(recordList);
            writeMapToSaveFile(creditScoreReturnedLoansMap);
        } catch (IOException e) {
            System.out.println("Error in saving data!");
        }
    }

    private void writeRecordListToSaveFile(RecordList recordList) throws IOException {
        FileWriter fw = new FileWriter(dataFilePath.toString(), false);
        for (int i = 0; i < recordList.getRecordCount(); i++) {
            Record currentRecord = recordList.getRecordAt(i);
            fw.write(currentRecord.convertFileFormat() + System.lineSeparator());
        }
        fw.close();
    }

    private void writeMapToSaveFile(CreditScoreReturnedLoansMap creditScoreReturnedLoansMap) throws IOException {
        FileWriter fw = new FileWriter(dataFilePath.toString(), true);
        for (String borrowerName : creditScoreReturnedLoansMap.getBorrowersNames()) {
            int creditScore = creditScoreReturnedLoansMap.getCreditScoreOf(borrowerName);
            fw.write(borrowerName + WHITESPACE_CHAR + FILE_DELIMITER_CHAR + WHITESPACE_CHAR + creditScore
                    + System.lineSeparator());
        }
        fw.close();
    }

    /**
     * Loads the RecordList from the file into FINUX.
     */
    public void loadFile() throws FileLoadingException {
        recordList = new ArrayList<>();
        creditScoreReturnedLoansMap = new HashMap<>();

        try {
            if (!saveFileExists()) {
                initSaveFile();
                return;
            }
            File loadFile = dataFilePath.toFile();
            Scanner sc = new Scanner(loadFile);
            while (sc.hasNextLine()) {
                String rawData = sc.nextLine();
                Object parsedObject = parseRawData(rawData);
                processParsedObject(parsedObject);
            }
        } catch (InvalidFileInputException | IOException e) {
            throw new FileLoadingException();
        }
    }

    private void processParsedObject(Object parsedObject) {
        if (parsedObject instanceof Record) {
            recordList.add((Record) parsedObject);
            assert !recordList.isEmpty() : "RecordList should have data!";
        } else if (parsedObject != null) {
            String[] mapEntryRawData = (String[]) parsedObject;
            creditScoreReturnedLoansMap.put(mapEntryRawData[BORROWER_NAME_INDEX],
                    Integer.parseInt(mapEntryRawData[CREDIT_SCORE_RETURNED_LOANS_INDEX]));
        }
    }

    private void initSaveFile() throws IOException {
        File newSaveFile = new File(String.valueOf(SAVED_FILE_PATH));
        if (!newSaveFile.createNewFile()) {
            FINUX_LOGGER.logWarning("File creation unsuccessful!");
            throw new IOException("File creation unsuccessful!");
        }
        Ui.printSuccessfulFileCreation();
    }

    private Object parseRawData(String rawData) throws InvalidFileInputException {
        if (Pattern.matches(REGEX_PATTERN_EXPENSE, rawData)) {
            return loadExpense(rawData);
        } else if (Pattern.matches(REGEX_PATTERN_LOAN, rawData)) {
            return loadLoan(rawData);
        } else if (Pattern.matches(REGEX_PATTERN_SAVING, rawData)) {
            return loadSaving(rawData);
        } else if (Pattern.matches(REGEX_PATTERN_MAP_ENTRY_RAW_DATA, rawData)) {
            return loadMapEntryRawData(rawData);
        } else {
            FINUX_LOGGER.logWarning("Invalid File Inputs!");
            throw new InvalidFileInputException();
        }
    }

    private String extractArg(String rawData, int index) throws InvalidFileInputException {
        String[] args = rawData.split(FILE_DELIMITER_CHAR_REGEX);
        if (index < 0 || index > args.length) {
            throw new InvalidFileInputException();
        }

        return args[index].strip();
    }

    private Record loadExpense(String rawData) throws InvalidFileInputException {
        BigDecimal amount;
        LocalDate issueDate;
        String description = extractArg(rawData, INDEX_OF_DESCRIPTION);

        try {
            amount = new BigDecimal(extractArg(rawData, INDEX_OF_AMOUNT));
            issueDate = LocalDate.parse(extractArg(rawData, INDEX_OF_DATE), DateTimeFormatter.ofPattern("yyyy-M-d"));
        } catch (NumberFormatException | DateTimeParseException e) {
            FINUX_LOGGER.logWarning("[E] Invalid data format!");
            throw new InvalidFileInputException();
        }

        return new Expense(amount, issueDate, description);
    }

    private Record loadLoan(String rawData) throws InvalidFileInputException {
        BigDecimal amount;
        boolean isReturn;
        String description = extractArg(rawData, INDEX_OF_DESCRIPTION);
        LocalDate issueDate;
        String borrowerName = extractArg(rawData, INDEX_OF_NAME);
        LocalDate returnDate;

        try {
            amount = new BigDecimal(extractArg(rawData, INDEX_OF_AMOUNT));
            isReturn = Integer.parseInt(extractArg(rawData, INDEX_OF_IS_RETURN)) == 1;
            issueDate = LocalDate.parse(extractArg(rawData, INDEX_OF_DATE), DateTimeFormatter.ofPattern("yyyy-M-d"));
            if (extractArg(rawData, INDEX_OF_RETURN_DATE).equals("null")) {
                returnDate = null;
            } else {
                returnDate = LocalDate.parse(extractArg(rawData, INDEX_OF_RETURN_DATE),
                        DateTimeFormatter.ofPattern("yyyy-M-d"));
            }
        } catch (NumberFormatException | DateTimeParseException e) {
            FINUX_LOGGER.logWarning("[L] Invalid data format!");
            throw new InvalidFileInputException();
        }

        return new Loan(amount, issueDate, description, borrowerName, returnDate, isReturn);
    }

    private Record loadSaving(String rawData) throws InvalidFileInputException {
        BigDecimal amount;
        String description = extractArg(rawData, INDEX_OF_DESCRIPTION);
        LocalDate issueDate;

        try {
            amount = new BigDecimal(extractArg(rawData, INDEX_OF_AMOUNT));
            issueDate = LocalDate.parse(extractArg(rawData, INDEX_OF_DATE), DateTimeFormatter.ofPattern("yyyy-M-d"));
        } catch (NumberFormatException | DateTimeParseException e) {
            FINUX_LOGGER.logWarning("[S] Invalid data format!");
            throw new InvalidFileInputException();
        }

        return new Saving(amount, issueDate, description);
    }

    private String[] loadMapEntryRawData(String rawData) throws InvalidFileInputException {
        String[] mapEntryRawData = rawData.split(FILE_DELIMITER_CHAR_REGEX);
        mapEntryRawData[BORROWER_NAME_INDEX] = mapEntryRawData[BORROWER_NAME_INDEX].strip();
        mapEntryRawData[CREDIT_SCORE_RETURNED_LOANS_INDEX] = mapEntryRawData[CREDIT_SCORE_RETURNED_LOANS_INDEX].strip();
        String borrowerNameInLowerCase = mapEntryRawData[BORROWER_NAME_INDEX].toLowerCase();
        if (!borrowerNameInLowerCase.equals(mapEntryRawData[BORROWER_NAME_INDEX])) {
            throw new InvalidFileInputException();
        }

        if (creditScoreReturnedLoansMap.containsKey(mapEntryRawData[BORROWER_NAME_INDEX])) {
            throw new InvalidFileInputException();
        }

        int creditScore = Integer.parseInt(mapEntryRawData[CREDIT_SCORE_RETURNED_LOANS_INDEX]);
        if (creditScore < ((int) MIN_CREDIT_SCORE) || creditScore > ((int) MAX_CREDIT_SCORE)) {
            throw new InvalidFileInputException();
        }

        return mapEntryRawData;
    }

    public ArrayList<Record> getRecordListData() {
        return recordList;
    }

    public HashMap<String, Integer> getMapData() {
        return creditScoreReturnedLoansMap;
    }
}