package control;

import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

import entity.Facility;
import exceptions.FacilityNotFoundException;

public class SearchFacility {
    //logger
    private static final Logger LOGGER = Logger.getLogger(SearchFacility.class.getName());
    private FileManager dataController;

    public SearchFacility(FileManager dataController) {
        this.dataController = dataController;
    }

    private Facility findCanteen(int facilityId, List<Facility> canteens) throws FacilityNotFoundException {
        for (Facility canteen : canteens) {
            if (canteen.getFacilityID() == facilityId) {
                return canteen;
            }
        }
        throw new FacilityNotFoundException("Aiyoh where got this canteen one");
    }

    private Facility findLibrary(int facilityId, List<Facility> libraries) throws FacilityNotFoundException {
        for (Facility library : libraries) {
            if (library.getFacilityID() == facilityId) {
                return library;
            }
        }
        throw new FacilityNotFoundException(
                String.format("Aiyoh where got \"%d\" this library one", facilityId));
    }

    private Facility findLectureTheater(int facilityId, List<Facility> lectureTheaters)
            throws FacilityNotFoundException {
        for (Facility lectureTheater : lectureTheaters) {
            if (lectureTheater.getFacilityID() == facilityId) {
                return lectureTheater;
            }
        }
        throw new FacilityNotFoundException(
                String.format("Aiyoh where got \"%d\" this lecture theater one", facilityId));
    }


    /**
     * Finds a facility of that type and ID, then prints out its address.
     * @param facilityType - type of facility
     * @param facilityId - ID of facility
     * @return boolean: true if facility found
     * @throws FacilityNotFoundException
     */
    public boolean query(String facilityType, int facilityId) throws FacilityNotFoundException {
        Facility facilityFound = null;
        switch (facilityType.toLowerCase(Locale.ROOT)) {
        case "canteen":
            facilityFound = this.findCanteen(facilityId, FileManager.getCanteens());
            break;
        case "library":
            facilityFound = this.findLibrary(facilityId, FileManager.getLibraries());
            break;
        case "lecturetheater":
            facilityFound = this.findLectureTheater(facilityId, FileManager.getLectureTheaters());
            break;
        default:
            throw new FacilityNotFoundException(String.format("Go die lah where got \"%s\" this kind of facility one",
                    facilityType));
        }
        System.out.println(
                String.format("%s (%d) is found at: %s", facilityType, facilityId, facilityFound.getAddress())
        );
        return true;
    }
}
