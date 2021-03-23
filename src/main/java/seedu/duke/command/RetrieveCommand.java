package seedu.duke.command;

import seedu.duke.Constants;
import seedu.duke.Data;
import seedu.duke.Ui;
import seedu.duke.model.Patient;
import seedu.duke.model.Record;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RetrieveCommand extends Command {
    /**
     * This is the constructor of the command. Arguments are passed to parent class.
     *
     * @param ui        Instance of Ui class, for UI input/output
     * @param data      Instance of Data class, for manipulating patient list and read/write miscellaneous config
     * @param arguments Arguments decomposed from the full command given by the user
     */
    public RetrieveCommand(Ui ui, Data data, HashMap<String, String> arguments) {
        super(ui, data, arguments);
    }

    @Override
    public void execute() throws Exception {
        assert ui != null : "Ui must not be null";
        // TODO: Implement proper exception
        Patient patient = data.currentPatient;
        if (patient == null) {
            throw new Exception(Constants.EXCEPTION_RECORD_RETRIEVE_NULLPATIENT);
        }
        TreeMap<LocalDate, Record> records = patient.getRecords();
        ui.printMessage("Here are " + patient.getID() + "'s records:");
        for(Map.Entry<LocalDate, Record> entry : records.entrySet()) {
            LocalDate date = entry.getKey();
            Record record = entry.getValue();
            ui.printMessage(date.toString() + ":");
            ui.printMessage(record.toString());
        }
    }
}
