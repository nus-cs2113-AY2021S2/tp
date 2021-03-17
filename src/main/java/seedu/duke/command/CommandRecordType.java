package seedu.duke.command;

import java.util.Locale;

public enum CommandRecordType {
    EXERCISE("E"), DIET("D"), SLEEP("S"), BODY_WEIGHT("W");
    private String recordType;
    CommandRecordType(String type) {
        recordType = type;
    }

    public static boolean isValidType(String type) {
        boolean isValid = false;
        for (int i = 0; i < CommandRecordType.values().length; i++) {
            if (type.toUpperCase(Locale.ROOT).equals(CommandRecordType.values()[i].recordType)) {
                isValid = true;
                break;
            }
        }
        return isValid;
    }
}
