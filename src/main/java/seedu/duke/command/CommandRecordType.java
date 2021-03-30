package seedu.duke.command;

import java.util.Locale;

public enum CommandRecordType {
    EXERCISE("E"), DIET("D"), SLEEP("S"), BODY_WEIGHT("W"), INVALID("I");
    private String recordType;
    CommandRecordType(String type) {
        recordType = type;
    }

    public static CommandRecordType getType(String typeString) {
        for (int i = 0; i < CommandRecordType.values().length; i++) {
            if (typeString.equals(CommandRecordType.values()[i].recordType)) {
                return CommandRecordType.values()[i];
            }
        }
        return INVALID;
    }
}
