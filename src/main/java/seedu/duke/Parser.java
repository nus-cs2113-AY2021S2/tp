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

    // used to process user data when required
    public void parseInput(String commandWord, String arguments) {
        switch (commandWord) {
            case "profile":
                System.out.println("View Profile");
                break;
            case "editprofile":
//               TEST: edit n/Obi-Wan v/BMW X-Wing l/SJU7606F
                System.out.println("Edit Profile ");
                Matcher editProfileMatcher = DRIVER_PROFILE_EDIT_FORMAT.matcher(arguments.trim());
                if (!editProfileMatcher.matches()){
                    System.out.println("Invalid Command");
                } else {
                    String str = String.format("Name: %s | Vehicle: %s | License: %s",
                            editProfileMatcher.group("name"),
                            editProfileMatcher.group("vehicle"),
                            editProfileMatcher.group("license"));
                    System.out.println(str);
                }
                break;
            case "start":
                System.out.println("start");
                break;
            case "list":
                System.out.println("List");
                break;
            case "view":
            case "viewdelivery":
                System.out.println("Delivery Details");
                break;
            case "complete":
                System.out.println("complete");
                break;
            case "exit":
                System.out.println("Exiting Diliveri");
                System.exit(0);
            case "help":
            default:
                System.out.println("help");
                break;
        }

    }
}
