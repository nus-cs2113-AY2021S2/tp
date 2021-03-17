package system.staff;

public class UI {


    public static void hiredOutput(String line) {
        if (line.split(" ")[1].charAt(0) == 'D') {
            System.out.println("Doctor " + line.split(" ")[2] + " hired!");
        }
        else if (line.split(" ")[1].charAt(0) == 'N') {
            System.out.println("Nurse " + line.split(" ")[2] + " hired!");
        }
    }


    public static String prettyPrint(String string, int length) {
        return String.format("%1$-" + length + "s", string);
    }



    public static String repeat(int count, String with) {
        return new String(new char[count]).replace("\0", with);
    }

    public static void printLine() {
        System.out.println(repeat(45, "-"));
    }

    public static void staffHeader() {
        System.out.println(
                prettyPrint("ID", 10) + " " + prettyPrint("Name", 10) + " "
                        + prettyPrint("Age",5) + " " + prettyPrint("Specialisation", 20));
    }

    public static void printStaffHelpList() {
        System.out.println("Here is a list of Staff commands: ");
        System.out.println("\"help\" brings up this list of commands!");
        System.out.println("\"add [Staff ID] [Name] [Age] [Specialisation]\" adds a Staff to the staff list!");
        System.out.println("\"list\" brings up the list of all current staff!");
        System.out.println("\"delete [Staff ID]\" deletes the staff with the specified ID from the list!");
        System.out.println("\"find [keyword or phrase]\" finds a keyword or phrase and shows its corresponding staff!");
        System.out.println("\"return\" returns you to the Start Menu!");
    }



}
