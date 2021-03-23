package seedu.duke.commands;

import seedu.duke.exception.DukeException;
import seedu.duke.exception.ParserException;
import seedu.duke.lesson.Lesson;
import seedu.duke.lesson.TeachingStaff;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.parser.Parser;
import seedu.duke.ui.UI;

import java.util.ArrayList;

import static seedu.duke.common.Constants.EDIT_INDEX_DAY_TIME;
import static seedu.duke.common.Constants.EDIT_INDEX_LINK;
import static seedu.duke.common.Constants.EDIT_INDEX_TEACHER_EMAIL;
import static seedu.duke.common.Constants.EDIT_INDEX_TEACHER_NAME;
import static seedu.duke.common.Constants.LESSON_FIELD_1_TIME_DAY;
import static seedu.duke.common.Constants.LESSON_FIELD_2_LINK;
import static seedu.duke.common.Constants.LESSON_FIELD_3_T_NAME;
import static seedu.duke.common.Constants.LESSON_FIELD_4_T_EMAIL;
import static seedu.duke.common.Constants.MAX_EDITABLE_FIELDS;
import static seedu.duke.common.Messages.*;

public class EditLessonCommand extends Command {
    private final String[] fields = {LESSON_FIELD_1_TIME_DAY, LESSON_FIELD_2_LINK, 
        LESSON_FIELD_3_T_NAME, LESSON_FIELD_4_T_EMAIL};

    @Override
    public void execute(UI ui) {
        Module module = ModuleList.getSelectedModule();
        ArrayList<Lesson> lessonsList = module.getLessonList();

        ListLessonsCommand.printLessons(lessonsList, ui);
        Lesson lessonToEdit = getLessonToEdit(lessonsList, ui);

        if (lessonToEdit != null) {
            editLessonFields(lessonToEdit, ui);
        }
        ModuleList.writeModule();
        ModuleList.sortLessons();
    }

    private Lesson getLessonToEdit(ArrayList<Lesson> lessonList, UI ui) {
        Lesson chosenLesson = null;

        if (lessonList.size() == 0) {
            ui.printMessage(MESSAGE_LESSONS_LIST_EMPTY);
        } else {
            int index = getLessonIndexFromUser(lessonList, ui) - 1;
            chosenLesson = lessonList.get(index);
        }
        return chosenLesson;
    }

    private int getLessonIndexFromUser(ArrayList<Lesson> lessonList, UI ui) {
        boolean isValidIndex = false;
        int index = 0;

        // loop until valid input is received
        while (!isValidIndex) {
            ui.printMessage(MESSAGE_LESSON_TO_EDIT);
            String line = ui.readCommand();
            try {
                index = Parser.checkIndex(line, lessonList.size());
                isValidIndex = true;
            } catch (ParserException e) {
                ui.printError(e);
            }
        }
        return index;
    }

    private void editLessonFields(Lesson lesson, UI ui) {
        ArrayList<Integer> indices = getFieldIndicesFromUser(ui);
        String newFieldValue;

        for (int index : indices) {
            newFieldValue = getNewFieldFromUser(index, ui);
            setNewFieldValue(lesson, newFieldValue, index, ui);
        }
    }

    private ArrayList<Integer> getFieldIndicesFromUser(UI ui) {
        boolean isValidInput = false;
        ArrayList<Integer> indices = new ArrayList<>();
        printFieldsAsList(ui);

        // loop until user enters valid input
        while (!isValidInput) {
            ui.printMessage(MESSAGE_LESSON_FIELD_TO_EDIT);
            String input = ui.readCommand();

            indices = Parser.checkIndices(input, MAX_EDITABLE_FIELDS);

            if (indices.size() == 0) {
                ui.printMessage(WARNING_NO_VALID_INPUT);
            } else {
                isValidInput = true;
            }
        }
        return indices;
    }

    private String getNewFieldFromUser(int userIndex, UI ui) {
        int fieldIndex = userIndex - 1;

        ui.printMessage(String.format(PROMPT_ENTER_FIELD_DETAILS, fields[fieldIndex]));
        String input = ui.readCommand();

        return input.trim();
    }

    private void setNewFieldValue(Lesson lesson, String newFieldValue, int userIndex, UI ui) {
        int fieldIndex = userIndex - 1;

        switch (fieldIndex) {
        case EDIT_INDEX_DAY_TIME:
            lesson.setTime(newFieldValue);
            ui.printMessage(String.format(MESSAGE_LESSON_TIME_UPDATED, newFieldValue));
            break;
        case EDIT_INDEX_LINK:
            if (Lesson.isValidLink(newFieldValue)) {
                lesson.setOnlineLink(newFieldValue);
                ui.printMessage(String.format(MESSAGE_LINK_UPDATED, newFieldValue));
            } else {
                ui.printMessage(MESSAGE_INVALID_LESSON_LINK);
                ui.printMessage(MESSAGE_NOT_UPDATED);
            }
            break;
        case EDIT_INDEX_TEACHER_NAME:
            lesson.getTeachingStaff().setName(newFieldValue);
            ui.printMessage(String.format(MESSAGE_TEACHER_NAME_UPDATED, newFieldValue));
            break;
        default:
            if(TeachingStaff.isValidEmail(newFieldValue)) {
                lesson.getTeachingStaff().setEmail(newFieldValue);
                ui.printMessage(String.format(MESSAGE_TEACHER_EMAIL_UPDATED, newFieldValue));
            } else {
                ui.printMessage(MESSAGE_INVALID_LESSON_EMAIL);
                ui.printMessage(MESSAGE_NOT_UPDATED);
            }
            break;
        }
    }

    private void printFieldsAsList(UI ui) {
        int numbering = 1;
        for (String field : this.fields) {
            String line = numbering + ". " + field;
            ui.printMessage(line);
            numbering++;
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
