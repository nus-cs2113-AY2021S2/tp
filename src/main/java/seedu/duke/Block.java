package seedu.duke;

import java.util.ArrayList;

public class Block {
    private String name;
    private boolean isVisited;
    private ArrayList<Block> neighbours;

    public Block(String name) {
        this.name = name;
        this.isVisited = false;
        this.neighbours = new ArrayList<>();
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

    public boolean isSameBlock(Block block) {
        return this.name.equals(block.name);
    }

    public void addNeighbour(Block block) {
        neighbours.add(block);
    }

    public ArrayList<Block> getNeighbours() {
        return neighbours;
    }
}
