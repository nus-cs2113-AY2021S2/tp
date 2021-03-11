package seedu.duke;

public class PatientCommandInstance {

    private Ui ui;
    private PatientList patients;
    private Storage storage;
    static final String PATIENT_FILE_PATH = "data/PatientList.txt";

    public PatientCommandInstance(String filepath) {
        ui = new Ui();
        storage = new Storage(PATIENT_FILE_PATH);
        try {
            patients = new PatientList(storage.loadPatients());
        } catch (DukeException e) {
            ui.showLoadingError();
            //creates new task list if failure to load from folder.
            patients = new PatientList();
        }
    }

    public void patientInstance() {
        ui.patientCommandWelcome();
        boolean isReturnToStartMenu = false;
        while (!isReturnToStartMenu) {
            try {
                String fullCommand = ui.scanInput();
                ui.showLine(); // show the divider line ("_______")
                isReturnToStartMenu = Parser.patientParse(fullCommand);
                if (isReturnToStartMenu) {
                    ui.returningToStartMenuMessage();
                }
                ui.showLine();
            } catch (NullPointerException e) {
                //Command C can return as null if an error is triggered in parser
                //Null Pointer Exception may hence occur, the catch statement is to ensure it does not exit the loop.
            }
        }
        storage.storePatients(patients);
    }

}
