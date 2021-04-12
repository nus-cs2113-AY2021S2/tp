package seedu.duke.command;

/**
 * Represents the supported types of records.
 */
public enum CommandRecordType {
    EXERCISE("E"), DIET("D"), SLEEP("S"), BODY_WEIGHT("W"), INVALID("I");
    private String recordType;
    CommandRecordType(String type) {
        recordType = type;
    }

    /**
     * Gets the type name.
     *
     * @param typeString the string of acronym.
     * @return the type name.
     */
    public static CommandRecordType getType(String typeString) {
        for (int i = 0; i < CommandRecordType.values().length; i++) {
            if (typeString.equals(CommandRecordType.values()[i].recordType)) {
                return CommandRecordType.values()[i];
            }
        }
        return INVALID;
    }
}
