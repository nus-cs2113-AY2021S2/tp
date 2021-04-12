package seedu.duke.email;

import java.util.ArrayList;

public class Sent extends Email {
    public Sent(String from, ArrayList<String> to, String subject, String time, String content, boolean isRead) {
        super(from, to, subject, time, content, isRead);
    }

    @Override
    public String getShortDescription() {
        return "[Sent]" + super.getShortDescription();
    }

}
