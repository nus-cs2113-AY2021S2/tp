package seedu.model.nurseschedule;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static seedu.ui.UI.prettyPrint;

public class NurseSchedule implements Comparable<NurseSchedule> {
    protected String nurseID;
    protected String patientID;
    protected String date;

    public NurseSchedule(String nurseID, String patientID, String date) {
        this.nurseID = nurseID;
        this.patientID = patientID;
        this.date = date;
    }

    /**
     * Compares as Date object.
     */
    @Override
    public int compareTo(NurseSchedule o) {
        if (getDate() == null || o.getDate() == null) {
            return 0;
        }
        SimpleDateFormat parser = new SimpleDateFormat("ddMMyyyy");
        Date date = null;
        Date odate = null;
        try {
            date = parser.parse(getDate());
            odate = parser.parse(o.getDate());
        } catch (ParseException e) {
            e.getMessage();
            return 1;
        }
        return date.compareTo(odate);
    }

    /**
     * Formats String date into dd/MM/YYYY.
     */
    public String formatDate(String input) throws ParseException {
        SimpleDateFormat parser = new SimpleDateFormat("ddMMyyyy");
        Date date = parser.parse(input);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyy");

        return formatter.format(date);
    }

    /**
     * returns Nurse ID.
     *
     * @return nurseID
     */
    public String getNurseID() {
        return nurseID;
    }

    /**
     * returns patient ID.
     *
     * @return patientID
     */
    public String getPatientID() {
        return patientID;
    }

    /**
     * returns date of schedule.
     *
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * returns formatted date.
     *
     * @return date
     */
    public String getFormattedDate() {
        String date = null;
        try {
            date = formatDate(this.date);
        } catch (ParseException e) {
            e.getMessage();
        }
        return date;
    }

    /**
     * returns format of data to be written into nurseschedule.txt.
     *
     * @return string of data
     */
    public String toSave() {
        return getNurseID() + "|" + getPatientID() + "|" + getDate();
    }

    /**
     * returns format of data to be displayed when listing.
     *
     * @return string of data
     */
    public String toFind() {
        //return getFormattedDate() + " " + patientID;
        return prettyPrint(patientID, 10) + " | " + prettyPrint(getFormattedDate(), 10);
    }

    /**
     * returns string of data.
     *
     * @return string of data
     */
    public String toString() {
        return nurseID + " " + patientID + " " + getFormattedDate();
    }
}
