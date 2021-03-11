package seedu.duke.commands;

import seedu.duke.exception.CommandException;
import seedu.duke.lesson.Lesson;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.parser.Parser;
import seedu.duke.ui.UI;


import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

import static seedu.duke.commands.DeleteLessonCommand.getLessonName;
import static seedu.duke.common.Messages.MESSAGE_LESSON_TO_OPEN_LINK;
import static seedu.duke.common.Messages.MESSAGE_OPENED_LESSON_LINK;
import static seedu.duke.common.Messages.MESSAGE_UNABLE_TO_OPEN_LINK;

public class OpenLessonLinkCommand extends Command {
    public static final String LINUX_COMMAND = "xdg-open ";
    private final Scanner commandLineReader = new Scanner(System.in);

    public Scanner getCommandLineReader() {
        return commandLineReader;
    }

    @Override
    public void execute(UI ui) throws CommandException {
        ui.printMessage(MESSAGE_LESSON_TO_OPEN_LINK);
        Module module = ModuleList.getSelectedModule();
        ArrayList<Lesson> lessonList = module.getLessonList();
        DeleteLessonCommand.printLessonOptions(lessonList,ui);
        Scanner input = getCommandLineReader();
        String line = input.nextLine();

        ArrayList<Integer> indexes = Parser.checkIndices(line, lessonList.size());
        printLessonsLink(lessonList, indexes, ui);
    }

    @Override
    public boolean isExit() {
        return false;
    }

    public static void printLessonsLink(ArrayList<Lesson> lessonList, ArrayList<Integer> indexes, UI ui) {
        for (int index : indexes) {
            Lesson lesson = lessonList.get(index - 1);
            String lessonName = getLessonName(lesson);
            ui.printMessage(String.format(MESSAGE_OPENED_LESSON_LINK, lessonName));
            openLessonLink(lesson.getOnlineLink(), ui);
        }
    }

    public static void openLessonLink(String onlineLink, UI ui) {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(onlineLink));
            } catch (IOException | URISyntaxException e) {
                ui.printMessage(MESSAGE_UNABLE_TO_OPEN_LINK);
            }
        } else {
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec(LINUX_COMMAND + onlineLink);
            } catch (IOException e) {
                ui.printMessage(MESSAGE_UNABLE_TO_OPEN_LINK);
            }
        }
    }
}
