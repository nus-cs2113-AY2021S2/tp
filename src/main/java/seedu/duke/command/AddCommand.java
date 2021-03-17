package seedu.duke.command;

import seedu.duke.account.FitCenter;
import seedu.duke.record.Record;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

public class AddCommand extends Command {
    private static final String FEEDBACK_FORMAT = "A new %s record is added successfully!\nRecord summary:%s";
    private Record record;
    private CommandRecordType recordType;

    public AddCommand(String type, HashMap<String, String> params) throws ParseException {
        SimpleDateFormat spf = new SimpleDateFormat("dd-MM-yyyy");
        spf.setLenient(false);
        String dateString = params.get("date");
        LocalDate localDate;
        if (dateString != null) {
            Date date = spf.parse(dateString);
            localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        } else {
            localDate = LocalDate.now();
        }
        switch (type) {
        case "E":
            //record = new DietRecord(recordType.EXERCISE, params.get("activity"), params.get("duration"), localDate);
            recordType = CommandRecordType.EXERCISE;
            System.out.println(params.get("activity") + params.get("duration") + localDate.toString());
            break;
        case "D":
            //record = new DietRecord(recordType.DIET, params.get("food"), params.get("weight"), localDate);
            recordType = CommandRecordType.DIET;
            System.out.println(params.get("food") + params.get("weight") + localDate.toString());
            break;
        case "S":
            //record = new DietRecord(recordType.SLEEP, params.get("duration"), localDate);
            recordType = CommandRecordType.SLEEP;
            System.out.println(params.get("duration") + localDate.toString());
            break;
        case "W":
            //record = new DietRecord(recordType.BODYWEIGHT, params.get("weight"), localDate);
            recordType = CommandRecordType.BODY_WEIGHT;
            System.out.println(params.get("weight") + localDate.toString());
            break;
        default:
            System.out.println("There is something wrong within the system.");
        }
    }

    public CommandResult execute(FitCenter fitCenter) {
        fitCenter.addRecordToList(recordType, record);
        feedback = String.format(FEEDBACK_FORMAT, record.getType(), record.getRecordSummary());
        return new CommandResult(feedback);
    }
}
