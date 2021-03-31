package seedu.logic.command;


import seedu.model.DoctorAppointment;
import seedu.exceptions.EmptyListException;
import seedu.storage.DoctorAppointmentStorage;
import seedu.ui.DoctorAppointmentUI;
import seedu.ui.UI;

import java.io.IOException;
import java.util.ArrayList;

public class AppointmentActions {
    public static ArrayList<DoctorAppointment> appointmentList;

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
        DoctorAppointmentStorage.writeToFile(appointmentList);
    }

    public static void listAppointment(String input) throws Exception {

        String indicator = "A";
        String[] inputArray = input.split("");
        String iD = inputArray[0];
        if (appointmentList.size() == 0) throw new EmptyListException();
        else {
            if (iD.equals("A")) {
                DoctorAppointmentUI.AptPrintList(indicator);
                UI.showLine();
                for (DoctorAppointment doc : appointmentList) {
                    if (doc.getAppointmentId().equals(input)) {
                        DoctorAppointmentUI.printList(doc, indicator);
                    }
                }
            } else {
                indicator = "D";
                DoctorAppointmentUI.AptPrintList(indicator);
                UI.showLine();
                for (DoctorAppointment doc : appointmentList) {
                    if (doc.getDoctorId().equals(input)) {
                        DoctorAppointmentUI.printList(doc, indicator);
                    }
                }
            }
        }
    }

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
            for (int i = appointmentList.size()-1; i >=0; i--) {
                if (appointmentList.get(i).getDoctorId().equals(inputID)) {
                    DoctorAppointmentUI.deletedDocID(appointmentList.get(i).getDoctorId(), appointmentList.get(i).getAppointmentId());
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
