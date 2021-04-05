package seedu.duke.command;

import seedu.duke.Common;
import seedu.duke.Data;
import seedu.duke.Ui;
import seedu.duke.exception.InvalidInputException;
import seedu.duke.exception.StorageException;
import seedu.duke.model.Patient;

import java.util.HashMap;

public class AddCommand extends Command {

    /**
     * This is the constructor of the command. Arguments are passed to parent class.
     *
     * @param ui        Instance of Ui class, for UI input/output
     * @param data      Instance of Data class, for manipulating patient list and read/write miscellaneous config
     * @param arguments Arguments decomposed from the full command given by the user
     */
    public AddCommand(Ui ui, Data data, HashMap<String, String> arguments) {
        super(ui, data, arguments);
    }

    @Override
    public void execute() throws InvalidInputException, StorageException {

        String id = arguments.get("payload");
        id = id.toUpperCase();

        if (!Common.isValidID(id)) {
            throw new InvalidInputException(InvalidInputException.Type.INVALID_NRIC);
        } else if (data.getPatients().containsKey(id)) {
            throw new InvalidInputException(InvalidInputException.Type.PATIENT_EXISTED);
        }

        assert Common.isValidID(id) : "validID should be true";
        Patient patient = new Patient(id);
        data.setPatient(patient);
        data.saveFile();

        ui.printMessage("Patient " + id + " has been added!");
    }
}

