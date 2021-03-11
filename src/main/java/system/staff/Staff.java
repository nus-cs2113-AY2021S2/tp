package system.staff;

import java.util.ArrayList;

import static system.staff.Parser.addFunctionParser;
import static system.staff.UI.prettyPrint;

public class Staff {
    private static ArrayList<Staff> list = new ArrayList<>();
    protected static int numStaff = 0;
    protected String id;
    protected String name;
    protected String age;
    protected String specialisation;

    public Staff(String[] list){

        this.id = list[0];
        this.name = list[1];
        this.age = list[2];
        this.specialisation = list[3];
    }

    //Need to implement addNurse and addDoctor if the parameters will be changed

    public static void addStaff(Staff staff) {
        list.add(staff);
        numStaff++;
    }

    public static void add(String line) {
        String[] array = addFunctionParser(line);
        Staff staff = new Staff(array);
        addStaff(staff);
        UI.hiredOutput(line);
    }

    public static void print(){
        for (Staff staff: list){
            System.out.println(
                    prettyPrint(staff.getId(), 10) + " " + prettyPrint(staff.getName(), 10) + " "
                            + prettyPrint(staff.getAge(),5) + " " + prettyPrint(staff.getSpecialisation(), 20));
        }
    }
    protected static ArrayList getList(){
        return list;
    }

    public static void listNurse(){
        for (Staff staff: list){
            if (staff.getType().equals("N")) {
                System.out.println(
                        prettyPrint(staff.getId(), 10) + " " + prettyPrint(staff.getName(), 10) + " "
                                + prettyPrint(staff.getAge(), 5) + " " + prettyPrint(staff.getSpecialisation(), 20));
            }
        }
    }
    public static void listDoctor(){
        for (Staff staff: list){
            if (staff.getType().equals("D")) {
                System.out.println(
                        prettyPrint(staff.getId(), 10) + " " + prettyPrint(staff.getName(), 10) + " "
                                + prettyPrint(staff.getAge(), 5) + " " + prettyPrint(staff.getSpecialisation(), 20));
            }
        }
    }

    public static void delete(String line) {
        int i = 0;
        for (Staff staff: list){
            if (staff.getId().equals(line.split(" ")[1])) {
                list.remove(i);
                numStaff--;
            }
            i++;
        }
        System.out.println(line.split(" ")[1] + " has been fired.");
    }


    public String getName() {
        return name;
    }
    public String getAge() {
        return age;
    }
    public String getSpecialisation() {
        return specialisation;
    }
    public String getId() {
        return id;
    }
    public String getType() {
        return this.id.substring(0,1);
    }


}
