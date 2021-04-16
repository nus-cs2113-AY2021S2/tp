//@@author KimIdeas8

package seedu.duke.command.notecommand;

import seedu.duke.command.Command;
import seedu.duke.data.Block;
import seedu.duke.exception.InvalidBlockException;
import seedu.duke.exception.InvalidNoteException;
import seedu.duke.ui.NoteUi;

/**
 * Execution for add note command. A <code>AddNoteCommand</code> object corresponds to
 * a response to each input by the user for every 'add notes' command.
 */
public class AddNoteCommand extends Command {

    protected NoteUi ui;
    private static final String MESSAGE_SUCCESS = "Got it! Successfully added and tagged note to %s";

    public AddNoteCommand() {
        this.ui = new NoteUi();
    }

    /**
     * Adds notes to a block's list, based on user input.
     * Returns error message if block doesn't exist or user input is empty.
     *
     */
    @Override
    public void execute() {
        try {
            String[] noteInfo = ui.getNoteInfo();
            assert noteInfo[0] != null : "Block is not supposed to be null";
            assert noteInfo[1] != null : "Added note is not supposed to be null";
            nusMap.checkIfValidBlock(noteInfo[0]);
            nusMap.getBlock(noteInfo[0]).addNote(noteInfo[1]);
            ui.showMessageWithDivider(String.format(MESSAGE_SUCCESS, noteInfo[0]));
        } catch (InvalidBlockException | InvalidNoteException e) {
            ui.showMessageWithDivider(e.getMessage());
        }
    }
}
