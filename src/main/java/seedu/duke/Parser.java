package seedu.duke;

import seedu.exceptions.DeliveryAlreadyCompletedException;
import seedu.exceptions.DeliveryOutOfBoundsException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    /**
     * Used for initial separation of command word and args.
     */
    public static final Pattern BASIC_USER_INPUT_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Used to more easily format the driver profile input data.
     */
    public static final Pattern DRIVER_PROFILE_EDIT_FORMAT
        = Pattern.compile("n/(?<name>[^/]+)"
        + " v/(?<vehicle>[^/]+)"
        + " l/(?<license>[^/]+)"
        + " w/(?<weight>[^/]+)");

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
     * This method is only called when certain input commands are called by the user.
     * The specific commands that require this method call are outlined in Ui.
     *
     * @param commandWord is the user input command
     * @param arguments   are any user input arguments following the command word
     */
    public String parseInput(String commandWord, String arguments) {
        String parsedData = null;
        switch (commandWord) {
        case "edit":
            // TEST: edit n/Obi-Wan v/BMW X-Wing l/SJU7606F w/2
            Matcher editProfileMatcher = DRIVER_PROFILE_EDIT_FORMAT.matcher(arguments.trim());
            if (!editProfileMatcher.matches()) {
                System.out.println("Invalid Command");
                System.out.println("Please use the format: n/name v/vehicle model l/license plate w/weight");
                System.out.println("i.e. edit n/Obi-Wan v/BMW X-Wing l/SJU7606F w/5");
                parsedData = "fail";
            } else {
                parsedData = String.format("%s | %s | %s | %s",
                    editProfileMatcher.group("name"),
                    editProfileMatcher.group("vehicle"),
                    editProfileMatcher.group("license"),
                    editProfileMatcher.group("weight"));
            }
            break;
        case "view":
        case "complete":
            try {
                arguments = Integer.toString(Integer.parseInt(arguments) - 1);
            } catch (NumberFormatException e) {
                arguments = "-1";
            }
            parsedData = arguments;
            break;
        default:
            break;
        }
        return parsedData;
    }

    public void validateDeliveryNumber(int deliveryNumber) throws DeliveryOutOfBoundsException {
        if (deliveryNumber >= DeliveryList.deliveries.size() | deliveryNumber <= -1) {
            throw new DeliveryOutOfBoundsException();
        }
    }

    public void validateCompleteDelivery(int deliveryNumber) throws DeliveryAlreadyCompletedException {
        if (DeliveryList.deliveries.get(deliveryNumber).getIsComplete()) {
            throw new DeliveryAlreadyCompletedException();
        }
    }
}
