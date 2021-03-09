package seedu.connoisseur.parser;

/**
 * Handles Connoisseur's commands.
 */
public class Parser {

    public static boolean determineCommand(String input) {
        String command = input.split(" ", 2)[0].toLowerCase().trim();
        String description = input.split(" ", 2)[1].trim();

        if (command.equals("list")) {
            CommandList.listReviews();
        } else if (command.equals("sort")) {
            CommandList.sortReview(description);
        } else if (command.equals("new")) {
            CommandList.addReview(description);
        } else if (command.equals("delete")) {
            CommandList.deleteReview(description);
        } else if (command.equals("help")) {
            CommandList.printHelp();
//            Ui.printDivider();
//            Ui.printHelpCommandList();
//            Ui.printDivider();
        } else if (command.equals("bye")) {
            return true;
        }
//        else {
//            throw new InvalidTaskCommandException();
//        }

        return false;
    }
}
