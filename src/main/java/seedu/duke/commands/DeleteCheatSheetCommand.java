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

    public static String filePath;

    public DeleteCheatSheetCommand(String nameOfFile) {
        super(nameOfFile);
    }

    @Override
    public void execute(UI ui) throws CommandException {
        Module module = ModuleList.getSelectedModule();
        String directoryPath = getDirectoryPath(module);
        filePath = directoryPath + fileName + FILE_EXTENSION;
        Path path = Paths.get(filePath);
        try {
            performFunction(ui, path);
        } catch (IOException e) {
            ui.printMessage(String.format(MESSAGE_FILE_DOES_NOT_EXIST, fileName));
        }
    }

    public void performFunction(UI ui, Path path) throws IOException {
        Files.delete(path);
        ui.printMessage(String.format(MESSAGE_FILE_HAS_BEEN_DELETED, fileName));
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
