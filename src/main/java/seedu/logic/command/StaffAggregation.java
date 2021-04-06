package seedu.logic.command;

import seedu.logic.errorchecker.StaffChecker;
import seedu.model.staff.Staff;
import seedu.ui.StaffUI;
import seedu.ui.UI;

import java.util.ArrayList;
import java.util.Iterator;

import static seedu.ui.UI.prettyPrint;

public class StaffAggregation {
    private static final String DOCTOR_TYPE = "D";
    private static final String NURSE_TYPE = "N";
    private ArrayList<Staff> list = new ArrayList<>();
    protected static int numStaff = 0;
    protected static int numDoctor = 0;
    protected static int numNurse = 0;
    private StaffChecker staffChecker = new StaffChecker();

    public StaffAggregation() {
    }

    public void resetList() {
        this.list.clear();
        numStaff=0;
    }

    public void addStaff(Staff staff) {
        list.add(staff);
        if (staff.getType().equals(NURSE_TYPE)) {
            numNurse ++;
        } else if (staff.getType().equals(DOCTOR_TYPE)) {
            numDoctor ++;
        }
        numStaff++;
    }

    public void add(String[] array) {
        if (isValidID(array[0])) {
            Staff staff = new Staff(array);
            addStaff(staff);
        }
    }

    public boolean isValidID(String id) {
        for (Staff staff : list) {
            if (staff.getId().equals(id)) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Staff> getList() {
        return this.list;
    }

    public void list(String... parameter) {
        if (parameter[0] == (null) && getNumStaff() != 0) {
            for (Staff staff : list) {
                StaffUI.staffListHeader();
                UI.showLine();
                display(staff);
            }
        } else if (parameter[0].equals("nurses") && getNumNurse() != 0 ) {
            for (Staff staff : list) {
                if (staff.getType().equals(NURSE_TYPE)) {
                    StaffUI.staffListHeader();
                    UI.showLine();
                    display(staff);
                }
            }
        } else if (parameter[0].equals("doctors") && getNumDoctor() != 0 ) {
            for (Staff staff : list) {
                if (staff.getType().equals(DOCTOR_TYPE)) {
                    StaffUI.staffListHeader();
                    UI.showLine();
                    display(staff);
                }
            }
        } else {
            StaffUI.emptyListOutput();
        }
    }

    public void find(String keyword) {
        for (Staff staff : list) {
            if (search(keyword, staff)) {
                display(staff);
            }
        }
    }

    public boolean search(String keyword, Staff staff) {
        return staffChecker.isSameInt(staff.getAge(), keyword) || staff.getName().contains(keyword)
                    || staff.getId().contains(keyword) || staff.getSpecialisation().contains(keyword);
    }




    public void delete(String line) {
        boolean isExistingID = false;
        for (Iterator<Staff> iterator = list.iterator(); iterator.hasNext(); ) {
            Staff staff = iterator.next();
            if (staff.getId().equals(line.split("/")[1])) {
                iterator.remove();
                numStaff--;
                isExistingID = true;
            }
        }
        if (isExistingID) {
            StaffUI.staffFiredOutput(line);
        } else {
            StaffUI.staffDoesNotExist(line);
        }
    }

    public static void display(Staff staff) {
        System.out.println(
                prettyPrint(staff.getId(), 10) + " | " + prettyPrint(staff.getName(), 10) + " | "
                        + prettyPrint(Integer.toString(staff.getAge()), 5) + " | " + prettyPrint(staff.getSpecialisation(), 20));
    }

    public static int getNumStaff() {
        return numStaff;
    }
    public static int getNumNurse() {
        return numNurse;
    }
    public static int getNumDoctor() {
        return numDoctor;
    }
}
