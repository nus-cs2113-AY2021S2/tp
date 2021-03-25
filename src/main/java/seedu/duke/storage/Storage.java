package seedu.duke.storage;

import seedu.duke.command.BorrowersCreditScoreForReturnedLoans;
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
    private static final String REGEX_PATTERN_LOAN = "[L]\\s\\|\\s[^|]+\\s\\|\\s[^|]+\\s\\|\\s[^|]+\\s\\|\\s[01]";
    private static final String REGEX_PATTERN_SAVING = "[S]\\s\\|\\s[^|]+\\s\\|\\s[^|]+\\s\\|\\s[^|]+";
    private static final String REGEX_PATTERN_BORROWER_CREDIT_SCORE_FOR_RETURNED_LOANS = "[^|]+\\s\\|\\s\\d{1,3}";
    private static final int INDEX_OF_DESCRIPTION = 1;
    private static final int INDEX_OF_AMOUNT = 2;
    private static final int INDEX_OF_DATE = 3;
    private static final int INDEX_OF_ISRETURN = 4;
    private ArrayList<Record> records;
    private HashMap<String, Integer> borrowersCreditScoreForReturnedLoansMap;

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

    public void saveData(RecordList records, BorrowersCreditScoreForReturnedLoans
            borrowersCreditScoreForReturnedLoans) {
        try {
            writeRecordListToSaveFile(records);
            writeBorrowersCreditScoreForReturnedLoansToSaveFile(borrowersCreditScoreForReturnedLoans);
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

    private void writeBorrowersCreditScoreForReturnedLoansToSaveFile(BorrowersCreditScoreForReturnedLoans
            borrowersCreditScoreForReturnedLoans) throws IOException {
        FileWriter fw = new FileWriter(dataFilePath.toString(), true);
        for (String borrowerNameInLowerCase: borrowersCreditScoreForReturnedLoans.getBorrowersNamesInLowerCase()) {
            int creditScore = getCreditScore(borrowersCreditScoreForReturnedLoans, borrowerNameInLowerCase);
            fw.write(borrowerNameInLowerCase + " | " + creditScore + System.lineSeparator());
        }
        fw.close();
    }

    private int getCreditScore(BorrowersCreditScoreForReturnedLoans borrowersCreditScoreForReturnedLoans,
                               String borrowerName) {
        return borrowersCreditScoreForReturnedLoans.getCurrentBorrowerCreditScoreForReturnedLoans(borrowerName);
    }

    /**
     * Loads the RecordList from the file into FINUX.
     */
    public void loadFile() throws FileLoadingException {
        this.records = new ArrayList<>();
        this.borrowersCreditScoreForReturnedLoansMap = new HashMap<>();

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
                } else if (parsedObject != null) {
                    String[] borrowerCreditScoreForReturnedLoansData = (String[]) parsedObject;
                    borrowersCreditScoreForReturnedLoansMap.put(borrowerCreditScoreForReturnedLoansData[0],
                            Integer.parseInt(borrowerCreditScoreForReturnedLoansData[1]));
                }
                assert !records.isEmpty() : "RecordList should have data!";
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
        } else if (Pattern.matches(REGEX_PATTERN_BORROWER_CREDIT_SCORE_FOR_RETURNED_LOANS, rawData)) {
            return loadBorrowerCreditScoreForReturnedLoans(rawData);
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
        LocalDate issueDate = LocalDate.parse(extractArg(rawData, INDEX_OF_DATE),
                DateTimeFormatter.ofPattern("yyyy-M-d"));

        try {
            amount = new BigDecimal(extractArg(rawData, INDEX_OF_AMOUNT));
            isReturn = Integer.parseInt(extractArg(rawData, INDEX_OF_ISRETURN)) == 1;
        } catch (NumberFormatException | DateTimeParseException e) {
            throw new InvalidFileInputException();
        }

        return new Loan(amount, issueDate, description, "borrowerName", null, isReturn);
    }

    private Record loadSaving(String rawData) throws InvalidFileInputException {
        BigDecimal amount;
        String description = extractArg(rawData, INDEX_OF_DESCRIPTION);
        LocalDate issueDate = LocalDate.parse(extractArg(rawData, INDEX_OF_DATE),
                DateTimeFormatter.ofPattern("yyyy-M-d"));

        try {
            amount = new BigDecimal(extractArg(rawData, INDEX_OF_AMOUNT));
        } catch (NumberFormatException | DateTimeParseException e) {
            throw new InvalidFileInputException();
        }

        return new Saving(amount, issueDate, description);
    }

    private String[] loadBorrowerCreditScoreForReturnedLoans(String rawData) throws InvalidFileInputException {
        String[] borrowerCreditScoreForReturnedLoansData = rawData.split(" \\| ");
        borrowerCreditScoreForReturnedLoansData[0] = borrowerCreditScoreForReturnedLoansData[0].toLowerCase();
        int creditScore = Integer.parseInt(borrowerCreditScoreForReturnedLoansData[1]);

        if (borrowersCreditScoreForReturnedLoansMap.containsKey(borrowerCreditScoreForReturnedLoansData[0])) {
            throw new InvalidFileInputException();
        }

        if (creditScore < 0 || creditScore > 100) {
            throw new InvalidFileInputException();
        }

        return borrowerCreditScoreForReturnedLoansData;
    }

    public ArrayList<Record> getRecordListData() {
        return records;
    }

    public HashMap<String, Integer> getBorrowersCreditScoreForReturnedLoansMapData() {
        return borrowersCreditScoreForReturnedLoansMap;
    }
}
