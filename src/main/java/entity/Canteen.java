package entity;

//@@author zhangyongzhe20
public class Canteen extends Facility {
    public Canteen(int facilityID, String name, Location location, Location address) {
        super(facilityID, name, location, address, entity.FacilityType.CANTEEN);
    }

    public Canteen() {
        super();
    }

    public Canteen(int facilityID, String name, Location location) {
        super(facilityID, name, location, location, entity.FacilityType.CANTEEN);
    }
}
