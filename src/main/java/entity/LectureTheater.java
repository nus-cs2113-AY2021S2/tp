package entity;

//@@author zhangyongzhe20
public class LectureTheater extends Facility {
    public LectureTheater(int facilityID, String name, Location location, Location address) {
        super(facilityID, name, location, address, entity.FacilityType.LECTURETHEATER);
    }

    public LectureTheater() {

    }

    public LectureTheater(int facilityID, String name, Location location) {
        super(facilityID, name, location, location, entity.FacilityType.LECTURETHEATER);
    }
}
