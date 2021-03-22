package seedu.doctorappointments;


import seedu.duke.exceptions.EmptyListException;
import seedu.duke.storage.DoctorAppointmentStorage;
import seedu.duke.ui.DoctorAppointmentUI;

import java.io.IOException;
import java.util.ArrayList;

public class AppointmentActions {
    public static ArrayList<DoctorAppointment> appointmentList;
    protected static DoctorAppointmentStorage storage = new DoctorAppointmentStorage("data/DoctorAppointmentList.txt");

    public AppointmentActions(ArrayList<DoctorAppointment> loadAppointments) {
        appointmentList = loadAppointments;
    }

    public static void addAppointment(String input) throws IOException {
        String[] inputArray = input.split(" ");

        String iD = inputArray[1];
        String patientName = inputArray[2];
        String gender = inputArray[3];
        String date = inputArray[4];


        DoctorAppointment newAppointment = new DoctorAppointment(iD, patientName, gender, date);

        System.out.println("Appointment Added");
        appointmentList.add(newAppointment);
        storage.writeToFile(appointmentList);
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
