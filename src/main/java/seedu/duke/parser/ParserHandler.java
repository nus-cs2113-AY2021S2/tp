package seedu.duke.parser;

import org.apache.commons.lang3.StringUtils;
import seedu.duke.command.Command;
import seedu.duke.command.CommandHandler;
import seedu.duke.exception.CommandException;
import seedu.duke.record.RecordList;

import java.util.ArrayList;

public class ParserHandler {
    public static ArrayList<String> getParseInput(String userInput) {
        ArrayList<String> extracted = new ArrayList<>();
        String trimmedInput = userInput.stripLeading();
        if (checkOptionStartWith(trimmedInput)) {
            extracted.add(trimmedInput.substring(0,2));
            trimmedInput = trimmedInput.substring(2);
        }
        return extractAfterFirstCheck(extracted, trimmedInput);
    }

    private static ArrayList<String> extractAfterFirstCheck(ArrayList<String> extracted, String trimmedInput) {
        int optionIndex = getNextOptionIndex(trimmedInput);
        while (optionIndex != -1) {
            String argument = trimmedInput.substring(0,optionIndex).trim();
            extracted.add(argument);
            trimmedInput = trimmedInput.substring(optionIndex).stripLeading();
            extracted.add(trimmedInput.substring(0,2));
            trimmedInput = trimmedInput.substring(2);
            optionIndex = getNextOptionIndex(trimmedInput);
        }
        return extractFinalPart(extracted, trimmedInput);
    }

    private static ArrayList<String> extractFinalPart(ArrayList<String> extracted, String trimmedInput) {
        if (checkOptionEndWith(trimmedInput)) {
            String argument = trimmedInput.substring(0, (trimmedInput.length() - 2)).trim();
            extracted.add(argument);
            extracted.add(trimmedInput.substring(trimmedInput.length() - 2).trim());
            extracted.add("");
        } else {
            extracted.add(trimmedInput.trim());
        }
        return extracted;
    }

    private static boolean checkOptionStartWith(String input) {
        return StringUtils.startsWithAny(input, "-e", "-l", "-s", "-d", "-a", "-i");
    }

    private static boolean checkOptionEndWith(String input) {
        return  StringUtils.endsWithAny(input, " -e", " -l", " -s", " -d", " -a", " -i");
    }

    private static int getNextOptionIndex(String leftOverString) {
        return StringUtils.indexOfAny(leftOverString, " -e ", " -l ", " -s ", " -d ", " -a ", " -i ");
    }
}
