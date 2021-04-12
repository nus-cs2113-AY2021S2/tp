package seedu.duke.command;

import seedu.duke.account.FitCenter;
import seedu.duke.common.Messages;
import seedu.duke.exception.ExceedTimeInOneDayException;
import seedu.duke.exception.FutureDateException;
import seedu.duke.exception.TypeException;
import seedu.duke.goal.timemanager.TimeController;
import seedu.duke.record.Record;
import seedu.duke.record.BodyWeight;
import seedu.duke.record.Diet;
import seedu.duke.record.Exercise;
import seedu.duke.record.Sleep;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;

import static seedu.duke.common.Messages.MESSAGE_EXCEED_24_HOURS_A_DAY;

/**
 * Represents a command of adding a new record to current record list.
 */
public class AddCommand extends Command {
    private static final String FEEDBACK_FORMAT = "A new %s record is added successfully!\nRecord summary:\n%s";
    private final Record record;
    private final CommandRecordType recordType;

    public AddCommand(CommandRecordType recordType, HashMap<String, String> params)
            throws ParseException, TypeException, NumberFormatException, FutureDateException {
        SimpleDateFormat spf = new SimpleDateFormat("dd-MM-yyyy");
        this.recordType = recordType;
        spf.setLenient(false);
        String dateString = params.get("date");
        LocalDate recordDate;
        if (dateString != null) {
            Date date = spf.parse(dateString);
            recordDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (recordDate.isAfter(LocalDate.now())) {
                throw new FutureDateException();
            }
        } else {
            recordDate = LocalDate.now();
        }
        switch (recordType) {
        case EXERCISE:
            record = new Exercise(params.get("activity"), params.get("duration"), recordDate);
            break;
        case DIET:
            record = new Diet(params.get("food"), params.get("weight"), recordDate);
            break;
        case SLEEP:
            record = new Sleep(params.get("duration"), recordDate);
            break;
        case BODY_WEIGHT:
            record = new BodyWeight(params.get("weight"), recordDate);
            break;
        default:
            record = null;
        }
    }

    /**
     * Adds the new record to record list.
     *
     * @param fitCenter the fitCenter interface for current user.
     * @return the feedback message of execution.
     */
    public CommandResult execute(FitCenter fitCenter) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate currentDate = LocalDate.now();
        int currentWeekOfYear = TimeController.getSystemWeekOfYear();
        try {
            if (record != null) {
                fitCenter.addRecordToList(recordType, record);
                fitCenter.updateProgressAtAdding(record, currentDate, currentWeekOfYear);
                feedback = String.format(FEEDBACK_FORMAT, record.getType(), record.getRecordSummary());
            } else {
                feedback = Messages.MESSAGE_CANT_ADD_RECORD;
            }
        } catch (ExceedTimeInOneDayException e) {
            feedback = String.format(MESSAGE_EXCEED_24_HOURS_A_DAY, record.getDate().format(dateFormatter));
        }
        return new CommandResult(feedback);
    }
}
