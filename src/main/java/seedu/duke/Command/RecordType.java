package seedu.duke.Command;

import java.util.Locale;

public enum RecordType {
    EXERCISE("E"), DIET("D"), SLEEP("S"), BODY_WEIGHT("W");
    private String recordType;
    private RecordType(String type){
        recordType = type;
    }

    public static boolean isValidType(String type){
        boolean isValid = false;
        for(int i=0; i<RecordType.values().length; i++){
            if(type.toUpperCase(Locale.ROOT).equals(RecordType.values()[i].recordType)){
                isValid = true;
                break;
            }
        }
        return isValid;
    }
}
