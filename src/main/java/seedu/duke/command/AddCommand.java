package seedu.duke.command;

import seedu.duke.Constants;
import seedu.duke.Data;
import seedu.duke.Ui;
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
    public void execute() throws Exception {

        String patientID = arguments.get("payload");
        patientID = patientID.toUpperCase();
        int stringLength = patientID.length();
        boolean validID = true;

        // Checks if ID has 9 characters
        if (stringLength != 9) {
            validID = false;
        }
        // Checks if ID is valid
        for (int i = 0; i < stringLength; i++) {
            char c = patientID.charAt(i);
            if (i == 0) {
                // Checks if first value of ID is S,T,F or G
                if (c != 'S' && c != 'T' && c != 'F' && c != 'G') {
                    validID = false;
                }
            } else if (i == 8) {
                // Checks if last value of ID is a letter
                if (!Character.isLetter(c)) {
                    validID = false;
                }
            } else {
                // Checks if the rest of the values are digits
                if (!Character.isDigit(c)) {
                    validID = false;
                }
            }
        }

        if (!validID) {
            throw new Exception(Constants.EXCEPTION_ADD_INVALIDNRIC);
        } else if (data.getPatients().containsKey(patientID)) {
            throw new Exception(Constants.EXCEPTION_ADD_PATIENTEXISTS);
        }

        assert validID : "validID should be true";
        Patient patient = new Patient(patientID);
        data.setPatient(patient);

        ui.printMessage("Patient " + patientID + " has been added!");
    }
}
