package seedu.duke.command;

import seedu.duke.Constants;
import seedu.duke.Data;
import seedu.duke.Ui;
import seedu.duke.exception.InvalidInputException;
import seedu.duke.exception.StorageException;
import seedu.duke.model.Patient;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
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
    public void execute() throws InvalidInputException, StorageException {
        assert ui != null : "Ui must not be null";
        assert arguments.containsKey("payload") : "Arguments must contain a value for the `payload` key";
        Patient patient = data.currentPatient;
        if (patient == null) {
            throw new InvalidInputException(InvalidInputException.Type.NO_PATIENT_LOADED);
        }
        String dateString = arguments.get(Constants.PAYLOAD_KEY);
        LocalDate date = null;
        // TODO: More test cases to test out the "invalid dates"
        try {
            date = parseDate(dateString);
        } catch (DateTimeParseException e) {
            throw new InvalidInputException(InvalidInputException.Type.INVALID_DATE, e);
        }
        if (date.isAfter(LocalDate.now())) {
            // We don't allow a record to be inserted for a future date
            throw new InvalidInputException(InvalidInputException.Type.FUTURE_DATE);
        }
        addRecord(patient, date);
        data.saveFile();
        printNewRecord(patient);
    }

    private LocalDate parseDate(String dateString) throws DateTimeParseException {
        if (!dateString.isEmpty()) {
            return LocalDate.parse(
                dateString,
                DateTimeFormatter.ofPattern(Constants.DATE_PATTERN).withResolverStyle(ResolverStyle.STRICT)
            );
        }
        return LocalDate.now();
    }

    private void addRecord(Patient patient, LocalDate date) throws InvalidInputException {
        String symptom = null;
        String diagnosis = null;
        String prescription = null;
        boolean containsSymptom = arguments.containsKey(Constants.SYMPTOM_KEY);
        boolean containsDiagnosis = arguments.containsKey(Constants.DIAGNOSIS_KEY);
        boolean containsPrescription = arguments.containsKey(Constants.PRESCRIPTION_KEY);
        if (!containsSymptom && !containsDiagnosis && !containsPrescription) {
            throw new InvalidInputException(InvalidInputException.Type.EMPTY_DESCRIPTION);
        }
        if (containsSymptom) {
            symptom = arguments.get(Constants.SYMPTOM_KEY);
        }
        if (containsDiagnosis) {
            diagnosis = arguments.get(Constants.DIAGNOSIS_KEY);
        }
        if (containsPrescription) {
            prescription = arguments.get(Constants.PRESCRIPTION_KEY);
        }
        patient.addRecord(date, symptom, diagnosis, prescription);
    }

    private void printNewRecord(Patient patient) {
        ui.printMessage("Added new record to patient " + patient.getID() + ":");
        ui.printMessage(patient.recentlyAdded());
    }
}
