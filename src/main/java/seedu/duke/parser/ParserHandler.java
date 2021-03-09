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
        int optionIndex = getNextOptionIndex(trimmedInput);
        while (optionIndex != -1) {
            extracted.add(trimmedInput.substring(0,optionIndex).trim());
            trimmedInput = trimmedInput.substring(optionIndex).stripLeading();
            extracted.add(trimmedInput.substring(0,2));
            trimmedInput = trimmedInput.substring(2);
            optionIndex = getNextOptionIndex(trimmedInput);
        }
        if (checkOptionEndWith(trimmedInput.stripLeading())) {
            extracted.add(trimmedInput.substring(0, trimmedInput.length() - 2).trim());
            trimmedInput = trimmedInput.substring(trimmedInput.length() - 2);
            extracted.add(trimmedInput);
            extracted.add("");
        } else {
            extracted.add(trimmedInput.trim());
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
