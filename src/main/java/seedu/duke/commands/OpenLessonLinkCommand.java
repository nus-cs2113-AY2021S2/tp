package seedu.duke.commands;

import seedu.duke.lesson.Lesson;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.awt.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.Scanner;

public class OpenLessonLinkCommand extends Command {
    private Scanner commandLineReader = new Scanner(System.in);

    public OpenLessonLinkCommand() {
        System.out.println("Which lesson’s link would you like to open?");

    }

    public Scanner getCommandLineReader() {
        return commandLineReader;
    }

    @Override
    public void execute(ModuleList moduleList, UI ui) {
        Module module = ModuleList.getSelectedModule();
        ArrayList<Lesson> lessonList = module.getLessonList();
        DeleteLessonCommand.printLessonOptions(lessonList);
        Scanner input = getCommandLineReader();
        String line = input.nextLine();

        ArrayList<Integer> indexes = checkIndices(line, lessonList.size());
        for (int index : indexes) {
            Lesson lesson = lessonList.get(index - 1);
            System.out.println("Opening "+AddLessonCommand.getLessonTypeString(lesson.getLessonType())+
                    " link in browser." );
            openLessonLink(lesson.getOnlineLink());
        }
    }

    public void openLessonLink(String onlineLink) {
        try {
            Desktop desktop = java.awt.Desktop.getDesktop();
            URI link = new URI(onlineLink);
            desktop.browse(link);
        } catch (Exception e) {
            System.out.println("Cannot open link");
        }
    }
}
