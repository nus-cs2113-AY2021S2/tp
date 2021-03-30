package seedu.logic.parser;

import seedu.exceptions.HealthVaultException;
import seedu.exceptions.patient.*;
import seedu.logic.command.Command;
import seedu.logic.command.patient.*;
import seedu.ui.UI;
import seedu.logic.command.PatientActions;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatientParser {

    private final String illegalCharacters = "^.*[~#@*+%{}<>\\[]|\"_\\^.$";
    private final String[] validGenderInput = {"M", "F", "Others"};

    public Command patientParse(String fullCommand, PatientActions patients) {
        String[] stringTokens = fullCommand.trim().split("/");
        int numberOfTokens = stringTokens.length;
        String command = stringTokens[0];
        Command c = null;
        try {
            switch (command) {
            case "list":
                lengthCheck(numberOfTokens, command);
                c = new PatientList();
                break;
            case "add":
                lengthCheck(numberOfTokens, command);
                if (addVariableChecker(patients, stringTokens, command)) {
                    String[] addFormat = parseToAddFormat(stringTokens);
                    c = new PatientAdd(addFormat);
                }
                break;
            case "delete":
                lengthCheck(numberOfTokens, command);
                if (iDParser(patients, stringTokens, command)) {
                    c = new PatientDelete(stringTokens[1]);
                }
                break;
            case "find":
                lengthCheck(numberOfTokens, command);
                if (iDParser(patients, stringTokens, command)) {
                    c = new PatientFind(stringTokens[1]);
                }
                break;
            case "help":
                lengthCheck(numberOfTokens, command);
                c = new PatientHelp();
                break;
            case "return":
                lengthCheck(numberOfTokens, command);
                c = new PatientReturn();
                break;
            default:
                UI.invalidCommandErrorMessage();
                break;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            UI.invalidFormatErrorMessage();
        } catch (HealthVaultException e) {
            e.getError(command);
        }
        return c;
    }

    private boolean addVariableChecker(PatientActions patients, String[] stringTokens, String command) {
        boolean correctID;
        boolean correctAge;
        try {
            correctID = iDParser(patients, stringTokens, command);
            correctAge = ageChecker(stringTokens[3]);
            illegalCharacterChecker(stringTokens[2]);
            illegalCharacterChecker(stringTokens[5]);
            illegalCharacterChecker(stringTokens[6]);
            genderChecker(stringTokens[4]);
            emptySpaceCheck(stringTokens);
        } catch (IllegalCharacterException e) {
            e.getError("character");
            return false;
        } catch (InvalidGenderException e) {
            e.getError("gender");
            return false;
        } catch (EmptyInputException e) {
            e.getError("emptyfield");
            return false;
        }
        if(correctAge && correctID) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks the number of tokens and throws an exception based on the command
     *
     * @param numberOfTokens number of tokens in the string
     * @param command        interpreted command from the user to be used in error finding
     * @throws HealthVaultException exception based on command
     */
    private void lengthCheck(int numberOfTokens, String command) throws HealthVaultException {
        if (command.equals("add") && numberOfTokens != 7) {
            throw new HealthVaultException(command);
        } else if ((command.equals("delete") || command.equals("find")) && numberOfTokens != 2) {
            throw new HealthVaultException(command);
        } else if ((command.equals("list") || command.equals("return") || command.equals("help"))
                && numberOfTokens != 1) {
            throw new HealthVaultException(command);
        }
    }

    private void emptySpaceCheck(String[] stringTokens) throws EmptyInputException{
        int stringLength = stringTokens.length;
        for (int i = 0; i < stringLength; i++) {
            if (stringTokens[i].trim().equals("")) {
                throw new EmptyInputException();
            }
        }
    }

    private void illegalCharacterChecker(String stringToken) throws IllegalCharacterException{
        String nameString = stringToken.toLowerCase();
        Pattern pattern = Pattern.compile(illegalCharacters);
        Matcher matcher = pattern.matcher(nameString);
        if (matcher.find()) {
            throw new IllegalCharacterException();
        }
    }

    private boolean ageChecker(String stringToken) {
        String ageString = stringToken;
        try {
            Integer.parseInt(ageString);
            ageRangeChecker(ageString);
        } catch(NumberFormatException e) {
            System.out.println("OOPS! Your input in the age field is not a valid integer!");
            return false;
        } catch (InvalidAgeException e) {
            e.getError("ageRange");
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    private void ageRangeChecker(String ageString) throws InvalidAgeException{
        int age = Integer.parseInt(ageString);
        if (!(age >= 0 && age < 150)) {
            throw new InvalidAgeException();
        }
    }

    private void genderChecker(String stringToken) throws InvalidGenderException{
        String gender = stringToken;
        if (!Arrays.stream(validGenderInput).anyMatch(gender::contains)) {
            throw new InvalidGenderException();
        }
    }

    private boolean iDParser(PatientActions patients, String[] stringTokens, String command) {
        try {
            isValidID(stringTokens[1]);
            isIDExist(stringTokens[1], patients, command);
        } catch (InvalidIDLengthException e) {
            e.getError("IDLength");
            return false;
        } catch (InvalidIDTypeException e) {
            e.getError("IDType");
            return false;
        } catch (InvalidIDValueException e) {
            e.getError("IDValue");
            return false;
        } catch (NonExistentIDException e) {
            e.getError("IDDoesNotExist");
            return false;
        } catch (DuplicateIDException e) {
            e.getError("IDTaken");
            return false;
        }
        return true;
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

    private void isValidID(String userID) throws InvalidIDLengthException, InvalidIDTypeException,
            InvalidIDValueException {
        if (userID.length() != 6) {
            throw new InvalidIDLengthException("IDLength");
        } else if (!(userID.charAt(0) == 'P')) {
            throw new InvalidIDTypeException("IDType");
        } else if (numberOfIntegersInString(userID) != 5) {
            throw new InvalidIDValueException("IDValue");
        }
    }

    private void isIDExist(String userID, PatientActions patients, String command) throws NonExistentIDException,
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

    private String[] parseToAddFormat(String[] stringTokens) {
        String[] addFormat;
        addFormat = new String[] {stringTokens[1], stringTokens[2], stringTokens[3],
        stringTokens[4], stringTokens[5], stringTokens[6]};
        return addFormat;
    }

}
