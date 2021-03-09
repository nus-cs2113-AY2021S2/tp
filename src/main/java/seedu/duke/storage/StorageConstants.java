package seedu.duke.storage;


import java.util.ArrayList;
import java.util.Arrays;

public class StorageConstants {

    public static final String DATE_IO_FORMAT = "d-M-yyyy";

    //Storage
    public static final String FOLDER_PATH = "Data";
    public static final String TXT_FORMAT = ".txt";
    public static final String STOP_LINE = "------------";
    public static final String DIVIDER_READ = "\\|";
    public static final String DIVIDER_WRITE = " | ";
    public static final String KEYWORD_LESSON = "lesson | ";
    public static final String KEYWORD_TASK = "task | ";
    public static final String TYPE_LECTURE = "lecture";
    public static final String TYPE_TUTORIAL = "tutorial";
    public static final String TYPE_LAB = "lab";

    public static final int ENTRY_LESSON_SHORT = 3;
    public static final int ENTRY_LESSON_MEDIUM = 4;
    public static final int ENTRY_LESSON_LONG = 5;
    public static final int ENTRY_LESSON_EXTRA_LONG = 6;
    public static final ArrayList<Integer> ENTRY_SIZE_LESSON
            = new ArrayList<>(Arrays.asList(ENTRY_LESSON_SHORT, ENTRY_LESSON_MEDIUM,
            ENTRY_LESSON_LONG, ENTRY_LESSON_EXTRA_LONG));

    public static final int INDEX_TYPE = 1;
    public static final int INDEX_DAY_TIME = 2;
    public static final int INDEX_LINK = 3;
    public static final int INDEX_TEACHER_NAME = 4;
    public static final int INDEX_TEACHER_EMAIL = 5;

    public static final int ENTRY_TASK_SHORT = 5;
    public static final int ENTRY_TASK_LONG = 6;
    public static final ArrayList<Integer> ENTRY_SIZE_TASK
            = new ArrayList<>(Arrays.asList(ENTRY_TASK_SHORT, ENTRY_TASK_LONG));

    public static final int INDEX_DESCRIPTION = 1;
    public static final int INDEX_DEADLINE = 2;
    public static final int INDEX_IS_DONE = 3;
    public static final int INDEX_IS_GRADED = 4;
    public static final int INDEX_REMARKS = 5;



}
