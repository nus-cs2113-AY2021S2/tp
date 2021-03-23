package seedu.duke;

import java.util.ArrayList;
import java.util.HashMap;

public class DailyRoute {
    HashMap<String, ArrayList<String>> DailyRoutes;

    public DailyRoute() {
        this.DailyRoutes = new HashMap<String, ArrayList<String>>();
        this.DailyRoutes.put("MONDAY", new ArrayList<String>());
        this.DailyRoutes.put("TUESDAY", new ArrayList<String>());
        this.DailyRoutes.put("WEDNESDAY", new ArrayList<String>());
        this.DailyRoutes.put("THURSDAY", new ArrayList<String>());
        this.DailyRoutes.put("FRIDAY", new ArrayList<String>());
        this.DailyRoutes.put("SATURDAY", new ArrayList<String>());
        this.DailyRoutes.put("SUNDAY", new ArrayList<String>());
    }
    public void addDailyRoute(String day,ArrayList<String> blocks){
        DailyRoutes.remove(day);
        DailyRoutes.put(day, blocks);
    }
    public ArrayList<String> getDailyRoute(String day){
        return DailyRoutes.get(day);
    }

}

