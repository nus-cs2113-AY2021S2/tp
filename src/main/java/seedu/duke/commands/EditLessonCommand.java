package seedu.duke.commands;

import seedu.duke.exception.DukeException;
import seedu.duke.lesson.Lesson;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.parser.Parser;
import seedu.duke.ui.UI;

import java.util.ArrayList;

import static seedu.duke.common.Constants.*;
import static seedu.duke.common.Messages.*;

public class EditLessonCommand extends Command {
    private final String[] FIELDS = {LESSON_FIELD_1_TIME_DAY, LESSON_FIELD_2_LINK, LESSON_FIELD_3_T_NAME, LESSON_FIELD_4_T_EMAIL};
    
    @Override
    public void execute(UI ui) {
        Module module = ModuleList.getSelectedModule();
        ArrayList<Lesson> lessonsList = module.getLessonList();

        ListLessonsCommand.printLessons(lessonsList, ui);
        Lesson lessonToEdit = getLessonToEdit(lessonsList, ui);
        
        if (lessonToEdit != null) {
            editLessonFields(lessonToEdit, ui);
        }
    }

    private Lesson getLessonToEdit(ArrayList<Lesson> lessonList, UI ui) {
        Lesson chosenLesson = null;

        if (lessonList.size() == 0) {
            ui.printMessage(MESSAGE_LESSONS_LIST_EMPTY);
        } else {
            int index = getLessonIndexFromUser(lessonList, ui);
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
            } catch (DukeException e) {
                ui.printError(e);
            }
        }
        return index;
    }

    private void editLessonFields(Lesson lesson, UI ui) {
        ArrayList<Integer> indices = getFieldIndicesFromUser(ui);
        String newFieldValue;
        
        for(int index : indices) {
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
                ui.printMessage("No valid inputs received. Pls reenter.");
            } else {
                isValidInput = true;
            }
        }
        return indices;
    }
    
    private String getNewFieldFromUser (int userIndex, UI ui) {
        int fieldIndex = userIndex - 1;
        
        ui.printMessage(String.format(PROMPT_ENTER_FIELD_DETAILS, FIELDS[fieldIndex]));
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
            // TODO: validate link?
            lesson.setOnlineLink(newFieldValue);
            ui.printMessage(String.format(MESSAGE_LINK_UPDATED, newFieldValue));
            break;
        case EDIT_INDEX_TEACHER_NAME:
            lesson.getTeachingStaff().setName(newFieldValue);
            ui.printMessage(String.format(MESSAGE_TEACHER_NAME_UPDATED, newFieldValue));
            break;
        case EDIT_INDEX_TEACHER_EMAIL:
            // TODO: validate email
            lesson.getTeachingStaff().setEmail(newFieldValue);
            ui.printMessage(String.format(MESSAGE_TEACHER_EMAIL_UPDATED, newFieldValue));
            break;
        }
    }

    private void printFieldsAsList(UI ui) {
        int numbering = 1;
        for (String field : this.FIELDS) {
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
