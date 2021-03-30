package seedu.logic.errorchecker;

import seedu.exceptions.doctorappointment.*;
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

    public static void checkValidDataForAdd(String[] input) throws InvalidDocIDException, AppointmentIDTakenException, InvalidAppIDException, InvalidGenderException, InvalidDateException {
        doctorID = input[1];
        appointmentID = input[2];
        gender = input[4];
        date = input[5];
        if (!isValidDocID(doctorID)) {
            throw new InvalidDocIDException();
        }
        if (!isValidAppointmentID(appointmentID)) {
            throw new InvalidAppIDException();
        }
        if (!isValidGender(gender)) {
            throw new InvalidGenderException();
        }
        if (!isValidDate(date)) {
            throw new InvalidDateException();
        }
    }

    public static void checkValidDataForList(String[] input) throws InvalidIDException {
        ID = input[1];
        if (!isValidDocID(ID) && !isValidListAppointmentID(ID)) {
            throw new InvalidIDException();
        }
    }

    public static void checkValidDataForDelete(String[] input) throws InvalidIDException {
        ID = input[1];
        if (!isValidIDToDelete(ID)) {
            throw new InvalidIDException();
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
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isValidAppointmentID(String appointmentID) throws AppointmentIDTakenException {
        String[] character = appointmentID.split("");

        if (character[0].equals("A")) {
            for (DoctorAppointment id : AppointmentActions.appointmentList) {
                if (id.getAppointmentId().equals(appointmentID)) {
                    throw new AppointmentIDTakenException();
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
