package seedu.duke.exceptions;

public class WrongLoginInfoException extends Exception {
    public static final String WRONG_LOGIN_INFO = "Wrong Email Address and/or Password. Please try again!";

    public WrongLoginInfoException() {
        super(WRONG_LOGIN_INFO);
    }
}
