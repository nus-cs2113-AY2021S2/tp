package seedu.duke.email;

import java.util.ArrayList;

public class Draft extends Email {
    public Draft(String from, ArrayList<String> to, String subject, String time, String content, boolean isRead) {
        super(from, to, subject, time, content, isRead);
    }

    @Override
    public String getShortDescription() {
        return "[Draft]" + super.getShortDescription();
    }
}
