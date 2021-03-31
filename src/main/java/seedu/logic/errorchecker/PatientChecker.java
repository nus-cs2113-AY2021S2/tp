package seedu.logic.errorchecker;

import seedu.exceptions.*;
import seedu.exceptions.patient.*;
import seedu.logic.command.PatientActions;
import seedu.model.Patient;

import java.util.ArrayList;

public class PatientChecker extends MainChecker{

    private PatientActions patients;
    private ArrayList<Patient> patientArrayList;
    private String[] stringTokens;
    private String command;
    private int numberOfTokens;

    public PatientChecker(PatientActions patients, String[] stringTokens, String command, int numberOfTokens) {
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
        checkIDStorage();
        checkAge(stringTokens[2]);
        illegalCharacterChecker(stringTokens[1], "name");
        illegalCharacterChecker(stringTokens[4], "Illness");
        illegalCharacterChecker(stringTokens[5], "medication required");
        checkGender(stringTokens[3]);
    }

    public void checkAdd() throws HealthVaultException, NumberFormatException {
        emptySpaceCheck();
        checkLength();
        checkID();
        checkAge(stringTokens[3]);
        illegalCharacterChecker(stringTokens[2], "name");
        illegalCharacterChecker(stringTokens[5], "Illness");
        illegalCharacterChecker(stringTokens[6], "medication required");
        checkGender(stringTokens[4]);
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

    private void checkAgeRange(String ageString) throws InvalidAgeException {
        int age = Integer.parseInt(ageString);
        if (!(age >= 0 && age < 150)) {
            throw new InvalidAgeException();
        }
    }

    public void checkID() throws HealthVaultException {
        checkValidID(stringTokens[1]);
        checkIDExist(stringTokens[1], patients, command);
    }

    public void checkIDStorage() throws HealthVaultException {
        checkValidID(stringTokens[0]);
        checkIDExistStorage(stringTokens[0]);
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

    private void checkValidID(String userID) throws InvalidIDLengthException, InvalidIDTypeException,
            InvalidIDValueException {
        if (userID.length() != 6) {
            throw new InvalidIDLengthException("IDLength");
        } else if (!(userID.charAt(0) == 'P')) {
            throw new InvalidIDTypeException("IDType");
        } else if (numberOfIntegersInString(userID) != 5) {
            throw new InvalidIDValueException("IDValue");
        }
    }

    private void checkIDExistStorage(String userID) throws CorruptedFileException {
        if (isIDTakenStorage(userID)) {
            throw new CorruptedFileException("Patient");
        }
    }

    private boolean isIDTakenStorage(String userID) {
        for (Patient patient : patientArrayList) {
            String patientID = patient.getPatientID();
            if (patientID.equals(userID)) {
                return true;
            }
        }
        return false;
    }

    private void checkIDExist(String userID, PatientActions patients, String command) throws IDNotFoundException,
            DuplicateIDException {
        if (patients.isIDTaken(userID)) {
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
