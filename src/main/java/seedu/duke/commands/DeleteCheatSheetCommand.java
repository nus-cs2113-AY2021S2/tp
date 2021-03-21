package seedu.duke.commands;

import seedu.duke.exception.CommandException;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static seedu.duke.common.Messages.MESSAGE_FILE_DOES_NOT_EXIST;
import static seedu.duke.common.Messages.MESSAGE_FILE_HAS_BEEN_DELETED;

public class DeleteCheatSheetCommand extends AddCheatSheetCommand {

    public DeleteCheatSheetCommand(String nameOfFile) {
        super(nameOfFile);
    }

    @Override
    public void execute(UI ui) throws CommandException {
        Module module = ModuleList.getSelectedModule();
        String directoryPath = getDirectoryPath(module);
        Path path;
        String filePath = directoryPath + fileName;
        path = Paths.get(filePath);
        try {
            Files.delete(path);
            ui.printMessage(String.format(MESSAGE_FILE_HAS_BEEN_DELETED, fileName));
        } catch (IOException e) {
            ui.printMessage(String.format(MESSAGE_FILE_DOES_NOT_EXIST, fileName));
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
