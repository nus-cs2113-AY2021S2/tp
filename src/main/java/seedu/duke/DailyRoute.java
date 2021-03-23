package seedu.duke;

import java.util.ArrayList;
import java.util.HashMap;

public class DailyRoute {
    HashMap<String, ArrayList<String>> dailyRoutes;

    public DailyRoute() {
        this.dailyRoutes = new HashMap<String, ArrayList<String>>();
        this.dailyRoutes.put("MONDAY", new ArrayList<String>());
        this.dailyRoutes.put("TUESDAY", new ArrayList<String>());
        this.dailyRoutes.put("WEDNESDAY", new ArrayList<String>());
        this.dailyRoutes.put("THURSDAY", new ArrayList<String>());
        this.dailyRoutes.put("FRIDAY", new ArrayList<String>());
        this.dailyRoutes.put("SATURDAY", new ArrayList<String>());
        this.dailyRoutes.put("SUNDAY", new ArrayList<String>());
    }

    public void addDailyRoute(String day, ArrayList<String> blocks) {
        dailyRoutes.remove(day);
        dailyRoutes.put(day, blocks);
    }

    public ArrayList<String> getDailyRoute(String day) {
        return dailyRoutes.get(day);
    }

}

