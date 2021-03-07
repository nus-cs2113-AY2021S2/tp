package seedu.duke.commands;

import seedu.duke.lesson.Lesson;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.parser.Parser;
import seedu.duke.ui.UI;

import java.util.ArrayList;
import java.util.Scanner;

public class DeleteLessonCommand extends Command{
    private Scanner commandLineReader = new Scanner(System.in);

    public DeleteLessonCommand(){
        System.out.println("Which lessons would you like to delete?");

    }
    public Scanner getCommandLineReader(){
        return commandLineReader;
    }

    @Override
    public void execute(ModuleList moduleList, UI ui) {
        Module module = ModuleList.getSelectedModule();
        ArrayList<Lesson> lessonList = module.getLessonList();
        printLessonOptions(lessonList);
        Scanner input = getCommandLineReader();
        String line = input.nextLine();
        //check indices is implemented in parser
        ArrayList<Integer> indexes = Parser.checkIndices(line,lessonList.size());
        int pointer = 1;
        for(int index: indexes){
            int modifiedIndex = index-pointer;
            System.out.println(index);
            Lesson lesson = lessonList.get(modifiedIndex);
            System.out.println("Removed "+ AddLessonCommand.getLessonTypeString(lesson.getLessonType()));
            module.deleteLessonFromList(lessonList,modifiedIndex);
            pointer++;
        }
    }

    public static void printLessonOptions(ArrayList<Lesson> lessonList) {
        int counter = 1;
        for(Lesson lesson: lessonList){
            System.out.println(String.format("%d. %s",counter,
                    AddLessonCommand.getLessonTypeString(lesson.getLessonType())));
            counter++;
        }
    }
}
