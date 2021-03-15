package seedu.duke.command;

import seedu.duke.record.Record;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class ViewCommand extends Command{
    private static final String FEEDBACK_FORMAT = "Displaying all %s exercise records %s:";
    private Record record;
    private SimpleDateFormat spf = new SimpleDateFormat("dd-MM-yyyy");

    public ViewCommand (String type, ArrayList<String> params) throws ParseException {
        switch (type) {
        }
    }

    public CommandResult execute() {
        //fitCenter.addRecordToList(record);
        feedback = String.format(FEEDBACK_FORMAT, record.getType(), record.getRecordSummary());
        return new CommandResult(feedback);
    }
}
