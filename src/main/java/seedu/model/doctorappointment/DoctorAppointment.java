package seedu.model.doctorappointment;

import seedu.model.nurseschedule.NurseSchedule;
import seedu.ui.DoctorAppointmentUI;

import javax.print.Doc;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import static seedu.ui.UI.prettyPrint;

public class DoctorAppointment implements Comparable<DoctorAppointment>{
    protected String doctorId;
    protected String appointmentID;
    protected String patientsName;
    protected String gender;
    protected String date;

    public DoctorAppointment(String doctorId, String appointmentID, String name, String gender, String date) {
        this.doctorId = doctorId;
        this.appointmentID = appointmentID;
        this.patientsName = name;
        this.gender = gender;
        this.date = date;
    }

    public String getAppointmentId() {
        return this.appointmentID;
    }

    public String getDoctorId() {
        return this.doctorId;
    }

    public String getPatientsName() {
        return this.patientsName;
    }

    public String getGender() {
        return this.gender;
    }

    public String getDate() {
        return this.date;
    }

    /*
        Date format = YYYY-MM-DD
    */
    public String getDateFormat(String inputDate) throws ParseException {
        SimpleDateFormat parser = new SimpleDateFormat("ddMMyyyy");
        Date date = parser.parse(inputDate);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyy");

        return formatter.format(date);
    }

    public String saveTask() {
        return doctorId + " | " + appointmentID + " | "+ patientsName + " | " + gender + " | " + date;
    }

    @Override
    public int compareTo(DoctorAppointment o) {
        int numDoctorId = Integer.parseInt(getDoctorId());
        int compareNumDoctorId = Integer.parseInt(o.getDoctorId());

        return Integer.compare(numDoctorId, compareNumDoctorId);
    }

    public String toFind() {
        //return getFormattedDatetime() + " " + patientID;
        return prettyPrint(doctorId, 10) + " | " + prettyPrint(appointmentID, 10);
    }
}