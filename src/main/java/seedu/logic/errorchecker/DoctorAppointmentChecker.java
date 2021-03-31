package seedu.logic.errorchecker;

import seedu.duke.Constants;
import seedu.exceptions.*;
import seedu.exceptions.doctorappointment.*;
import seedu.exceptions.doctorappointment.InvalidGenderException;
import seedu.exceptions.staff.WrongStaffIdException;
import seedu.logic.command.AppointmentActions;
import seedu.logic.parser.DoctorAppointmentParser;
import seedu.model.DoctorAppointment;
import seedu.model.staff.Staff;
import seedu.storage.DoctorAppointmentStorage;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DoctorAppointmentChecker extends MainChecker {
    //private String[] input;
    private static String doctorID;
    private static String appointmentID;
    private static String ID;
    private static String gender;
    private static String date;

    public static void checkValidDataForAdd(String[] input) throws HealthVaultException {
        doctorID = input[1];
        appointmentID = input[2];
        gender = input[4];
        date = input[5];
        if (!isValidDocID(doctorID)) {
            throw new IDNotFoundException(doctorID);
        }
        if (!isValidAppointmentID(appointmentID)) {
            throw new IDNotFoundException(appointmentID);
        }
        if (!isValidGender(gender)) {
            throw new InvalidGenderException();
        }
        if (!isValidDate(date)) {
            throw new seedu.exceptions.InvalidDateException();
        }
    }

    public static void checkValidDataForList(String[] input) throws seedu.exceptions.InvalidIDException {
        ID = input[1];
        if (!isValidDocID(ID) && !isValidListAppointmentID(ID)) {
            throw new seedu.exceptions.InvalidIDException();
        }
    }

    public static void checkValidDataForDelete(String[] input) throws seedu.exceptions.InvalidIDException {
        ID = input[1];
        if (!isValidIDToDelete(ID)) {
            throw new seedu.exceptions.InvalidIDException();
        }
    }

    public static void checkAptID(String id) throws WrongAptIDFormatException {
        try {
            Integer.parseInt(id.substring(1));
        } catch (NumberFormatException e) {
            throw new WrongAptIDFormatException();
        }
        if (!(id.charAt(0) == 'A') || (id.length()) != 6) {
            throw new WrongAptIDFormatException();
        }
    }

    public static void checkDataFromStorage(String input) throws HealthVaultException {
        String[] inputArray = input.split("\\s\\|\\s", 5);
        doctorID = inputArray[0];
        appointmentID = inputArray[1];
        gender = inputArray[3];
        date = inputArray[4];
        checkID(doctorID, appointmentID);
        if (!isValidGender(gender) || !isValidDate(date)) {
            throw new CorruptedFileException(Constants.APPOINTMENT_FILE_PATH);
        }
    }

    public static void checkID(String doctorID, String appointmentID) throws HealthVaultException {
        try {
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
            String[] character = doctorID.split("");

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

        }
        return false;
    }

    public static boolean isValidAppointmentID(String appointmentID) throws DuplicateIDException, WrongAptIDFormatException {
        String[] character = appointmentID.split("");

        checkAptID(appointmentID);
        if (character[0].equals("A")) {
            for (DoctorAppointment id : AppointmentActions.appointmentList) {
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

        if (character[0].equals("A")) {
            for (DoctorAppointment id : AppointmentActions.appointmentList) {
                if (id.getAppointmentId().equals(appointmentID)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isValidStorageAppointmentID(String appointmentID) {

        if (!(appointmentID.charAt(0) == 'A') || (appointmentID.length()) != 6) {
            return true;
        }
        return false;
    }

    public static boolean isValidGender(String gender) {
        return gender.equals("M") || gender.equals("F");
    }

    public static boolean isValidDate(String datetime) {
        if (!datetime.trim().equals("")) {
            SimpleDateFormat sdfrmt = new SimpleDateFormat("ddMMyyyy");
            sdfrmt.setLenient(false);
            try {
                Date javaDate = sdfrmt.parse(datetime);
            } catch (ParseException e) {
                System.out.println(datetime + " is Invalid Date format");
                return false;
            }
        }
        return true;
    }

    public static boolean isValidIDToDelete(String ID) {
        String[] IDKeyword = ID.split("");

        for (DoctorAppointment doc : AppointmentActions.appointmentList) {
            if (IDKeyword[0].equals("A")) {
                if (doc.getAppointmentId().equals(ID)) {
                    return true;
                }
            } else if (IDKeyword[0].equals("D")) {
                if (doc.getDoctorId().equals(ID)) {
                    return true;
                }
            }
        }
        return false;
    }

}
