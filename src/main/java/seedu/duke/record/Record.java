package seedu.duke.record;

public abstract class Record {
    private double amount;
    private String issueDate;
    private String description;

    public Record(double amount, String issueDate, String description) {
        this.amount = amount;
        this.issueDate = issueDate;
        this.description = description;
    }

    public String convertFileFormat() {
        return "1";
    }
}
