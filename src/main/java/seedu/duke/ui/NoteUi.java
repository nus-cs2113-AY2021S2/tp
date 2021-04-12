package seedu.duke.ui;

import seedu.duke.exception.EmptyNoteException;
import seedu.duke.exception.InvalidIndexException;
import seedu.duke.exception.InvalidNoteException;

import java.util.ArrayList;

public class NoteUi extends UiManager {


    /**
     * Prompts the user for the block name and the note description.
     *
     * @return the block name and note description
     */
    public String[] getNoteInfo() {
        String[] noteInfo = new String[2];
        showMessage("Enter Block:");
        noteInfo[0] = getUserInput().toUpperCase();

        showMessage("Enter the Note:");
        noteInfo[1] = getUserInput();

        showMessage(CommonMessage.DIVIDER);
        return noteInfo;
    }


    /** Return the block name inputted by the user. */
    public String getBlockInfo() {
        showMessage("Enter Block:");
        String block = getUserInput().toUpperCase();
        showMessage(CommonMessage.DIVIDER);
        return block;
    }


    /**
     * Generates and displays all the notes tagged to a particular block.
     *
     * @param notes the list of notes to be show to the user
     * @throws EmptyNoteException if there are no notes
     */
    public void showNotes(ArrayList<String> notes) throws EmptyNoteException {
        if (notes.isEmpty()) {
            throw new EmptyNoteException();
        }
        showMessage("Here is the list of notes:");
        for (int i = 0; i < notes.size(); i++) {
            showMessage((i + 1) + ". " + notes.get(i));
        }
        showMessage(CommonMessage.DIVIDER);
    }

    /**
     * Prompts the user for the index of the note to be deleted.
     *
     * @return the number of note to be deleted.
     * @throws InvalidIndexException if the input is not an integer
     */
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
