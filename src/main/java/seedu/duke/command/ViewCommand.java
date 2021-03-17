package seedu.duke.command;

import seedu.duke.account.FitCenter;
import seedu.duke.common.Messages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;

public class ViewCommand extends Command {
    private CommandRecordType recordType;
    private HashMap<String, String> specifiedParams = null;

    public ViewCommand(CommandRecordType type) {
        recordType = type;
    }

    public ViewCommand(CommandRecordType type, HashMap<String, String> params) throws ParseException {
        recordType = type;
        String dateString = params.get("date");
        if (dateString != null) {
            SimpleDateFormat spf = new SimpleDateFormat("dd-MM-yyyy");
            spf.setLenient(false);
            Date date = spf.parse(dateString); //just for format checking
        }
        specifiedParams = params;
    }

    private String getRecordsWithOptionalParam(FitCenter fitCenter, String optionalParam) {
        return fitCenter.getRecordListString(recordType, LocalDate.parse(specifiedParams.get("date")), optionalParam);
    }

    private String getRecordsWithoutOptionalParam(FitCenter fitCenter) {
        if (specifiedParams != null) {
            return fitCenter.getRecordListString(recordType, LocalDate.parse(specifiedParams.get("date")));
        } else {
            return fitCenter.getRecordListString(recordType);
        }
    }

    public CommandResult execute(FitCenter fitCenter) {
        switch (recordType) {
        case SLEEP:
            //FALL-THROUGH
        case BODY_WEIGHT:
            feedback = getRecordsWithoutOptionalParam(fitCenter);
            break;
        case EXERCISE:
            if (specifiedParams != null && specifiedParams.size() > 2) {
                feedback = getRecordsWithOptionalParam(fitCenter, specifiedParams.get("activity"));
            } else {
                feedback = getRecordsWithoutOptionalParam(fitCenter);
            }
            break;
        case DIET:
            if (specifiedParams != null && specifiedParams.size() > 2) {
                feedback = getRecordsWithOptionalParam(fitCenter, specifiedParams.get("food"));
            } else {
                feedback = getRecordsWithoutOptionalParam(fitCenter);
            }
            break;
        default:
            feedback = Messages.MESSAGE_CANT_VIEW_LIST;
        }
        return new CommandResult(feedback);
    }

}