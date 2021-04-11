//@@author KimIdeas8

package seedu.duke.command.notecommand;

import seedu.duke.command.Command;
import seedu.duke.exception.EmptyNoteException;
import seedu.duke.exception.InvalidBlockException;
import seedu.duke.ui.NoteUi;

import java.util.ArrayList;

/**
 * Execution for show note command. A <code>ShowNoteCommand</code> object corresponds to
 * a response to each input by the user for every 'show notes' command.
 */
public class ShowNoteCommand extends Command {

    protected NoteUi ui;

    public ShowNoteCommand() {
        this.ui = new NoteUi();
    }

    /**
     * Shows notes from a block's list, based on user input of selected block, if block exists.
     * Returns error message if block doesn't exist or list of block is empty.
     *
     */
    @Override
    public void execute() {
        String showBlockInfo = ui.getBlockInfo();
        try {
            nusMap.checkIfValidBlock(showBlockInfo);
            ArrayList<String> notes = nusMap.getBlock(showBlockInfo).getNotes();
            ui.showNotes(notes);
        } catch (EmptyNoteException e) {
            ui.showMessageWithDivider(String.format(e.getMessage(), showBlockInfo));
        } catch (InvalidBlockException e) {
            ui.showMessageWithDivider(e.getMessage());
        }
    }

}
