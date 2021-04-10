package seedu.logic.errorchecker;

import seedu.exceptions.InvalidDateException;
import seedu.exceptions.NoInputException;
import seedu.exceptions.nurseschedules.DuplicateScheduleException;
import seedu.exceptions.nurseschedules.InvalidiDTypeException;
import seedu.exceptions.nurseschedules.NurseCrossValidationError;
import seedu.exceptions.nurseschedules.NurseIdNotFound;
import seedu.exceptions.nurseschedules.PatientCrossValidationError;
import seedu.exceptions.nurseschedules.PatientIdNotFound;
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

    /**
     * checks if date is valid.
     *
     * @param date string date
     * @throws InvalidDateException if date is not valid
     */
    public static void isValidDate(final String date) throws InvalidDateException {
        try {
            LocalDate.parse(date,
                    DateTimeFormatter.ofPattern("ddMMuuuu")
                        .withResolverStyle(ResolverStyle.STRICT));
        } catch (DateTimeParseException e) {
            throw new InvalidDateException();
        }
    }

    /**
     * checks if input is empty.
     *
     * @param line raw user input
     * @throws NoInputException if input is empty
     */
    public static void checkEmptyInput(String line) throws NoInputException {
        String[] array = line.split("/");
        for (String s : array) {
            if (s.trim().equals("")) {
                throw new NoInputException();
            }
        }
    }

    /**
     * checks if nurseID exists in staff database.
     *
     * @param nurseID id to be checked
     * @throws NurseIdNotFound if id does not exist
     * @throws NurseCrossValidationError if staff database cannot be loaded
     */
    public static void checkNurseiDExist(String nurseID) throws NurseIdNotFound, NurseCrossValidationError {
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

    /**
     * checks if patientID exists in patient database.
     *
     * @param patientID id to be checked
     * @throws PatientIdNotFound if id does not exist
     * @throws PatientCrossValidationError if patient database cannot be loaded
     */
    public static void checkPatientiDExist(String patientID) throws PatientIdNotFound, PatientCrossValidationError {
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

    /**
     * checks if nurse id is of correct format.
     *
     * @param userID user inputted id
     * @throws InvalidiDTypeException if id is not valid
     */
    public static void checkValidNurseID(String userID) throws InvalidiDTypeException {
        if (userID.length() != 6) {
            throw new InvalidiDTypeException();
        } else if (!(userID.charAt(0) == 'N')) {
            throw new InvalidiDTypeException();
        } else if (numberOfIntegersInString(userID) != 5) {
            throw new InvalidiDTypeException();
        }

    }

    /**
     * checks if patient id is of correct format.
     *
     * @param userID user inputted id
     * @throws InvalidiDTypeException if id is not valid
     */
    public static void checkValidPatientID(String userID) throws InvalidiDTypeException {
        if (userID.length() != 6) {
            throw new InvalidiDTypeException();
        }  else if (!(userID.charAt(0) == 'P')) {
            throw new InvalidiDTypeException();
        } else if (numberOfIntegersInString(userID) != 5) {
            throw new InvalidiDTypeException();
        }
    }

    /**
     * checks the number of integers in id.
     *
     * @param userInput user inputted id
     * @return number of integers
     */
    private static int numberOfIntegersInString(String userInput) {
        int numberOfIntegers = 0;
        for (int i = 0; i < userInput.length(); i++) {
            if (Character.isDigit(userInput.charAt(i))) {
                numberOfIntegers++;
            }
        }
        return numberOfIntegers;
    }

    /**
     * checks if patientID is duplicated.
     *
     * @param id patient id
     * @param date date of schedule
     * @param list arraylist of nurseschedules
     * @throws DuplicateScheduleException if patient already has a schedule on that date
     */
    public static void checkDuplicatePatientID(String id, String date, ArrayList<NurseSchedule> list)
            throws DuplicateScheduleException {
        for (NurseSchedule patient : list) {
            if (patient.getPatientID().equals(id)) {
                if (patient.getDate().equals(date)) {
                    try {
                        date = NurseSchedulesParser.formatDate(date);
                    } catch (ParseException ignored) {
                        //Exception ignored
                    }
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
