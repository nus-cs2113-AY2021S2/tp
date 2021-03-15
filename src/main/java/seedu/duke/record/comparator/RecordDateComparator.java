package seedu.duke.record.comparator;

import seedu.duke.record.Record;

import java.time.LocalDate;
import java.util.Comparator;

public class RecordDateComparator implements Comparator<Record> {
    @Override
    public int compare(Record record1, Record record2) {
        LocalDate date1 = record1.getDate();
        LocalDate date2 = record2.getDate();
        if (date1.isBefore(date2)) {
            return -1;
        } else if (date1.isAfter(date2)) {
            return 1;
        } else {
            return 0;
        }
    }
}
