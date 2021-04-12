package seedu.duke.data;

import seedu.duke.exception.EmptyNoteException;
import seedu.duke.exception.InvalidIndexException;
import seedu.duke.exception.InvalidNoteException;

import java.util.ArrayList;

/**
 * Represents a location in the {@link NusMap}.
 */
public class Block {

    private String name;
    private boolean isVisited;
    private ArrayList<Block> neighbours;
    private ArrayList<String> notes;
    private int distanceFromStart;

    public Block(String name) {
        this.name = name;
        this.isVisited = false;
        this.neighbours = new ArrayList<>();
        this.notes = new ArrayList<>();
        this.distanceFromStart = 0;
    }

    /** Returns the name of the block. */
    public String getName() {
        return name;
    }

    /** Checks whether the block has been visited. */
    public boolean isVisited() {
        return isVisited;
    }

    /** Sets the block as visited. */
    public void setAsVisited() {
        this.isVisited = true;
    }

    /** Sets the block as not visited. */
    public void setAsNotVisited() {
        this.isVisited = false;
    }


    /**
     * Checks whether two blocks are the same.
     *
     * @param block the block to be compared
     * @return true if the block have the same name.
     */
    public boolean isSameBlock(Block block) {
        return this.name.equals(block.name);
    }

    /**
     * Adds new neighbour to a block.
     *
     * @param block neighbouring block.
     */
    public void addNeighbour(Block block) {
        neighbours.add(block);
    }

    /** Returns a list of neighbouring blocks. */
    public ArrayList<Block> getNeighbours() {
        return neighbours;
    }

    /** Returns list of notes tagged to the block. */
    public ArrayList<String> getNotes() {
        return notes;
    }

    public int getDistanceFromStart() {
        return distanceFromStart;
    }


    public void setDistanceFromStart(int distanceFromStart) {
        this.distanceFromStart = distanceFromStart;
    }


    /**
     * Adds note about a block.
     *
     * @param note note to be added
     * @throws InvalidNoteException if the note is empty
     */
    public void addNote(String note) throws InvalidNoteException {
        if (note.isBlank() || note.contains("/")) {
            throw new InvalidNoteException();
        }
        this.notes.add(note);
    }

    /**
     * Deletes note tagged to a block.
     *
     * @param index the note number to be deleted
     * @throws InvalidIndexException if the index is out of bounds of the note list
     */
    public void deleteNote(int index) throws InvalidIndexException {
        try {
            notes.remove(index);
            assert (index >= 0 & index <= notes.size()) : "Index is out of bounds";
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidIndexException();
        }
    }
}
