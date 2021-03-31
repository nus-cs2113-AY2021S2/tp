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
            nusMap.checkIfValidBlock(noteInfo[0]);
            nusMap.getBlock(noteInfo[0]).addNote(noteInfo[1]);
            ui.showMessageWithDivider(String.format(MESSAGE_SUCCESS, noteInfo[0]));
        } catch (InvalidBlockException e) {
            ui.showMessageWithDivider(e.getMessage());
        }
    }
}
