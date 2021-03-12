package parser;

import command.Command;
import command.DisplayCommand;
import command.ExitCommand;
import exceptions.DukeExceptions;

public class Parser {

    public static Command parse(String line) throws DukeExceptions {
        Command newCommand;
        String[] parsedLine = line.split(" ");
        if (parsedLine[0].equals("list")) {
            newCommand = new DisplayCommand();
        } else if (parsedLine[0].equals("exit")) {
            newCommand = new ExitCommand();
        } else {
            throw new DukeExceptions();
        }
        return newCommand;
    }
}
