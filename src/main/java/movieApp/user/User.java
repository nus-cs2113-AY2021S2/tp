package movieApp.user;

import java.io.Serializable;

public class User implements Serializable {

    private String name;
    private String password;
    private String userType;

    /**
     * Class constructor.
     */
    public User(String name, String password, String userType) {
        this.name = name;
        this.password = password;
        this.userType = userType;
    }

    /**
     * Returns the name of the user, for display purposes
     *
     * @return a String containing the name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user, according to input
     *
     * @param name a String containing the name to be set for a user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the password of the user, for operational purposes
     *
     * @return a String containing the password of the user,
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password type of the user, according to input
     *
     * @param password a String containing the password to be set for a user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the user type of the user, for operational and display purposes
     *
     * @return a String containing the type of user, can be "Customer" or "Admin"
     */
    public String getUserType() {
        return userType;
    }

    /**
     * Sets the user type of the user, according to input
     *
     * @param userType a String containing the type of user, should only be "Customer" or "Admin"
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

}
