package seedu.duke.command;

import seedu.duke.History;
import seedu.duke.NotesManager;
import seedu.duke.UiManager;
import seedu.duke.routing.Router;

import java.util.Scanner;

public class GoCommand extends Command {
    public GoCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(Router router, UiManager ui, History history, NotesManager notesManager) {
        Scanner in = new Scanner(System.in);
        System.out.println("STARTING BLOCK:");
        String from = in.nextLine().toUpperCase();
        System.out.println("DESTINATION BLOCK:");
        String to = in.nextLine().toUpperCase();
        String route = router.execute(from,to);
        history.addRecord(from, to);
        System.out.println(route);
    }
}
