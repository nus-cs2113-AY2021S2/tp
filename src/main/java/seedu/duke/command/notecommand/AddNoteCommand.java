package seedu.duke.command.notecommand;

import seedu.duke.command.Command;
import seedu.duke.data.Block;
import seedu.duke.exception.InvalidBlockException;
import seedu.duke.ui.NoteUi;

public class AddNoteCommand extends Command {

    protected NoteUi ui;
    private static final String MESSAGE_SUCCESS = "Got it! Successfully added and tagged note to %s";

    public AddNoteCommand() {
        this.ui = new NoteUi();
    }

    @Override
    public void execute() {
        try {
            String[] noteInfo = ui.getNoteInfo();
            if (nusMap.isValidBlock(noteInfo[0])) {
                Block block = nusMap.getBlock(noteInfo[0]);
                block.addNote(noteInfo[1]);
                ui.showMessageWithDivider(String.format(MESSAGE_SUCCESS, noteInfo[0]));
            } else {
                throw new InvalidBlockException();
            }
        } catch (InvalidBlockException e) {
            ui.showMessageWithDivider(e.getMessage());
        }
    }
}
