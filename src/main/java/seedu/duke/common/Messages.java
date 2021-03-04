package seedu.duke.common;

public class Messages {

    //Main
    public static final String MESSAGE_WELCOME = "";
    public static final String MESSAGE_EXIT = "";


    //Storage
    public static final String FILE_INSTRUCTIONS = " Data File\n\n"
            + "Note for editing:\n"
            + "Please follow the format strictly when adding/editing/removing lessons or tasks.\n"
            + "Do not edit anything above the line, as well as the line.\n"
            + "Please do not use '\\n' in any of the entries.\n"
            + "Please do not use '|' except for separating fields.\n\n"
            + "Choose 1 of the 3 formats for lessons:\n"
            + "1) lesson | <type> | <Day & Time>\n"
            + "2) lesson | <type> | <Day & Time> | <Link>\n"
            + "3) lesson | <type> | <Day & Time> | <Link> | <Teaching Staff Name> | <Teaching Staff Email>\n\n"
            + "Type: \"lecture\", \"tutorial\" or \"lab\".\n"
            + "Day & time: When the lesson occurs.\n"
            + "Link: Online meeting link for the lesson.\n"
            + "Teaching staff name: Name of teaching staff for the lesson.\n"
            + "Teaching staff email: Email of teaching staff for the lesson.\n\n"
            + "Choose 1 of the 2 formats for tasks:\n"
            + "1) task | <description> | <deadline> | <is done> | <is graded>\n"
            + "2) task | <description> | <deadline> | <is done> | <is graded> | <remarks>\n\n"
            + "Description: Name/description of the task.\n"
            + "Deadline: In the format DD-MM-YYYY.\n"
            + "Is done: 'T' for true and 'F' for false.\n"
            + "Is graded: 'T' for true and 'F' for false.\n"
            + "Remarks: Additional information for task.\n\n"
            + "--------------------------------------------------------------------------------\n\n";


}
