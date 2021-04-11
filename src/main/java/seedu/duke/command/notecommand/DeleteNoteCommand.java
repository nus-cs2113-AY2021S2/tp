//@@author KimIdeas8

package seedu.duke.command.notecommand;

import seedu.duke.command.Command;
import seedu.duke.data.Block;
import seedu.duke.exception.EmptyNoteException;
import seedu.duke.exception.InvalidBlockException;
import seedu.duke.exception.InvalidIndexException;
import seedu.duke.ui.NoteUi;


/**
 * Execution for delete note command. A <code>DeleteNoteCommand</code> object corresponds to
 * a response to each input by the user for every 'delete notes' command.
 */
public class DeleteNoteCommand extends Command {

    protected NoteUi ui;
    private static final String MESSAGE_SUCCESS = "Got it! Successfully deleted note tagged to %s";

    public DeleteNoteCommand() {
        this.ui = new NoteUi();
    }

    /**
     * Removes notes from a block's list, based on user input of selected note, if note and block exists.
     * Returns error message if block doesn't exist or if note does not exist or index of note out of bounds.
     *
     */
    @Override
    public void execute() {
        String deleteBlockInfo = ui.getBlockInfo();
        try {
            nusMap.checkIfValidBlock(deleteBlockInfo);
            Block block = nusMap.getBlock(deleteBlockInfo);
            ui.showNotes(block.getNotes());
            int deleteIndex = ui.getDeleteIndex();
            block.deleteNote(deleteIndex - 1);
            ui.showMessageWithDivider(String.format(MESSAGE_SUCCESS, deleteBlockInfo));
        } catch (EmptyNoteException e) {
            ui.showMessageWithDivider(String.format(e.getMessage(), deleteBlockInfo));
        } catch (InvalidIndexException | InvalidBlockException e) {
            ui.showMessageWithDivider(e.getMessage());
        }
    }
}
