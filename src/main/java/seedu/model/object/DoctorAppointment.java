package seedu.model.object;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DoctorAppointment {
    protected String doctorId;
    protected String patientsName;
    protected String gender;
    protected String date;

    public DoctorAppointment(String doctorId, String name, String gender, String date) {
        this.doctorId = doctorId;
        this.patientsName = name;
        this.gender = gender;
        this.date = date;
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
        return doctorId + " | " + patientsName + " | " + gender + " | " + date;
    }


}
