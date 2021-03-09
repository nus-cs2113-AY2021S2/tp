package seedu.duke.parser;

import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;

public class ParserHandler {
    public static ArrayList<String> getParseInput(String userInput) {
        ArrayList<String> extracted = new ArrayList<>();
        String trimmedInput = userInput.stripLeading();
        if (checkOptionStartWith(trimmedInput)) {
            extracted.add(trimmedInput.substring(0,2));
            trimmedInput = trimmedInput.substring(2);
        }
        String argument;
        while (true) {
            int optionIndex = getNextOptionIndex(trimmedInput);
            if (optionIndex != -1) {
                argument = trimmedInput.substring(0,optionIndex).trim();
                extracted.add(argument);
                trimmedInput = trimmedInput.substring(optionIndex).stripLeading();
                extracted.add(trimmedInput.substring(0,2));
                trimmedInput = trimmedInput.substring(2);
            } else {
                if (checkOptionEndWith(trimmedInput)) {
                    argument = trimmedInput.substring(0,trimmedInput.length()-2).trim();
                    extracted.add(argument);
                    extracted.add(trimmedInput.substring(trimmedInput.length()-2).trim());
                    extracted.add("");
                } else {
                    extracted.add(trimmedInput.trim());
                }
                break;
            }
        }
        return extracted;
    }

    public static boolean checkOptionStartWith(String input) {
        return StringUtils.startsWithAny(input, "-e", "-l", "-s", "-d", "-a");
    }

    public static boolean checkOptionEndWith(String input) {
        return  StringUtils.endsWithAny(input, " -e", " -l", " -s", " -d", " -a");
    }

    public static int getNextOptionIndex(String leftOverString) {
        return StringUtils.indexOfAny(leftOverString, " -e ", " -l ", " -s ", " -d ", " -a ");
    }
}
