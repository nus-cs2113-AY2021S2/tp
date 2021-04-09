package seedu.logic.errorchecker;

import seedu.duke.Constants;
import seedu.exceptions.EmptyListException;
import seedu.exceptions.HealthVaultException;
import seedu.exceptions.IDNotFoundException;
import seedu.exceptions.CorruptedFileException;
import seedu.exceptions.InvalidDateException;
import seedu.exceptions.DuplicateIDException;
import seedu.exceptions.doctorappointment.DocIdNotFoundException;
import seedu.exceptions.doctorappointment.InvalidGenderException;
import seedu.exceptions.IllegalCharacterException;
import seedu.exceptions.doctorappointment.WrongAptIDFormatException;
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
    private static String ID;
    private static String gender;
    private static String date;
    public static Logger logger = HealthVaultLogger.getLogger();

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
            throw new IDNotFoundException(appointmentID);
        }
        illegalCharacterChecker(name, "name");
        if (!isValidGender(gender)) {
            throw new InvalidGenderException();
        }
        checkValidDate(date);
    }

    public static void checkValidDataForList(String[] input) throws HealthVaultException {
        ID = input[1];

        if (AppointmentList.appointmentList.size() == 0) throw new EmptyListException();
        if (ID.equals("all")) return;
        logger.log(Level.INFO, "Checking for Valid data after list command");
        if (!isValidDocID(ID) && !isValidListAppointmentID(ID)) {
            throw new seedu.exceptions.InvalidIDException();
        }
    }

    public static void checkValidDataForDelete(String[] input) throws seedu.exceptions.InvalidIDException {
        ID = input[1];
        logger.log(Level.INFO, "Checking for Valid data after delete command");
        if (!isValidIdToDelete(ID)) {
            throw new seedu.exceptions.InvalidIDException();
        }
    }

    public static void checkAptID(String id) throws WrongAptIDFormatException {
        try {
            Integer.parseInt(id.substring(1));
            logger.log(Level.INFO, "Checking for Valid Appointment ID");
        } catch (NumberFormatException e) {
            throw new WrongAptIDFormatException();
        }
        if (!(id.charAt(0) == 'A') || (id.length()) != 6) {
            throw new WrongAptIDFormatException();
        }
    }

    public static void illegalCharacterChecker(String name, String path) throws IllegalCharacterException {
        String cleanedInput = UI.cleanseInput(name);
        if (!name.equals(cleanedInput)) {
            throw new IllegalCharacterException(path);
        }
    }

    public static void illegalCharacterNameCheckerForStorage(String name) throws CorruptedFileException {
        logger.log(Level.INFO, "Checking for Illegal Character for Name from storage data ");
        String cleanedInput = UI.cleanseInput(name);
        if (!name.equals(cleanedInput)) {
            throw new CorruptedFileException(Constants.APPOINTMENT_FILE_PATH);
        }
    }

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

    public static void checkDuplicateAptIdFromStorage(String appointmentID, ArrayList<String> storageList)
            throws HealthVaultException {
        for (String storageID : storageList) {
            if (storageID.equals(appointmentID)) {
                throw new CorruptedFileException(Constants.APPOINTMENT_FILE_PATH);
            }
        }
    }

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

    public static boolean isValidAppointmentID(String appointmentID) throws HealthVaultException {
        final String[] character = appointmentID.split("");

        checkAptID(appointmentID);
        logger.log(Level.INFO, "Checking Validity Appointment ID during ADD command ");
        illegalCharacterChecker(appointmentID, "Appointment ID");
        if (character[0].equals("A")) {
            for (DoctorAppointment id : AppointmentList.appointmentList) {
                if (id.getAppointmentId().equals(appointmentID)) {
                    throw new DuplicateIDException(appointmentID);
                }
            }
            return true;
        }
        return false;
    }

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


    public static boolean isValidGender(String gender) {
        logger.log(Level.INFO, "Checking Validity of gender");
        return gender.equals("M") || gender.equals("F");
    }

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

    public static boolean isValidIdToDelete(String Id) {
        String[] IdKeyword = Id.split("");
        logger.log(Level.INFO, "Checking Validity of Doctor/ Appointment ID to be deleted");

        for (DoctorAppointment doc : AppointmentList.appointmentList) {
            if (IdKeyword[0].equals("A")) {
                if (doc.getAppointmentId().equals(Id)) {
                    return true;
                }
            } else if (IdKeyword[0].equals("D")) {
                if (doc.getDoctorId().equals(Id)) {
                    return true;
                }
            }
        }
        return false;
    }
}
