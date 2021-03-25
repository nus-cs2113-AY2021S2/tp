package seedu.duke;

import java.util.ArrayList;

import static seedu.duke.NotesCommandParser.location;
import static seedu.duke.NotesCommandParser.note;
import static seedu.duke.NotesCommandParser.noteIndexInList;

public class Block {

    private String name;
    private boolean isVisited;
    private ArrayList<Block> neighbours;
    private ArrayList<String> notesList;
    private int notesCount;
    private int distanceFromStart;


    public Block(String name) {
        this.name = name;
        this.isVisited = false;
        this.neighbours = new ArrayList<>();
        this.notesList = new ArrayList<>();
        this.notesCount = 0;
        this.distanceFromStart = 0;
    }

    public String getName() {
        return name;
    }
    public int getNotesCount() {
        return notesCount;
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

    public void addNotes() {
        this.notesList.add(note); //add notes to list for that location
        this.notesCount++; //add to count for number of notes made for that location
        System.out.println("This note has been added and tagged to " + location + ":");
        System.out.println("\t" + note);
    }

    public void deleteNotes() {
        final String deletedNote = this.notesList.get(noteIndexInList); //record down deleted note

        this.notesList.remove(noteIndexInList); //remove note using given Note Index from list
        this.notesCount--; //reduce count for number of notes made for that location
        System.out.println("This note tagged to " + location + " has been deleted:");
        System.out.println("\t" + deletedNote);
    }

    public void listNotes() {
        int currentNoteIndex = 0;
        //Print all notes
        for (String currentNote: notesList) {
            System.out.print("\t");
            currentNoteIndex++;
            System.out.print(currentNoteIndex + ". ");
            System.out.println(currentNote);
        }
        //If no notes for current location, tell user
        if (currentNoteIndex == 0) {
            System.out.println("No notes are tagged to this location.");
        }
    }

    public ArrayList<Block> getNeighbours() {
        return neighbours;
    }

    public int getDistanceFromStart() {
        return distanceFromStart;
    }

    public void setDistanceFromStart(int distanceFromStart) {
        this.distanceFromStart = distanceFromStart;
    }
}
