package seedu.duke.routing;

import seedu.duke.Block;

import java.util.HashMap;

public class Map {
    HashMap<String, Block> map;

    public Map() {
        this.map = new HashMap<>();
    }

    public Block getBlock(String name) {
        return map.get(name);
    }

    public void addBlock(String name) {
        map.put(name, new Block(name));
    }

    public void addRelationship(String a, String b) {
        map.get(a).addNeighbour(map.get(b));
        map.get(b).addNeighbour(map.get(a));
    }
}
