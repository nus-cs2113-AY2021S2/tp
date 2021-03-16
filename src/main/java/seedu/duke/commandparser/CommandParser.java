package seedu.duke.commandparser;

import seedu.duke.command.AddCommand;
import seedu.duke.command.Command;
import seedu.duke.command.CommandRecordType;
import seedu.duke.command.InvalidCommand;
import seedu.duke.record.RecordType;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import static seedu.duke.command.CommandType.ADD;
import static seedu.duke.command.CommandType.VIEW;

public class CommandParser {
    private HashMap<String, String> params;

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
            /*
        case "view":
            return prepareView(inputParts);
            break;
        //    return prepareView(inputParts);
        case "delete":
            return prepareDelete(inputParts);
            break;
        //   return prepareDelete();

             */
        default:
            //return new InvalidCommand();
            System.out.println("Invalid");
            break;
        }
    }

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
    /*
    private Command prepareView(String[] inputParts) {
    //private void prepareView(String[] inputParts) {
        if (inputParts.length < 2) {
            return new InvalidCommand(VIEW);
            //System.out.println("invalid");
            //return;
        }
        String recordType = parseType(inputParts[1]);
        if (recordType.equals("")) {
            //System.out.println("invalid");
            //return;
            return new InvalidCommand(VIEW);
        }
        String typeContent = inputParts[1];
        switch (recordType) {
        case "E":
            //return prepareExercise(content.trim());
            return prepareViewExercise(typeContent.trim());
            //break;
        case "W":
            return prepareViewBodyWeight(typeContent.trim());
            //prepareViewBodyWeight(typeContent.trim());
            //break;
        case "D":
            return prepareViewDiet(typeContent.trim());
            //prepareViewDiet(typeContent.trim());
            //break;
        case "S":
            return prepareViewSleep(typeContent.trim());
            //prepareViewSleep(typeContent.trim());
            //break;
        default:
            return new InvalidCommand(VIEW);
            //System.out.println("Invalid");
            //break;
        }
    }

 */

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
        String activity = "";
        String date = "";
        boolean hasActivity = optionParams.contains("a/");
        boolean hasDate = optionParams.contains("date/");
        if (!hasActivity && !hasDate) {
            System.out.println("Invalid");
            return;
        }
        if (hasActivity) {
            activity = parseExerciseActivity(optionParams,false);
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
        String food = "";
        String date = "";
        boolean hasFood = optionalParams.contains("f/");
        boolean hasDate = optionalParams.contains("date/");
        if (!hasFood && !hasDate) {
            System.out.println("Invalid");
            return;
        }
        if (hasFood) {
            food = parseDiet(optionalParams,false);
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
