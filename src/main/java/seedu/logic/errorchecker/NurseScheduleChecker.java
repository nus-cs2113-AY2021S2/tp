package seedu.logic.errorchecker;

import seedu.exceptions.InvalidDateException;
import seedu.exceptions.NoInputException;
import seedu.exceptions.nurseschedules.*;
import seedu.logic.parser.NurseSchedulesParser;
import seedu.model.nurseschedule.NurseSchedule;
import seedu.model.patient.Patient;
import seedu.model.staff.Staff;
import seedu.storage.DoctorAppointmentStorage;
import seedu.storage.NurseScheduleStorage;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;

public class NurseScheduleChecker extends MainChecker {

    public static void isValidDate(final String date) throws InvalidDateException {
        try {
            LocalDate.parse(date,
                    DateTimeFormatter.ofPattern("ddMMuuuu")
                        .withResolverStyle(ResolverStyle.STRICT));
        } catch (DateTimeParseException e) {
            throw new InvalidDateException();
        }
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

    public static void checkDuplicatePatientID(String id, String date, ArrayList<NurseSchedule> list) throws DuplicateScheduleException {
        for (NurseSchedule patient : list) {
            if (patient.getPatientID().equals(id)) {
                if (patient.getDate().equals(date)) {
                    try {
                        date = NurseSchedulesParser.formatDate(date);
                    } catch (ParseException e) {}
                    throw new DuplicateScheduleException(date);
                }
            }
        }
    }

    /**
     * Checks if nurseID exists within schedules.
     *
     * @param nurseSchedules List of all schedules
     * @param id NurseID to check
     * @return boolean
     * @throws NurseIdNotFound if id does not exist
     */
    private boolean isValidNurseID(List<NurseSchedule> nurseSchedules, String id) throws NurseIdNotFound {
        int i = 0;
        while (i < nurseSchedules.size()) {
            if (nurseSchedules.get(i).getNurseID().equals(id)) {
                return true;
            }
            i++;
        }
        throw new NurseIdNotFound();
    }
}
