package employee;

import java.util.ArrayList;

public class Employee {
    private String name;
    private ArrayList<String> schedules = new ArrayList<>();
    private static final int MAX_DAY_OF_ODD_MONTH = 31;
    private static final int MAX_DAY_OF_EVEN_MONTH = 30;
    private static final int MAX_DAY_OF_FEB = 28;
    private static final int MIN_DAY_OF_MONTH = 1;
    private static final int MAX_MONTH_OF_YEAR = 12;
    private static final int MIN_MONTH_OF_YEAR = 1;
    private static final int MAX_ALLOWABLE_YEAR = 2099;
    private static final int MIN_ALLOWABLE_YEAR = 2021;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean addSchedule(String schedule) {
        if (isScheduleValid(schedule)) {
            schedules.add(schedule);
            return true;
        } else {
            return false;
        }
    }

    public static boolean isScheduleValid(String schedule) {
        if (schedule.length() != 10) {
            return false;
        }
        if (!schedule.substring("dd".length(), "dd/".length()).equals("/")
                || !schedule.substring("dd/mm".length(), "dd/mm/".length()).equals("/")) {
            return false;
        }
        String day = schedule.substring(0, "dd".length());
        String month = schedule.substring("dd/".length(), "dd/mm".length());
        String year = schedule.substring("dd/mm/".length(), "dd/mm/yyyy".length());
        if (!isInteger(day) || !isInteger(month) || !isInteger(year)) {
            return false;
        }
        int yyyy = Integer.parseInt(year);
        int mm = Integer.parseInt(month);
        int dd = Integer.parseInt(day);
        if (yyyy < MIN_ALLOWABLE_YEAR || yyyy > MAX_ALLOWABLE_YEAR) {
            return false;
        }
        if (mm < MIN_MONTH_OF_YEAR || mm > MAX_MONTH_OF_YEAR) {
            return false;
        }
        if (dd < MIN_DAY_OF_MONTH) {
            return false;
        }
        if (mm % 2 == 1) {
            return dd <= MAX_DAY_OF_ODD_MONTH;
        } else if (mm != 2) {
            return dd <= MAX_DAY_OF_EVEN_MONTH;
        } else {
            return dd <= MAX_DAY_OF_FEB;
        }
    }

    public void dropSchedule(String schedule) {
        schedules.remove(schedule);
    }

    public ArrayList<String> getSchedules() {
        return schedules;
    }

    public String formatData() {
        StringBuilder formattedString = new StringBuilder(getName());

        for (String schedule : getSchedules()) {
            formattedString.append("#");
            formattedString.append(schedule);
        }
        return formattedString + "\n";
    }

    private static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
}
