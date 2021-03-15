package seedu.duke.command;

import seedu.duke.record.Record;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

//import static seedu.duke.record.RecordType;

public class AddCommand extends Command {
    private static final String FEEDBACK_FORMAT = "A new %s record is added successfully!\nRecord summary:%s";
    private Record record;
    private SimpleDateFormat spf = new SimpleDateFormat("dd-MM-yyyy");

    public AddCommand(String type, ArrayList<String> params) throws ParseException {
        switch (type) {
        case "E":
            if (params.size() == 3) {
                Date date = spf.parse(params.get(3));
                LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                //record = new DietRecord(recordType.EXERCISE, params.get(1), params.get(2), localDate);
                System.out.println(params.get(1) + params.get(2) + params.get(3));
            } else {
                //record = new DietRecord(recordType.params.get(1), params.get(2), LocalDate.now());
                System.out.println(params.get(1) + params.get(2));
            }
            break;
        case "D":
            if (params.size() == 3) {
                Date date = spf.parse(params.get(3));
                LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                //record = new DietRecord(recordType.DIET, params.get(1), params.get(2), localDate);
                System.out.println(params.get(1) + params.get(2) + params.get(3));
            } else {
                //record = new DietRecord(recordType.DIET, params.get(1), params.get(2), LocalDate.now());
                System.out.println(params.get(1) + params.get(2));
            }
            break;
        case "S":
            if (params.size() == 2) {
                Date date = spf.parse(params.get(2));
                LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                //record = new DietRecord(recordType.SLEEP, params.get(1), localDate);
                System.out.println(params.get(1) + params.get(2));
            } else {
                //record = new DietRecord(recordType.SLEEP, params.get(1), LocalDate.now());
                System.out.println(params.get(1));
            }
            break;
        case "W":
            if (params.size() == 2) {
                Date date = spf.parse(params.get(2));
                LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                //record = new DietRecord(recordType.BODYWEIGHT, params.get(1), localDate);
                System.out.println(params.get(1) + params.get(2));
            } else {
                //record = new DietRecord(RecordType.BODYWEIGHT, params.get(1), LocalDate.now());
                System.out.println(params.get(1));
            }
            break;
        default:
            System.out.println("There is something wrong within the system.");
        }
    }

    public CommandResult execute() {
        //fitCenter.addRecordToList(record);
        feedback = String.format(FEEDBACK_FORMAT, record.getType(), record.getRecordSummary());
        return new CommandResult(feedback);
    }
}
