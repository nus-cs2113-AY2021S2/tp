package seedu.model.staff;

/**
 * Staff class contains the information of a Staff working in a hospital.
 */
public class Staff {

    protected String staffID;
    protected String name;
    protected int age;
    protected String specialisation;

    /**
     * Constructor for Staff object.
     *
     * @param array Array of inputs for Staff object.
     */
    public Staff(String[] array) {
        this.staffID = array[0];
        this.name = array[1];
        this.age = Integer.parseInt(array[2]);
        this.specialisation = array[3];
    }

    /**
     * Returns name of Staff object.
     *
     * @return name of Staff object.
     */
    public String getName() {
        if (this.name == null) {
            return "-";
        }
        return this.name;
    }

    /**
     * Returns age of Staff object.
     *
     * @return age of Staff object.
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Returns specialisation of Staff object.
     *
     * @return specialisation of Staff object.
     */
    public String getSpecialisation() {
        if (this.specialisation == null) {
            return "-";
        }
        return this.specialisation;
    }

    /**
     * Returns Staff ID of Staff object.
     *
     * @return Staff ID of Staff object.
     */
    public String getId() {
        if (this.staffID == null) {
            return "-";
        }
        return this.staffID;
    }

    /**
     * Returns Staff type ("N"/"D") of Staff object.
     *
     * @return Staff type of Staff object.
     */
    public String getType() {
        return this.staffID.substring(0, 1);
    }

    /**
     * Returns a String with all Staff object fields to store data in text files.
     *
     * @return String with all Staff object fields.
     */
    public String formWriteData() {
        return (this.staffID + "|" + this.name + "|"
                + this.age + "|" + this.specialisation + "\n");
    }

}
