package seedu.duke.storage;

import seedu.duke.account.FitCenter;
import seedu.duke.account.User;
import seedu.duke.exception.TypeException;

import seedu.duke.goal.timemanager.TimeController;
import seedu.duke.record.Diet;
import seedu.duke.record.Record;
import seedu.duke.record.Exercise;
import seedu.duke.record.Sleep;
import seedu.duke.record.BodyWeight;
import seedu.duke.goal.DietGoal;
import seedu.duke.goal.ExerciseGoal;
import seedu.duke.goal.BodyWeightGoal;
import seedu.duke.goal.SleepGoal;
import seedu.duke.goal.Goal;
import seedu.duke.goal.PeriodType;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

import static seedu.duke.command.CommandRecordType.EXERCISE;
import static seedu.duke.command.CommandRecordType.DIET;
import static seedu.duke.command.CommandRecordType.BODY_WEIGHT;
import static seedu.duke.command.CommandRecordType.SLEEP;
import static seedu.duke.goal.PeriodType.WEEKLY;
import static seedu.duke.goal.PeriodType.DAILY;

/**
 * Reads information from text file and converts to usable objects.
 */
public class FileInfoReader {
    private File recordSource;
    private File goalSource;
    private File timeSource;
    /**
     * A separator symbol.
     */
    public static final String SEPARATOR = " \\| ";
    /**
     * Date format for Singapore region.
     */
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    /**
     * Initializes the file reader for goals & records.
     *
     * @param recordFile the file that stores user records.
     * @param goalFile   the file that stores user goals.
     */
    public FileInfoReader(File recordFile, File goalFile) {
        recordSource = recordFile;
        goalSource = goalFile;
    }

    /**
     * Initializes the file reader for app time info.
     *
     * @param timeFile the file that stores app time info.
     */
    public FileInfoReader(File timeFile) {
        timeSource = timeFile;
    }

    /**
     * Parses the time info into usable format from text file.
     *
     * @return a String array that contains time info of date and week of year.
     * @throws FileNotFoundException when the file path or file cannot be found.
     */
    public String[] parseTimeStrParams() throws FileNotFoundException {
        Scanner sc = new Scanner(timeSource);
        String timeStr = null;
        while (sc.hasNext()) {
            timeStr = sc.nextLine();
        }
        if (timeStr == null) {
            return null;
        }
        return timeStr.split(SEPARATOR);
    }

    /**
     * Parses the records in text into a list of records in a usable format.
     *
     * @param user the current user.
     * @throws FileNotFoundException when the file path or file cannot be found.
     * @throws TypeException         when the type of food/workout is invalid for diet/exercise records.
     * @throws NumberFormatException when the number format is not consistent with the format expected.
     * @throws ParseException        when the file path or file cannot be found.
     */
    public void parseToRecordList(User user) throws FileNotFoundException, TypeException, NumberFormatException,
            ParseException {
        Scanner sc = new Scanner(recordSource);
        while (sc.hasNext()) {
            String currentLine = sc.nextLine();
            String[] typeContent = currentLine.split(SEPARATOR, 2);
            String content = typeContent[1];
            Record record;
            switch (typeContent[0]) {
            case "E":
                record = getExerciseRecord(content);
                user.getFitCenter().addRecordToList(EXERCISE, record);
                break;
            case "D":
                record = getDietRecord(content);
                user.getFitCenter().addRecordToList(DIET, record);
                break;
            case "W":
                record = getBodyWeightRecord(content);
                user.getFitCenter().addRecordToList(BODY_WEIGHT, record);
                break;
            case "S":
                record = getSleepRecord(content);
                user.getFitCenter().addRecordToList(SLEEP, record);
                break;
            default:
                System.out.println("Unable to recognize input format: " + currentLine);
                break;
            }
        }
    }

    /**
     * Parses the goals in text into a list of goals in a usable format.
     *
     * @param user the current user.
     * @throws FileNotFoundException when the file path or file cannot be found.
     * @throws TypeException         when the type of food/workout is invalid for diet/exercise records.
     * @throws NumberFormatException when the number format is not consistent with the format expected.
     * @throws ParseException        when the file path or file cannot be found.
     */
    public void parseToGoal(User user) throws FileNotFoundException, ParseException,
            TypeException, NumberFormatException {
        FitCenter fitCenter = user.getFitCenter();
        Scanner sc = new Scanner(goalSource);
        while (sc.hasNext()) {
            String currentLine = sc.nextLine();
            String[] typeContent = currentLine.split(SEPARATOR, 2);
            String content = typeContent[1];
            Goal goal;
            String[] params = getGoalParams(content);
            LocalDate setDay = getDate(params[0]);
            PeriodType periodType = getPeriodType(params[1]);
            double target = Double.parseDouble(params[2]);
            switch (typeContent[0]) {
            case "E":
                goal = new ExerciseGoal(periodType, target, setDay);
                fitCenter.addGoalToList(EXERCISE, goal);
                break;
            case "D":
                goal = new DietGoal(periodType, target, setDay);
                fitCenter.addGoalToList(DIET, goal);
                break;
            case "W":
                goal = new BodyWeightGoal(periodType, target, setDay);
                fitCenter.addGoalToList(BODY_WEIGHT, goal);
                break;
            case "S":
                goal = new SleepGoal(periodType, target, setDay);
                fitCenter.addGoalToList(SLEEP, goal);
                break;
            default:
                System.out.println("Unable to recognize input format: " + currentLine);
                break;
            }
        }
        LocalDate currentDate = LocalDate.now();
        int currentWeekOfYear = TimeController.getSystemWeekOfYear();
        fitCenter.initProgressAtLoading(currentDate, currentWeekOfYear);
    }

    private Record getExerciseRecord(String content) throws ParseException, TypeException, NumberFormatException {
        String[] contentParts = content.split(SEPARATOR);
        String activity = contentParts[0].trim();
        String durationString = contentParts[1].trim();
        int duration = Integer.parseInt(durationString);
        LocalDate recordDate = getDate(contentParts[2]);
        return new Exercise(activity, duration, recordDate);
    }

    private Record getDietRecord(String content) throws ParseException, TypeException, NumberFormatException {
        String[] contentParts = content.split(SEPARATOR);
        String food = contentParts[0].trim();
        String amountString = contentParts[1].trim();
        double amount = Double.parseDouble(amountString);
        LocalDate recordDate = getDate(contentParts[2]);
        return new Diet(food, amount, recordDate);
    }

    private Record getBodyWeightRecord(String content) throws ParseException, NumberFormatException {
        String[] contentParts = content.split(SEPARATOR);
        String weightString = contentParts[0].trim();
        double weight = Double.parseDouble(weightString);
        LocalDate recordDate = getDate(contentParts[1]);
        return new BodyWeight(weight, recordDate);
    }

    private Record getSleepRecord(String content) throws ParseException, NumberFormatException {
        String[] contentParts = content.split(SEPARATOR);
        String durationString = contentParts[0].trim();
        double duration = Double.parseDouble(durationString);
        LocalDate recordDate = getDate(contentParts[1]);
        return new Sleep(duration, recordDate);
    }

    private String[] getGoalParams(String content) {
        String[] params = content.split(SEPARATOR);
        for (int i = 0; i < params.length; i++) {
            params[i] = params[i].trim();
        }
        return params;
    }

    private LocalDate getDate(String dateString) throws ParseException {
        Date date = DATE_FORMAT.parse(dateString);
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    private PeriodType getPeriodType(String type) throws TypeException {
        switch (type) {
        case "DAILY":
            return DAILY;
        case "WEEKLY":
            return WEEKLY;
        default:
            throw new TypeException("period type");
        }
    }
}