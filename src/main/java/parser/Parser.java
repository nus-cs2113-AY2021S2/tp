package parser;

import command.AddCommand;
import command.Command;
import command.DisplayMenusCommand;
import command.ExitCommand;
import command.ReadCommand;
import command.DisplayStoresCommand;
import exceptions.DukeExceptions;


public class Parser {

    public int parseIndex(String input, String keyword, int maxStores) throws DukeExceptions {
        String[] inputArray = input.split(" ");
        int index = -1;
        String invalidIndexMessage = "Invalid index! Please enter a valid index for your '" + keyword + "' command.";

        // parse to get index from input
        for (String word : inputArray) {
            if (word.equals(keyword)) {
                continue;
            }
            try {
                index = Integer.parseInt(word);
                // show menu for first index given
                // returns the first integer given
                break;
            } catch (NumberFormatException e) {
                throw new DukeExceptions(invalidIndexMessage);
            }
        }
        if (index <= 0 || index > maxStores) {
            throw new DukeExceptions(invalidIndexMessage);
        }
        return index;
    }

    public Command parse(String line, int maxStores) throws DukeExceptions {
        Command newCommand;
        String[] parsedLine = line.split(" ");
        if (line.startsWith("list")) {
            newCommand = new DisplayStoresCommand();
        } else if (line.startsWith("menu")) {
            int storeDisplayedIndex = parseIndex(line, "menu", maxStores);
            newCommand = new DisplayMenusCommand(storeDisplayedIndex - 1);
        } else if (line.startsWith("exit")) {
            newCommand = new ExitCommand();
        } else if (parsedLine[0].equals("read")) {
            int reviewDisplayedIndex = parseIndex(line, "read", maxStores);
            newCommand = new ReadCommand(reviewDisplayedIndex - 1);
        } else if (parsedLine[0].equals("add")) {
            int storeDisplayedIndex = parseIndex(line, "add", maxStores);
            String newStoreReview = line.substring(line.indexOf("r/") + 2);
            double newStoreRating = Double.parseDouble(line.substring(line.indexOf("s/") + 2,line.indexOf("r/")));
            newCommand = new AddCommand(storeDisplayedIndex - 1,newStoreReview,newStoreRating);
        } else {
            throw new DukeExceptions("Please enter a valid command!");
        }
        return newCommand;
    }

}
