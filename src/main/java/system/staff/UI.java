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



}
