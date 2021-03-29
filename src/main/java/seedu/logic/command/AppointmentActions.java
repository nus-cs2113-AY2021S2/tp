package seedu.logic.command;


import seedu.model.DoctorAppointment;
import seedu.exceptions.EmptyListException;
import seedu.model.object.staff.Staff;
import seedu.model.objectList.StaffList;
import seedu.storage.DoctorAppointmentStorage;
import seedu.ui.DoctorAppointmentUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.function.DoubleConsumer;

public class AppointmentActions {
    public static ArrayList<DoctorAppointment> appointmentList;
    public static ArrayList<Staff> doctorList;

    protected static DoctorAppointmentStorage storage = new DoctorAppointmentStorage("data/DoctorAppointmentList.txt");

    public AppointmentActions(ArrayList<DoctorAppointment> loadAppointments) {
        appointmentList = loadAppointments;
    }

    public static void addAppointment(String input) throws IOException {
        String[] inputArray = input.split(" ");

        String doctorID = inputArray[1];
        String appointmentID = inputArray[2];
        String patientName = inputArray[3];
        String gender = inputArray[4];
        String date = inputArray[5];

        boolean isRegister = false;
        doctorList = DoctorAppointmentStorage.loadDoctorFile();

        for (Staff id : doctorList) {

            if (id.getId().equals(doctorID)) {
                isRegister = true;
                DoctorAppointment newAppointment = new DoctorAppointment(doctorID, appointmentID, patientName, gender, date);

                DoctorAppointmentUI.printAddedAppointment();
                appointmentList.add(newAppointment);
                storage.writeToFile(appointmentList);
            }
            System.out.println(id.getId());
        }
        if (!isRegister) {
            DoctorAppointmentUI.printDoctorNotFound();
        }
    }

    public static void listAppointment(String input) throws Exception {
        String[] inputArray = input.split(" ");

        String iD = inputArray[1];
        if (appointmentList.size() == 0) throw new EmptyListException();
        else {
            for (DoctorAppointment doc : appointmentList) {
                if (doc.getDoctorId().equals(iD)) {
                    System.out.println("ID: " + doc.getDoctorId());
                    System.out.println("Patient's Name: " + doc.getPatientsName());
                    System.out.println("Gender: " + doc.getGender());
                    System.out.println("Date: " + doc.getDateFormat(doc.getDate()));
                }
            }
        }
    }

    public static void deleteAppointment(String input) throws IOException {
        String[] inputArray = input.split(" ");
        String iD = inputArray[1];
        int index = 999;
        int counter = 0;

        for (DoctorAppointment doc : appointmentList) {
            if (doc.getDoctorId().equals(iD)) {
                index = counter;
            }
        }
        storage.writeToFile(appointmentList);

        if (index == 999) System.out.println("ID number not found");
        else {
            System.out.println("iD: " + appointmentList.get(index).getDoctorId() + " has been deleted!");
            appointmentList.remove(index);
            storage.writeToFile(appointmentList);
        }

    }

    public static void helpAppointment() {
        DoctorAppointmentUI.doctorAppointmentHelp();
    }
}
