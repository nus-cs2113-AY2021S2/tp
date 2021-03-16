package seedu.duke.command;

import seedu.duke.History;
import seedu.duke.NotesManager;
import seedu.duke.UiManager;
import seedu.duke.routing.Router;

import java.util.Scanner;

public class RepeatCommand extends Command {
    public RepeatCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(Router router, UiManager ui, History history, NotesManager notesManager) {
        Scanner in = new Scanner(System.in);
        history.displayRecords();
        System.out.println("SELECT ENTRY TO REPEAT:");
        try {
            int entry = Integer.parseInt(in.nextLine());
            String[] pathDetails = history.getSpecificEntry(entry);
            String from = pathDetails[0];
            String to = pathDetails[1];
            String route = router.execute(from,to);
            history.addRecord(from, to);
            System.out.println(route);
        } catch (NumberFormatException e) {
            System.out.println("PLEASE ENTER A NUMBER INSTEAD!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("ERROR, NO ENTRY AVAILABLE.");
        }
    }
}
