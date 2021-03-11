package seedu.duke;

import java.util.ArrayList;

public class Location {
    private Block block;
    private ArrayList<Block> neighbours;

    public Location(Block block) {
        this.block = block;
        this.neighbours = new ArrayList<>();
    }

    public Block getBlock() {
        return block;
    }

    public ArrayList<Block> getNeighbours() {
        return neighbours;
    }

    public void addNeighbour(Block block) {
        neighbours.add(block);
    }
}