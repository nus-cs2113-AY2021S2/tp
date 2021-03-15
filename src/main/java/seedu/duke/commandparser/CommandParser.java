package seedu.duke.commandparser;

import seedu.duke.command.RecordType;

import java.util.ArrayList;
import java.util.Locale;

public class CommandParser {
    public CommandParser() {
    }

    //public Command parseCommand(String userInput) {
    public void parseCommand(String userInput) {
        String[] inputParts = userInput.trim().split("\\s+", 2);
        String commandWord = inputParts[0];
        switch (commandWord) {
        case "add":
            //return prepareAdd(inputParts);
            prepareAdd(inputParts);
            break;
        case "view":
            prepareView(inputParts);
            break;
        //    return prepareView(inputParts);
        //case "delete":
        //   return prepareDelete();
        default:
            //return new InvalidCommand();
            System.out.println("Invalid");
            break;
        }
    }

    //private Command prepareView(String[] inputParts) {
    private void prepareView(String[] inputParts) {
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
        String typeContent = inputParts[1];
        switch (recordType) {
        case "E":
            //return prepareExercise(content.trim());
            prepareViewExercise(typeContent.trim());
            return;
            /*
        case "W":
            return prepareAddBodyWeight(content.trim());
        case "D":
            return prepareAddDiet(content.trim());
        case "S":
            return prepareAddSleep(content.trim());

             */
        default:
            //return new InvalidCommand();
            System.out.println("Invalid");
        }
    }

    private void prepareViewExercise(String typeContent) {
        if (typeContent.length() == 3) {
            System.out.println("print all exercise records");
            return;
        }
        String rawInput = typeContent.split("\\s+", 2)[1];
        String activity = "";
        String date = "";
        boolean hasActivity = typeContent.contains("a/");
        boolean hasDate = typeContent.contains("date");
        if (!hasActivity && !hasDate) {
            System.out.println("Invalid");
            return;
        }
        if (hasActivity) {
            activity = parseExerciseActivity(rawInput,false);
            if (activity.equals("")) {
                System.out.println("Invalid");
                return;
            }
        }
        if (hasDate) {
            String[] activityDate = getDate(activity);
            if (activityDate.length == 0) {
                //return new InvalidCommand();
                System.out.println("Invalid");
                return;
            }
            activity = activityDate[0];
            date = activityDate[1];
        }
        ArrayList<String> params = new ArrayList<>();
        System.out.println(activity);
        System.out.println(date);
    }

    private void prepareViewSleep(String typeContent) {
        if (typeContent.length() == 3) {
            System.out.println("print all sleep records");
            return;
        }
        String rawInput = typeContent.split("\\s+", 2)[1];
        String activity = "";
        String date = "";
        boolean hasActivity = typeContent.contains("a/");
        boolean hasDate = typeContent.contains("date");
        if (!hasActivity && !hasDate) {
            System.out.println("Invalid");
            return;
        }
        if (hasActivity) {
            activity = parseExerciseActivity(rawInput,false);
            if (activity.equals("")) {
                System.out.println("Invalid");
                return;
            }
        }
        if (hasDate) {
            String[] activityDate = getDate(activity);
            if (activityDate.length == 0) {
                //return new InvalidCommand();
                System.out.println("Invalid");
                return;
            }
            activity = activityDate[0];
            date = activityDate[1];
        }
        ArrayList<String> params = new ArrayList<>();
        System.out.println(activity);
        System.out.println(date);
    }


    //private Command prepareAdd(String[] inputParts) {
    private void prepareAdd(String[] inputParts) {
        if (inputParts.length < 2) {
            //return new InvalidCommand();
            System.out.println("Invalid");
            return;
        }
        String recordType = parseType(inputParts[1]);
        if (recordType.equals("")) {
            System.out.println("Invalid");
            return;
        }
        String[] typeContent = inputParts[1].split("\\s+", 2);
        if (typeContent.length < 2) {
            //return new InvalidCommand();
            System.out.println("Invalid");
            return;
        }
        String content = typeContent[1];
        switch (recordType) {
        case "E":
            //return prepareAddExercise(content.trim());
            prepareAddExercise(content.trim());
            break;
        case "W":
            //return prepareAddBodyWeight(content.trim());
            prepareAddBodyWeight(content.trim());
            break;
        case "D":
            //return prepareAddDiet(content.trim());
            prepareAddDiet(content.trim());
            break;
        case "S":
            //return prepareAddSleep(content.trim());
            prepareAddSleep(content.trim());
            break;
        default:
            //return new InvalidCommand();
            System.out.println("Invalid");
            break;
        }
        /**
         try {
         String recordType = parseType(inputParts[1]);
         String[] typeContent = inputParts[1].split("\\s+", 2);
         if (typeContent.length < 2) {
         return new InvalidCommand();
         }
         String content = typeContent[1];
         switch (recordType) {
         case "E":
         return prepareAddExercise(content.trim());
         case "W":
         return prepareAddBodyWeight(content.trim());
         case "D":
         return prepareAddDiet(content.trim());
         case "S":
         return prepareAddSleep(content.trim());
         }
         } catch (FormatException e) {
         return new InvalidCommand();
         }
         */
    }

    //private Command prepareAddSleep(String content) {
    private void prepareAddSleep(String content) {
        /*
        boolean isDurationValid = content.startsWith("d/") && content.length() >= 3;
        if (!isDurationValid) {
            return new InvalidCommand();
        }
        String duration = content.substring(2,content.length());

         */
        String durationRawInput = content.trim();
        String duration = parseDuration(durationRawInput,false);
        if (duration.equals("")) {
            //return new InvalidCommand();
            System.out.println("Invalid");
            return;
        }
        boolean hasDate = content.contains("date/");
        String date = "";
        if (hasDate) {
            String[] durationDate = getDate(duration);
            if (durationDate.length == 0) {
                //return new InvalidCommand();
                System.out.println("Invalid");
                return;
            }
            duration = durationDate[0];
            date = durationDate[1];
        }
        ArrayList<String> params = new ArrayList<>();
        params.add(duration);
        params.add(date);
        //return new AddCommand("S", params);
        for (int i = 0; i < params.size(); i++) {
            System.out.println(params.get(i));
        }
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

    //private Command prepareAddDiet(String content) {
    private void prepareAddDiet(String content) {
        String[] foodWeight = content.split("w/",2);
        if (foodWeight.length < 2) {
            //return new InvalidCommand();
            System.out.println("Invalid");
            return;
        }
        String foodRawInput = foodWeight[0].trim();
        String weightRawInput = foodWeight[1].trim();
        /*
        boolean isFoodValid = foodRawInput.length() >= 3 && foodRawInput.startsWith("f/");
        boolean isWeightValid = weightRawInput.length() >= 3 && weightRawInput.startsWith("d/");
        if (!isFoodValid || !isWeightValid) {
            return new InvalidCommand();
        }
        String food = foodRawInput.substring(2, foodRawInput.length());
        String weight = weightRawInput.substring(2, weightRawInput.length());

         */
        String food = parseDiet(foodRawInput,false);
        if (food.equals("")) {
            //return new InvalidCommand();
            System.out.println("Invalid");
            return;
        }
        String weight = parseWeight(weightRawInput,true);
        if (weight.equals("")) {
            //return new InvalidCommand();
            System.out.println("Invalid");
            return;
        }
        boolean hasDate = weightRawInput.contains("date/");
        String date = "";
        if (hasDate) {
            String[] weightDate = getDate(weight);
            if (weightDate.length == 0) {
                //return new InvalidCommand();
                System.out.println("Invalid");
                return;
            }
            weight = weightDate[0];
            date = weightDate[1];
        }
        ArrayList<String> params = new ArrayList<>();
        params.add(food);
        params.add(weight);
        params.add(date);
        //return new AddCommand("D", params);
        for (int i = 0; i < params.size(); i++) {
            System.out.println(params.get(i));
        }
    }

    //private Command prepareAddBodyWeight(String content) {
    private void prepareAddBodyWeight(String content) {
        /*
        boolean isWeightValid = content.startsWith("w/") && content.length() >= 3;
        if (!isWeightValid) {
            return new InvalidCommand();
        }
        String weight = content.substring(2,content.length());

         */
        String weightRawInput = content.trim();
        String weight = parseWeight(weightRawInput,false);
        if (weight.equals("")) {
            //return new InvalidCommand();
            System.out.println("Invalid");
            return;
        }
        boolean hasDate = content.contains("date/");
        String date = "";
        if (hasDate) {
            String[] weightDate = getDate(weight);
            if (weightDate.length == 0) {
                //return new InvalidCommand();
                System.out.println("Invalid");
                return;
            }
            weight = weightDate[0];
            date = weightDate[1];
        }
        ArrayList<String> params = new ArrayList<>();
        params.add(weight);
        params.add(date);
        //return new AddCommand("W", params);
        for (int i = 0; i < params.size(); i++) {
            System.out.println(params.get(i));
        }
    }

    //private Command prepareAddExercise(String content) {
    private void prepareAddExercise(String content) {
        String[] activityDuration = content.split("d/",2);
        if (activityDuration.length < 2) {
            //return new InvalidCommand();
            System.out.println("Invalid");
            return;
        }
        String activityRawInput = activityDuration[0].trim();
        String activity = parseExerciseActivity(activityRawInput,false);
        if (activity.equals("")) {
            //return new InvalidCommand();
            System.out.println("Invalid");
            return;
        }
        String durationRawInput = activityDuration[1].trim();
        String duration = parseDuration(durationRawInput,true);
        if (duration.equals("")) {
            //return new InvalidCommand();
            System.out.println("Invalid");
            return;
        }
        boolean hasDate = durationRawInput.contains("date/");
        String date = "";
        if (hasDate) {
            String[] durationDate = getDate(duration);
            if (durationDate.length == 0) {
                //return new InvalidCommand();
                System.out.println("Invalid");
                return;
            }
            duration = durationDate[0];
            date = durationDate[1];
        }
        //duration = duration.substring(2,duration.length());
        ArrayList<String> params = new ArrayList<>();
        params.add(activity);
        params.add(duration);
        params.add(date);
        //return new AddCommand("E", params);
        for (int i = 0; i < params.size(); i++) {
            System.out.println(params.get(i));
        }
    }

    private String parseType(String input) {
        boolean isTypeKeywordValid = input.startsWith("t/") && input.length() >= 3;
        if (!isTypeKeywordValid) {
            return "";
        }
        String type = "" + input.charAt(2);
        if (!RecordType.isValidType(type)) {
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
            return activityRawInput.substring(2,activityRawInput.length());
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
            return bodyWeightRawInput.substring(2, bodyWeightRawInput.length());
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
            return durationRawInput.substring(2,durationRawInput.length());
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
            return dietRawInput.substring(2,dietRawInput.length());
        }
    }

    /**
    private String parseType(String input) throws FormatException{
        boolean isTypeKeywordValid = input.startsWith("t/") && input.length() > 3;
        if (!isTypeKeywordValid) {
            throw new FormatException("The type of record should be the first parameter" +
                    " and preceded by \"t\\\"");
        }
        String type = "" + input.charAt(2);
        if (!RecordType.isValidType(type)) {
            throw new FormatException("The type is not valid. We support types: E, D, W, S");
        }
        return type;
    }
 */
}
