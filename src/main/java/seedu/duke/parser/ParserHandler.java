package seedu.duke.parser;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Parser class to handle parsing of userInput.
 */
public class ParserHandler {
    /**
     * Check and parse if the input starts with option.
     * @param userInput contains a single string to be parsed.
     * @return a ArrayList of String containing trimmed options and arguments.
     */
    public static ArrayList<String> getParseInput(String userInput) {
        ArrayList<String> extracted = new ArrayList<>();
        String trimmedInput = userInput.stripLeading();
        if (checkOptionStartWith(trimmedInput)) {
            extracted.add(trimmedInput.substring(0,2));
            trimmedInput = trimmedInput.substring(2);
        }

        return extractAfterFirstCheck(extracted, trimmedInput);
    }

    /**
     * parse the remaining trimmed input before checking for last block.
     * @param extracted ArrayList of String containing the initial parsed option or argument.
     * @param trimmedInput contains the remaining input that is needed to be parse.
     * @return a ArrayList of String containing trimmed options and arguments.
     */
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

    /**
     * Check and parse if last block in ArrayList of String ends with option.
     * Add a empty string after the last block if last block ends with option.
     * @param extracted ArrayList of String containing the pre-final parsed option or argument.
     * @param trimmedInput contains the final remaining input that is needed to be parse.
     * @return the final parsed ArrayList of String containing the options and arguments.
     */
    private static ArrayList<String> extractFinalPart(ArrayList<String> extracted, String trimmedInput) {
        if (checkOptionEndWith(trimmedInput)) {
            String argument = trimmedInput.substring(0, (trimmedInput.length() - 2)).trim();
            extracted.add(argument);
            extracted.add(trimmedInput.substring(trimmedInput.length() - 2).trim());
            extracted.add("");
        } else {
            extracted.add(trimmedInput.trim());
        }
        return checkFirstBlock(extracted);
    }

    private static ArrayList<String> checkFirstBlock(ArrayList<String> extracted) {
        String firstblock = extracted.get(0);
        if (StringUtils.startsWithAny(firstblock, "remove ", "return ", "help ", "creditscore ")) {
            String[] splitBlock = firstblock.split(" ", 2);
            extracted.remove(0);
            extracted.add(splitBlock[0]);
            extracted.add(splitBlock[1].trim());
        }
        return extracted;
    }

    /**
     * Check if the input starts with valid options.
     * @param input string that is needed to be checked against.
     * @return true if input starts with valid options, else otherwise.
     */
    private static boolean checkOptionStartWith(String input) {
        return StringUtils.startsWithAny(input, "-e", "-l", "-s", "-d", "-a", "-i", "-p");
    }

    /**
     * Check if the input ends with valid options.
     * @param input string that is needed to be checked against.
     * @return true if input ends with valid options, else otherwise.
     */
    private static boolean checkOptionEndWith(String input) {
        return  StringUtils.endsWithAny(input, " -e", " -l", " -s", " -d", " -a", " -i", " -p");
    }

    /**
     * Check the next valid option index.
     * @param leftOverString containing the remaining input to be checked against.
     * @return the first index if matches any valid options in input, else -1.
     */
    private static int getNextOptionIndex(String leftOverString) {
        return StringUtils.indexOfAny(leftOverString, " -e ", " -l ", " -s ", " -d ", " -a ", " -i ", " -p ");
    }
}
