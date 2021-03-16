package seedu.duke.common;

import java.util.ArrayList;
import java.util.Arrays;

public class Constants {

    //General
    public static final String FORMAT_DATE_IO = "d-M-yyyy";
    public static final String FORMAT_DATE_NORMAL = "d MMM yyyy";
    public static final String LINUX_OPEN_COMMAND = "xdg-open ";
    public static final int INDEX_FIRST = 0;
    public static final String EMPTY_STRING = "";

    //Lecture type
    public static final String LECTURE_STRING = "lecture";
    public static final String TUTORIAL_STRING = "tutorial";
    public static final String LAB_STRING = "lab";

    //Lesson
    public static final int INDEX_TYPE = 0;
    public static final int INDEX_DAY_TIME = 1;
    public static final int INDEX_LINK = 2;
    public static final int INDEX_TEACHER_NAME = 3;
    public static final int INDEX_TEACHER_EMAIL = 4;

    public static final int ENTRY_LESSON_MAX_PARSER = 5;
    public static final int ENTRY_LESSON_SHORT = 2;
    public static final int ENTRY_LESSON_MEDIUM = 3;
    public static final int ENTRY_LESSON_LONG = 4;
    public static final int ENTRY_LESSON_EXTRA_LONG = 5;
    public static final ArrayList<Integer> ENTRY_SIZE_LESSON
            = new ArrayList<>(Arrays.asList(ENTRY_LESSON_SHORT, ENTRY_LESSON_MEDIUM,
            ENTRY_LESSON_LONG, ENTRY_LESSON_EXTRA_LONG));

    //Task
    public static final int INDEX_DESCRIPTION = 0;
    public static final int INDEX_DEADLINE = 1;
    public static final int INDEX_REMARKS_PARSER = 2;
    public static final int INDEX_IS_DONE = 2;
    public static final int INDEX_IS_GRADED = 3;
    public static final int INDEX_REMARKS_LOADER = 4;

    public static final int ENTRY_TASK_MAX_PARSER = 3;
    public static final int ENTRY_TASK_SHORT = 4;
    public static final int ENTRY_TASK_LONG = 5;
    public static final ArrayList<Integer> ENTRY_SIZE_TASK
            = new ArrayList<>(Arrays.asList(ENTRY_TASK_SHORT, ENTRY_TASK_LONG));

    public static final String YES_STRING = "Y";
    public static final String NO_STRING = "N";

    //Parser
    public static final String FORMAT_MODULE_CODE = "([A-z]{2,3}[\\d]{4}[A-z]?)";
    public static final String FORMAT_EMAIL = "[A-z0-9_.-]+@[A-z.]+";
    public static final String FORMAT_LINK = "[(http(s)?):\\/\\/(www\\.)?a-zA-Z0-9@:%._\\-\\+~#=]{2,256}\\.[a-z]{2,6}" 
                                            + "\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)";
    public static final String DELIM = ";;";
    public static final String WHITESPACE = " ";
    public static final String PLACEHOLDER = "-";

    //Storage
    public static final String FOLDER_PATH = "Data";
    public static final String TXT_FORMAT = ".txt";
    public static final String STOP_LINE = "------------";
    public static final String DIVIDER_READ = "\\|";
    public static final String DIVIDER_WRITE = " | ";
    public static final String KEYWORD_LESSON = "lesson | ";
    public static final String KEYWORD_TASK = "task | ";
    public static final String TRUE_STRING = "T";
}
