package seedu.duke.command.notecommand;

import seedu.duke.command.Command;
import seedu.duke.exception.EmptyNoteException;
import seedu.duke.exception.InvalidBlockException;
import seedu.duke.ui.NoteUi;

import java.util.ArrayList;

public class ListNoteCommand extends Command {

    protected NoteUi ui;

    public ListNoteCommand() {
        this.ui = new NoteUi();
    }

    @Override
    public void execute() {
        String listInfo = ui.getBlockInfo();
        try {
            if (nusMap.isValidBlock(listInfo)) {
                ArrayList<String> notes = nusMap.getBlock(listInfo).getNotes();
                ui.showNotes(notes);
            } else {
                throw new InvalidBlockException();
            }
        } catch (EmptyNoteException e) {
            ui.showMessageWithDivider(String.format(e.getMessage(), listInfo));
        } catch (InvalidBlockException e) {
            ui.showMessageWithDivider(e.getMessage());
        }
    }

}
