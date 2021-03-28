package seedu.duke.ui;

public class MessagesUi extends Ui {

    public MessagesUi() {
    }

    public final String tab = "\t";
    public final String logo =  " /$$   /$$ /$$   /$$  /$$$$$$  /$$      /$$\n"
            + "| $$$ | $$| $$  | $$ /$$__  $$| $$$    /$$$\n"
            + "| $$$$| $$| $$  | $$| $$  \\__/| $$$$  /$$$$  /$$$$$$  /$$$$$$$$  /$$$$$$\n"
            + "| $$ $$ $$| $$  | $$|  $$$$$$ | $$ $$/$$ $$ |____  $$|____ /$$/ /$$__  $$\n"
            + "| $$  $$$$| $$  | $$ \\____  $$| $$  $$$| $$  /$$$$$$$   /$$$$/ | $$$$$$$$\n"
            + "| $$\\  $$$| $$  | $$ /$$  \\ $$| $$\\  $ | $$ /$$__  $$  /$$__/  | $$_____/\n"
            + "| $$ \\  $$|  $$$$$$/|  $$$$$$/| $$ \\/  | $$|  $$$$$$$ /$$$$$$$$|  $$$$$$$\n"
            + "|__/  \\__/ \\______/  \\______/ |__/     |__/ \\_______/|________/ \\_______/";
    public final String greetingMessage = "Hello! Welcome to NUSMaze" + lineSeparator
            + "Where do you want to go today?";
    public final String byeMessage = "Bye. Hope to see you again soon!";
    public final String helpMessage = "1.  go:\n"
            + tab + "* finds the route to go from one block to another block or eatery\n"
            + "2.  history:\n"
            + tab + "* lists past 10 route searches\n"
            + "3.  clear history:\n"
            + tab + "* deletes all past route searches from history\n"
            + "4.  repeat:\n"
            + tab + "* repeats the past route search of your choice\n"
            + "5.  add alias:\n"
            + tab + "* creates an alias for an existing block\n"
            + "6.  show alias:\n"
            + tab + "* lists all aliases that are currently active\n"
            + "7.  delete alias:\n"
            + tab + "* deletes an alias that was previously created\n"
            + "8.  add day:\n"
            + tab + "* adds a schedule for the selected day\n"
            + "9.  day:\n"
            + tab + "* shows the generated route for the schedule of the selected day\n"
            + "10. add note LOCATION/DESCRIPTION:\n"
            + tab + "* adds and tags a note to a particular location\n"
            + "11. list notes LOCATION:\n"
            + tab + "* list notes tagged to the given location\n"
            + "12. delete note LOCATION/NOTE INDEX:\n"
            + tab + "* deletes notes based on index number tagged to the given location\n"
            + "13. bye:\n"
            + tab + "* exits the application";

    public void showLogo() {
        showToUser(divider, logo, divider);
    }

    public void showGreetMessage() {
        showToUser(greetingMessage, divider);
    }

    public void showByeMessage() {
        showToUser(byeMessage, divider);
    }

    public void showHelpMessage() {
        showToUser(helpMessage, divider);
    }
}
