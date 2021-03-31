package seedu.duke;

public class Constants {


    public static final String LINEBREAK = "____________________________________________________________";
    public static final String LONGLINEBREAK = "____________________________________________________"
            +"____________________________________________________________________";
    public static final String LOGO =
            " __   __  ______  _______  _  ________  __   __  __  __  _______  __   __  _             __   \n"
             + "|  | |  ||   ___||   _   || ||___    _||  | |  ||  ||  ||   _   ||  | |  || | _   _     /  \\  \n"
             + "|  |_|  ||  |___ |  |_|  || |    |  |  |  |_|  ||  ||  ||  |_|  ||  | |  || || |_| |___/ / \\\\ \n"
             + "|   _   ||   ___||   _   || |    ||=|  |   _   |\\  \\/  /|   _   ||  | |  || ||_________  | | |\n"
             + "|  | |  ||  |___ |  | |  || |___ ||=|  |  | |  | \\    / |  | |  ||  |_|  || |_____     \\ \\ // \n"
             + "|__| |__||______||__| |__||_____||__|  |__| |__|  \\__/  |__| |__||_______||_______|     \\__/  \n";


    public static final String PATIENT_FILE_PATH = "data/Patients.txt";
    public static final String APPOINTMENT_FILE_PATH = "data/DoctorAppointment.txt";
    public static final String INVENTORY_FILE_PATH = "data/Inventory.txt";
    public static final String STAFF_FILE_PATH = "data/Staff.txt";
    public static final String SCHEDULES_FILE_PATH = "data/NurseSchedule.txt";

    public static final String TO_STAFF_INSTANCE = "staff";
    public static final String TO_PATIENT_INSTANCE = "patient";
    public static final String TO_APPOINTMENTS_INSTANCE = "appointments";
    public static final String TO_SCHEDULES_INSTANCE = "schedules";
    public static final String TO_INVENTORY_INSTANCE = "inventory";

    public static final String TO_STAFF_INSTANCE_DESCRIPTION = "To go to staff";
    public static final String TO_PATIENT_INSTANCE_DESCRIPTION = "To go to patients";
    public static final String TO_APPOINTMENTS_INSTANCE_DESCRIPTION = "To go to doctors appointments";
    public static final String TO_SCHEDULES_INSTANCE_DESCRIPTION = "To go to nurse schedules";
    public static final String TO_INVENTORY_INSTANCE_DESCRIPTION = "To go to inventory";
    public static final String EXIT_COMMAND_DESCRIPTION = "To exit the application";
    public static final String HELP_COMMAND_DESCRIPTION = "To see what commands for Start Menu";

    public static final String EXIT_COMMAND = "exit";
    public static final String HELP_COMMAND = "help";
    public static final String ADD_COMMAND = "add";
    public static final String DELETE_COMMAND = "delete";
    public static final String FIND_COMMAND = "find";
    public static final String LIST_COMMAND = "list";
    public static final String RETURN_COMMAND = "return";

    //field Checking
    public static final String[] VALID_GENDER_INPUT = {"M", "F", "Others"};

    // Miscellaneous
    public static final String BLANK = "";
    public static final String MARK_BLANK = "-";
    public static final String RETURN_DESCRIPTION = "Returns you to the Start Menu!";

    // HELP HEADER
    public static final String HELP_HEADER_COMMAND = "Commands";
    public static final String HELP_HEADER_DESCRIPTION = "Description";
    public static final String HELP_HEADER_FORMAT = "Format";

    // HELP FUNCTION DESCRIPTION
    public static final String STAFF_HELP_DESCRIPTION = "Brings up the list of commands for Staff!";
    public static final String PATIENT_HELP_DESCRIPTION = "Brings up the list of commands for Patient!";
    public static final String APPOINTMENTS_HELP_DESCRIPTION =
            "Brings up the list of commands for Doctor Appointments!";
    public static final String SCHEDULES_HELP_DESCRIPTION = "Brings up the list of commands for Nurse Schedule!";
    public static final String INVENTORY_HELP_DESCRIPTION = "Brings up the list of commands for Inventory!";


    // ADD FUNCTION DESCRIPTION
    public static final String STAFF_ADD_DESCRIPTION = "Adds Staff details to the Staff database!";
    public static final String PATIENT_ADD_DESCRIPTION = "Adds Patient details to the Patient database!";
    public static final String APPOINTMENTS_ADD_DESCRIPTION = "Adds Doctor Appointment details to the database!";
    public static final String SCHEDULES_ADD_DESCRIPTION = "Adds Nurse Schedule details to the database!";
    public static final String INVENTORY_ADD_DESCRIPTION = "Adds Inventory details to the database!";

    // ADD FUNCTION FORMATTING
    public static final String STAFF_ADD_FORMAT = "add/[Staff ID]/[Name]/[Age]/[Specialisation]";
    public static final String PATIENT_ADD_FORMAT = "add/[Patient ID]/[Name]/[Age]/[Gender][Illness][Medication Needed]";
    public static final String APPOINTMENTS_ADD_FORMAT = "";
    public static final String SCHEDULES_ADD_FORMAT = "add/[Nurse ID]/[Patient ID]/[Date (DDMMYYYY)]";
    public static final String INVENTORY_ADD_FORMAT = "add/[Drug name]/[Price]/[Quantity]";


    // LIST FUNCTION DESCRIPTION
    public static final String STAFF_LIST_DESCRIPTION = "Brings up the list of all current Staff in database!";
    public static final String PATIENT_LIST_DESCRIPTION = "Brings up the list of all current Patient in database!";
    public static final String APPOINTMENTS_LIST_DESCRIPTION =
            "Brings up the list of all current Doctor Appointments in database!";
    public static final String SCHEDULES_LIST_DESCRIPTION = "Brings up the list of all current Nurse Schedules in database!";
    public static final String INVENTORY_LIST_DESCRIPTION = "Brings up the list of all current Inventory in database!";

    // LIST FUNCTION FORMATTING
    public static final String STAFF_LIST_FORMAT = "list/<input>, where input == doctor or nurse";
    public static final String APPOINTMENTS_LIST_FORMAT = "";
    public static final String SCHEDULES_LIST_FORMAT = "list/[NurseID/all]";
    public static final String INVENTORY_LIST_FORMAT = "list";


    // DELETE FUNCTION DESCRIPTION
    public static final String STAFF_DELETE_DESCRIPTION = "Deletes the Staff with the specified ID from the list!";
    public static final String PATIENT_DELETE_DESCRIPTION =
            "Deletes the Patient with the specified ID from the list!";
    public static final String APPOINTMENTS_DELETE_DESCRIPTION =
            "Deletes the Appointment with the specified ID from the list!";
    public static final String SCHEDULES_DELETE_DESCRIPTION = "Deletes the Schedule with the specified ID from the list!";
    public static final String INVENTORY_DELETE_DESCRIPTION = "Deletes the Inventory item from the list!";
    // DELETE FUNCTION FORMATTING
    public static final String STAFF_DELETE_FORMAT = "delete/[Staff ID]";
    public static final String PATIENT_DELETE_FORMAT = "delete/[Patient ID]";
    public static final String APPOINTMENTS_DELETE_FORMAT = "delete/[Appointment ID]";
    public static final String SCHEDULES_DELETE_FORMAT = "delete/[Nurse ID]/[Date (DDMMYYYY)]";
    public static final String INVENTORY_DELETE_FORMAT = "delete/[Drug Name]";


    // FIND FUNCTION DESCRIPTION
    public static final String STAFF_FIND_DESCRIPTION = "Finds a matching Staff using a keyword or phrase!";
    public static final String PATIENT_FIND_DESCRIPTION = "Finds a matching Patient using an ID!";

    // FIND FUNCTION FORMATTING
    public static final String STAFF_FIND_FORMAT = "find/[keyword or phrase]";
    public static final String PATIENT_FIND_FORMAT = "find/[Patient ID]";


}
