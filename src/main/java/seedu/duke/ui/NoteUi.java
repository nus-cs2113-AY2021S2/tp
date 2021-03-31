package seedu.duke.ui;

import seedu.duke.exception.EmptyNoteException;
import seedu.duke.exception.InvalidIndexException;

import java.util.ArrayList;

public class NoteUi extends UiManager {

    public String[] getNoteInfo() {
        String[] noteInfo = new String[2];
        showMessage("Enter Location:");
        noteInfo[0] = getUserInput().toUpperCase();

        showMessage("Enter the Note:");
        noteInfo[1] = getUserInput();

        showMessage(CommonMessage.DIVIDER);
        return noteInfo;
    }

    public String getBlockInfo() {
        showMessage("Enter Location:");
        return getUserInput().toUpperCase();
    }

    public void showNotes(ArrayList<String> notes) throws EmptyNoteException {
        showMessage(CommonMessage.DIVIDER, "Here is the list of notes:");
        if (notes.isEmpty()) {
            throw new EmptyNoteException();
        }
        for (int i = 0; i < notes.size(); i++) {
            showMessage((i + 1) + ". " + notes.get(i));
        }
        showMessage(CommonMessage.DIVIDER);
    }

    public int getDeleteIndex() throws InvalidIndexException {
        try {
            showMessage("Select Entry to delete:");
            int deleteIndex = Integer.parseInt(getUserInput());
            showMessage(CommonMessage.DIVIDER);
            return deleteIndex;
        } catch (NumberFormatException e) {
            throw new InvalidIndexException();
        }
    }
}
