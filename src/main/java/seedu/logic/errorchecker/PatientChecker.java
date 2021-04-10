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

public class PatientChecker extends MainChecker {

    private PatientList patients;
    private ArrayList<Patient> patientArrayList;
    private String[] stringTokens;
    private String command;
    private int numberOfTokens;

    public PatientChecker(PatientList patients, String[] stringTokens, String command, int numberOfTokens) {
        this.patients = patients;
        this.stringTokens = stringTokens;
        this.command = command;
        this.numberOfTokens = numberOfTokens;
    }

    public PatientChecker(ArrayList<Patient> patients, String[] stringTokens, int numberOfTokens) {
        patientArrayList = patients;
        this.stringTokens = stringTokens;
        this.numberOfTokens = numberOfTokens;
    }

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

    public void checkFind() throws HealthVaultException {
        emptySpaceCheck();
        checkLength();
        illegalCharacterChecker(stringTokens[1], "keyword");
    }

    public void checkStorageLength() throws HealthVaultException {
        if (numberOfTokens != 6) {
            throw new CorruptedFileException("Patient");
        }
    }

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

    private void emptySpaceCheck() throws NoInputException {
        for (int i = 0; i < numberOfTokens; i++) {
            if (stringTokens[i].trim().equals("")) {
                throw new NoInputException();
            }
        }
    }

    private void checkAge(String stringToken) throws NumberFormatException, HealthVaultException {
        checkNumericInput(stringToken);
        checkAgeRange(stringToken);
    }

    private void checkAgeRange(String ageString) throws InvalidPatientAgeException {
        int age = Integer.parseInt(ageString);
        if (!(age >= 0 && age <= 150)) {
            throw new InvalidPatientAgeException();
        }
    }

    public void checkId() throws HealthVaultException {
        checkValidId(stringTokens[1]);
        checkIdExist(stringTokens[1], patients, command);
    }

    public void checkIdStorage() throws HealthVaultException {
        checkValidId(stringTokens[0]);
        checkIdExistStorage(stringTokens[0]);
    }

    private int numberOfIntegersInString(String userInput) {
        int numberOfIntegers = 0;
        for (int i = 0; i < userInput.length(); i++) {
            if (Character.isDigit(userInput.charAt(i))) {
                numberOfIntegers++;
            }
        }
        return numberOfIntegers;
    }

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

    private void checkIdExistStorage(String userID) throws CorruptedFileException {
        if (isIdTakenStorage(userID)) {
            System.out.println("There is a duplicate ID!");
            throw new CorruptedFileException("Patient");
        }
    }

    private boolean isIdTakenStorage(String userID) {
        for (Patient patient : patientArrayList) {
            String patientID = patient.getPatientID();
            if (patientID.equals(userID)) {
                System.out.println("The duplicate ID is: " + userID);
                return true;
            }
        }
        return false;
    }

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
