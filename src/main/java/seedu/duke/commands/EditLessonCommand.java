package seedu.duke.commands;

import seedu.duke.exception.ParserException;
import seedu.duke.lesson.Lesson;
import seedu.duke.lesson.TeachingStaff;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.parser.ParserUtil;
import seedu.duke.ui.UI;

import java.util.ArrayList;

import static seedu.duke.common.Constants.EDIT_INDEX_DAY_TIME;
import static seedu.duke.common.Constants.EDIT_INDEX_LINK;
import static seedu.duke.common.Constants.EDIT_INDEX_TEACHER_NAME;
import static seedu.duke.common.Constants.LESSON_FIELD_1_TIME_DAY;
import static seedu.duke.common.Constants.LESSON_FIELD_2_LINK;
import static seedu.duke.common.Constants.LESSON_FIELD_3_T_NAME;
import static seedu.duke.common.Constants.LESSON_FIELD_4_T_EMAIL;
import static seedu.duke.common.Constants.MAX_EDITABLE_FIELDS;
import static seedu.duke.common.Messages.FORMAT_INDEX_ITEM;
import static seedu.duke.common.Messages.MESSAGE_EDITED_FIELD;
import static seedu.duke.common.Messages.MESSAGE_FIELDS_TO_EDIT;
import static seedu.duke.common.Messages.MESSAGE_FIELD_BEING_EDITED;
import static seedu.duke.common.Messages.MESSAGE_INVALID_LESSON_EMAIL;
import static seedu.duke.common.Messages.MESSAGE_INVALID_LESSON_LINK;
import static seedu.duke.common.Messages.MESSAGE_LESSONS_LIST_EMPTY;
import static seedu.duke.common.Messages.MESSAGE_LESSON_TO_EDIT;
import static seedu.duke.common.Messages.MESSAGE_NOT_UPDATED;
import static seedu.duke.common.Messages.MESSAGE_NO_CHANGES;
import static seedu.duke.common.Messages.MESSAGE_SEPARATE_INDICES;
import static seedu.duke.common.Messages.PROMPT_ENTER_FIELD_DETAILS;
import static seedu.duke.common.Messages.WARNING_NO_VALID_INPUT;

//@@author ivanchongzhien
public class EditLessonCommand extends Command {
    private final String[] fields = {LESSON_FIELD_1_TIME_DAY, LESSON_FIELD_2_LINK,
        LESSON_FIELD_3_T_NAME, LESSON_FIELD_4_T_EMAIL};

    /**
     * Edits the fields of selected lesson.
     *
     * @param ui instance of UI
     */
    @Override
    public void execute(UI ui) {
        Module module = ModuleList.getSelectedModule();
        ArrayList<Lesson> lessonsList = module.getLessonList();

        Lesson lessonToEdit = getLessonToEdit(lessonsList, ui);

        if (lessonToEdit == null) {
            return;
        }
        
        ui.printMessage(String.format(MESSAGE_FIELD_BEING_EDITED, lessonToEdit.getLessonType().toString()));
        editLessonFields(lessonToEdit, ui);
        ModuleList.writeModule();
        ModuleList.sortLessons();
    }

    /**
     * Obtains the fields to be edited from the user and makes the changes
     * to the Lesson object.
     *
     * @param lesson the lesson to be edited
     * @param ui     instance of UI for printing prompts
     */
    private void editLessonFields(Lesson lesson, UI ui) {
        ArrayList<Integer> indices = getFieldIndicesFromUser(ui);
        String newFieldValue;

        for (int index : indices) {
            newFieldValue = getNewFieldFromUser(index, ui);
            setNewFieldValue(lesson, newFieldValue, index, ui);
        }
    }

    /**
     * Determines the lesson the user wants to edit.
     *
     * @param lessonList list of lessons that can be edited
     * @param ui         instance of UI for printing prompts and warnings
     * @return the lesson chosen by the user
     */
    private Lesson getLessonToEdit(ArrayList<Lesson> lessonList, UI ui) {
        Lesson chosenLesson;

        if (lessonList.size() == 0) {
            ui.printMessage(MESSAGE_LESSONS_LIST_EMPTY);
            return null;
        }

        int index = getLessonIndexFromUser(lessonList, ui);

        if (index == 0) {
            ui.printMessage(MESSAGE_NO_CHANGES);
            return null;
        }
        chosenLesson = lessonList.get(index - 1);
        return chosenLesson;
    }

    /**
     * Prompts user to choose the lesson to be edited.
     *
     * @param lessonList list of lessons that can be edited
     * @param ui         instance of UI for printing user prompts
     * @return the index of the chosen lesson, 0 if user enters invalid index
     */
    private int getLessonIndexFromUser(ArrayList<Lesson> lessonList, UI ui) {
        int index = 0;

        ui.printMessage(MESSAGE_LESSON_TO_EDIT);
        ListLessonsCommand.printLessons(lessonList, ui);

        String line = ui.readUserInput();

        try {
            index = ParserUtil.checkIndex(line, lessonList.size());
        } catch (ParserException e) {
            ui.printError(e);
        }
        return index;
    }

    /**
     * Prompts user to choose the fields of the lesson to be edited.
     *
     * @param ui instance of UI for printing prompts and warnings
     * @return an array list of indices chosen by the user
     */
    private ArrayList<Integer> getFieldIndicesFromUser(UI ui) {

        ui.printMessage(MESSAGE_FIELDS_TO_EDIT);
        printFieldsAsList(ui);
        ui.printMessage(MESSAGE_SEPARATE_INDICES);

        String input = ui.readUserInput();

        ArrayList<Integer> indices;
        indices = ParserUtil.checkIndices(input, MAX_EDITABLE_FIELDS);

        if (indices.size() == 0) {
            ui.printMessage(WARNING_NO_VALID_INPUT);
        }
        return indices;
    }

    /**
     * Reads in a new lesson field from the user.
     *
     * @param userIndex the index of the field being read (as entered by the user)
     * @param ui        instance of UI for printing prompts
     * @return trimmed user input string
     */
    private String getNewFieldFromUser(int userIndex, UI ui) {
        int fieldIndex = userIndex - 1;

        ui.printMessage(String.format(PROMPT_ENTER_FIELD_DETAILS, fields[fieldIndex].toLowerCase()));
        String input = ui.readUserInput();

        return input.trim();
    }

    /**
     * Sets the value of a lesson field to the new value entered by the user.
     *
     * @param lesson        the lesson being edited
     * @param newFieldValue new field entered obtained from the user
     * @param userIndex     the index of the field being edited
     * @param ui            instance of UI for printing messages and warnings
     */
    private void setNewFieldValue(Lesson lesson, String newFieldValue, int userIndex, UI ui) {
        int fieldIndex = userIndex - 1;

        switch (fieldIndex) {
        case EDIT_INDEX_DAY_TIME:
            lesson.setTime(newFieldValue);
            ui.printMessage(String.format(MESSAGE_EDITED_FIELD, fields[fieldIndex].toLowerCase()));
            break;
        case EDIT_INDEX_LINK:
            if (Lesson.isValidLink(newFieldValue)) {
                lesson.setOnlineLink(newFieldValue);
                ui.printMessage(String.format(MESSAGE_EDITED_FIELD, fields[fieldIndex].toLowerCase()));
            } else {
                ui.printMessage(MESSAGE_INVALID_LESSON_LINK + MESSAGE_NOT_UPDATED);
            }
            break;
        case EDIT_INDEX_TEACHER_NAME:
            lesson.setTeachingStaffName(newFieldValue);
            ui.printMessage(String.format(MESSAGE_EDITED_FIELD, fields[fieldIndex].toLowerCase()));
            break;
        default:
            if (TeachingStaff.isValidEmail(newFieldValue)) {
                lesson.setTeachingStaffEmail(newFieldValue);
                ui.printMessage(String.format(MESSAGE_EDITED_FIELD, fields[fieldIndex].toLowerCase()));
            } else {
                ui.printMessage(MESSAGE_INVALID_LESSON_EMAIL + MESSAGE_NOT_UPDATED);
            }
            break;
        }
    }

    /**
     * Prints the fields of a lesson with numbering.
     *
     * @param ui instance of UI to print the fields
     */
    private void printFieldsAsList(UI ui) {
        int numbering = 1;
        for (String field : this.fields) {
            ui.printMessage(String.format(FORMAT_INDEX_ITEM, numbering, field));
            numbering++;
        }
    }
}
