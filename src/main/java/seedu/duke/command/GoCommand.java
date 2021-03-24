package seedu.duke.command;

import seedu.duke.*;
import seedu.duke.exception.InvalidBlockException;
import seedu.duke.routing.Map;
import seedu.duke.routing.Router;

import java.util.ArrayList;
import java.util.LinkedList;

public class GoCommand extends Command {
    public GoCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(Map nusMap, UiManager ui, History history,
                        NotesManager notesManager, DailyRoute dailyRoute) {
        try {
            String[] startAndDestination = ui.getRoutingInfo();
            if (startAndDestination[1].equals("EATERY")) {
                Block sortEateries[] = getNearestEatery(nusMap, startAndDestination[0]);
                int eateryEntry = ui.getEateryEntry(sortEateries);
                startAndDestination[1] = sortEateries[eateryEntry - 1].getName();
            }
            LinkedList<Block> route = new Router().execute(nusMap, startAndDestination[0], startAndDestination[1]);
            history.addHistory(startAndDestination[0], startAndDestination[1]);
            ui.showRoute(route);
        } catch (InvalidBlockException e) {
            ui.showToUser(e.getMessage());
        }
    }

    public Block[] getNearestEatery(Map nusMap, String from) throws InvalidBlockException {
        ArrayList<LinkedList<Block>> eateries = new ArrayList<>();
        eateries.add(new Router().execute(nusMap, from, "TECHNO EDGE CANTEEN"));
        eateries.add(new Router().execute(nusMap, from, "CHEERS MINIMART"));
        eateries.add(new Router().execute(nusMap, from, "ARISE & SHINE"));
        eateries.add(new Router().execute(nusMap, from, "PLATYPUS FOOD BAR"));
        eateries.add(new Router().execute(nusMap, from, "SPINELLI COFFEE"));
        return sortEateries(nusMap);
    }

    public Block[] sortEateries(Map nusMap) {
        Block[] eateries = new Block[5];
        eateries[0] = nusMap.getBlock("TECHNO EDGE CANTEEN");
        eateries[1] = nusMap.getBlock("CHEERS MINIMART");
        eateries[2] = nusMap.getBlock("ARISE & SHINE");
        eateries[3] = nusMap.getBlock("PLATYPUS FOOD BAR");
        eateries[4] = nusMap.getBlock("SPINELLI COFFEE");
        for (int i = 0; i < eateries.length - 1; i++) {
            for (int j = 0; j < eateries.length - 1 - i; j++) {
                if (eateries[j].getDistanceFromStart() > eateries[j + 1].getDistanceFromStart()) {
                    Block temp = eateries[j];
                    eateries[j] = eateries[j + 1];
                    eateries[j + 1] = temp;
                }
            }
        }
        return eateries;
    }
}
