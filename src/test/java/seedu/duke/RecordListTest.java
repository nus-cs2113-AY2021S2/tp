package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.record.Expense;
import seedu.duke.record.RecordList;
import seedu.duke.record.Saving;
import seedu.duke.record.Loan;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.duke.common.Validators.validateDate;

public class RecordListTest {
    @Test
    public void addRecord_expenseLoanSavingObjs_success() {
        RecordList records = getPopulatedRecordList();
        assertEquals(3, records.getRecordCount(),
                "Failed test 'addRecord_expenseLoanSavingObjs_success', expected a record count of 3 but "
                        + "RecordList::getRecordCount() returned " + records.getRecordCount());
        assertEquals("[E][2020-01-01] electric bills ", records.getRecordAt(0).toString(),
                "Failed test 'addRecord_expenseLoanSavingObjs_success', wrong record object at index 0 of "
                        + "record list");
        assertEquals("[L][2020-01-01] loan to bob [ ]", records.getRecordAt(1).toString(),
                "Failed test 'addRecord_expenseLoanSavingObjs_success', wrong record object at index 1 of "
                        + "record list");
        assertEquals("[S][2020-01-01] red packet ", records.getRecordAt(2).toString(),
                "Failed test 'addRecord_expenseLoanSavingObjs_success', wrong record object at index 2 of "
                        + "record list");
    }

    @Test
    public void deleteRecordAt_indexOfAddedRecordToDelete_success() {
        RecordList records = getPopulatedRecordList();
        records.deleteRecordAt(1);
        assertEquals(2, records.getRecordCount(),
                "Failed test 'deleteRecordAt_indexOfAddedRecordToDelete_success', expected a record count of 2 but "
                        + "RecordList::getRecordCount() returned " + records.getRecordCount());
        assertEquals("[E][2020-01-01] electric bills ", records.getRecordAt(0).toString(),
                "Failed test 'deleteRecordAt_indexOfAddedRecordToDelete_success', wrong record object at index 0 of "
                        + "record list");
        assertEquals("[S][2020-01-01] red packet ", records.getRecordAt(1).toString(),
                "Failed test 'deleteRecordAt_indexOfAddedRecordToDelete_success', wrong record object at index 1 of "
                        + "record list");
    }

    @Test
    public void deleteAllRecords_noTestInputs_success() {
        RecordList records = getPopulatedRecordList();
        records.deleteAllRecords();
        assertTrue(records.isEmpty(), "Failed test 'deleteAllRecords_noTestInputs_success', expected an empty "
                + "record list but RecordList::isEmpty() returned false");
        assertEquals(0, records.getRecordCount(),
                "Failed test 'deleteAllRecords_noTestInputs_success', expected a record count of 0 but "
                        + "RecordList::getRecordCount() returned " + records.getRecordCount());
    }

    private RecordList getPopulatedRecordList() {
        RecordList records = new RecordList();
        records.addRecord(new Expense(new BigDecimal("220.50"), validateDate("2020/01/01"), "electric bills"));
        records.addRecord(new Loan(new BigDecimal("100"), validateDate("2020/01/01"), "loan to bob", "bob"));
        records.addRecord(new Saving(new BigDecimal("20"), validateDate("2020/01/01"), "red packet"));
        return records;
    }
}
