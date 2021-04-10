package seedu.duke.commands;

import seedu.duke.editor.TextEditor;
import seedu.duke.exception.CommandException;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static seedu.duke.common.Constants.FOLDER_PATH;
import static seedu.duke.common.Constants.PATH_DELIMITER;
import static seedu.duke.common.Constants.STRING_CHEATSHEET;
import static seedu.duke.common.Constants.TXT_FORMAT;
import static seedu.duke.common.Messages.MESSAGE_CHEATSHEET_ADDED;
import static seedu.duke.common.Messages.MESSAGE_CHEAT_SHEET_ALREADY_EXISTS;
import static seedu.duke.common.Messages.MESSAGE_CLOSE_CHEATSHEET_FIRST;
import static seedu.duke.common.Messages.MESSAGE_INVALID_FILE_NAME;
import static seedu.duke.common.InputValidator.hasInvalidCharacter;

public class AddCheatSheetCommand extends Command {
    public static String fileName;

    //@@author H-horizon
    public AddCheatSheetCommand(String nameOfFile) {
        fileName = nameOfFile;
    }

    @Override
    public void execute(UI ui) throws CommandException {
        Module module = ModuleList.getSelectedModule();
        boolean isInvalidFileName = hasInvalidCharacter(fileName);
        if (fileName.isEmpty() || isInvalidFileName) {
            throw new CommandException(MESSAGE_INVALID_FILE_NAME);
        }
        try {
            String directoryPath = getDirectoryPath(module, ui);
            String filePath = directoryPath + fileName + TXT_FORMAT;
            Path path;
            path = Paths.get(filePath);
            openTextEditor(ui, path, filePath);
        } catch (InvalidPathException e) {
            throw new CommandException(MESSAGE_INVALID_FILE_NAME);
        }
    }

    public void openTextEditor(UI ui, Path path, String filePath) {

        if (Files.exists(path)) {
            ui.printMessage(MESSAGE_CHEAT_SHEET_ALREADY_EXISTS);
        } else {
            if (!TextEditor.isNull()) {
                //already open
                ui.printMessage(MESSAGE_CLOSE_CHEATSHEET_FIRST);
                return;
            }
            try {
                File file = new File(filePath);
                file.createNewFile();
                ui.printMessage(String.format(MESSAGE_CHEATSHEET_ADDED, fileName));
                TextEditor.createNew(filePath, fileName);
            } catch (NullPointerException | IOException e) {
                ui.printMessage(MESSAGE_INVALID_FILE_NAME);
            }
        }
    }

    public String getDirectoryPath(Module module, UI ui) {
        String directoryPath = FOLDER_PATH + PATH_DELIMITER + module.getModuleCode() + PATH_DELIMITER
                + STRING_CHEATSHEET + PATH_DELIMITER;
        try {
            Path path = Paths.get(directoryPath);
            assert Files.isDirectory(path) : "Directory missing";
        } catch (InvalidPathException e) {
            ui.printMessage(MESSAGE_INVALID_FILE_NAME);
        }
        return directoryPath;
    }
}
