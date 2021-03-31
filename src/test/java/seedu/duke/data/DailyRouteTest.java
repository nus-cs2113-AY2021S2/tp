package seedu.duke.data;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class DailyRouteTest {

    @Test
    void addDailyRoute_addedValidRoute_expectMapped() {
        DailyRoute dailyRoute = new DailyRoute();
        ArrayList<String> blocks = new ArrayList<>(List.of("E1", "E2", "E3"));
        String day = "MONDAY";
        dailyRoute.addDailyRoute(day, blocks);
        assertEquals(dailyRoute.getDailyRoute(day), blocks);
    }

    @Test
    void getDailyRoute_nothingAdded_expectEmpty() {
        DailyRoute dailyRoute = new DailyRoute();
        assertEquals(dailyRoute.getDailyRoute("MONDAY"), new ArrayList<>());
    }

    @Test
    void saveDaySchedule_validRoutePresent_expectSaveFormat() {
        DailyRoute dailyRoute = new DailyRoute();
        ArrayList<String> blocks = new ArrayList<>(List.of("E1", "E2", "E3"));
        String day = "MONDAY";
        dailyRoute.addDailyRoute(day, blocks);
        String toSave = dailyRoute.saveDaySchedule(day);
        assertEquals(toSave, "MONDAY+E1|E2|E3|");
    }

    @Test
    void getSelectableDays_dayAdded_expectMonday() {
        DailyRoute dailyRoute = new DailyRoute();
        ArrayList<String> blocks = new ArrayList<>(List.of("E1", "E2", "E3"));
        String day = "MONDAY";
        dailyRoute.addDailyRoute(day, blocks);
        assertEquals(dailyRoute.getSelectableDays(), new ArrayList<>(List.of("MONDAY")));
    }

    @Test
    void getSelectableDays_noDayAdded_expectEmpty() {
        DailyRoute dailyRoute = new DailyRoute();
        assertEquals(dailyRoute.getSelectableDays(), new ArrayList<>());
    }

    @Test
    void getValidDays_expectMonToSun() {
        DailyRoute dailyRoute = new DailyRoute();
        assertEquals(dailyRoute.getValidDays(),
                new ArrayList<>(List.of("MONDAY", "TUESDAY", "WEDNESDAY",
                        "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY")));
    }
}