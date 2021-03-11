package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.record.Expense;
import seedu.duke.record.RecordList;
import seedu.duke.record.Saving;
import seedu.duke.record.Loan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.duke.common.Validators.validateDate;

public class RecordListTest {
    @Test
    public void addRecord_expenseLoanSavingObjs_success() {
        RecordList records = new RecordList();
        records.addRecord(new Expense(220.50, validateDate("2020/01/01"), "electric bills"));
        records.addRecord(new Loan(100, validateDate("2020/01/01"), "loan to bob"));
        records.addRecord(new Saving(20, validateDate("2020/01/01"), "red packet"));
        assertEquals(3, records.getRecordCount());
        assertEquals("List expenses!", records.getRecordAt(0).toString());
        assertEquals("List loans!", records.getRecordAt(1).toString());
        assertEquals("List savings!", records.getRecordAt(2).toString());
    }

    @Test
    public void deleteRecordAt_indexOfAddedRecordToDelete_success() {
        RecordList records = new RecordList();
        records.addRecord(new Expense(220.50, validateDate("2020/01/01"), "electric bills"));
        records.addRecord(new Loan(100, validateDate("2020/01/01"), "loan to bob"));
        records.addRecord(new Saving(20, validateDate("2020/01/01"), "red packet"));
        records.deleteRecordAt(1);
        assertEquals(2, records.getRecordCount());
        assertEquals("List expenses!", records.getRecordAt(0).toString());
        assertEquals("List savings!", records.getRecordAt(1).toString());
    }

    @Test
    public void deleteAllRecords_noTestInputs_success() {
        RecordList records = new RecordList();
        records.addRecord(new Expense(220.50, validateDate("2020/01/01"), "electric bills"));
        records.addRecord(new Loan(100, validateDate("2020/01/01"), "loan to bob"));
        records.addRecord(new Saving(20, validateDate("2020/01/01"), "red packet"));
        records.deleteAllRecords();
        assertTrue(records.isEmpty());
        assertEquals(0, records.getRecordCount());
    }
}
