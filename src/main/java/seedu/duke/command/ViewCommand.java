package seedu.duke.command;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;

public class ViewCommand extends Command {
    private static final String FEEDBACK_FORMAT = "Displaying all %s exercise records %s:";
    private SimpleDateFormat spf = new SimpleDateFormat("dd-MM-yyyy");
    private CommandRecordType recordType;
    private HashMap<String, String> specifiedParams;

    public ViewCommand(CommandRecordType type) {
        recordType = type;
    }

    public ViewCommand(CommandRecordType type, HashMap<String, String> params) throws ParseException {
        recordType = type;
        String dateString = params.get("date");
        LocalDate localDate;
        if (dateString != null) {
            spf.setLenient(false);
            Date date = spf.parse(dateString); //just for format checking
        }
        specifiedParams = params;
    }

    public CommandResult execute() {
        //fitCenter.addRecordToList(record);
        //feedback = String.format(FEEDBACK_FORMAT, record.getType(), record.getRecordSummary());
        return new CommandResult(feedback);
    }
}