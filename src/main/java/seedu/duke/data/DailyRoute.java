package seedu.duke.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DailyRoute {
    private HashMap<String, ArrayList<String>> dailyRoutes;
    private final ArrayList<String> days =
            new ArrayList<>(List.of("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"));
    private boolean[] selectableDays = {false,false,false,false,false,false,false};

    public DailyRoute() {
        this.dailyRoutes = new HashMap<>();
        this.dailyRoutes.put("MONDAY", new ArrayList<>());
        this.dailyRoutes.put("TUESDAY", new ArrayList<>());
        this.dailyRoutes.put("WEDNESDAY", new ArrayList<>());
        this.dailyRoutes.put("THURSDAY", new ArrayList<>());
        this.dailyRoutes.put("FRIDAY", new ArrayList<>());
        this.dailyRoutes.put("SATURDAY", new ArrayList<>());
        this.dailyRoutes.put("SUNDAY", new ArrayList<>());
    }


    /**
     * maps the day to the inputted schedule.
     * @param day is the day input from the user.
     * @param blocks is the schedule input from the user.
     */
    public void addDailyRoute(String day, ArrayList<String> blocks) {
        dailyRoutes.replace(day, blocks);
        int index = days.indexOf(day);
        selectableDays[index] = blocks.size() != 0;
    }

    /**
     * Returns the schedule to the inputted day.
     * @param day  is the day input from the user.
     */
    public ArrayList<String> getDailyRoute(String day) {
        return dailyRoutes.get(day);
    }

    /**
     * Returns the days that have schedules mapped to them.
     */
    public ArrayList<String> getSelectableDays() {
        ArrayList<String> daysFound = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            if (selectableDays[i]) {
                daysFound.add(days.get(i));
            }
        }
        return daysFound;
    }

    /**
     * Returns the days in the week.
     */
    public ArrayList<String> getValidDays() {
        return days;
    }

}

