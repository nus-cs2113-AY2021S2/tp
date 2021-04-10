package seedu.duke.commands;

import seedu.duke.exception.CommandException;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static seedu.duke.common.Constants.TXT_FORMAT;
import static seedu.duke.common.Messages.MESSAGE_FILE_DOES_NOT_EXIST;
import static seedu.duke.common.Messages.MESSAGE_FILE_HAS_BEEN_DELETED;

public class DeleteCheatSheetCommand extends AddCheatSheetCommand {

    public static String filePath;

    //@@author H-horizon
    public DeleteCheatSheetCommand(String nameOfFile) {
        super(nameOfFile);
    }

    @Override
    public void execute(UI ui) throws CommandException {
        Module module = ModuleList.getSelectedModule();
        try {
            String directoryPath = getDirectoryPath(module, ui);


            filePath = directoryPath + fileName + TXT_FORMAT;
            Path path = Paths.get(filePath);
            performFunction(ui, path);
        } catch (InvalidPathException | IOException e) {
            ui.printMessage(String.format(MESSAGE_FILE_DOES_NOT_EXIST, fileName));
            Command command = new ListCheatSheetsCommand();
            command.execute(ui);
        }
    }

    public void performFunction(UI ui, Path path) throws IOException {
        Files.delete(path);
        ui.printMessage(String.format(MESSAGE_FILE_HAS_BEEN_DELETED, fileName));
    }
}
