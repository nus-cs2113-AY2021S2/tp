package control;

import java.util.ArrayList;
import java.util.List;

import entity.Facility;
import entity.Location;
import exceptions.FacilityNotFoundException;

//@author geezzzyyy

/**
 * This class implements the main functionality of find top K nearest facility.
 */
public class FindNearest {
    private static FileManager dataController;
    public FindNearest(FileManager dataController) {
        this.dataController = dataController;
    }

    /**
     * This function searches a user inputted facility from all our existing facility and returns the facility found.
     * If facility not found, there will be an error message.
     * @param facilityLocation the user input facility name
     * @return Facility the facility object found
     * @throws FacilityNotFoundException if the user inputted invalid facility that does not match with any of our existing facilities
     */
    public static Facility findFacilityByName(String facilityName) throws FacilityNotFoundException {

        for (Facility f: FileManager.getLibraries()) {
            if (f.getName().equals(facilityName)) {
                return f;
            }
        }
        for (Facility f: FileManager.getCanteens()) {
            if (f.getName().equals(facilityName)) {
                return f;
            }
        }
        for (Facility f: FileManager.getLectureTheaters()) {
            if (f.getName().equals(facilityName)) {
                return f;
            }
        }
        throw new FacilityNotFoundException("Your current location: " + facilityName + " does not exist");
    }

    /**
     * This function search for a specific fype of facility near user's current location.
     * It returns the top K nearest facility of this type.
     * @param currentLocation the current of the user
     * @param facilityType type of the facility to look for
     * @param topK top K nearest facility
     * @throws FacilityNotFoundException if the input facilityType is invalid.
     * @throws ArrayIndexOutOfBoundsException if top K nearest facility cannot be found as K is larger than the number of existing facilities
     */
    public static void findTopKFacility(Location currentLocation, String facilityType, int topK) throws FacilityNotFoundException {

        List<Facility> facilityList = new ArrayList<Facility>();
        switch (facilityType.toUpperCase()) {
        case "CANTEEN":
            facilityList = new ArrayList<Facility>(dataController.getCanteens());
            break;
        case "LIBRARY":
            facilityList = new ArrayList<Facility>(dataController.getLibraries());
            break;
        case "LECTURETHEATER":
            facilityList = new ArrayList<Facility>(dataController.getLectureTheaters());
            break;
        default:
            throw new FacilityNotFoundException(
                    "Invalid Facility type! please choose from CANTEEN, LIBRARY and LECTURETHEATER");
        }
        if (topK > facilityList.size()) {
            throw new ArrayIndexOutOfBoundsException("Unable to find top" + topK + "! "
                    + "There are only " + facilityList.size() + " " + facilityType + " available");
        } else {
            for (int i = 0; i < topK; i++) {
                int minIndex = 0;

                for (int j = 1; j < facilityList.size(); j++) {
                    double newDistance = facilityList.get(j).getLocation().distanceTo(currentLocation);
                    double shortestDistance = facilityList.get(minIndex).getLocation().distanceTo(currentLocation);
                    if (newDistance < shortestDistance) {
                        minIndex = j;
                    }
                }
                Facility facilityFound = facilityList.get(minIndex);
                System.out.println(facilityFound.getName() + "@" + facilityFound.getLocation().getAddress());
                facilityList.remove(minIndex);
            }
        }
    }
}
