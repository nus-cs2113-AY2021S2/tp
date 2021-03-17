package seedu.duke.commandparser;

import seedu.duke.command.AddCommand;
import seedu.duke.command.ViewCommand;
import seedu.duke.command.Command;
import seedu.duke.command.InvalidCommand;
import seedu.duke.command.CommandRecordType;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Locale;

import static seedu.duke.command.CommandType.ADD;
import static seedu.duke.command.CommandType.VIEW;
import static seedu.duke.command.CommandRecordType.EXERCISE;
import static seedu.duke.command.CommandRecordType.DIET;
import static seedu.duke.command.CommandRecordType.SLEEP;
import static seedu.duke.command.CommandRecordType.BODY_WEIGHT;

public class CommandParser {
    private final HashMap<String, String> params;

    public CommandParser() {
        params = new HashMap<>();
    }

    //public Command parseCommand(String userInput) {
    public void parseCommand(String userInput) {
        String[] inputParts = userInput.trim().split("\\s+", 2);
        String commandWord = inputParts[0];
        switch (commandWord) {
        case "add":
            prepareAdd(inputParts);
            //return prepareAdd(inputParts);
            break;
        case "view":
            prepareView(inputParts);
            break;
        //    return prepareView(inputParts);
        case "delete":
            //return prepareDelete(inputParts);
            break;
        //   return prepareDelete();
        default:
            //return new InvalidCommand();
            System.out.println("Invalid");
            break;
        }
    }
    /*
    private void prepareDelete(String[] inputParts) {
        if (inputParts.length < 2) {
            //return new InvalidCommand();
            System.out.println("invalid");
            return;
        }
        String recordType = parseType(inputParts[1]);
        if (recordType.equals("")) {
            System.out.println("invalid");
            return;
        }
        String[] typeIndex = inputParts[1].split("\\s+",2);
        if (typeIndex.length < 2) {
            System.out.println("Invalid");
            return;
        }
        String index = typeIndex[1];
        boolean isIndexValid = index.startsWith("i/") && index.length() >= 3;
        if (!isIndexValid) {
            System.out.println("Invalid");
            return;
        }
        index = index.substring(2);
        System.out.println(index);
    }
     */

    private Command prepareView(String[] inputParts) {
        try {
            if (inputParts.length < 2) {
                return new InvalidCommand(VIEW);
            }
            String recordType = parseType(inputParts[1]);
            if (recordType.equals("")) {
                return new InvalidCommand(VIEW);
            }
            String typeContent = inputParts[1];
            String optionalParams = getOptionalParamsForView(typeContent);
            switch (recordType) {
            case "E":
                if (!optionalParams.equals("")) {
                    return prepareViewExercise(optionalParams);
                }
                return new ViewCommand(EXERCISE);
            case "W":
                if (!optionalParams.equals("")) {
                    return prepareViewBodyWeight(optionalParams);
                }
                return new ViewCommand(BODY_WEIGHT);
            case "D":
                if (!optionalParams.equals("")) {
                    return prepareViewDiet(optionalParams);
                }
                return new ViewCommand(DIET);
            case "S":
                if (!optionalParams.equals("")) {
                    return prepareViewSleep(optionalParams);
                }
                return new ViewCommand(SLEEP);
            default:
                return new InvalidCommand(VIEW);
            }
        } catch (ParseException e) {
            return new InvalidCommand("The date format is incorrect");
        }
    }

    private String getOptionalParamsForView(String typeContent) {
        String[] rawInput = typeContent.split("\\s+", 2);
        if (rawInput.length == 1) {
            return "";
        } else {
            return rawInput[1].trim();
        }
    }

    private boolean checkDateValid(String dateString) {
        if (dateString.startsWith("date/") && dateString.length() > 5) {
            return true;
        } else {
            return false;
        }
    }

    private Command prepareViewExercise(String optionalParams) throws ParseException {
        String activity;
        String date;
        boolean hasActivity = optionalParams.contains("a/");
        boolean hasDate = optionalParams.contains("date/");
        if (!hasActivity && !hasDate) {
            return new InvalidCommand(VIEW);
        }
        if (hasActivity) {
            activity = parseExerciseActivity(optionalParams,false);
            if (activity.equals("")) {
                return new InvalidCommand(VIEW);
            }
            if (!hasDate) {
                params.put("activity", activity);
                return new ViewCommand(EXERCISE, params);
            }
            String[] activityDate = getDate(activity);
            if (activityDate.length == 0) {
                return new InvalidCommand(VIEW);
            }
            activity = activityDate[0];
            date = activityDate[1];
            params.put("activity", activity);
            params.put("date", date);
            return new ViewCommand(EXERCISE, params);
        }
        if (!checkDateValid(optionalParams)) {
            return new InvalidCommand(VIEW);
        }
        date = optionalParams.substring(5);
        params.put("date", date);
        return new ViewCommand(EXERCISE, params);
    }

    private Command prepareViewDiet(String optionalParams) throws ParseException {
        String food;
        String date;
        boolean hasFood = optionalParams.contains("f/");
        boolean hasDate = optionalParams.contains("date/");
        if (!hasFood && !hasDate) {
            return new InvalidCommand(VIEW);
        }
        if (hasFood) {
            food = parseDiet(optionalParams,false);
            if (food.equals("")) {
                //System.out.println("Invalid");
                return new InvalidCommand(VIEW);
            }
            if (!hasDate) {
                //System.out.println(activity);
                params.put("food", food);
                //return;
                return new ViewCommand(DIET, params);
            }
            String[] foodDate = getDate(food);
            if (foodDate.length == 0) {
                return new InvalidCommand(VIEW);
                //System.out.println("Invalid");
                //return;
            }
            food = foodDate[0];
            date = foodDate[1];
            params.put("food", food);
            params.put("date", date);
            return new ViewCommand(DIET, params);
        }
        if (!checkDateValid(optionalParams)) {
            return new InvalidCommand(VIEW);
        }
        date = optionalParams.substring(5);
        params.put("date", date);
        return new ViewCommand(DIET, params);
    }


    private Command prepareViewSleep(String optionalParmas) throws ParseException {
        if (!checkDateValid(optionalParmas)) {
            return new InvalidCommand(VIEW);
        }
        String date = optionalParmas.substring(5);
        params.put("date", date);
        return new ViewCommand(SLEEP, params);
    }

    private Command prepareViewBodyWeight(String optionalParmas) throws ParseException {
        if (!checkDateValid(optionalParmas)) {
            return new InvalidCommand(VIEW);
        }
        String date = optionalParmas.substring(5);
        params.put("date", date);
        return new ViewCommand(BODY_WEIGHT, params);
    }

    //private Command prepareAdd(String[] inputParts) {
    private void prepareAdd(String[] inputParts) {
        try {
            if (inputParts.length < 2) {
                //return new InvalidCommand(ADD);
                //System.out.println("Invalid");
                InvalidCommand invalidCommand = new InvalidCommand(ADD);
                return;
            }
            String recordType = parseType(inputParts[1]);
            if (recordType.equals("")) {
                //System.out.println("Invalid");
                //return new InvalidCommand(ADD);
                InvalidCommand invalidCommand = new InvalidCommand(ADD);
                return;
            }
            String[] typeContent = inputParts[1].split("\\s+", 2);
            if (typeContent.length < 2) {
                //return new InvalidCommand(ADD);
                //System.out.println("Invalid");
                //return;
                InvalidCommand invalidCommand = new InvalidCommand(ADD);
                return;
            }
            String content = typeContent[1];
            switch (recordType) {
            case "E":
                prepareAddExercise(content.trim());
                return;
            //    return prepareAddExercise(content.trim());
            //prepareAddExercise(content.trim());
            //break;
            case "W":
                prepareAddBodyWeight(content.trim());
                return;
            //    return prepareAddBodyWeight(content.trim());
            //prepareAddBodyWeight(content.trim());
            //break;
            case "D":
                //return prepareAddDiet(content.trim());
                prepareAddDiet(content.trim());
                break;
            case "S":
                prepareAddSleep(content.trim());
                return;
            //    return prepareAddSleep(content.trim());
            //prepareAddSleep(content.trim());
            //break;
            default:
                //return new InvalidCommand("The command word is invalid. Enter help to see help messages\n");
                System.out.println("Invalid");
                break;
            }
        } catch (ParseException e) {
            //return new InvalidCommand("The date format is incorrect");
            //System.out.println("Invalid");
            InvalidCommand invalidCommand = new InvalidCommand("The date format is incorrect");
            return;
        }

    }

    //private Command prepareAddSleep(String content) throws ParseException {
    private void prepareAddSleep(String content) throws ParseException {
        String durationRawInput = content.trim();
        String duration = parseDuration(durationRawInput,false);
        if (duration.equals("")) {
            InvalidCommand invalidCommand = new InvalidCommand(ADD);
            return;
            //return new InvalidCommand(ADD);
            //System.out.println("Invalid");
            //return;
        }
        boolean hasDate = content.contains("date/");
        String date = "";
        if (hasDate) {
            String[] durationDate = getDate(duration);
            if (durationDate.length == 0) {
                InvalidCommand invalidCommand = new InvalidCommand(ADD);
                return;
                //return new InvalidCommand(ADD);
                //System.out.println("Invalid");
                //return;
            }
            duration = durationDate[0];
            date = durationDate[1];
            params.put("duration", duration);
            params.put("date", date);
            //return new AddCommand("S", params);
            AddCommand addCommand = new AddCommand("S", params);
            return;
        }
        params.put("duration", duration);
        AddCommand addCommand = new AddCommand("S", params);
        return;
        //return new AddCommand("S", params);
        //for (int i = 0; i < params.size(); i++) {
        //    System.out.println(params.get(i));
        //}
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

    //private Command prepareAddDiet(String content) throws ParseException {
    private void prepareAddDiet(String content) throws ParseException {
        String[] foodWeight = content.split("w/",2);
        if (foodWeight.length < 2) {
            //return new InvalidCommand(ADD);
            //System.out.println("Invalid");
            //return;
            InvalidCommand invalidCommand = new InvalidCommand(ADD);
            return;
        }
        String foodRawInput = foodWeight[0].trim();
        String weightRawInput = foodWeight[1].trim();
        String food = parseDiet(foodRawInput,false);
        if (food.equals("")) {
            //return new InvalidCommand(ADD);
            //System.out.println("Invalid");
            //return;
            InvalidCommand invalidCommand = new InvalidCommand(ADD);
            return;
        }
        String weight = parseWeight(weightRawInput,true);
        if (weight.equals("")) {
            //return new InvalidCommand(ADD);
            //System.out.println("Invalid");
            //return;
            InvalidCommand invalidCommand = new InvalidCommand(ADD);
            return;
        }
        boolean hasDate = weightRawInput.contains("date/");
        String date = "";
        if (hasDate) {
            String[] weightDate = getDate(weight);
            if (weightDate.length == 0) {
                //return new InvalidCommand(ADD);
                //System.out.println("Invalid");
                //return;
                InvalidCommand invalidCommand = new InvalidCommand(ADD);
                return;
            }
            weight = weightDate[0];
            date = weightDate[1];
            params.put("food", food);
            params.put("weight", weight);
            params.put("date", date);
            //return new AddCommand("D", params);
            Command addCommand = new AddCommand("D", params);
            return;
        }
        params.put("food", food);
        params.put("weight", weight);
        //return new AddCommand("D", params);
        Command addCommand = new AddCommand("D", params);
        return;
        //for (int i = 0; i < params.size(); i++) {
        //    System.out.println(params.get(i));
        //}
    }

    //private Command prepareAddBodyWeight(String content) throws ParseException {
    private void prepareAddBodyWeight(String content) throws ParseException {
        String weightRawInput = content.trim();
        String weight = parseWeight(weightRawInput,false);
        if (weight.equals("")) {
            //return new InvalidCommand(ADD);
            //System.out.println("Invalid");
            //return;
            InvalidCommand invalidCommand = new InvalidCommand(ADD);
            return;
        }
        boolean hasDate = content.contains("date/");
        String date = "";
        if (hasDate) {
            String[] weightDate = getDate(weight);
            if (weightDate.length == 0) {
                //return new InvalidCommand(ADD);
                //System.out.println("Invalid");
                //return;
                InvalidCommand invalidCommand = new InvalidCommand(ADD);
                return;
            }
            weight = weightDate[0];
            date = weightDate[1];
            params.put("weight",weight);
            params.put("date",date);
            //return new AddCommand("W", params);
            AddCommand addCommand = new AddCommand("W", params);
            return;
        }
        params.put("weight",weight);
        AddCommand addCommand = new AddCommand("W", params);
        return;
        //return new AddCommand("W", params);
        //for (int i = 0; i < params.size(); i++) {
        //    System.out.println(params.get(i));
        //}
    }

    //private Command prepareAddExercise(String content) throws ParseException {
    private void prepareAddExercise(String content) throws ParseException {
        String[] activityDuration = content.split("d/",2);
        if (activityDuration.length < 2) {
            InvalidCommand invalidCommand = new InvalidCommand(ADD);
            return;
            //return new InvalidCommand(ADD);
            //System.out.println("Invalid");
            //return;
        }
        String activityRawInput = activityDuration[0].trim();
        String activity = parseExerciseActivity(activityRawInput,false);
        if (activity.equals("")) {
            InvalidCommand invalidCommand = new InvalidCommand(ADD);
            return;
            //return new InvalidCommand(ADD);
            //System.out.println("Invalid");
            //return;
        }
        String durationRawInput = activityDuration[1].trim();
        String duration = parseDuration(durationRawInput,true);
        if (duration.equals("")) {
            InvalidCommand invalidCommand = new InvalidCommand(ADD);
            return;
            //return new InvalidCommand(ADD);
            //System.out.println("Invalid");
            //return;
        }
        boolean hasDate = durationRawInput.contains("date/");
        String date = "";
        if (hasDate) {
            String[] durationDate = getDate(duration);
            if (durationDate.length == 0) {
                InvalidCommand invalidCommand = new InvalidCommand(ADD);
                return;
                //return new InvalidCommand(ADD);
                //System.out.println("Invalid");
                //return;
            }
            duration = durationDate[0];
            date = durationDate[1];
            params.put("activity", activity);
            params.put("duration", duration);
            params.put("date", date);
            //return new AddCommand("E", params);
            AddCommand addCommand = new AddCommand("E", params);
            return;
        }
        //duration = duration.substring(2,duration.length());
        params.put("activity", activity);
        params.put("duration", duration);
        AddCommand addCommand = new AddCommand("E", params);
        return;
        //return new AddCommand("E", params);
        //for (int i = 0; i < params.size(); i++) {
        //    System.out.println(params.get(i));
        //}
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

    private String parseExerciseActivity(String activityRawInput, boolean prefixChecked) {
        boolean isActivityValid;
        if (prefixChecked) {
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
        boolean isBosyWeightValid;
        if (prefixChecked) {
            isBosyWeightValid = bodyWeightRawInput.length() > 0;
            if (!isBosyWeightValid) {
                return "";
            }
            return bodyWeightRawInput;
        } else {
            isBosyWeightValid = bodyWeightRawInput.length() >= 3 && bodyWeightRawInput.startsWith("w/");
            if (!isBosyWeightValid) {
                return "";
            }
            return bodyWeightRawInput.substring(2);
        }
    }

    private String parseDuration(String durationRawInput,boolean prefixChecked) {
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

    private String parseDiet(String dietRawInput,boolean prefixChecked) {
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
