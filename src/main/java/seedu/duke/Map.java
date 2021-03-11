package seedu.duke;

import java.util.HashMap;

public class Map {
    HashMap<String, Location> map;

    public Map() {
        this.map = new HashMap<>();
    }

    public Location getLocation(String name) {
        return map.get(name);
    }

    public void addLocation(Block block) {
        map.put(block.getName(), new Location(block));
    }

    public void addRelationship(String a, String b) {
        map.get(a).addNeighbour(map.get(b).getBlock());
        map.get(b).addNeighbour(map.get(a).getBlock());
    }
}
