package seedu.logic.errorchecker;

import seedu.exceptions.DuplicateIDException;
import seedu.exceptions.HealthVaultException;
import seedu.exceptions.patient.*;
import seedu.logic.command.PatientActions;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatientChecker extends MainChecker{

    private PatientActions patients;
    private ArrayList<String> stringTokens;
    private String command;
    private int numberOfTokens;

    private final String ILLEGAL_CHARACTERS = "^.*[~#@*+%{}<>\\[]|\"_\\^.$\\.*";

    public PatientChecker(PatientActions patients, ArrayList<String> stringTokens, String command, int numberOfTokens) {
        this.patients = patients;
        this.stringTokens = stringTokens;
        this.command = command;
        this.numberOfTokens = numberOfTokens;
    }

    public void checkAddCommand() throws HealthVaultException, NumberFormatException{
        checkLength();
        checkID();
        checkAge(stringTokens.get(3));
        illegalCharacterChecker(stringTokens.get(2));
        illegalCharacterChecker(stringTokens.get(5));
        illegalCharacterChecker(stringTokens.get(6));
        checkGender(stringTokens.get(4));
        emptySpaceCheck();
    }

    public void checkLength() throws HealthVaultException {
        if (command.equals("add") && numberOfTokens != 7) {
            throw new HealthVaultException(command);
        } else if ((command.equals("delete") || command.equals("find")) && numberOfTokens != 2) {
            throw new HealthVaultException(command);
        } else if ((command.equals("list") || command.equals("return") || command.equals("help"))
                && numberOfTokens != 1) {
            throw new HealthVaultException(command);
        }
    }

    private void emptySpaceCheck() throws EmptyInputException{
        for (int i = 0; i < numberOfTokens; i++) {
            if (stringTokens.get(i).trim().equals("")) {
                throw new EmptyInputException();
            }
        }
    }

    private void illegalCharacterChecker(String stringToken) throws IllegalCharacterException{
        String nameString = stringToken.toLowerCase();
        Pattern pattern = Pattern.compile(ILLEGAL_CHARACTERS);
        Matcher matcher = pattern.matcher(nameString);
        if (matcher.find()) {
            throw new IllegalCharacterException();
        }
    }

    private void checkAge(String stringToken) throws NumberFormatException, HealthVaultException{
        checkNumericInput(stringToken);
        checkAgeRange(stringToken);
    }

    private void checkAgeRange(String ageString) throws InvalidAgeException{
        int age = Integer.parseInt(ageString);
        if (!(age >= 0 && age < 150)) {
            throw new InvalidAgeException();
        }
    }

    public void checkID() throws HealthVaultException{
        checkValidID(stringTokens.get(1));
        checkIDExist(stringTokens.get(1), patients, command);
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

    private void checkIDExist(String userID, PatientActions patients, String command) throws NonExistentIDException,
            DuplicateIDException {
        if (patients.isIDTaken(userID)) {
            if (command.equals("add")) {
                throw new DuplicateIDException("IDTaken");
            }
        } else {
            if ((command.equals("delete") || command.equals("find"))) {
                throw new NonExistentIDException("IDDoesNotExist");
            }
        }
    }
}
