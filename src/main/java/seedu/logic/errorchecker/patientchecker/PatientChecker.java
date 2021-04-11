package seedu.logic.errorchecker.patientchecker;

import seedu.exceptions.CorruptedFileException;
import seedu.exceptions.DuplicateIdException;
import seedu.exceptions.ExcessInputException;
import seedu.exceptions.HealthVaultException;
import seedu.exceptions.IdNotFoundException;
import seedu.exceptions.InsufficientInputException;
import seedu.exceptions.NoInputException;
import seedu.exceptions.UnrecognizedCommandException;
import seedu.exceptions.patient.InvalidPatientAgeException;
import seedu.exceptions.patient.InvalidPatientIdException;
import seedu.logger.HealthVaultLogger;
import seedu.logic.errorchecker.MainChecker;
import seedu.logic.errorchecker.patientchecker.utils.CommandInputTypeLength;
import seedu.model.patient.PatientList;
import seedu.model.patient.Patient;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Checks the user input for any characters and format that causes volatility in the program.
 */
public class PatientChecker extends MainChecker {

    private PatientList patients;
    private ArrayList<Patient> patientArrayList;
    private String[] stringTokens;
    private String command;
    private int numberOfTokens;
    public Logger logger = HealthVaultLogger.getLogger();

    /**
     * Constructor for patient data internally received from parser.
     *
     * @param patients patients currently in the list.
     * @param stringTokens the string that has already been split using the delimiter.
     * @param command the command that the user is trying to access.
     * @param numberOfTokens the number of tokens in the resulting string array.
     */
    public PatientChecker(PatientList patients, String[] stringTokens, String command, int numberOfTokens) {
        this.patients = patients;
        this.stringTokens = stringTokens;
        this.command = command;
        this.numberOfTokens = numberOfTokens;
    }

    /**
     * Constructor for patient data retrieved from storage.
     *
     * @param patients patients currently in the list.
     * @param stringTokens the string that has already been split using the delimiter.
     * @param numberOfTokens the number of tokens in the resulting string array.
     */
    public PatientChecker(ArrayList<Patient> patients, String[] stringTokens, int numberOfTokens) {
        patientArrayList = patients;
        this.stringTokens = stringTokens;
        this.numberOfTokens = numberOfTokens;
    }

    /**
     * Uses methods to check the input from the storage.
     * Throws an exception if there is a violation found.
     *
     * @throws HealthVaultException collection of exceptions from checks.
     */
    public void checkStorage() throws HealthVaultException, NumberFormatException {
        emptySpaceCheck();
        checkStorageLength();
        checkIdStorage();
        checkAge(stringTokens[2]);
        illegalCharacterChecker(stringTokens[1], "name");
        illegalCharacterChecker(stringTokens[4], "Illness");
        illegalCharacterChecker(stringTokens[5], "medication required");
        checkGender(stringTokens[3].toLowerCase());
    }

    /**
     * Uses methods to check the input from the user using the add command.
     * Throws an exception if there is a violation found.
     *
     * @throws HealthVaultException collection of exceptions from checks.
     */
    public void checkAdd() throws HealthVaultException, NumberFormatException {
        emptySpaceCheck();
        checkLength();
        checkId();
        checkAge(stringTokens[3]);
        illegalCharacterChecker(stringTokens[2], "name");
        illegalCharacterChecker(stringTokens[5], "Illness");
        illegalCharacterChecker(stringTokens[6], "medication required");
        checkGender(stringTokens[4].toLowerCase());
    }

    /**
     * Uses methods to check the input from the user using the find command.
     * Throws an exception if there is a violation found.
     *
     * @throws HealthVaultException collection of exceptions from checks.
     */
    public void checkFind() throws HealthVaultException {
        emptySpaceCheck();
        checkLength();
        illegalCharacterChecker(stringTokens[1], "keyword");
    }

    /**
     * Checks if the number of tokens in the split input from the storage is acceptable.
     *
     * @throws CorruptedFileException when file is corrupted.
     */
    public void checkStorageLength() throws HealthVaultException {
        if (numberOfTokens != 6) {
            logger.log(Level.WARNING, "Corrupted patient file.");
            throw new CorruptedFileException("Patient");
        }
    }

    /**
     * Checks if the number of tokens in the split input from the storage is acceptable for the given command.
     *
     * @throws ExcessInputException when the number of input fields is in excess.
     * @throws InsufficientInputException when the number of input fields is insufficient.
     * @throws UnrecognizedCommandException when the command is unrecognized.
     */
    public void checkLength() throws ExcessInputException, InsufficientInputException, UnrecognizedCommandException {
        CommandInputTypeLength c = commandLengthClassifier();
        switch (c) {
        case MULTI:
            inputLengthCheck(7, numberOfTokens);
            break;
        case DUAL:
            inputLengthCheck(2, numberOfTokens);
            break;
        case SINGLE:
            inputLengthCheck(1, numberOfTokens);
            break;
        default:
            throw new UnrecognizedCommandException();
        }
    }

    /**
     * Identifies the appropriate allows length for a particular command.
     *
     * @return CommandInputTypeLength which shows represents the desired length of the command.
     * @throws UnrecognizedCommandException when the command is unrecognized.
     */
    public CommandInputTypeLength commandLengthClassifier() throws UnrecognizedCommandException {
        CommandInputTypeLength commandLength;
        switch (command) {
        case "add":
            commandLength = CommandInputTypeLength.MULTI;
            break;
        case "delete":
        case "find":
            commandLength = CommandInputTypeLength.DUAL;
            break;
        case "list":
        case "help":
        case "return":
            commandLength = CommandInputTypeLength.SINGLE;
            break;
        default:
            throw new UnrecognizedCommandException();
        }
        return commandLength;
    }

    /**
     * Checks if the given command has greater or fewer than the required number of inputs.
     *
     * @param correctNumberInputs the ideal number of inputs for this particular command
     * @param numberOfTokens the number of inputs currently in the command
     * @throws ExcessInputException when the number of input fields is in excess.
     * @throws InsufficientInputException when the number of input fields is insufficient.
     */
    public void inputLengthCheck(int correctNumberInputs, int numberOfTokens) throws ExcessInputException,
            InsufficientInputException {
        if (numberOfTokens > correctNumberInputs) {
            logger.log(Level.WARNING, "Incorrect patient input fields, excess fields.");
            throw new ExcessInputException();
        } else if (numberOfTokens < correctNumberInputs) {
            logger.log(Level.WARNING, "Incorrect patient input fields, insufficient fields.");
            throw new InsufficientInputException();
        }
    }

    /**
     * Checks in the user has inputted an empty string or no text into an input field.
     *
     * @throws NoInputException when the user has omitted a required field.
     */
    public void emptySpaceCheck() throws NoInputException {
        for (int i = 0; i < numberOfTokens; i++) {
            if (stringTokens[i].trim().equals("")) {
                logger.log(Level.WARNING, "Input field is empty.");
                throw new NoInputException();
            }
        }
    }

    /**
     * Checks if the Age of the patient is appropriate.
     *
     * @param stringToken the age of the user.
     * @throws NumberFormatException when the input from the user is not an integer.
     * @throws HealthVaultException collection of exceptions from checks.
     */
    public void checkAge(String stringToken) throws NumberFormatException, HealthVaultException {
        checkNumericInput(stringToken);
        checkAgeRange(stringToken);
    }

    /**
     * Checks if the age of the patient is within the appropriate range.
     *
     * @param ageString the age of the patient.
     * @throws InvalidPatientAgeException when the patient's age is not acceptable.
     */
    public void checkAgeRange(String ageString) throws InvalidPatientAgeException {
        int age = Integer.parseInt(ageString);
        if (!(age >= 0 && age <= 150)) {
            logger.log(Level.WARNING, "Patient age is out of range.");
            throw new InvalidPatientAgeException();
        }
    }

    /**
     * Checks if the ID of the patient from the parser is acceptable.
     *
     * @throws HealthVaultException collection of exceptions from checks.
     */
    public void checkId() throws HealthVaultException {
        checkValidId(stringTokens[1]);
        checkIdExist(stringTokens[1], patients, command);
    }

    /**
     * Checks if the ID of the patient from the storage is acceptable.
     *
     * @throws HealthVaultException collection of exceptions from checks.
     */
    public void checkIdStorage() throws HealthVaultException {
        checkValidId(stringTokens[0]);
        checkIdExistStorage(stringTokens[0]);
    }

    /**
     * Checks the number of integers in the string.
     *
     * @param userInput the user input to be checked.
     * @return the number of integers in the user input.
     */
    public int numberOfIntegersInString(String userInput) {
        int numberOfIntegers = 0;
        for (int i = 0; i < userInput.length(); i++) {
            if (Character.isDigit(userInput.charAt(i))) {
                numberOfIntegers++;
            }
        }
        return numberOfIntegers;
    }

    /**
     * Checks if the ID is of the proper format.
     *
     * @param userID the string containing the ID of the patient.
     * @throws InvalidPatientIdException when the characters in the patient ID are unacceptable.
     */
    public void checkValidId(String userID) throws InvalidPatientIdException {
        if (userID.length() != 6) {
            logger.log(Level.WARNING, "Incorrect patient ID length.");
            throw new InvalidPatientIdException();
        } else if (!(userID.charAt(0) == 'P')) {
            logger.log(Level.WARNING, "Incorrect patient ID type.");
            throw new InvalidPatientIdException();
        } else if (numberOfIntegersInString(userID) != 5) {
            logger.log(Level.WARNING, "Incorrect patient ID value.");
            throw new InvalidPatientIdException();
        }
    }

    /**
     * Checks if there is a matching ID in the patient list retrieved from storage.
     *
     * @param userID the string containing the ID of the patient.
     * @throws CorruptedFileException when file is corrupted.
     */
    public void checkIdExistStorage(String userID) throws CorruptedFileException {
        if (isIdTakenStorage(userID)) {
            logger.log(Level.WARNING, "Duplicate patient ID in storage.");
            throw new CorruptedFileException("Patient");
        }
    }

    /**
     * Checks if the ID already exists within the list of patients from the storage.
     *
     * @param userID the string containing the ID of the patient.
     * @return true if the ID is taken already and false if the ID is new.
     */
    public boolean isIdTakenStorage(String userID) {
        for (Patient patient : patientArrayList) {
            String patientID = patient.getPatientID();
            if (patientID.equals(userID)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the ID already exists in the list of patients.
     *
     * @param userID the string containing the ID of the patient.
     * @param patients the current list of patients.
     * @param command the command that the user is trying to access.
     * @throws IdNotFoundException when the ID does not exist in the patient list
     * @throws DuplicateIdException when there is already an existing ID in the patient list.
     */
    public void checkIdExist(String userID, PatientList patients, String command) throws IdNotFoundException,
            DuplicateIdException {
        if (patients.isIdTaken(userID)) {
            if (command.equals("add")) {
                logger.log(Level.WARNING, "Duplicate patient ID in patient list.");
                throw new DuplicateIdException("Patient");
            }
        } else {
            if ((command.equals("delete") || command.equals("find"))) {
                logger.log(Level.WARNING, "Patient ID does not exist.");
                throw new IdNotFoundException("Patient");
            }
        }
    }
}
