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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + name.hashCode();;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Block other = (Block) obj;
        if (name != other.name)
            return false;
        return true;
    }
}
