package seedu.logic.errorchecker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NurseScheduleChecker extends MainChecker {
    public boolean isValidDate(String datetime) {
        /* Check if date is 'null' */
        if (!datetime.trim().equals("")) {
            /*
             * Set preferred date format,
             * For example MM-dd-yyyy, MM.dd.yyyy,dd.MM.yyyy etc.*/
            SimpleDateFormat sdfrmt = new SimpleDateFormat("ddMMyyyy");
            sdfrmt.setLenient(false);
            /* Create Date object
             * parse the string into date
             */
            try {
                Date javaDate = sdfrmt.parse(datetime);
                //System.out.println(datetime + " is valid date format");
            }
            /* Date format is invalid */
            catch (ParseException e) {
                System.out.println(datetime + " is Invalid Date format");
                return false;
            }
        }
        /* Return true if date format is valid */
        return true;
    }

}
