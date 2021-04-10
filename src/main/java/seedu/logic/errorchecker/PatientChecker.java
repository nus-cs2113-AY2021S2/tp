package seedu.logic.errorchecker;

import seedu.exceptions.CorruptedFileException;
import seedu.exceptions.DuplicateIDException;
import seedu.exceptions.HealthVaultException;
import seedu.exceptions.IDNotFoundException;
import seedu.exceptions.NoInputException;
import seedu.exceptions.patient.InvalidFieldsNumberException;
import seedu.exceptions.patient.InvalidIdLengthException;
import seedu.exceptions.patient.InvalidIdTypeException;
import seedu.exceptions.patient.InvalidIdValueException;
import seedu.exceptions.patient.InvalidPatientAgeException;
import seedu.model.patient.PatientList;
import seedu.model.patient.Patient;

import java.util.ArrayList;

/**
 * Checks the user input for any characters and format that causes volatility in the program.
 */
public class PatientChecker extends MainChecker {

    private PatientList patients;
    private ArrayList<Patient> patientArrayList;
    private String[] stringTokens;
    private String command;
    private int numberOfTokens;

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
     * @throws HealthVaultException
     */
    public void checkStorage() throws HealthVaultException {
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
     * @throws HealthVaultException
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
     * @throws HealthVaultException
     */
    public void checkFind() throws HealthVaultException {
        emptySpaceCheck();
        checkLength();
        illegalCharacterChecker(stringTokens[1], "keyword");
    }

    /**
     * Checks if the number of tokens in the split input from the storage is acceptable.
     *
     * @throws CorruptedFileException
     */
    public void checkStorageLength() throws HealthVaultException {
        if (numberOfTokens != 6) {
            throw new CorruptedFileException("Patient");
        }
    }

    /**
     * Checks if the number of tokens in the split input from the storage is acceptable for the given command.
     *
     * @throws InvalidFieldsNumberException
     */
    public void checkLength() throws HealthVaultException {
        if (command.equals("add") && numberOfTokens != 7) {
            throw new InvalidFieldsNumberException(command);
        } else if ((command.equals("delete") || command.equals("find")) && numberOfTokens != 2) {
            throw new InvalidFieldsNumberException(command);
        } else if ((command.equals("list") || command.equals("return") || command.equals("help"))
                && numberOfTokens != 1) {
            throw new InvalidFieldsNumberException(command);
        }
    }

    /**
     * Checks in the user has inputted an empty string or no text into an input field.
     *
     * @throws NoInputException
     */
    private void emptySpaceCheck() throws NoInputException {
        for (int i = 0; i < numberOfTokens; i++) {
            if (stringTokens[i].trim().equals("")) {
                throw new NoInputException();
            }
        }
    }

    /**
     * Checks if the Age of the patient is appropriate.
     *
     * @param stringToken the age of the user.
     * @throws NumberFormatException
     * @throws HealthVaultException
     */
    private void checkAge(String stringToken) throws NumberFormatException, HealthVaultException {
        checkNumericInput(stringToken);
        checkAgeRange(stringToken);
    }

    /**
     * Checks if the age of the patient is within the appropriate range.
     *
     * @param ageString the age of the patient.
     * @throws InvalidPatientAgeException
     */
    private void checkAgeRange(String ageString) throws InvalidPatientAgeException {
        int age = Integer.parseInt(ageString);
        if (!(age >= 0 && age <= 150)) {
            throw new InvalidPatientAgeException();
        }
    }

    /**
     * Checks if the ID of the patient from the parser is acceptable.
     *
     * @throws HealthVaultException
     */
    public void checkId() throws HealthVaultException {
        checkValidId(stringTokens[1]);
        checkIdExist(stringTokens[1], patients, command);
    }

    /**
     * Checks if the ID of the patient from the storage is acceptable.
     *
     * @throws HealthVaultException
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
    private int numberOfIntegersInString(String userInput) {
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
     * @throws InvalidIdLengthException
     * @throws InvalidIdTypeException
     * @throws InvalidIdValueException
     */
    private void checkValidId(String userID) throws InvalidIdLengthException, InvalidIdTypeException,
            InvalidIdValueException {
        if (userID.length() != 6) {
            throw new InvalidIdLengthException("IDLength");
        } else if (!(userID.charAt(0) == 'P')) {
            throw new InvalidIdTypeException("IDType");
        } else if (numberOfIntegersInString(userID) != 5) {
            throw new InvalidIdValueException("IDValue");
        }
    }

    /**
     * Checks if there is a matching ID in the patient list retrieved from storage.
     *
     * @param userID the string containing the ID of the patient.
     * @throws CorruptedFileException
     */
    private void checkIdExistStorage(String userID) throws CorruptedFileException {
        if (isIdTakenStorage(userID)) {
            throw new CorruptedFileException("Patient");
        }
    }

    /**
     * Checks if the ID already exists within the list of patients from the storage.
     *
     * @param userID the string containing the ID of the patient.
     * @return true if the ID is taken already and false if the ID is new.
     */
    private boolean isIdTakenStorage(String userID) {
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
     * @throws IDNotFoundException
     * @throws DuplicateIDException
     */
    private void checkIdExist(String userID, PatientList patients, String command) throws IDNotFoundException,
            DuplicateIDException {
        if (patients.isIdTaken(userID)) {
            if (command.equals("add")) {
                throw new DuplicateIDException("Patient");
            }
        } else {
            if ((command.equals("delete") || command.equals("find"))) {
                throw new IDNotFoundException("Patient");
            }
        }
    }
}
