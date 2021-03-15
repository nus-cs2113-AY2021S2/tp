package admin;

import exceptions.DukeExceptions;
import admin.AdminVerification;
import org.junit.jupiter.api.Test;
import ui.Ui;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AdminVerificationTest {

    private static String actualPassword = "Password";
    private static String inputPassword = null;

    @Test
    public void testAdminPassword() {
        assertEquals("Wrong Password!",verifyInputPassword());
    }

    public static String verifyInputPassword() {

        try {
            String inputPassword = "wrong password";
            if (!(inputPassword.equals(actualPassword))) {
                throw new DukeExceptions("Wrong Password!");
            }
        } catch (DukeExceptions e) {
            return e.getMessage();
        }
        return "Password is correct!";
    }
}