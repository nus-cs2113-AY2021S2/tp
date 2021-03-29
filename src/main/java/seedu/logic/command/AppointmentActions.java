package seedu.logic.command;


import seedu.model.DoctorAppointment;
import seedu.exceptions.EmptyListException;
import seedu.model.staff.Staff;
import seedu.storage.DoctorAppointmentStorage;
import seedu.ui.DoctorAppointmentUI;

import java.io.IOException;
import java.util.ArrayList;

public class AppointmentActions {
    public static ArrayList<DoctorAppointment> appointmentList;
    public static ArrayList<Staff> doctorList;

    protected static DoctorAppointmentStorage storage = new DoctorAppointmentStorage("data/DoctorAppointmentList.txt");

    public AppointmentActions(ArrayList<DoctorAppointment> loadAppointments) {
        appointmentList = loadAppointments;
    }

    public static void addAppointment(String[] inputArray) throws IOException {

        String doctorID = inputArray[1];
        String appointmentID = inputArray[2];
        String patientName = inputArray[3];
        String gender = inputArray[4];
        String date = inputArray[5];

        DoctorAppointment newAppointment = new DoctorAppointment(doctorID, appointmentID, patientName, gender, date);

        DoctorAppointmentUI.printAddedAppointment();
        appointmentList.add(newAppointment);
        storage.writeToFile(appointmentList);
    }

    public static void listAppointment(String[] inputArray) throws Exception {

        String indicator = "A"; //if doesnt work can change to boolean
        String iD = inputArray[1];
        if (appointmentList.size() == 0) throw new EmptyListException();
        else {
            if (iD.equals("A")) {
                for (DoctorAppointment doc : appointmentList) {
                    if (doc.getAppointmentId().equals(iD)) {
                        DoctorAppointmentUI.printList(doc, indicator);
                    }
                }
            } else {
                indicator = "D";
                for (DoctorAppointment doc : appointmentList) {
                    if (doc.getDoctorId().equals(iD)) {
                        DoctorAppointmentUI.printList(doc,indicator);
                    }
                }
            }
        }
    }

    public static void deleteAppointment(String[] inputArray) throws IOException {
        String iD = inputArray[1];
        int index = 999;
        int counter = 0;
        boolean isAorD = false;

        for (DoctorAppointment doc : appointmentList) {
            if (iD.equals("A")) {
                isAorD = true;
                if (doc.getAppointmentId().equals(iD)) {
                    index = counter;
                }
            }
            if (iD.equals("D")){
                if (doc.getDoctorId().equals(iD)) {
                    index = counter;
                }
            }
        }
        if (index == 999) DoctorAppointmentUI.printIDNotFound();
        else {
            if (isAorD) DoctorAppointmentUI.deletedID(appointmentList.get(index).getAppointmentId());
            else DoctorAppointmentUI.deletedID(appointmentList.get(index).getDoctorId());

            appointmentList.remove(index);
            storage.writeToFile(appointmentList);
        }

    }

    public static void helpAppointment() {
        DoctorAppointmentUI.doctorAppointmentHelp();
    }
}
