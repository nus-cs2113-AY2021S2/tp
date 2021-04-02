//@@author KimIdeas8

package seedu.duke.command.notecommand;

import seedu.duke.command.Command;
import seedu.duke.exception.EmptyNoteException;
import seedu.duke.exception.InvalidBlockException;
import seedu.duke.ui.NoteUi;

import java.util.ArrayList;

public class ShowNoteCommand extends Command {

    protected NoteUi ui;

    public ShowNoteCommand() {
        this.ui = new NoteUi();
    }

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
