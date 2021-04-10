package seedu.duke.commands;

import seedu.duke.editor.TextEditor;
import seedu.duke.exception.CommandException;
import seedu.duke.ui.UI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static seedu.duke.common.Messages.MESSAGE_CLOSE_CHEATSHEET_FIRST;
import static seedu.duke.common.Messages.MESSAGE_FILE_DOES_NOT_EXIST;
import static seedu.duke.common.Messages.MESSAGE_OPEN_FILE;

public class EditCheatSheetCommand extends DeleteCheatSheetCommand {

    //@@author H-horizon
    public EditCheatSheetCommand(String nameOfFile) {
        super(nameOfFile);
    }

    @Override
    public void performFunction(UI ui, Path path) throws IOException {
        openTextEditor(ui, path, filePath);
    }

    @Override
    public void openTextEditor(UI ui, Path path, String filePath) {
        if (Files.exists(path)) {
            if (TextEditor.createNew(filePath, fileName)) {
                ui.printMessage(String.format(MESSAGE_OPEN_FILE, fileName));
            } else {
                ui.printMessage(String.format(MESSAGE_CLOSE_CHEATSHEET_FIRST, fileName));
            }
        } else {
            ui.printMessage(String.format(MESSAGE_FILE_DOES_NOT_EXIST, fileName));
            Command command = new ListCheatSheetsCommand();
            try {
                command.execute(ui);
            } catch (CommandException e) {
                assert false : "Directory not found";
            }
        }
    }
}
