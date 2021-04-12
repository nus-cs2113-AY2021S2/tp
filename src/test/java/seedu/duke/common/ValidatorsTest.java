package seedu.duke.common;

import org.junit.jupiter.api.Test;
import seedu.duke.exception.CustomException;

import java.time.DateTimeException;

import static org.junit.jupiter.api.Assertions.fail;
import static seedu.duke.common.Validators.validateAmount;
import static seedu.duke.common.Validators.validateDate;

class ValidatorsTest {

    @Test
    void validateDate_properDateFormat_success() {
        String[] dateStrings = {
            "13122011", "13.1.2011", "13-1-2011", "13/1/2011", "30120001",
            "2011.1.13", "2011-1-13", "2011/1/13", "2020.2.29", "today"
        };
        try {
            for (String d : dateStrings) {
                validateDate(d);
            }
        } catch (DateTimeException e) {
            fail();
        }
    }

    @Test
    void validateDate_improperDateFormat() {
        int counter = 0;
        String[] dateStrings = {
            "12345678", "13.13.2011", "13-13-2011", "13 13 2011", "30120000",
            "2011 1 13", "2011-1/13", "2011/1.13", "2020.2.30", "today123"
        };
        for (String d : dateStrings) {
            try {
                validateDate(d);
            } catch (DateTimeException e) {
                counter++;
            }
        }
        if (dateStrings.length != counter) {
            fail();
        }
    }

    @Test
    void validateAmount_properFormat_expectSuccess() {
        String[] arrayOfAmount = {"1", "1.0", "1.00", "0.1", "0.10", "987654321"};
        try {
            for (String testAmount : arrayOfAmount) {
                validateAmount(testAmount);
            }
        } catch (NumberFormatException | CustomException e) {
            fail();
        }
    }

    @Test
    void validateAmount_wrongFormat_expectFailure() {
        int numFailCase = 0;
        String[] arrayOfAmount = {"0", "-1", "1num1word", "wordonly", ".50", "5.", "5.123"};
        for (String testAmount : arrayOfAmount) {
            try {
                validateAmount(testAmount);
            } catch (NumberFormatException | CustomException e) {
                numFailCase++;
            }
        }
        if (arrayOfAmount.length != numFailCase) {
            fail();
        }
    }
}
