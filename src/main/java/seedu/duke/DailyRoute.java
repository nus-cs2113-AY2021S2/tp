package seedu.duke;


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

    public void addDailyRoute(String day, ArrayList<String> blocks) {
        dailyRoutes.remove(day);
        dailyRoutes.put(day, blocks);
        int index = days.indexOf(day);
        selectableDays[index] = true;
    }

    public ArrayList<String> getDailyRoute(int selection) {
        return dailyRoutes.get(days.get(selection));
    }

    public String saveDaySchedule(String day) {
        StringBuilder saveLine = new StringBuilder(day + "+");
        ArrayList<String> blocks = dailyRoutes.get(day);
        for (String block: blocks) {
            saveLine.append(block).append("|");
        }
        return saveLine.toString();
    }


    public ArrayList<String> getSelectableDays() {
        ArrayList<String> daysFound = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            if (selectableDays[i]) {
                daysFound.add(days.get(i));
            }
        }
        return daysFound;
    }

    public ArrayList<String> getValidDays() {
        return days;
    }

}

