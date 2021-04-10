package seedu.duke.commands;

import seedu.duke.exception.CommandException;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static seedu.duke.common.Constants.BEGIN_INDEX;
import static seedu.duke.common.Constants.STRING_CHEATSHEET;
import static seedu.duke.common.Constants.DOT;
import static seedu.duke.common.Constants.EMPTY;
import static seedu.duke.common.Constants.EXTENSION;
import static seedu.duke.common.Constants.FOLDER_PATH;
import static seedu.duke.common.Constants.PATH_DELIMITER;
import static seedu.duke.common.Messages.MESSAGE_EMPTY_CHEAT_SHEET_DIRECTORY;
import static seedu.duke.common.Messages.MESSAGE_LIST_OF_CHEAT_SHEETS;

public class ListCheatSheetsCommand extends Command {
    protected static String directoryPath;
    protected static Path directoryAbsolutePath;

    //@@author H-horizon
    public ListCheatSheetsCommand() {
        directoryPath = FOLDER_PATH + PATH_DELIMITER + ModuleList.getSelectedModuleCode() + PATH_DELIMITER
                + STRING_CHEATSHEET + PATH_DELIMITER;
        directoryAbsolutePath = Paths.get(directoryPath);
        assert Files.isDirectory(directoryAbsolutePath) : "Directory missing";
    }

    @Override
    public void execute(UI ui) throws CommandException {
        String[] filePaths;
        File f = new File(directoryPath);

        filePaths = f.list();
        int i = 1;
        if (filePaths != null && filePaths.length > EMPTY) {
            ui.printMessage(MESSAGE_LIST_OF_CHEAT_SHEETS);
            for (String filePath : filePaths) {
                ui.printMessage(i + DOT + filePath.substring(BEGIN_INDEX, filePath.length() - EXTENSION));
                i++;
            }
        } else {
            ui.printMessage(MESSAGE_EMPTY_CHEAT_SHEET_DIRECTORY);
        }
    }
}
