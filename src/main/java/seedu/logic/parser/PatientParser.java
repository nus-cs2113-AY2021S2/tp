package seedu.logic.parser;

import seedu.exceptions.DukeException;
import seedu.exceptions.patient.*;
import seedu.ui.PatientUI;
import seedu.ui.UI;
import seedu.model.objectList.PatientList;

public class PatientParser {

    /**
     * Checks the number of tokens and throws an exception based on the command
     *
     * @param numberOfTokens number of tokens in the string
     * @param command        interpreted command from the user to be used in error finding
     * @throws DukeException exception based on command
     */
    public static void lengthCheck(int numberOfTokens, String command) throws DukeException {
        if (command.equals("add") && numberOfTokens != 7) {
            throw new DukeException(command);
        } else if ((command.equals("delete") || command.equals("find")) && numberOfTokens != 2) {
            throw new DukeException(command);
        } else if ((command.equals("list") || command.equals("return") || command.equals("help")) && numberOfTokens != 1) {
            throw new DukeException(command);
        }
    }

    private static int numberOfIntegersInString(String userInput) {
        int numberOfIntegers = 0;
        for (int i = 0; i < userInput.length(); i++) {
            if (Character.isDigit(userInput.charAt(i))) {
                numberOfIntegers++;
            }
        }
        return numberOfIntegers;
    }

    private static void isValidID(String userID) throws InvalidIDLengthException, InvalidIDTypeException, InvalidIDValueException {
        if (userID.length() != 6) {
            throw new InvalidIDLengthException("IDLength");
        } else if (!(userID.charAt(0) == 'P')) {
            throw new InvalidIDTypeException("IDType");
        } else if (numberOfIntegersInString(userID) != 5) {
            throw new InvalidIDValueException("IDValue");
        }
    }

    private static void isIDExist(String userID, PatientList patients, String command) throws NonExistentIDException, DuplicateIDException {
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

    public static boolean patientParse(String fullCommand, PatientList patients) {
        String[] stringTokens = fullCommand.trim().split(" ");
        int numberOfTokens = stringTokens.length;
        String command = stringTokens[0];
        try {
            switch (command) {
            case "list":
                lengthCheck(numberOfTokens, command);
                PatientList.listPatients();
                break;
            case "add":
                lengthCheck(numberOfTokens, command);
                if (iDParser(patients, stringTokens, command)) {
                    PatientList.addPatient(stringTokens[1], stringTokens[2], Integer.parseInt(stringTokens[3]),
                            stringTokens[4], stringTokens[5], stringTokens[6]);
                }
                break;
            case "delete":
                lengthCheck(numberOfTokens, command);
                if (iDParser(patients, stringTokens, command)) {
                    PatientList.deletePatient(stringTokens[1]);
                }
                break;
            case "find":
                lengthCheck(numberOfTokens, command);
                if (iDParser(patients, stringTokens, command)) {
                    PatientList.findPatient(stringTokens[1]);
                }
                break;
            case "help":
                lengthCheck(numberOfTokens, command);
                PatientUI.printPatientHelpList();
                break;
            case "return":
                lengthCheck(numberOfTokens, command);
                UI.returningToStartMenuMessage();
                return true;
            default:
                UI.invalidCommandErrorMessage();
                break;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            UI.invalidFormatErrorMessage();
        } catch (DukeException e) {
            e.getError(command);
        }
        return false;
    }

    private static boolean iDParser(PatientList patients, String[] stringTokens, String command) {
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


}
