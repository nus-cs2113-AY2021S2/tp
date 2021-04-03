package seedu.duke.common;

//@@author isaharon
public enum ModuleCommands implements CommandList {
    
    HELP("help", "Lists all commands available for the selected module."),
    CLOSE("close", "Closes the current module."),
    INFO("info", "Prints an overview of the current module."),
    ADD_LESSON("add lsn",
            "LESSON_NAME ;; [DAY_AND_TIME STRING] ;; [LESSON LINK] ;; [STAFF_NAME] ;; [EMAIL]",
            "Adds a new lesson."),
    DELETE_LESSON("del lsn", "Deletes lessons."),
    EDIT_LESSON("edit lsn", "Edits specified fields of a chosen lesson."),
    LINK("link", "Opens link to the lesson in a browser."),
    TEACHER("tch", "Lists all teaching staff."),
    LESSONS("lsn", "Lists all lessons."),
    ADD_TASK("add task", "NAME ;; DD-MM-YYYY ;; [REMARKS]", "Adds new task."),
    DELETE_TASK("del task", "Deletes specified tasks."),
    EDIT_TASK("edit task", "Edits specified fields of a chosen task."),
    MARK("mark", "Marks specified tasks as done."),
    UNMARK("unmark", "Marks specified tasks as undone."),
    TASKS("task", "Lists all tasks."),
    ADD_CHEAT_SHEET("add cs", "[Cheat-Sheet name]",
            "Add a new cheat-sheet for that module."),
    DELETE_CHEAT_SHEET("del cs", "[Cheat-Sheet name]",
            "Delete a cheat-sheet stored in the cheat-sheet directory of the module."),
    EDIT_CHEAT_SHEET("edit cs", "[Cheat-Sheet name]",
            "Edit a cheat-sheet stored in the cheat-sheet directory of the module."),
    LIST_CHEAT_SHEET("cs", "Lists all cheat-sheets");

    private final String word;
    private final String argumentsFormat;
    private final String description;

    ModuleCommands(String word, String description) {
        this.word = word;
        this.argumentsFormat = Constants.EMPTY_STRING;
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

    //@@author ivanchongzhien

    /**
     * Converts given string to a module command.
     *
     * @param commandWord word string
     * @return the enum type of ModuleCommands representing the command specified
     */
    public static ModuleCommands getModuleCommandsFromString(String commandWord) {
        if (commandWord.equalsIgnoreCase(ModuleCommands.HELP.getWord())) {
            return ModuleCommands.HELP;
        } else if (commandWord.equalsIgnoreCase(CLOSE.getWord())) {
            return CLOSE;
        } else if (commandWord.equalsIgnoreCase(INFO.getWord())) {
            return INFO;
        } else if (commandWord.equalsIgnoreCase(LESSONS.getWord())) {
            return LESSONS;
        } else if (commandWord.equalsIgnoreCase(LINK.getWord())) {
            return LINK;
        } else if (commandWord.equalsIgnoreCase(TASKS.getWord())) {
            return TASKS;
        } else if (commandWord.equalsIgnoreCase(MARK.getWord())) {
            return MARK;
        } else if (commandWord.equalsIgnoreCase(UNMARK.getWord())) {
            return UNMARK;
        } else if (commandWord.equalsIgnoreCase(TEACHER.getWord())) {
            return TEACHER;
        } else if (commandWord.equalsIgnoreCase(ADD_LESSON.getWord())) {
            return ADD_LESSON;
        } else if (commandWord.equalsIgnoreCase(DELETE_LESSON.getWord())) {
            return DELETE_LESSON;
        } else if (commandWord.equalsIgnoreCase(ADD_TASK.getWord())) {
            return ADD_TASK;
        } else if (commandWord.equalsIgnoreCase(DELETE_TASK.getWord())) {
            return DELETE_TASK;
        } else if (commandWord.equalsIgnoreCase(ADD_CHEAT_SHEET.getWord())) {
            return ADD_CHEAT_SHEET;
        } else if (commandWord.equalsIgnoreCase(DELETE_CHEAT_SHEET.getWord())) {
            return DELETE_CHEAT_SHEET;
        } else if (commandWord.equalsIgnoreCase(EDIT_CHEAT_SHEET.getWord())) {
            return EDIT_CHEAT_SHEET;
        } else if (commandWord.equalsIgnoreCase(LIST_CHEAT_SHEET.getWord())) {
            return LIST_CHEAT_SHEET;
        } else if (commandWord.equalsIgnoreCase(EDIT_TASK.getWord())) {
            return EDIT_TASK;
        } else if (commandWord.equalsIgnoreCase(EDIT_LESSON.getWord())) {
            return EDIT_LESSON;
        }
        return null;
    }
}
