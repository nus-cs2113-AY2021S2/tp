//@@author KimIdeas8

package seedu.duke.command.notecommand;

import seedu.duke.command.Command;
import seedu.duke.data.Block;
import seedu.duke.exception.EmptyNoteException;
import seedu.duke.exception.InvalidBlockException;
import seedu.duke.exception.InvalidIndexException;
import seedu.duke.ui.NoteUi;

public class DeleteNoteCommand extends Command {

    protected NoteUi ui;
    private static final String MESSAGE_SUCCESS = "Got it! Successfully deleted note tagged to %s";

    public DeleteNoteCommand() {
        this.ui = new NoteUi();
    }

    @Override
    public void execute() {
        String deleteBlockInfo = ui.getBlockInfo();
        try {
            nusMap.checkIfValidBlock(deleteBlockInfo);
            Block block = nusMap.getBlock(deleteBlockInfo);
            ui.showNotes(block.getNotes());
            int deleteIndex = ui.getDeleteIndex();
            block.deleteNote(deleteIndex - 1);
            assert (deleteIndex > 0 & deleteIndex <= nusMap.getBlock(deleteBlockInfo).getNotes().size()) :
                    "Index is out of bounds";
            ui.showMessageWithDivider(String.format(MESSAGE_SUCCESS, deleteBlockInfo));
        } catch (EmptyNoteException e) {
            ui.showMessageWithDivider(String.format(e.getMessage(), deleteBlockInfo));
        } catch (InvalidIndexException | InvalidBlockException e) {
            ui.showMessageWithDivider(e.getMessage());
        }
    }
}
