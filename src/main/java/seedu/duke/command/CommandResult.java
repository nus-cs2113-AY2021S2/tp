package seedu.duke.command;

public class CommandResult {
    private String feedback;
    //private RecordList relevantRecords;

    public CommandResult(String feedback) {
        this.feedback = feedback;
    }
    /*
    public CommandResult(String feedback, RecordList relevantRecords) {
        this.feedback = feedback;
        this.relevantRecords = relevantRecords;
    }

     */

    public String getFeedback() {
        return feedback;
    }
    /*
    public RecordList getRelevantRecords(){
        return relevantRecords;
    }

     */
}
