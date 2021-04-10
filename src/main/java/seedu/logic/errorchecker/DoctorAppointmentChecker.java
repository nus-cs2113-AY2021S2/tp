package seedu.logic.errorchecker;

import seedu.duke.Constants;
import seedu.exceptions.*;
import seedu.exceptions.doctorappointment.DocIdNotFoundException;
import seedu.exceptions.doctorappointment.InvalidGenderException;
import seedu.exceptions.doctorappointment.WrongAptIdFormatException;
import seedu.logger.HealthVaultLogger;
import seedu.model.doctorappointment.AppointmentList;
import seedu.model.doctorappointment.DoctorAppointment;
import seedu.model.staff.Staff;
import seedu.storage.DoctorAppointmentStorage;
import seedu.ui.UI;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DoctorAppointmentChecker extends MainChecker {
    private static String doctorID;
    private static String appointmentID;
    private static String name;
    private static String id;
    private static String gender;
    private static String date;
    public static Logger logger = HealthVaultLogger.getLogger();

    /**
     * Checks the data is valid to execute the add command.
     *
     * @param input String Array from input.
     * @throws HealthVaultException If the data to be added does not fit the parameters.
     */

    public static void checkValidDataForAdd(String[] input) throws HealthVaultException {
        doctorID = input[1];
        appointmentID = input[2];
        name = input[3];
        gender = input[4];
        date = input[5];
        logger.log(Level.INFO, "Checking for Valid data after add command");
        if (!isValidDocID(doctorID)) {
            throw new DocIdNotFoundException(doctorID);
        }
        if (!isValidAppointmentID(appointmentID)) {
            throw new IdNotFoundException(appointmentID);
        }
        illegalCharacterChecker(name, "name");
        if (!isValidGender(gender)) {
            throw new InvalidGenderException();
        }
        checkValidDate(date);
    }

    /**
     * Checks the data is valid to execute the List command.
     *
     * @param input String Array from Input.
     * @throws HealthVaultException If the data to execute list command does not fit the parameters.
     */
    public static void checkValidDataForList(String[] input) throws HealthVaultException {
        id = input[1];

        if (AppointmentList.appointmentList.size() == 0) {
            throw new EmptyListException();
        }
        if (id.equals("all")) {
            return;
        }
        logger.log(Level.INFO, "Checking for Valid data after list command");
        if (!isValidDocID(id) && !isValidListAppointmentID(id)) {
            throw new InvalidIdException();
        }
    }

    /**
     * Checks the data is valid to execute the Delete command.
     *
     * @param input String Array from Input.
     * @throws InvalidIdException If the data to execute delete command does not fit the parameters.
     */

    public static void checkValidDataForDelete(String[] input) throws InvalidIdException {
        id = input[1];
        logger.log(Level.INFO, "Checking for Valid data after delete command");
        if (!isValidIdToDelete(id)) {
            throw new InvalidIdException();
        }
    }

    /**
     * Checks if the Appointment ID is in the correct format.
     *
     * @param id The input Appointment Id.
     * @throws WrongAptIdFormatException If the data does not fit the parameters.
     */

    public static void checkAptID(String id) throws WrongAptIdFormatException {
        try {
            Integer.parseInt(id.substring(1));
            logger.log(Level.INFO, "Checking for Valid Appointment ID");
        } catch (NumberFormatException e) {
            throw new WrongAptIdFormatException();
        }
        if (!(id.charAt(0) == 'A') || (id.length()) != 6) {
            throw new WrongAptIdFormatException();
        }
    }

    /**
     * Checks if the input name contains any illegal character.
     *
     * @param name The input name.
     * @param path The file path.
     * @throws IllegalCharacterException If the data does not fit the parameters.
     */

    public static void illegalCharacterChecker(String name, String path) throws IllegalCharacterException {
        String cleanedInput = UI.cleanseInput(name);
        if (!name.equals(cleanedInput)) {
            throw new IllegalCharacterException(path);
        }
    }

    /**
     * Checks if the name data from storage contains any illegal character.
     *
     * @param name The input name.
     * @throws CorruptedFileException If the data does not fit the parameters.
     */

    public static void illegalCharacterNameCheckerForStorage(String name) throws CorruptedFileException {
        logger.log(Level.INFO, "Checking for Illegal Character for Name from storage data ");
        String cleanedInput = UI.cleanseInput(name);
        if (!name.equals(cleanedInput)) {
            throw new CorruptedFileException(Constants.APPOINTMENT_FILE_PATH);
        }
    }

    /**
     * Checks data that is being read from storage.
     *
     * @param input       input
     * @param storageList Current loaded files of data.
     * @throws HealthVaultException If the data does not fit the parameters.
     */
    public static void checkDataFromStorage(String input, ArrayList<String> storageList) throws HealthVaultException {
        String[] inputArray = input.split("\\s\\|\\s", 5);
        checkID(inputArray[0], inputArray[1]);
        illegalCharacterNameCheckerForStorage(inputArray[2]);
        illegalCharacterNameCheckerForStorage(inputArray[1]);
        checkDuplicateAptIdFromStorage(inputArray[1], storageList);
        checkValidDate(inputArray[4]);
        logger.log(Level.INFO, "Checking Validity of storage data ");
        if (!isValidGender(inputArray[3])) {
            throw new CorruptedFileException(Constants.APPOINTMENT_FILE_PATH);
        }
    }

    /**
     * Checks if there is any duplicate appointment Id in storage.
     *
     * @param appointmentID appointment Id.
     * @param storageList   Current loaded files of data.
     * @throws HealthVaultException If the data does not fit the parameters.
     */

    public static void checkDuplicateAptIdFromStorage(String appointmentID, ArrayList<String> storageList)
            throws HealthVaultException {
        for (String storageID : storageList) {
            if (storageID.equals(appointmentID)) {
                throw new CorruptedFileException(Constants.APPOINTMENT_FILE_PATH);
            }
        }
    }

    /**
     * Checks the validity of the Id.
     *
     * @param doctorID      doctor Id.
     * @param appointmentID Appointment Id.
     * @throws HealthVaultException If the data does not fit the parameters.
     */

    public static void checkID(String doctorID, String appointmentID) throws HealthVaultException {
        try {
            logger.log(Level.INFO, "Checking Validity Doctor and Appointment ID from storage data ");
            Integer.parseInt(doctorID.substring(1));
            Integer.parseInt(appointmentID.substring(1));
        } catch (NumberFormatException e) {
            throw new CorruptedFileException(Constants.APPOINTMENT_FILE_PATH);
        }
        if (!(doctorID.charAt(0) == 'D') || (doctorID.length()) != 6) {
            throw new CorruptedFileException(Constants.APPOINTMENT_FILE_PATH);
        }
        if (!(appointmentID.charAt(0) == 'A') || (doctorID.length()) != 6) {
            throw new CorruptedFileException(Constants.APPOINTMENT_FILE_PATH);
        }
    }

    /**
     * Checks if there is a existing doctor Id in Staff Database.
     *
     * @param doctorID input doctor Id.
     * @return true if doctorId exists in staff database.
     * @throws FileNotFoundException If staff file does not exists.
     */

    public static boolean isValidDocID(String doctorID) {
        try {
            final String[] character = doctorID.split("");
            logger.log(Level.INFO, "Checking Validity Doctor ID during program commands ");
            if (character[0].equals("D")) {
                ArrayList<Staff> doctorList;
                doctorList = DoctorAppointmentStorage.loadDoctorFile();

                for (Staff id : doctorList) {
                    if (id.getId().equals(doctorID)) {
                        return true;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * Check if the Appointment Id to be added is valid.
     *
     * @param appointmentID appointment Id.
     * @return true if the appointment Id is valid and does not exist in appointmentList.
     * @throws HealthVaultException If the data does not fit the parameters.
     */

    public static boolean isValidAppointmentID(String appointmentID) throws HealthVaultException {
        final String[] character = appointmentID.split("");

        checkAptID(appointmentID);
        logger.log(Level.INFO, "Checking Validity Appointment ID during ADD command ");
        illegalCharacterChecker(appointmentID, "Appointment ID");
        if (character[0].equals("A")) {
            for (DoctorAppointment id : AppointmentList.appointmentList) {
                if (id.getAppointmentId().equals(appointmentID)) {
                    throw new DuplicateIdException(appointmentID);
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Checks if the input Appointment Id exist in the appointmentList.
     *
     * @param appointmentID appointment Id.
     * @return true if the same appointment Id exists.
     */

    public static boolean isValidListAppointmentID(String appointmentID) {
        String[] character = appointmentID.split("");
        logger.log(Level.INFO, "Checking Validity Appointment ID during LIST command ");

        if (character[0].equals("A")) {
            for (DoctorAppointment id : AppointmentList.appointmentList) {
                if (id.getAppointmentId().equals(appointmentID)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if the input gender is valid.
     *
     * @param gender input gender
     * @return true if the gender is M or F.
     */

    public static boolean isValidGender(String gender) {
        logger.log(Level.INFO, "Checking Validity of gender");
        return gender.equals("M") || gender.equals("F");
    }

    /**
     * Checks if the input date is valid.
     *
     * @param date input date
     * @throws InvalidDateException if the date input does not fit the correct format.
     */

    public static void checkValidDate(final String date) throws InvalidDateException {
        try {
            logger.log(Level.INFO, "Checking Validity of date");
            LocalDate.parse(date,
                    DateTimeFormatter.ofPattern("ddMMuuuu")
                            .withResolverStyle(ResolverStyle.STRICT));
        } catch (DateTimeParseException e) {
            throw new InvalidDateException();
        }
    }

    /**
     * Checks if the input date is valid.
     *
     * @param id appointment/doctor iD to be checked.
     * @return true if the corresponding iD exists in teh appointmentList.
     */
    public static boolean isValidIdToDelete(String id) {
        String[] idKeyword = id.split("");
        logger.log(Level.INFO, "Checking Validity of Doctor/ Appointment ID to be deleted");

        for (DoctorAppointment doc : AppointmentList.appointmentList) {
            if (idKeyword[0].equals("A")) {
                if (doc.getAppointmentId().equals(id)) {
                    return true;
                }
            } else if (idKeyword[0].equals("D")) {
                if (doc.getDoctorId().equals(id)) {
                    return true;
                }
            }
        }
        return false;
    }
}
