package seedu.duke.command;

import seedu.duke.Common;
import seedu.duke.Constants;
import seedu.duke.Data;
import seedu.duke.Ui;
import seedu.duke.exception.DataException;
import seedu.duke.exception.InvalidInputException;
import seedu.duke.exception.StorageException;
import seedu.duke.model.Patient;

import java.time.LocalDate;
import java.util.HashMap;

public class RecordCommand extends Command {

    /**
     * This is the constructor of the command. Arguments are passed to parent class.
     *
     * @param ui        Instance of Ui class, for UI input/output
     * @param data      Instance of Data class, for manipulating patient list and read/write miscellaneous config
     * @param arguments Arguments decomposed from the full command given by the user
     */
    public RecordCommand(Ui ui, Data data, HashMap<String, String> arguments) {
        super(ui, data, arguments);
    }

    @Override
    public void execute() throws InvalidInputException, DataException, StorageException {
        assert ui != null : "Ui must not be null";
        assert arguments.containsKey("payload") : "Arguments must contain a value for the `payload` key";
        String dateString = arguments.get(Constants.PAYLOAD_KEY);
        LocalDate date = Common.parseDate(dateString);
        String recentDetails = addRecord(date);
        ui.printMessage(recentDetails);
        data.saveFile();
    }

    private String addRecord(LocalDate date) throws DataException {
        String symptom = null;
        String diagnosis = null;
        String prescription = null;
        if (arguments.containsKey(Constants.SYMPTOM_KEY)) {
            symptom = arguments.get(Constants.SYMPTOM_KEY);
        }
        if (arguments.containsKey(Constants.DIAGNOSIS_KEY)) {
            diagnosis = arguments.get(Constants.DIAGNOSIS_KEY);
        }
        if (arguments.containsKey(Constants.PRESCRIPTION_KEY)) {
            prescription = arguments.get(Constants.PRESCRIPTION_KEY);
        }
        String recentDetails = data.addRecord(date, symptom, diagnosis, prescription);
        return recentDetails;
    }
}
