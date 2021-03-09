package seedu.fridgefriend.command;

import java.util.List;

public class ListCommand extends Command {

    private static final int EXTRA_INDEX = 1;

    public ListCommand() {
    }

    @Override
    public void execute(List<String> foods) {
        System.out.println("Here are the items in your fridge:");
        for (int i = 0; i < foods.size(); i++) {
            int indexShownToUser = i+ EXTRA_INDEX;
            System.out.println("\t" + indexShownToUser + ". " + foods.get(i));
        }
    }

}
