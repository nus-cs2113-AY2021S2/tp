package seedu.duke.common;

import org.junit.jupiter.api.Test;
import seedu.duke.exception.CustomException;

import java.time.DateTimeException;

import static org.junit.jupiter.api.Assertions.fail;
import static seedu.duke.common.Validators.validateAmount;
import static seedu.duke.common.Validators.validateDate;

class ValidatorsTest {

    // Not a proper JUnit test format, please do not follow.
    @Test
    void validateDate_properDateFormat_success() {
        String[] dateStrings = {
            "13122011", "13.1.2011", "13-1-2011", "13/1/2011",
            "2011.1.13", "2011-1-13", "2011/1/13"
        };
        try {
            for (String d : dateStrings) {
                validateDate(d);
            }
        } catch (DateTimeException e) {
            fail();
        }
    }

    // Not a proper JUnit test format, please do not follow.
    @Test
    void validateDate_improperDateFormat() {
        final int finalCount = 7;
        int counter = 0;
        String[] dateStrings = {
            "12345678", "13.13.2011", "13-13-2011", "13 13 2011",
            "2011 1 13", "2011-1/13", "2011/1.13"
        };
        for (String d : dateStrings) {
            try {
                validateDate(d);
            } catch (DateTimeException e) {
                counter++;
            }
        }
        if (finalCount != counter) {
            fail();
        }
    }

    @Test
    void validateAmount_properFormat_expectSuccess() {
        String[] arrayOfAmount = {"0.1", "1.0", "1", "987654321", "0.987654321"};
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
        String[] arrayOfAmount = {"0", "-1", "1num1word", "wordonly"};
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
