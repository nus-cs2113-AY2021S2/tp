package seedu.duke.login;

/**
 * This class is responsible for modelling Login Information which contains the
 * attributes and methods of each LoginInfo Object.
 * from a particular user logging into MojoHr
 */
public class LoginInfo {
    /**
     * A string declared as userId represents the email address entered during the user login process.
     */
    private String userId;
    /**
     * A string declared as password represents the password entered from the user logging in.
     */
    private String password;

    /**
     * Constructor which constructs the LoginInfo object.
     * @param userId The email address entered by the user during the login process
     * @param password The password entered by the user during the login process
     */
    public LoginInfo(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    /**
     * password password to set.
     * @param password Password used for Log in
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *Gets the password.
     * @return String representing the password of the {@LoginInfo} object
     */
    public String getPassword() {
        return password;
    }

    /**
     *Gets the email address.
     * @return String representing the email address of the {@LoginInfo} object
     */
    public String getUserId() {
        return userId;
    }

    public String strAddToTxt() {
        return getUserId() + " | " + getPassword();
    }

    /**
     *checks the two object of LoginInfo objects.
     * @param obj The object which will be evaluated
     * @return The boolean value representing whether or not the parameter is a {@code LoginInfo} object and if it is,
     *          whether or not this LoginInfo object matches {@LoginInfo} object within the method's parameters
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LoginInfo) {
            LoginInfo loginInfoObj = (LoginInfo) obj;
            return getUserId().equals(loginInfoObj.getUserId())
                    && getPassword().equals(loginInfoObj.getPassword());
        }

        return false;
    }


}
