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


    public AppointmentList(ArrayList<DoctorAppointment> loadAppointments) {
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

    public static void listAppointment(String input) throws HealthVaultException, EmptyListException, ParseException {

        String indicator = "A";
        String doctorID;
        String[] inputArray = input.split("");
        String Id = inputArray[0];
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
            } else if (Id.equals("A")) {
                DoctorAppointmentUI.appointmentPrintList(indicator);
                UI.showLine();
                for (DoctorAppointment doc : appointmentList) {
                    if (doc.getAppointmentId().equals(input)) {
                        DoctorAppointmentUI.printList(doc, indicator);
                    }
                }
            } else if (Id.equals("D")) {
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
    /*private static void getDoctorAppointmentByID(List<DoctorAppointment> doctorAppointments, String id) {
        int i = 0;
        while (i < doctorAppointments.size()) {
            if (doctorAppointments.get(i).getDoctorId().equals(id)) {
                extraList.add(doctorAppointments.get(i));
            }
            i++;
        }
        try {
            Collections.sort(extraList);
            System.out.println(prettyPrint(id, 10) + " | " + extraList.get(0).toFind());
        } catch (Exception ignored) {}
    }
    private static void printSchedules(List<DoctorAppointment> list) {
        int i = 1;
        while (i < list.size()) {
            NurseScheduleUI.printEmptyCell();
            System.out.println(list.get(i).toFind());
            i++;
        }
    }
    private static boolean isDoctorDone(List<DoctorAppointment> doctorAppointments, int i) {
        if (doctorFound.contains(doctorAppointments.get(i).getDoctorId())) {
            return true;
        } else {
            doctorFound.add(doctorAppointments.get(i).getDoctorId());
            return false;
        }
    }*/

    public static void deleteAppointment(String inputID) throws IOException {
        String[] Id = inputID.split("");

        if (Id[0].equals("A")) {
            for (int i = 0; i < appointmentList.size(); i++) {
                if (appointmentList.get(i).getAppointmentId().equals(inputID)) {
                    DoctorAppointmentUI.deletedAptID(appointmentList.get(i).getAppointmentId());
                    appointmentList.remove(i);
                    DoctorAppointmentStorage.writeToFile(appointmentList);
                }
            }
        } else if (Id[0].equals("D")) {
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
