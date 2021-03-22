package seedu.nurseschedules;

import seedu.duke.ui.NurseScheduleUI;
import seedu.duke.ui.UI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NurseScheduleActions {

    List<NurseSchedule> findSchedules = new ArrayList<NurseSchedule>();
    List<String> nursesFound = new ArrayList<String>();
    private String nurseID = null;

    public void listSchedules(List<NurseSchedule> nurseSchedules, String[] details) {
        if (details[0].equals("all")) {
            listAllSchedules(nurseSchedules);
        } else if (isValidNurseID(nurseSchedules, details[0])) {
            findSchedules.clear();
            getNurseSchedulesByID(nurseSchedules, details[0]);
            printSchedules(findSchedules);
        }
        UI.showLine();
    }

    public void listAllSchedules(List<NurseSchedule> nurseSchedules) {
        nursesFound.clear();
        if (nurseSchedules.size() == 0) {
            NurseScheduleUI.noNurseSchedulesFoundMessage();
        } else {
            for (int i = 0; i < nurseSchedules.size(); i++) {
                findSchedules.clear();
                if (!isNurseDone(nurseSchedules, i)) {
                    getNurseSchedulesByID(nurseSchedules, nurseID);
                    printSchedules(findSchedules);
                }
            }
        }
    }

    public void deleteSchedule(List<NurseSchedule> nurseSchedules, String[] details) {
        int i = 0;
        while (i < nurseSchedules.size()) {
            if ((nurseSchedules.get(i).getNurseID()).equals(details[0])
                    && nurseSchedules.get(i).getDatetime().equals(details[1])) {
                NurseScheduleUI.printDeletedSchedule(nurseSchedules.get(i).getPatientID(),
                        nurseSchedules.get(i).getFormattedDatetime());
                nurseSchedules.remove(i);
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
        Collections.sort(findSchedules);
        System.out.println(id);
    }

    private void printSchedules(List<NurseSchedule> list) {
        int i = 0;
        while (i < list.size()) {
            System.out.println("\t" + list.get(i).toFind());
            i++;
        }
    }

    private boolean isNurseDone(List<NurseSchedule> nurseSchedules, int i) {
        if (nursesFound.contains(nurseSchedules.get(i).getNurseID())) {
            return true;
        } else {
            nursesFound.add(nurseSchedules.get(i).getNurseID());
            nurseID = nurseSchedules.get(i).getNurseID();
            return false;
        }
    }

    private boolean isValidNurseID(List<NurseSchedule> nurseSchedules, String id) {
        int i = 0;
        while (i < nurseSchedules.size()) {
            if (nurseSchedules.get(i).getNurseID().equals(id)) return true;
            i++;
        }
        NurseScheduleUI.nurseIDDoesNotExistMessage();
        return false;
    }
}
