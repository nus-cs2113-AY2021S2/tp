package parser;

import command.AddReviewCommand;
import command.AddStoreCommand;
import command.Command;
import command.DisplayMenusCommand;
import command.DisplayStoresCommand;
import command.ExitCommand;
import command.ReadReviewsCommand;
import exceptions.DukeExceptions;


public class Parser {

    public void indexCheckValid(int storeIndex, int maxStores) throws DukeExceptions {

        try {
            if (storeIndex < 0 | storeIndex > maxStores) {
                throw new DukeExceptions("Index out of bound, "
                        + "please re-enter a valid index.");
            }

        } catch (DukeExceptions e) {
            System.out.println(e.getMessage());
        }

    }


    public Command parse(String line, String index, int maxStores) throws DukeExceptions {
        Command newCommand;
        if (line.startsWith("list")) {
            newCommand = new DisplayStoresCommand();
        } else if (line.equals("menu")) {
            indexCheckValid(Integer.parseInt(index) - 1,maxStores);
            newCommand = new DisplayMenusCommand(Integer.parseInt(index) - 1);
        } else if (line.equals("add")) {
            indexCheckValid(Integer.parseInt(index) - 1,maxStores);
            newCommand = new AddReviewCommand(Integer.parseInt(index) - 1);
        } else if (line.startsWith("exit")) {
            newCommand = new ExitCommand();
        } else if (line.equals("reviews")) {
            indexCheckValid(Integer.parseInt(index) - 1,maxStores);
            newCommand = new ReadReviewsCommand( Integer.parseInt(index) - 1);
        } else {
            throw new DukeExceptions("Please enter a valid command!");
        }
        return newCommand;
    }

    //parse admin commands only
    public Command parseAdminCommand(String line, int maxStores) throws DukeExceptions {
        Command newCommand;

        if (line.equals("1")) {
            newCommand = new AddStoreCommand();
        } else if (line.startsWith("list")) {
            newCommand = new DisplayStoresCommand();
        } else if (line.startsWith("exit")) {
            newCommand = new ExitCommand();
        } else {
            throw new DukeExceptions("Please enter a valid command!");
        }
        return newCommand;
    }
}
