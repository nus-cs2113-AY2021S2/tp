package seedu.logic.command;

import seedu.ui.StaffUI;
import seedu.model.staff.Staff;

import java.util.ArrayList;
import java.util.Iterator;

import static seedu.logic.errorchecker.StaffChecker.isSameInt;
import static seedu.ui.UI.*;

public class StaffAggregation {
    private static final String DOCTOR_TYPE = "D";
    private static final String NURSE_TYPE = "N";
    private ArrayList<Staff> list = new ArrayList<>();
    protected static int numStaff = 0;

    public StaffAggregation() {
    }

    public void resetList() {
        this.list.clear();
        numStaff=0;
    }

    public void addStaff(Staff staff) {
        list.add(staff);
        numStaff++;
    }

    public void add(String[] array) {
        if (isValidID(array[0])) {
            Staff staff = new Staff(array);
            addStaff(staff);
            StaffUI.staffHiredOutput(array[0], array[1]);
        }
    }

    public boolean isValidID(String id) {
        for (Staff staff : list) {
            if (staff.getId().equals(id)) {
                System.out.println("Error that staff ID has been taken\n");
                return false;
            }
        }
        return true;
    }

    public ArrayList<Staff> getList() {
        return this.list;
    }

    public void list(String... parameter) {
        if (this.getNumStaff() == 0){
            StaffUI.emptyListOutput();
        }
        if (parameter[0] == (null)) {
            for (Staff staff : list) {
                display(staff);
            }
        } else if (parameter[0].equals("nurses")) {
            for (Staff staff : list) {
                if (staff.getType().equals(NURSE_TYPE)) {
                    display(staff);
                }
            }
        } else if (parameter[0].equals("doctors")) {
            for (Staff staff : list) {
                if (staff.getType().equals(DOCTOR_TYPE)) {
                    display(staff);
                }
            }
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
        return isSameInt(staff.getAge(),keyword) || staff.getName().contains(keyword)
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
}
