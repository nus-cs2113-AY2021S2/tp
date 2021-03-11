package seedu.duke.commands;

import seedu.duke.exception.CommandException;
import seedu.duke.lesson.Lesson;
import seedu.duke.lesson.LessonType;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.parser.Parser;
import seedu.duke.ui.UI;

import java.util.ArrayList;
import java.util.Scanner;

import static seedu.duke.commands.AddLessonCommand.getLessonTypeName;
import static seedu.duke.common.Messages.FORMAT_INDEX_ITEM;
import static seedu.duke.common.Messages.MESSAGE_LESSONS_TO_DELETE;
import static seedu.duke.common.Messages.MESSAGE_REMOVED_LESSON;

public class DeleteLessonCommand extends Command {
    private final Scanner commandLineReader = new Scanner(System.in);

    public DeleteLessonCommand() {
        System.out.println(MESSAGE_LESSONS_TO_DELETE);

    }

    public Scanner getCommandLineReader() {
        return commandLineReader;
    }

    @Override
    public void execute(UI ui) throws CommandException {
        Module module = ModuleList.getSelectedModule();
        ArrayList<Lesson> lessonList = module.getLessonList();
        printLessonOptions(lessonList, ui);

        Scanner input = getCommandLineReader();
        String line = input.nextLine();
        ArrayList<Integer> indexes = Parser.checkIndices(line, lessonList.size());

        deleteLessonsFromList(lessonList, indexes, ui);
        ModuleList.writeModule();
    }

    @Override
    public boolean isExit() {
        return false;
    }

    public static void deleteLessonsFromList(ArrayList<Lesson> lessonList, ArrayList<Integer> indexes, UI ui) {
        int pointer = 1;
        for (int index : indexes) {
            int modifiedIndex = index - pointer;
            Lesson lesson = lessonList.get(modifiedIndex);
            String lessonName = getLessonName(lesson);
            ui.printMessage(String.format(MESSAGE_REMOVED_LESSON, lessonName));
            ModuleList.getSelectedModule().deleteLessonFromList(lessonList, modifiedIndex);
            pointer++;
        }
    }

    public static String getLessonName(Lesson lesson) {
        LessonType newLessonType = lesson.getLessonType();
        return getLessonTypeName(newLessonType);
    }

    public static void printLessonOptions(ArrayList<Lesson> lessonList, UI ui) {
        int counter = 1;
        for (Lesson lesson : lessonList) {
            String lessonName = getLessonName(lesson);
            ui.printMessage(String.format(FORMAT_INDEX_ITEM, counter, lessonName));
            counter++;
        }
    }
}
