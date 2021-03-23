package seedu.duke.command;

import seedu.duke.DailyRoute;
import seedu.duke.History;
import seedu.duke.NotesManager;
import seedu.duke.UiManager;
import seedu.duke.exception.InvalidBlockException;
import seedu.duke.exception.InvalidDayException;
import seedu.duke.routing.Router;

import java.util.ArrayList;

public class ShowDailyRouteCommand extends Command {
    public ShowDailyRouteCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(Router router, UiManager ui, History history, NotesManager notesManager, DailyRoute dailyRoute) {
        String Day = null;
        try {
            Day = ui.getDay();
            assert Day != null;
            ArrayList<String> Blocks = dailyRoute.getDailyRoute(Day);
            StringBuilder DayRoute = new StringBuilder();
            for(int i = 0; i < Blocks.size() - 1; i++){
                try {
                    String route = router.execute(Blocks.get(i), Blocks.get(i + 1));
                    DayRoute.append(route);
                    if(i < Blocks.size()-2){
                        DayRoute.append("\n");
                    }
                    ui.showToUser(DayRoute.toString());
                } catch (InvalidBlockException e){
                    ui.showToUser(e.getMessage());
                }
            }
        } catch (InvalidDayException e) {
            ui.showToUser(e.getMessage());
        }
    }
}