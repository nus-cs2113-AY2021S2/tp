package seedu.model.nurseschedule;

import seedu.exceptions.nurseschedules.*;
import seedu.logic.errorchecker.NurseScheduleChecker;
import seedu.ui.NurseScheduleUI;
import seedu.ui.UI;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;

import static seedu.logic.instance.NurseScheduleInstance.logger;
import static seedu.ui.UI.prettyPrint;

public class NurseScheduleList {

    private static ArrayList<NurseSchedule> findSchedules = new ArrayList<>();
    private static ArrayList<String> nursesFound = new ArrayList<String>();
    private String nurseID = null;

    private static ArrayList<NurseSchedule> nurseSchedules = new ArrayList<>();

    public NurseScheduleList(ArrayList<NurseSchedule> load) {
        nurseSchedules = load;
        logger.info("Creating a NurseSchedule list");
    }

    public NurseScheduleList() { }

    public void clearSchedules() {
        nurseSchedules.clear();
    }

    public void addSchedule(String[] details) throws NurseIdNotFound, InvalidIDTypeException,
            NurseCrossValidationError, PatientIdNotFound, PatientCrossValidationError, DuplicateScheduleException {
        try {
            NurseScheduleChecker.checkValidNurseID(details[0]);
            NurseScheduleChecker.checkDuplicatePatientID(details[1], details[2], nurseSchedules);
            NurseScheduleChecker.checkNurseIDExist(details[0]);
            NurseScheduleChecker.checkValidPatientID(details[1]);
            NurseScheduleChecker.checkPatientDExist(details[1]);
            nurseSchedules.add(new NurseSchedule(details[0], details[1], details[2]));
            NurseScheduleUI.printAddedSchedule(details[1], details[2]);
            logger.info("Schedule successfully added");
        }
        catch (ParseException e) {
            System.out.println(e.getMessage());
            logger.log(Level.WARNING, "Failed to add schedule");
        }
    }

    /**
     * Handler when list command is issued.
     *
     * @param details Contains either NurseID or 'all'
     */
    public void listSchedules(String[] details)
            throws EmptyListException, NurseIdNotFound {
        if (details[0].equals("ALL")) {
            listAllSchedules();
        } else if (isValidNurseID(nurseSchedules, details[0])) {
            findSchedules.clear();
            NurseScheduleUI.nurseListHeader();
            UI.showLine();
            getNurseSchedulesByID(nurseSchedules, details[0]);
            printSchedules(findSchedules);
        }
    }

    /**
     * Handler for 'list all' schedules.
     *
     * @throws EmptyListException when nurse schedule list is empty
     */
    public void listAllSchedules() throws EmptyListException {
        nursesFound.clear();
        if (nurseSchedules.size() == 0) {
            throw new EmptyListException();
        } else {
            NurseScheduleUI.nurseListHeader();
            UI.showLine();
            for (int i = 0; i < nurseSchedules.size(); i++) {
                findSchedules.clear();
                nurseID = nurseSchedules.get(i).getNurseID();
                if (!isNurseDone(nurseSchedules, i)) {
                    getNurseSchedulesByID(nurseSchedules, nurseID);
                    printSchedules(findSchedules);
                }
            }
        }
    }

    /**
     * Deletes schedule with given nurseID and datetime.
     *
     * @param details nurseID to delete
     */
    public void deleteSchedule(String[] details) throws NurseIdNotFound, InvalidScheduleException {
        int i = 0;
        while (i < nurseSchedules.size()) {
            if(!isValidNurseID(nurseSchedules, details[0]) | !isValidSchedule(nurseSchedules, details[0], details[1])) {
                break;
            }
            if ((nurseSchedules.get(i).getNurseID()).equals(details[0])
                    && nurseSchedules.get(i).getDatetime().equals(details[1])) {
                NurseScheduleUI.printDeletedSchedule(nurseSchedules.get(i).getPatientID(),
                        nurseSchedules.get(i).getFormattedDatetime());
                nurseSchedules.remove(i);
                logger.info("Schedule successfully removed");
                break;
            }
            i++;
        }
    }

    private void getNurseSchedulesByID(List<NurseSchedule> nurseSchedules, String id) {
        int i = 0;
        while (i < nurseSchedules.size()) {
            if (nurseSchedules.get(i).getNurseID().equals(id)) {
                findSchedules.add(nurseSchedules.get(i));
            }
            i++;
        }
        try {
            Collections.sort(findSchedules);
            System.out.println(prettyPrint(id, 10) + " | " + findSchedules.get(0).toFind());
        } catch (Exception ignored) {}
    }

    /**
     * Prints schedules.
     *
     * @param list List of schedules to be printed
     */
    private void printSchedules(List<NurseSchedule> list) {
        int i = 1;
        while (i < list.size()) {
            NurseScheduleUI.printEmptyCell();
            System.out.println(list.get(i).toFind());
            i++;
        }
    }

    private boolean isNurseDone(List<NurseSchedule> nurseSchedules, int i) {
        if (nursesFound.contains(nurseSchedules.get(i).getNurseID())) {
            return true;
        } else {
            nursesFound.add(nurseSchedules.get(i).getNurseID());
            return false;
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

    private boolean isValidSchedule(List<NurseSchedule> nurseSchedules, String id, String date) throws InvalidScheduleException {
        int i = 0;
        while (i < nurseSchedules.size()) {
            if (nurseSchedules.get(i).getNurseID().equals(id)) {
                if (nurseSchedules.get(i).getDatetime().equals(date)) {
                    return true;
                }
            }
            i++;
        }
        throw new InvalidScheduleException();
    }

    public int getSize() {
        return nurseSchedules.size();
    }

    public String toSaveFile(int i) {
        return nurseSchedules.get(i).toSave();
    }
}
