package seedu.logic.errorchecker;

import seedu.exceptions.DuplicateIDException;
import seedu.exceptions.InvalidDateException;
import seedu.exceptions.NoInputException;
import seedu.exceptions.nurseschedules.*;
import seedu.model.NurseSchedule;
import seedu.model.Patient;
import seedu.model.staff.Staff;
import seedu.storage.DoctorAppointmentStorage;
import seedu.storage.NurseScheduleStorage;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NurseScheduleChecker extends MainChecker {
    public boolean isValidDate(String datetime) throws InvalidDateException {
        /* Check if date is 'null' */
        if (!datetime.trim().equals("")) {
            /*
             * Set preferred date format,
             * For example MM-dd-yyyy, MM.dd.yyyy,dd.MM.yyyy etc.*/
            SimpleDateFormat sdfrmt = new SimpleDateFormat("ddMMyyyy");
            sdfrmt.setLenient(false);
            /* Create Date object
             * parse the string into date
             */
            try {
                Date javaDate = sdfrmt.parse(datetime);
                //System.out.println(datetime + " is valid date format");
            }
            /* Date format is invalid */
            catch (ParseException e) {
                throw new InvalidDateException();
            }
        }
        /* Return true if date format is valid */
        return true;
    }

    public static void checkEmptyInput(String line) throws NoInputException {
        String[] array = line.split("/");
        for (String s : array) {
            if (s.trim().equals("")) {
                throw new NoInputException();
            }
        }
    }

    public static void checkNurseIDExist(String nurseID) throws NurseIdNotFound, NurseCrossValidationError {
        try {
            ArrayList<Staff> doctorList;
            doctorList = DoctorAppointmentStorage.loadDoctorFile();

            for (Staff id : doctorList) {
                if (id.getId().equals(nurseID)) {
                    return;
                }
            }
            throw new NurseIdNotFound();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NurseCrossValidationError();
        } catch (FileNotFoundException e) {
            throw new NurseIdNotFound();
        }
    }

    public static void checkPatientDExist(String patientID) throws PatientIdNotFound, PatientCrossValidationError {
        try {
            ArrayList<Patient> patientList;
            patientList = NurseScheduleStorage.loadPatientFile();

            for (Patient id : patientList) {
                if (id.getPatientID().equals(patientID)) {
                    return;
                }
            }
            throw new PatientIdNotFound();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new PatientCrossValidationError();
        } catch (FileNotFoundException e) {
            throw new PatientIdNotFound();
        }
    }

    public static void checkValidNurseID(String userID) throws InvalidIDTypeException {
        if (userID.length() != 6) {
            throw new InvalidIDTypeException();
        } else if (!(userID.charAt(0) == 'N')) {
            throw new InvalidIDTypeException();
        } else if (numberOfIntegersInString(userID) != 5) {
            throw new InvalidIDTypeException();
        }

    }

    public static void checkValidPatientID(String userID) throws InvalidIDTypeException {
        if (userID.length() != 6) {
            throw new InvalidIDTypeException();
        }  else if (!(userID.charAt(0) == 'P')) {
            throw new InvalidIDTypeException();
        } else if (numberOfIntegersInString(userID) != 5) {
            throw new InvalidIDTypeException();
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

    public static void checkDuplicatePatientID(String id, ArrayList<NurseSchedule> list) throws DuplicateIDException {
        for (NurseSchedule patient : list) {
            if (patient.getPatientID().equals(id)) {
                throw new DuplicateIDException("Patient");
            }
        }
    }
}
