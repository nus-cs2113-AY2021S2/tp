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
        String deleteBlock = ui.getBlockInfo();
        try {
            nusMap.checkIfValidBlock(deleteBlock);
            Block block = nusMap.getBlock(deleteBlock);
            ui.showNotes(nusMap.getBlock(deleteBlock).getNotes());
            int deleteIndex = ui.getDeleteIndex();
            block.deleteNote(deleteIndex - 1);
            ui.showMessageWithDivider(String.format(MESSAGE_SUCCESS, deleteBlock));
        } catch (EmptyNoteException e) {
            ui.showMessageWithDivider(String.format(MESSAGE_SUCCESS, deleteBlock));
        } catch (InvalidIndexException | InvalidBlockException e) {
            ui.showMessageWithDivider(e.getMessage());
        }
    }
}
