package seedu.duke.commands;

import seedu.duke.editor.TextEditor;
import seedu.duke.exception.CommandException;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static seedu.duke.common.Constants.CHEATSHEET_DIR;
import static seedu.duke.common.Constants.FOLDER_PATH;
import static seedu.duke.common.Constants.PATH_DELIMITER;
import static seedu.duke.common.Messages.MESSAGE_CHEATSHEET_ADDED;
import static seedu.duke.common.Messages.MESSAGE_CHEAT_SHEET_ALREADY_EXISTS;

public class AddCheatSheetCommand extends Command {
    public static String fileName;

    public AddCheatSheetCommand(String nameOfFile) {
        fileName = nameOfFile;
    }

    @Override
    public void execute(UI ui) throws CommandException {
        Module module = ModuleList.getSelectedModule();
        String directoryPath = getDirectoryPath(module);
        Path path;
        String filePath = directoryPath + fileName;
        path = Paths.get(filePath);
        openTextEditor(ui, path, filePath);
    }

    public void openTextEditor(UI ui, Path path, String filePath) {

        if (Files.exists(path)) {
            ui.printMessage(MESSAGE_CHEAT_SHEET_ALREADY_EXISTS);
        } else {
            File file = new File(filePath);
            ui.printMessage(String.format(MESSAGE_CHEATSHEET_ADDED, fileName));
            TextEditor textEditor = new TextEditor(filePath);
        }
    }

    public String getDirectoryPath(Module module) {
        String directoryPath = FOLDER_PATH + PATH_DELIMITER + module.getModuleCode() + PATH_DELIMITER + CHEATSHEET_DIR
                + PATH_DELIMITER;
        Path path = Paths.get(directoryPath);
        assert Files.isDirectory(path) : "Directory missing";
        return directoryPath;
    }


    @Override
    public boolean isExit() {
        return false;
    }
}
