package entity;
//@@author zhangyongzhe20
public abstract class Facility {
    private int facilityID;
    private String name;
    private entity.FacilityType type;
    private Location location;
    private Location address;

    /**
     * Facility Constructor
     * @param facilityID
     * @param name
     * @param location
     * @param address
     * @param type
     */
    public Facility(int facilityID, String name, Location location, Location address, entity.FacilityType type) {
        this.facilityID = facilityID;
        this.name = name;
        this.location = location;
        this.type = type;
        this.address = address;
    }

    public Facility() {

    }

    public int getFacilityID() {
        return facilityID;
    }

    public void setFacilityID(String facilityID) {
        this.facilityID = Integer.parseInt(facilityID);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public entity.FacilityType getType() {
        return type;
    }

    public Location getLocation() {
        return location;
    }
    public String getAddress() {
        return getLocation().getAddress();
    }

    public void setLocation(String x, String y, String address, String building) {
        this.location = new Location(Double.parseDouble(x), Double.parseDouble(y), address, building);
    }

    /**
     * Convert string to enum
     * @param type
     */
    public void strToFacilityType(String type) {
        if (type.equalsIgnoreCase("LECTURETHEATER")) {
            this.type = entity.FacilityType.LECTURETHEATER;
        } else if (type.equalsIgnoreCase("CANTEEN")) {
            this.type = entity.FacilityType.CANTEEN;
        } else if (type.equalsIgnoreCase("LIBRARY")) {
            this.type = entity.FacilityType.LIBRARY;
        }
    }

    /**
     * return string representation of this facility
     * @return string representation of facility
     */
    public String toString() {
        return this.facilityID + " (" + this.name + ")"
                + " is located at " + this.location.toString();
    }
}
