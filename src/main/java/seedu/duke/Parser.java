package seedu.duke;

import exceptions.InvalidSearchException;

//@@chenling

/**
 * This class deals with user input commands.
 */
public class Parser {

    /**
     * This function handles input of the search facilityType/id command and returns the user input for facilityType
     * @param userInput the user input command
     * @return String, name of the facility type
     * @throws InvalidSearchException if the there are some parameters missing or if the syntax of the command is wrong
     */
    public static String getFacilitySearch(String userInput) throws InvalidSearchException {
        if (userInput.length() < 7) {
            throw new InvalidSearchException("No parameters provided for search function :(");
        }
        int index = userInput.indexOf('/');
        if (index == -1) {
            throw new InvalidSearchException(
                    "Invalid syntax for search!!! It must be: \"search facilityType/facilityId\"");
        }
        String facility = userInput.substring(7, index);
        return facility;
    }

    /**
     * This function handles input of the search facilityType/id command and returns the user input for facility ID
     * @param userInput  the user input command
     * @return String, name of the facilityid
     * @throws InvalidSearchException if the there are some parameters missing or if the syntax of the command is wrong
     */
    public static int getIdSearch(String userInput) throws InvalidSearchException {
        int index = userInput.indexOf('/');
        if (index == -1) {
            throw new InvalidSearchException(
                    "Invalid syntax for search!!! It must be: \"search facilityType/facilityId\"");
        }
        String searchIdString = userInput.substring(index + 1);
        try {
            return Integer.parseInt(searchIdString);
        } catch (NumberFormatException exception) {
            throw new InvalidSearchException(String.format("facilityId provided to search must be an integer! "
                    + "\"%s\" is not a valid integer.", searchIdString));
        }

    }

    /**
     * This function handles user input for the search in building_name command and returns the user input for the buiding name
     * @param userInput the user input command
     * @return building name
     */
    public static String getBuildingName(String userInput) {
        return userInput.substring(9).strip();
    }

    /**
     * This function handles input of the findFacility<facility><facility_type><top k> command and returns the user input for facility
     * @param userInput the user input command
     * @return facility name
     * @throws NumberFormatException if the there are some parameters missing or if the syntax of the command is wrong
     * @throws StringIndexOutOfBoundsException if the there are some parameters missing or if the syntax of the command is wrong
     */
    public static String getFindFacilityLocation(String userInput) {
        try{
            int index1 = userInput.indexOf('<');
            int index2 = userInput.indexOf('>');
            String location = userInput.substring(index1 + 1, index2);
            return location;
        }catch (NumberFormatException e){
            String errMsg="please try again! remember to input location name, the facility name that you want to look for and the number of nearest facilities you are searching for \nFor example:findFacility<library1><Canteen><2> ";
            System.out.println(errMsg);
        }catch (StringIndexOutOfBoundsException e){
            String errMsg="please try again! remember to input location name, the facility name that you want to look for and the number of nearest facilities you are searching for \nFor example:findFacility<library1><Canteen><2> ";
            System.out.println(errMsg);
        }
        return null;

    }

    /**
     * This function handles input of the findFacility<facility><facility_type><top k> command and returns the user input for facilityType
     * @param userInput the user input command
     * @return facilityType
     * @throws NumberFormatException if the there are some parameters missing or if the syntax of the command is wrong
     * @throws StringIndexOutOfBoundsException if the there are some parameters missing or if the syntax of the command is wrong
     */
    public static String getFindFacilityType(String userInput) {
        try{
            int index1 = userInput.indexOf('>');
            String substring = userInput.substring(index1 + 1);
            int index2 = substring.indexOf('<');
            int index3 = substring.indexOf('>');
            String facilityType = substring.substring(index2 + 1, index3);
            return facilityType;
        }catch(NumberFormatException e){
            String errMsg="please try again! remember to input location name, the facility name that you want to look for and the number of nearest facilities you are searching for \nFor example:findFacility<library1><Canteen><2> ";
            System.out.println(errMsg);
        }catch(StringIndexOutOfBoundsException e){
            String errMsg="please try again! remember to input location name, the facility name that you want to look for and the number of nearest facilities you are searching for \nFor example:findFacility<library1><Canteen><2> ";
            System.out.println(errMsg);
        }
        return null;
    }

    /**
     * This function handles input of the findFacility<facility><facility_type><top k> command and returns the user input for top K
     * @param userInput the user input command
     * @return int topK
     * @throws NumberFormatException if the there are some parameters missing or if the syntax of the command is wrong
     * @throws StringIndexOutOfBoundsException if the there are some parameters missing or if the syntax of the command is wrong
     */
    public static int getTopK(String userInput) {
       try{
            int index1 = userInput.indexOf('>');
            String substring1 = userInput.substring(index1 + 1);
            int index2 = substring1.indexOf('>');
            String substring2 = substring1.substring(index2 + 1);
            int index3 = substring2.indexOf('<');
            int index4 = substring2.indexOf('>');
            String stringTopK = substring2.substring(index3 + 1, index4);
            int topK = Integer.parseInt(stringTopK);
            if(topK<=0){
                System.out.println("Please input a positive integer!");
            }
            return topK;
        }catch (NumberFormatException e){
           String errMsg="please try again! remember to input location name, the facility name that you want to look for and the number of nearest facilities you are searching for \nFor example:findFacility<library1><Canteen><2> ";
           System.out.println(errMsg);
        }catch(StringIndexOutOfBoundsException e){
            String errMsg="please try again! remember to input location name, the facility name that you want to look for and the number of nearest facilities you are searching for \nFor example:findFacility<library1><Canteen><2> ";
            System.out.println(errMsg);
        }
        return 0;

    }

    /**
     * This function handles input of the listAllLocations<facility_type> command and returns the user input for facility_type
     * @param userInput the user input command
     * @return facility_type
     * @throws StringIndexOutOfBoundsException if the syntax of the user input command is invalid
     */
    public static String getLocationsList(String userInput) {
        try{
            int index1 = userInput.indexOf('<');
            int index2 = userInput.indexOf('>');
            String location = userInput.substring(index1 + 1, index2);
            return location;
        }catch (StringIndexOutOfBoundsException e) {
            String errMsg = "please try again! remember to input the facility name in <>. \nFor example: listAllLocations<Canteen>";
            System.out.println(errMsg);
        }
        return null;
    }

    /**
     * Check if the user input command is of type: listAllLocations<facility_type>
     * @param userInput user input command
     * @return boolean, true if the command is of type: listAllLocations<facility_type>
     */
    public static boolean isList(String userInput) {
        if (userInput.length() >= 16) {
            return userInput.startsWith("listAllLocations");
        }
        return false;
    }

    /**
     * Check if the user input command is of type: search facilityType/id
     * @param userInput user input command
     * @return boolean, true if the command is of type: search facilityType/id
     */
    public static boolean isSearch(String userInput) {
        if (userInput.length() >= 6) {
            return userInput.startsWith("search");
        }
        return false;
    }

    /**
     * Check if the user input command is of type: search in building_name
     * @param userInput user input command
     * @return boolean, true if the command is of type: search in building_name
     */
    public static boolean isSearchIn(String userInput) {
        if (userInput.length() >= 9) {
            return userInput.startsWith("search in");
        }
        return false;
    }

    /**
     * Check if the user input command is of type: findFacility<facility><facility_type><top k>
     * @param userInput user input command
     * @return boolean, true if the command is of type: findFacility<facility><facility_type><top k>
     */
    public static boolean isFind(String userInput) {
        if (userInput.length() >= 12) {
            return userInput.startsWith("findFacility");
        }
        return false;
    }

    /**
     * Check if the user input command is of type: bye
     * @param userInput user input command
     * @return boolean, true if the command is of type: bye
     */
    public static boolean isBye(String userInput) {
        return userInput.equalsIgnoreCase("bye");
    }


}
