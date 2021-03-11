package seedu.duke.common;

import org.apache.commons.lang3.StringUtils;

public class Validators {

    public static void validateIndex() {

    }

    public static boolean validateDate(String inputToCheck) {
        if (inputToCheck.contains("dummy")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validateAmount(String inputToCheck) {
        return StringUtils.isNumeric(inputToCheck);
    }
}
