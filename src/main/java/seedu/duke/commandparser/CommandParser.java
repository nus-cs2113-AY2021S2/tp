package seedu.duke.commandparser;

import seedu.duke.account.FitCenter;
import seedu.duke.command.*;
import seedu.duke.common.Messages;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import static seedu.duke.command.CommandType.ADD;
import static seedu.duke.command.CommandType.VIEW;

public class CommandParser {
    private final HashMap<String, String> params;
    private final FitCenter fitCenter;

    public CommandParser(FitCenter fitCenter) {
        params = new HashMap<>();
        this.fitCenter = fitCenter;
    }

    public Command parseCommand(String userInput) {
        String[] inputParts = getInputParts(userInput);
        String commandWord = getCommandWord(inputParts);
        switch (commandWord) {
        case "add":
            return prepareAdd(inputParts);
        case "view":
            return prepareView(inputParts);
        case "delete":
            return prepareDelete(inputParts);
        case "exit":
            return new ExitCommand();
        default:
            return new InvalidCommand("Invalid");
        }
    }

    private String getCommandWord(String[] inputParts) {
        return inputParts[0];
    }

    private String[] getInputParts(String userInput) {
        return userInput.trim().split("\\s+", 2);
    }

    private Command prepareAdd(String[] inputParts) {
        try {
            if (inputParts.length < 2) {
                return new InvalidCommand(ADD);
            }

            String recordType = parseType(inputParts[1]);
            if (recordType.equals("")) {
                return new InvalidCommand(ADD);
            }

            String[] typeContent = getTypeAndContent(inputParts[1]);
            if (typeContent.length < 2) {
                return new InvalidCommand(ADD);
            }

            String content = typeContent[1];
            content = content.trim();
            switch (recordType) {
            case "E":
                return prepareAddExercise(content);
            case "W":
                return prepareAddBodyWeight(content);
            case "D":
                return prepareAddDiet(content);
            case "S":
                return prepareAddSleep(content);
            default:
                return new InvalidCommand(Messages.MESSAGE_INVALID_COMMAND_WORD);
            }
        } catch (ParseException e) {
            return new InvalidCommand(Messages.MESSAGE_INVALID_DATE_FORMAT);
        }
    }

    private String[] getTypeAndContent(String inputPart) {
        return inputPart.split("\\s+", 2);
    }

    private Command prepareView(String[] inputParts) {
        if (inputParts.length < 2) {
            return new InvalidCommand(VIEW);
        }
        String recordType = parseType(inputParts[1]);
        if (recordType.equals("")) {
            return new InvalidCommand(VIEW);
        }
        String typeContent = inputParts[1];
        typeContent = typeContent.trim();
        switch (recordType) {
        case "E":
            //return prepareViewExercise(typeContent);
        case "W":
            //return prepareViewBodyWeight(typeContent);
        case "D":
            //return prepareViewDiet(typeContent);
        case "S":
            //return prepareViewSleep(typeContent);
        default:
            return new InvalidCommand(VIEW);
        }
    }

    private Command prepareDelete(String[] inputParts) {
        if (inputParts.length < 2) {
            return new InvalidCommand("Invalid");
        }
        String recordType = parseType(inputParts[1]);
        if (recordType.equals("")) {
            return new InvalidCommand("Invalid");
        }
        String[] typeIndex = inputParts[1].split("\\s+", 2);
        if (typeIndex.length < 2) {
            return new InvalidCommand("Invalid");
        }
        String index = typeIndex[1];
        boolean isIndexValid = index.startsWith("i/") && index.length() >= 3;
        if (!isIndexValid) {
            return new InvalidCommand("Invalid");
        }
        index = index.substring(2);
        System.out.println(index);
        return new InvalidCommand("Invalid");
    }

    private void prepareViewExercise(String typeContent) {
        if (typeContent.length() == 3) {
            //System.out.println("print all exercise records");
            return;
        }
        String[] rawInput = typeContent.split("\\s+", 2);
        if (rawInput.length == 1) {
            System.out.println("Invalid");
            return;
        }
        String optionParams = rawInput[1].trim();
        String activity;
        String date;
        boolean hasActivity = optionParams.contains("a/");
        boolean hasDate = optionParams.contains("date/");
        if (!hasActivity && !hasDate) {
            System.out.println("Invalid");
            return;
        }
        if (hasActivity) {
            activity = parseExerciseActivity(optionParams, false);
            if (activity.equals("")) {
                System.out.println("Invalid");
                return;
            }
            if (!hasDate) {
                System.out.println(activity);
                return;
            }
            String[] activityDate = getDate(activity);
            if (activityDate.length == 0) {
                //return new InvalidCommand();
                System.out.println("Invalid");
                return;
            }
            activity = activityDate[0];
            date = activityDate[1];
            System.out.println(activity);
            System.out.println(date);
            return;
        }
        if (!optionParams.startsWith("date/")) {
            System.out.println("Invalid");
            return;
        }
        date = optionParams.substring(5);
        if (date.length() == 0) {
            System.out.println("Invalid");
            return;
        }
        ArrayList<String> params = new ArrayList<>();
        System.out.println(date);
    }

    private void prepareViewDiet(String typeContent) {
        if (typeContent.length() == 3) {
            System.out.println("print all diet records");
            return;
        }
        String[] rawInput = typeContent.split("\\s+", 2);
        if (rawInput.length == 1) {
            System.out.println("Invalid");
            return;
        }
        String optionalParams = rawInput[1].trim();
        String food;
        String date;
        boolean hasFood = optionalParams.contains("f/");
        boolean hasDate = optionalParams.contains("date/");
        if (!hasFood && !hasDate) {
            System.out.println("Invalid");
            return;
        }
        if (hasFood) {
            food = parseDiet(optionalParams, false);
            if (food.equals("")) {
                System.out.println("Invalid");
                return;
            }
            if (!hasDate) {
                System.out.println(food);
                return;
            }
            String[] activityDate = getDate(food);
            if (activityDate.length == 0) {
                //return new InvalidCommand();
                System.out.println("Invalid");
                return;
            }
            food = activityDate[0];
            date = activityDate[1];
            System.out.println(food);
            System.out.println(date);
            return;
        }
        if (!optionalParams.startsWith("date/")) {
            System.out.println("Invalid");
            return;
        }
        date = optionalParams.substring(5);
        if (date.length() == 0) {
            System.out.println("Invalid");
            return;
        }
        ArrayList<String> params = new ArrayList<>();
        System.out.println(date);
    }

    private void prepareViewSleep(String typeContent) {
        if (typeContent.length() == 3) {
            System.out.println("print all sleep records");
            return;
        }
        boolean hasDate = typeContent.contains("date/");
        if (!hasDate) {
            System.out.println("Invalid");
            return;
        }
        String[] typeDate = getDate(typeContent);
        if (typeDate.length == 0) {
            //return new InvalidCommand();
            System.out.println("Invalid");
            return;
        }
        String date = typeDate[1];
        System.out.println(date);
    }

    private void prepareViewBodyWeight(String typeContent) {
        if (typeContent.length() == 3) {
            System.out.println("print all body weight records");
            return;
        }
        boolean hasDate = typeContent.contains("date/");
        if (!hasDate) {
            System.out.println("Invalid");
            return;
        }
        String[] typeDate = getDate(typeContent);
        if (typeDate.length == 0) {
            //return new InvalidCommand();
            System.out.println("Invalid");
            return;
        }
        String date = typeDate[1];
        System.out.println(date);
    }

    private Command prepareAddSleep(String content) throws ParseException {
        String duration = parseDuration(content, false);
        if (duration.equals("")) {
            return new InvalidCommand(ADD);
        }
        boolean hasDate = content.contains("date/");
        String date;
        if (hasDate) {
            String[] durationDate = getDate(duration);
            if (durationDate.length == 0) {
                return new InvalidCommand(ADD);
            }
            duration = durationDate[0];
            date = durationDate[1];
            params.put("duration", duration);
            params.put("date", date);
            return new AddCommand("S", params, fitCenter);
        }
        params.put("duration", duration);
        return new AddCommand("S", params, fitCenter);
    }

    private String[] getDate(String stringWithDate) {
        String[] paramDateRaw = stringWithDate.split("date/", 2);
        String date = paramDateRaw[1].trim();
        String param = paramDateRaw[0].trim();
        boolean isParamValid = param.length() > 0;
        boolean isDateValid = date.length() == 10;
        if (!isParamValid || !isDateValid) {
            return new String[0];
        }
        String[] paramDate = new String[2];
        paramDate[0] = param;
        paramDate[1] = date;
        return paramDate;
    }

    private Command prepareAddDiet(String content) throws ParseException {
        String[] foodWeight = getFoodAndFoodWeight(content);
        if (foodWeight.length < 2) {
            return new InvalidCommand(ADD);
        }
        String foodRawInput = foodWeight[0].trim();
        String weightRawInput = foodWeight[1].trim();
        String food = parseDiet(foodRawInput, false);
        if (food.equals("")) {
            return new InvalidCommand(ADD);
        }
        String weight = parseWeight(weightRawInput, true);
        if (weight.equals("")) {
            return new InvalidCommand(ADD);
        }
        boolean hasDate = weightRawInput.contains("date/");
        String date;
        if (hasDate) {
            String[] weightDate = getDate(weight);
            if (weightDate.length == 0) {
                return new InvalidCommand(ADD);
            }
            weight = weightDate[0];
            date = weightDate[1];
            params.put("food", food);
            params.put("weight", weight);
            params.put("date", date);
            return new AddCommand("D", params, fitCenter);
        }
        params.put("food", food);
        params.put("weight", weight);
        return new AddCommand("D", params, fitCenter);
    }

    private String[] getFoodAndFoodWeight(String content) {
        return content.split("w/", 2);
    }

    private Command prepareAddBodyWeight(String content) throws ParseException {
        String weight = parseWeight(content, false);
        if (weight.equals("")) {
            return new InvalidCommand(ADD);
        }
        boolean hasDate = content.contains("date/");
        String date;
        if (hasDate) {
            String[] weightDate = getDate(weight);
            if (weightDate.length == 0) {
                return new InvalidCommand(ADD);
            }
            weight = weightDate[0];
            date = weightDate[1];
            params.put("weight", weight);
            params.put("date", date);
            return new AddCommand("W", params, fitCenter);
        }
        params.put("weight", weight);
        return new AddCommand("W", params, fitCenter);
    }

    private Command prepareAddExercise(String content) throws ParseException {
        String[] activityDuration = getActivityAndDuration(content);
        if (activityDuration.length < 2) {
            return new InvalidCommand(ADD);
        }

        String activityRawInput = activityDuration[0].trim();
        String activity = parseExerciseActivity(activityRawInput, false);
        if (activity.equals("")) {
            return new InvalidCommand(ADD);
        }

        String durationRawInput = activityDuration[1].trim();
        String duration = parseDuration(durationRawInput, true);
        if (duration.equals("")) {
            return new InvalidCommand(ADD);
        }

        boolean hasDate = durationRawInput.contains("date/");
        String date;
        if (hasDate) {
            String[] durationDate = getDate(duration);
            if (durationDate.length == 0) {
                return new InvalidCommand(ADD);
            }
            duration = durationDate[0];
            date = durationDate[1];
            params.put("activity", activity);
            params.put("duration", duration);
            params.put("date", date);
            return new AddCommand("E", params, fitCenter);
        }

        duration = duration.substring(2);
        params.put("activity", activity);
        params.put("duration", duration);
        return new AddCommand("E", params, fitCenter);
    }

    private String[] getActivityAndDuration(String content) {
        return content.split("d/", 2);
    }

    private String parseType(String input) {
        boolean isTypeKeywordValid = input.startsWith("t/") && input.length() >= 3;
        if (!isTypeKeywordValid) {
            return "";
        }
        String type = "" + input.charAt(2);
        if (!CommandRecordType.isValidType(type)) {
            return "";
        }
        return type.toUpperCase(Locale.ROOT);
    }

    private String parseExerciseActivity(String activityRawInput, boolean isPrefixChecked) {
        boolean isActivityValid;
        if (isPrefixChecked) {
            isActivityValid = activityRawInput.length() > 0;
            if (!isActivityValid) {
                return "";
            }
            return activityRawInput;
        } else {
            isActivityValid = activityRawInput.length() >= 3 && activityRawInput.startsWith("a/");
            if (!isActivityValid) {
                return "";
            }
            return activityRawInput.substring(2);
        }
    }

    private String parseWeight(String bodyWeightRawInput, boolean prefixChecked) {
        boolean isBodyWeightValid;
        if (prefixChecked) {
            isBodyWeightValid = bodyWeightRawInput.length() > 0;
            if (!isBodyWeightValid) {
                return "";
            }
            return bodyWeightRawInput;
        } else {
            isBodyWeightValid = bodyWeightRawInput.length() >= 3 && bodyWeightRawInput.startsWith("w/");
            if (!isBodyWeightValid) {
                return "";
            }
            return bodyWeightRawInput.substring(2);
        }
    }

    private String parseDuration(String durationRawInput, boolean prefixChecked) {
        boolean isDurationValid;
        if (prefixChecked) {
            isDurationValid = durationRawInput.length() > 0;
            if (!isDurationValid) {
                return "";
            }
            return durationRawInput;
        } else {
            isDurationValid = durationRawInput.length() >= 3 && durationRawInput.startsWith("d/");
            if (!isDurationValid) {
                return "";
            }
            return durationRawInput.substring(2);
        }
    }

    private String parseDiet(String dietRawInput, boolean prefixChecked) {
        boolean isDietValid;
        if (prefixChecked) {
            isDietValid = dietRawInput.length() > 0;
            if (!isDietValid) {
                return "";
            }
            return dietRawInput;
        } else {
            isDietValid = dietRawInput.length() >= 3 && dietRawInput.startsWith("f/");
            if (!isDietValid) {
                return "";
            }
            return dietRawInput.substring(2);
        }
    }

    public void clearParserParams() {
        params.clear();
    }

}
