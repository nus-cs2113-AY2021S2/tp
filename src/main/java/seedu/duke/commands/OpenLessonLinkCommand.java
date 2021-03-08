package seedu.duke.commands;

import seedu.duke.lesson.Lesson;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.parser.Parser;
import seedu.duke.ui.UI;


import java.awt.Desktop;
import java.net.URI;
import java.util.ArrayList;
import java.util.Scanner;

import static seedu.duke.commands.DeleteLessonCommand.getLessonName;

public class OpenLessonLinkCommand extends Command {
    public static final String MESSAGE_OPEN_LESSON_LINK = "Which lesson’s link would you like to open?";
    public static final String OPEN_LESSON_LINK_FORMAT = "Opening %s link in browser.";
    public static final String MESSAGE_CANNOT_OPEN_LESSON_LINK = "Cannot open lesson link";
    private final Scanner commandLineReader = new Scanner(System.in);

    public OpenLessonLinkCommand() {
        System.out.println(MESSAGE_OPEN_LESSON_LINK);
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

        ArrayList<Integer> indexes = Parser.checkIndices(line, lessonList.size());
        for (int index : indexes) {
            Lesson lesson = lessonList.get(index - 1);
            String lessonName = getLessonName(lesson);
            System.out.println(String.format(OPEN_LESSON_LINK_FORMAT, lessonName));
            openLessonLink(lesson.getOnlineLink());
        }
    }

    public static void openLessonLink(String onlineLink) {
        try {
            Desktop desktop = java.awt.Desktop.getDesktop();
            URI link = new URI(onlineLink);
            desktop.browse(link);
        } catch (Exception e) {
            System.out.println(MESSAGE_CANNOT_OPEN_LESSON_LINK);
        }
    }
}
