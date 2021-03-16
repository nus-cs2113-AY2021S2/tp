package seedu.duke;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    /**
     * Used for initial separation of command word and args.
     */
    public static final Pattern BASIC_USER_INPUT_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    public static final Pattern DRIVER_PROFILE_EDIT_FORMAT
            = Pattern.compile("n/(?<name>[^/]+)"
            + " v/(?<vehicle>[^/]+)"
            + " l/(?<license>[^/]+)");

    // original method is split it into 2 methods below

//    public void parse(String userInput) {
//        Matcher matcher = BASIC_USER_INPUT_FORMAT.matcher(userInput.trim());
//        String commandWord = null;
//        String arguments = null;
//        while (matcher.find()) {
//            commandWord = matcher.group("commandWord").trim();
//            arguments = matcher.group("arguments").trim();
//        }
//    }

    public String parseCommand(String userInput) {
        Matcher matcher = BASIC_USER_INPUT_FORMAT.matcher(userInput.trim());
        String commandWord = null;
        while (matcher.find()) {
            commandWord = matcher.group("commandWord").trim();
        }
        return commandWord;
    }

    public String parseArguments(String userInput) {
        Matcher matcher = BASIC_USER_INPUT_FORMAT.matcher(userInput.trim());
        String arguments = null;
        while (matcher.find()) {
            arguments = matcher.group("arguments").trim();
        }
        return arguments;
    }

    /**
     * This method is only called when certain input commands are called by the user
     * The specific commands that require this method call are outlined in Ui
     * @param commandWord is the user input command
     * @param arguments are any user input arguments following the command word
     * @param deliveryman
     */
    public String parseInput(String commandWord, String arguments, Deliveryman deliveryman) {
        String parsedData = null;
        switch (commandWord) {
            case "edit":
            case "editprofile":
//               TEST: edit n/Obi-Wan v/BMW X-Wing l/SJU7606F
                Matcher editProfileMatcher = DRIVER_PROFILE_EDIT_FORMAT.matcher(arguments.trim());
                if (!editProfileMatcher.matches()){
                    System.out.println("Invalid Command");
                    System.out.println("Please use the format: n/name v/vehicle model l/license plate");
                    System.out.println("i.e. edit n/Obi-Wan v/BMW X-Wing l/SJU7606F");
                    parsedData = "fail";
                } else {
                    parsedData = String.format("%s | %s | %s",
                            editProfileMatcher.group("name"),
                            editProfileMatcher.group("vehicle"),
                            editProfileMatcher.group("license"));
                }
                break;
            case "view":
            case "viewdelivery":
            case "complete":
                arguments = Integer.toString(Integer.parseInt(arguments) - 1);
                // display list starts from 1 while array index starts from 0, hence the decrement
                parsedData = arguments;
                break;
            default:
                System.out.println("You shouldn't have been able to get here..");
                // consider setting parsedData to a flagger value and handling from there
                break;
        }
        return parsedData;
    }
}
