package seedu.model.staff;

import seedu.logic.errorchecker.StaffChecker;
import seedu.ui.StaffUI;
import seedu.ui.UI;

import java.util.ArrayList;
import java.util.Iterator;

import static seedu.ui.UI.prettyPrint;

public class StaffList {
    private static final String DOCTOR_TYPE = "D";
    private static final String NURSE_TYPE = "N";
    private ArrayList<Staff> list = new ArrayList<>();
    protected static int numStaff = 0;
    protected static int numDoctor = 0;
    protected static int numNurse = 0;
    private StaffChecker staffChecker = new StaffChecker();

    /**
     * Resets the StaffList.
     */
    public void resetList() {
        this.list.clear();
        numStaff = 0;
        numDoctor = 0;
        numNurse = 0;
    }

    /**
     * Adds a Staff object to the StaffList.
     *
     * @param staff Staff object to be added.
     */
    public void addStaff(Staff staff) {
        list.add(staff);
        if (staff.getType().equals(NURSE_TYPE)) {
            numNurse++;
        } else if (staff.getType().equals(DOCTOR_TYPE)) {
            numDoctor++;
        }
        numStaff++;
    }

    /**
     * Adds a Staff object to StaffList with using an array of input fields.
     *
     * @param array  array of fields to form Staff object.
     */
    public void add(String[] array) {
        if (isValidID(array[0])) {
            Staff staff = new Staff(array);
            addStaff(staff);
        }
    }

    /**
     * Returns a boolean indicating whether ID is found within the StaffList.
     *
     * @param id  String of Staff ID
     * @return boolean for whether ID is found in the StaffList.
     */
    public boolean isValidID(String id) {
        for (Staff staff : list) {
            if (staff.getId().equals(id)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns an ArrayList that holds all Staff objects.
     *
     * @return ArrayList of Staff objects.
     */
    public ArrayList<Staff> getList() {
        return this.list;
    }

    /**
     * Displays information of all relevant Staff objects.
     *
     * @param array  Array of inputs to determine what Staff objects to be displayed.
     */
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
        } else if (array[1].equals("nurses") && getNumNurse() != 0) {
            StaffUI.staffListHeader();
            UI.showLine();
            for (Staff staff : list) {
                if (staff.getType().equals(NURSE_TYPE)) {
                    display(staff);
                }
            }
        } else if (array[1].equals("doctors") && getNumDoctor() != 0) {
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

    /**
     * Displays all Staff object information if keyword matches the Staff object.
     *
     * @param keyword String to locate relevant Staff objects.
     */
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

    /**
     * Checks if a Staff object matches a given keyword.
     *
     * @param keyword  String to locate relevant Staff objects.
     * @param staff Staff object to check against.
     * @return boolean for whether the keyword can be found in the Staff object.
     */
    public boolean search(String keyword, Staff staff) {
        return staffChecker.isSameInt(staff.getAge(), keyword) || staff.getName().contains(keyword)
                    || staff.getId().contains(keyword) || staff.getSpecialisation().contains(keyword);
    }



    /**
     * Deletes a Staff object from StaffList based on the Staff ID input.
     *
     * @param input  Staff ID to be removed from the StaffList.
     */
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

    /**
     * Displays the information of Staff object.
     *
     * @param staff Staff object to be displayed.
     */
    public static void display(Staff staff) {
        System.out.println(
                prettyPrint(staff.getId(), 10) + " | "
                + prettyPrint(staff.getName(), 10) + " | "
                + prettyPrint(Integer.toString(staff.getAge()), 5) + " | "
                + prettyPrint(staff.getSpecialisation(), 20));
    }

    /**
     * Returns number of Staff in StaffList.
     *
     * @return Number of Staff objects.
     */
    public static int getNumStaff() {
        return numStaff;
    }

    /**
     * Returns number of Nurse Staff objects in StaffList.
     *
     * @return Number of Nurse Staff objects.
     */
    public static int getNumNurse() {
        return numNurse;
    }

    /**
     * Returns number of Doctor Staff objects in StaffList.
     *
     * @return Number of Doctor Staff objects.
     */
    public static int getNumDoctor() {
        return numDoctor;
    }
}
