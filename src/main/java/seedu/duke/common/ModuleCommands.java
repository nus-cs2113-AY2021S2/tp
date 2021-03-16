package seedu.duke.common;

//@@author isaharon
public enum ModuleCommands implements CommandList {

    HELP("help", "Lists all commands available for the selected module."),
    CLOSE("close", "Closes the current module."),
    INFO("info", "Prints an overview of the current module."),
    ADD_LESSON("add lesson", "LESSON_NAME ;; [DAY_AND_TIME] ;; [LINK] ;; [STAFF_NAME] ;; [EMAIL]",
            "Adds a new lesson."),
    DELETE_LESSON("delete lesson", "Deletes lessons."),
    LINK("link", "Opens link to the lesson in a browser."),
    LESSONS("lessons", "Lists all lessons."),
    TEACHER("teacher", "Lists all teaching staff."),
    ADD_TASK("add task", "NAME ;; DEADLINE ;; [REMARKS]","Adds new task."),
    DELETE_TASK("delete task", "Deletes specified tasks."),
    MARK("mark", "Marks specified tasks as done."),
    UNMARK("unmark", "Marks specified tasks as undone."),
    TASKS("tasks", "Lists all tasks."),
    INVALID("unknown", "Unrecognized command.");

    private final String word;
    private final String argumentsFormat;
    private final String description;

    ModuleCommands(String word, String description) {
        this.word = word;
        this.argumentsFormat = "";
        this.description = description;
    }

    ModuleCommands(String word, String argumentsFormat, String description) {
        this.word = word;
        this.argumentsFormat = argumentsFormat;
        this.description = description;
    }

    public String getWord() {
        return word;
    }

    @Override
    public String getArgumentsFormat() {
        return argumentsFormat;
    }

    public String getDescription() {
        return description;
    }
}
