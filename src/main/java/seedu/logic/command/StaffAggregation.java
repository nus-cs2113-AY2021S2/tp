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
        numStaff = 0;
        numDoctor = 0;
        numNurse = 0;
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

    public void list(String[] array) {
        if (getNumStaff() == 0) {
            StaffUI.emptyListErrorMessage();
            return;
        }

        if (array.length == 1) {
            StaffUI.staffListHeader();
            UI.showLine();
            for (Staff staff : list) {
                display(staff);
            }
        } else if (array[1].equals("nurses") && getNumNurse() != 0 ) {
            StaffUI.staffListHeader();
            UI.showLine();
            for (Staff staff : list) {
                if (staff.getType().equals(NURSE_TYPE)) {
                    display(staff);
                }
            }
        } else if (array[1].equals("doctors") && getNumDoctor() != 0 ) {
            StaffUI.staffListHeader();
            UI.showLine();
            for (Staff staff : list) {
                if (staff.getType().equals(DOCTOR_TYPE)) {
                    display(staff);
                }
            }
        } else {
            StaffUI.emptyListErrorMessage();
        }
    }

    public void find(String keyword) {
        boolean isFirstItemFound = false;
        for (Staff staff : list) {
            if (search(keyword, staff)) {
                if (!isFirstItemFound) {
                    UI.printEmptyLine();
                    StaffUI.staffListHeader();
                    UI.showLine();
                    isFirstItemFound = true;
                }
                display(staff);
            }
        }
        if (!isFirstItemFound) {
            StaffUI.staffNotFoundErrorMessage();
        }
    }

    public boolean search(String keyword, Staff staff) {
        return staffChecker.isSameInt(staff.getAge(), keyword) || staff.getName().contains(keyword)
                    || staff.getId().contains(keyword) || staff.getSpecialisation().contains(keyword);
    }




    public void delete(String input) {
        boolean isExistingID = false;
        for (Iterator<Staff> iterator = list.iterator(); iterator.hasNext(); ) {
            Staff staff = iterator.next();
            if (staff.getId().equals(input)) {
                iterator.remove();
                numStaff--;
                if (staff.getType() == NURSE_TYPE) {
                    numNurse--;
                } else {
                    numDoctor--;
                }
                isExistingID = true;
            }
        }
        if (isExistingID) {
            StaffUI.staffFiredOutput(input);
        } else {
            StaffUI.staffDoesNotExistErrorMessage(input);
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
