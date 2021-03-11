package seedu.duke;

public class Block {
    private String name;
    private boolean isVisited;

    public Block(String name) {
        this.name = name;
        this.isVisited = false;
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
}
