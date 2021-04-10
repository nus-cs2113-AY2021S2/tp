package seedu.model.doctorappointment;


import seedu.exceptions.HealthVaultException;
import seedu.exceptions.EmptyListException;
import seedu.storage.DoctorAppointmentStorage;
import seedu.ui.DoctorAppointmentUI;
import seedu.ui.UI;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class AppointmentList {
    public static ArrayList<DoctorAppointment> appointmentList;
    public static ArrayList<DoctorAppointment> extraList;
    private static ArrayList<String> doctorFound = new ArrayList<String>();

    /**
     * Constructor to initialise appointmentList with the loaded Appointments.
     *
     * @param loadAppointments the DoctorAppointments objects loaded from the storage file.
     */

    public AppointmentList(ArrayList<DoctorAppointment> loadAppointments) {
        appointmentList = loadAppointments;
    }

    /**
     * Add an appointment into the array list.
     *
     * @param inputArray the user input data to be added.
     * @throws IOException if writing to storage throws an error.
     */

    public static void addAppointment(String[] inputArray) throws IOException {

        String doctorID = inputArray[1];
        String appointmentID = inputArray[2];
        String patientName = inputArray[3];
        String gender = inputArray[4];
        String date = inputArray[5];

        DoctorAppointment newAppointment = new DoctorAppointment(doctorID, appointmentID, patientName, gender, date);

        DoctorAppointmentUI.printAddedAppointment();
        appointmentList.add(newAppointment);
        DoctorAppointmentStorage.writeToFile(appointmentList);
    }

    /**
     * Lists the appointments in the array list.
     *
     * @param input the key word use to distinguish the type of list.
     * @throws HealthVaultException if there are any errors.
     * @throws ParseException       if thee data parsed is incorrect.
     */
    public static void listAppointment(String input) throws HealthVaultException, EmptyListException, ParseException {

        String indicator = "A";
        String doctorID;
        String[] inputArray = input.split("");
        String iD = inputArray[0];
        if (appointmentList.size() == 0) {
            throw new EmptyListException();
        } else {
            if (input.equals("all")) {
                doctorFound.clear();
                indicator = "all";
                DoctorAppointmentUI.appointmentPrintList(indicator);
                UI.showLine();
                for (int i = 0; i < appointmentList.size(); i++) {
                    DoctorAppointmentUI.printList(appointmentList.get(i), indicator);

                    /*extraList.clear();
                    doctorID = appointmentList.get(i).getDoctorId();
                    if (!isDoctorDone(appointmentList, i)) {
                        getDoctorAppointmentByID(appointmentList, doctorID);
                        printSchedules(extraList);
                    }*/
                }
            } else if (iD.equals("A")) {
                DoctorAppointmentUI.appointmentPrintList(indicator);
                UI.showLine();
                for (DoctorAppointment doc : appointmentList) {
                    if (doc.getAppointmentId().equals(input)) {
                        DoctorAppointmentUI.printList(doc, indicator);
                    }
                }
            } else if (iD.equals("D")) {
                indicator = "D";
                DoctorAppointmentUI.appointmentPrintList(indicator);
                UI.showLine();
                DoctorAppointmentUI.printEmptyCell(input);
                int counter = 0;
                for (int i = 0; i < appointmentList.size(); i++) {
                    if (appointmentList.get(i).getDoctorId().equals(input)) {
                        if (counter != 0) {
                            DoctorAppointmentUI.printEmptyCell("");
                        }
                        DoctorAppointmentUI.printList(appointmentList.get(i), indicator);
                        counter++;
                    }
                }
            }
        }
    }
    /**
     * Deletes an appointment from the array list.
     *
     * @param inputID the Id to be deleted from the array list.
     * @throws IOException if writing to storage throws an error.
     */

    public static void deleteAppointment(String inputID) throws IOException {
        String[] iD = inputID.split("");

        if (iD[0].equals("A")) {
            for (int i = 0; i < appointmentList.size(); i++) {
                if (appointmentList.get(i).getAppointmentId().equals(inputID)) {
                    DoctorAppointmentUI.deletedAptID(appointmentList.get(i).getAppointmentId());
                    appointmentList.remove(i);
                    DoctorAppointmentStorage.writeToFile(appointmentList);
                }
            }
        } else if (iD[0].equals("D")) {
            for (int i = appointmentList.size() - 1; i >= 0; i--) {
                if (appointmentList.get(i).getDoctorId().equals(inputID)) {
                    DoctorAppointmentUI.deletedDocID(appointmentList.get(i).getDoctorId(),
                            appointmentList.get(i).getAppointmentId());
                    appointmentList.remove(i);
                    DoctorAppointmentStorage.writeToFile(appointmentList);
                }
            }
        }
    }

    public static void helpAppointment() {
        DoctorAppointmentUI.doctorAppointmentHelp();
    }
}
