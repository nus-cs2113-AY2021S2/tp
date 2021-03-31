package seedu.model.staff;

public class Staff {

    protected String staffID;
    protected String name;
    protected int age;
    protected String specialisation;

    public Staff(String[] array) {
        this.staffID = array[0];
        this.name = array[1];
        this.age = Integer.parseInt(array[2]);
        this.specialisation = array[3];
    }

    public String getName() {
        if (this.name == null) {
            return "-";
        }
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getSpecialisation() {
        if (this.specialisation == null) {
            return "-";
        }
        return this.specialisation;
    }

    public String getId() {
        if (this.staffID == null) {
            return "-";
        }
        return this.staffID;
    }

    public String getType() {
        return this.staffID.substring(0, 1);
    }

    public String formWriteData() {
        return (this.staffID + "|" + this.name + "|"
                + this.age + "|" + this.specialisation + "\n");
    }

}
