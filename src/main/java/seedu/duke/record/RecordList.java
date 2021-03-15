package seedu.duke.record;

import seedu.duke.common.Messages;
import seedu.duke.record.comparator.RecordDateComparator;
import seedu.duke.ui.UI;

import java.time.LocalDate;
import java.util.ArrayList;

public class RecordList {
    private final ArrayList<Record> records = new ArrayList<>();
    private RecordType type;

    public RecordList(RecordType type) {
        this.type = type;
    }

    public void addRecord(Record newRecord) {
        records.add(newRecord);
        records.sort(new RecordDateComparator());
    }

    public void removeRecord(int index) {
        records.remove(index);
    }

    public void printRecords() {
        if (records.isEmpty()) {
            UI.printMessage(Messages.MESSAGE_NO_RECORD
                    + Messages.MESSAGE_SEE_HELP);
        } else {
            UI.printDivider();
            for (Record record : records) {
                System.out.println(record.getRecordSummary());
            }
            UI.printDivider();
        }
    }

    public void printRecords(LocalDate date) {
        if (records.isEmpty()) {
            UI.printMessage(Messages.MESSAGE_NO_RECORD
                    + Messages.MESSAGE_SEE_HELP);
        } else {
            UI.printDivider();
            for (Record record : records) {
                if (record.getDate().isEqual(date)) {
                    System.out.println(record.getRecordSummary());
                }
            }
            UI.printDivider();
        }
    }
}
