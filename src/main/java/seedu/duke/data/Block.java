package seedu.duke.data;

import seedu.duke.exception.EmptyNoteException;
import seedu.duke.exception.InvalidIndexException;
import seedu.duke.exception.InvalidNoteException;

import java.util.ArrayList;

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

    public String getName() {
        return name;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setAsVisited() {
        this.isVisited = true;
    }

    public void setAsNotVisited() {
        this.isVisited = false;
    }

    public boolean isSameBlock(Block block) {
        return this.name.equals(block.name);
    }

    public void addNeighbour(Block block) {
        neighbours.add(block);
    }

    public ArrayList<Block> getNeighbours() {
        return neighbours;
    }

    public ArrayList<String> getNotes() {
        return notes;
    }

    public int getDistanceFromStart() {
        return distanceFromStart;
    }

    public void setDistanceFromStart(int distanceFromStart) {
        this.distanceFromStart = distanceFromStart;
    }

    public void addNote(String note) throws InvalidNoteException {
        if (note.isBlank()) {
            throw new InvalidNoteException();
        }
        this.notes.add(note);
    }

    public void deleteNote(int index) throws InvalidIndexException {
        try {
            notes.remove(index);
            assert (index >= 0 & index <= notes.size()) : "Index is out of bounds";
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidIndexException();
        }
    }
}
