package seedu.duke.routing;

import seedu.duke.Block;

import java.util.HashMap;

public class Map {
    HashMap<String, Block> map;

    public Map() {
        this.map = new HashMap<>();
        initValidBlocks();
        initNeighbouringBlocks();
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

    public void initValidBlocks(){
        addBlock("E1");
        addBlock("E1A");
        addBlock("E2");
        addBlock("E2A");
        addBlock("E3");
        addBlock("E3A");
        addBlock("E4");
        addBlock("E4A");
        addBlock("E5");
        addBlock("E6");
        addBlock("E7");
        addBlock("EA");
        addBlock("EW1");
        addBlock("EW1A");
        addBlock("EW2");
        addBlock("LT1");
        addBlock("LT2");
        addBlock("LT5");
        addBlock("LT6");
        addBlock("LT7");
        addBlock("LT7A");
        addBlock("IT");
        addBlock("T-LAB");
        addBlock("TECHNO EDGE");
        addBlock("AS1");
    }

    public void initNeighbouringBlocks(){
        addRelationship("EW1", "E1");
        addRelationship("E1", "LT5");
        addRelationship("E1", "E1A");
        addRelationship("E1", "E2");
        addRelationship("LT5", "TECHNO EDGE");
        addRelationship("E1A", "EA");
        addRelationship("EA", "EW1A");
        addRelationship("EA", "LT7A");
        addRelationship("EA", "LT7");
        addRelationship("E2", "E1A");
        addRelationship("E2", "EA");
        addRelationship("E2", "E2A");
        addRelationship("E2", "LT1");
        addRelationship("E2", "LT2");
        addRelationship("LT5", "E3");
        addRelationship("E3", "LT6");
        addRelationship("E2", "E3");
        addRelationship("E3", "T-LAB");
        addRelationship("E3", "E4");
        addRelationship("E4", "E5");
        addRelationship("E4", "E4A");
        addRelationship("E5", "IT");
        addRelationship("EA", "E3A");
        addRelationship("E4A", "EW2");
        addRelationship("EW2", "E6");
        addRelationship("E6", "E7");

    }
}
