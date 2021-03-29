package seedu.duke.storage;

import seedu.duke.command.CreditScoreMap;
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

public class Storage {
    private static final Path SAVED_FILE_PATH = Paths.get("finux.txt");
    private static final String REGEX_PATTERN_EXPENSE = "[E]\\s\\|\\s[^|]+\\s\\|\\s[^|]+\\s\\|\\s[^|]+";
    private static final String REGEX_PATTERN_LOAN =
            "[L]\\s\\|\\s[^|]+\\s\\|\\s[^|]+\\s\\|\\s[^|]+\\s\\|\\s[01]\\s\\|\\s[^|]+\\s\\|\\s[^|]+";
    private static final String REGEX_PATTERN_SAVING = "[S]\\s\\|\\s[^|]+\\s\\|\\s[^|]+\\s\\|\\s[^|]+";
    private static final String REGEX_PATTERN_CREDIT_SCORE = "[^|]+\\s\\|\\s\\d{1,3}";
    private static final int INDEX_OF_DESCRIPTION = 1;
    private static final int INDEX_OF_AMOUNT = 2;
    private static final int INDEX_OF_DATE = 3;
    private static final int INDEX_OF_ISRETURN = 4;
    private static final int INDEX_OF_NAME = 5;
    private static final int INDEX_OF_RETURN_DATE = 6;
    private ArrayList<Record> records;
    private HashMap<String, Integer> creditScoreHashMapData;

    public Path dataFilePath;


    public Storage() {
        this(SAVED_FILE_PATH);
    }

    public Storage(Path dataFilePath) {
        this.dataFilePath = dataFilePath;
    }

    private boolean saveFileExists() {
        return Files.exists(SAVED_FILE_PATH);
    }

    public void saveData(RecordList records, CreditScoreMap creditScoreMap) {
        try {
            writeRecordListToSaveFile(records);
            writeCreditScoreMapToSaveFile(creditScoreMap);
        } catch (IOException e) {
            System.out.println("Error in saveData()");
        }
    }

    private void writeRecordListToSaveFile(RecordList records) throws IOException {
        FileWriter fw = new FileWriter(dataFilePath.toString(), false);
        for (int i = 0; i < records.getRecordCount(); i++) {
            Record currentRecord = records.getRecordAt(i);
            fw.write(currentRecord.convertFileFormat() + System.lineSeparator());
        }
        fw.close();
    }

    private void writeCreditScoreMapToSaveFile(CreditScoreMap creditScoreMap) throws IOException {
        FileWriter fw = new FileWriter(dataFilePath.toString(), true);
        for (String borrowerName : creditScoreMap.getBorrowersNames()) {
            int creditScore = getCreditScore(creditScoreMap, borrowerName);
            fw.write(borrowerName + " | " + creditScore + System.lineSeparator());
        }
        fw.close();
    }

    private int getCreditScore(CreditScoreMap creditScoreMap, String borrowerName) {
        return creditScoreMap.getCreditScore(borrowerName);
    }

    /**
     * Loads the RecordList from the file into FINUX.
     */
    public void loadFile() throws FileLoadingException {
        this.records = new ArrayList<>();
        this.creditScoreHashMapData = new HashMap<>();

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
                if (parsedObject instanceof Record) {
                    records.add((Record) parsedObject);
                    assert !records.isEmpty() : "RecordList should have data!";
                } else if (parsedObject != null) {
                    String[] creditScoreRawData = (String[]) parsedObject;
                    creditScoreHashMapData.put(creditScoreRawData[0], Integer.parseInt(creditScoreRawData[1]));
                }
            }
        } catch (InvalidFileInputException | IOException e) {
            throw new FileLoadingException();
        }
    }

    private void initSaveFile() throws IOException {
        File newSaveFile = new File(String.valueOf(SAVED_FILE_PATH));
        if (newSaveFile.createNewFile()) {
            Ui.printSuccessfulFileCreation();
        } else {
            throw new IOException("File creation unsuccessful!");
        }
    }

    private Object parseRawData(String rawData) throws InvalidFileInputException {
        if (Pattern.matches(REGEX_PATTERN_EXPENSE, rawData)) {
            return loadExpense(rawData);
        } else if (Pattern.matches(REGEX_PATTERN_LOAN, rawData)) {
            return loadLoan(rawData);
        } else if (Pattern.matches(REGEX_PATTERN_SAVING, rawData)) {
            return loadSaving(rawData);
        } else if (Pattern.matches(REGEX_PATTERN_CREDIT_SCORE, rawData)) {
            return loadCreditScoreRawData(rawData);
        } else {
            throw new InvalidFileInputException();
        }
    }

    private String extractArg(String rawData, int index) throws InvalidFileInputException {
        String[] args = rawData.split("\\|");
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
            issueDate = LocalDate.parse(extractArg(rawData, INDEX_OF_DATE),
                    DateTimeFormatter.ofPattern("yyyy-M-d"));
        } catch (NumberFormatException | DateTimeParseException e) {
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
            isReturn = Integer.parseInt(extractArg(rawData, INDEX_OF_ISRETURN)) == 1;
            issueDate = LocalDate.parse(extractArg(rawData, INDEX_OF_DATE),
                    DateTimeFormatter.ofPattern("yyyy-M-d"));
            if (extractArg(rawData, INDEX_OF_RETURN_DATE).equals("null")) {
                returnDate = null;
            } else {
                returnDate = LocalDate.parse(extractArg(rawData, INDEX_OF_RETURN_DATE),
                        DateTimeFormatter.ofPattern("yyyy-M-d"));
            }
        } catch (NumberFormatException | DateTimeParseException e) {
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
            issueDate = LocalDate.parse(extractArg(rawData, INDEX_OF_DATE),
                    DateTimeFormatter.ofPattern("yyyy-M-d"));
        } catch (NumberFormatException | DateTimeParseException e) {
            throw new InvalidFileInputException();
        }

        return new Saving(amount, issueDate, description);
    }

    private String[] loadCreditScoreRawData(String rawData) throws InvalidFileInputException {
        String[] creditScoreRawData = rawData.split(" \\| ");
        String borrowerName = creditScoreRawData[0].toLowerCase();
        if (!borrowerName.equals(creditScoreRawData[0])) {
            throw new InvalidFileInputException();
        }

        if (creditScoreHashMapData.containsKey(creditScoreRawData[0])) {
            throw new InvalidFileInputException();
        }

        int creditScore = Integer.parseInt(creditScoreRawData[1]);
        if (creditScore < 0 || creditScore > 100) {
            throw new InvalidFileInputException();
        }

        return creditScoreRawData;
    }

    public ArrayList<Record> getRecordListData() {
        return records;
    }

    public HashMap<String, Integer> getCreditScoreHashMapData() {
        return creditScoreHashMapData;
    }
}
