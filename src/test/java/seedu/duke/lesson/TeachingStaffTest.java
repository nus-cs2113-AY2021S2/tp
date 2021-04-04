package seedu.duke.lesson;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TeachingStaffTest {
    // Emails taken from https://gist.github.com/cjaoude/fd9910626629b53c4d25.
    // Excluded strange emails and some others.
    static final String VALID_EMAIL1 = "email@example.com";
    static final String VALID_EMAIL2 = "firstname.lastname@example.com";
    static final String VALID_EMAIL3 = "email@subdomain.example.com";
    static final String VALID_EMAIL4 = "firstname+lastname@example.com";
    static final String VALID_EMAIL5 = "email@123.123.123.123";
    static final String VALID_EMAIL6 = "email@[123.123.123.123]";
    static final String VALID_EMAIL7 = "\"email\"@example.com";
    static final String VALID_EMAIL8 = "1234567890@example.com";
    static final String VALID_EMAIL9 = "email@example-one.com";
    static final String VALID_EMAIL10 = "_______@example.com";
    static final String VALID_EMAIL11 = "email@example.name";
    static final String VALID_EMAIL12 = "email@example.museum";
    static final String VALID_EMAIL13 = "email@example.co.jp";
    static final String VALID_EMAIL14 = "firstname-lastname@example.com";

    static final String INVALID_EMAIL1 = "plainaddress";
    static final String INVALID_EMAIL2 = "#@%^%#$@#$@#.com";
    static final String INVALID_EMAIL3 = "@example.com";
    static final String INVALID_EMAIL4 = "Joe Smith <email@example.com>";
    static final String INVALID_EMAIL5 = "email.example.com";
    static final String INVALID_EMAIL6 = "email@example@example.com";
    static final String INVALID_EMAIL7 = ".email@example.com";
    static final String INVALID_EMAIL8 = "email.@example.com";
    static final String INVALID_EMAIL9 = "email..email@example.com";
    static final String INVALID_EMAIL10 = "email@example.com (Joe Smith)";
    static final String INVALID_EMAIL11 = "email@example";
    static final String INVALID_EMAIL12 = "email@-example.com";
    static final String INVALID_EMAIL13 = "email@example..com";
    static final String INVALID_EMAIL14 = "Abc..123@example.com";

    @Test
    void isValidEmail_validEmailInput_expectTrue() {
        assertTrue(TeachingStaff.isValidEmail(VALID_EMAIL1));
        assertTrue(TeachingStaff.isValidEmail(VALID_EMAIL2));
        assertTrue(TeachingStaff.isValidEmail(VALID_EMAIL3));
        assertTrue(TeachingStaff.isValidEmail(VALID_EMAIL4));
        assertTrue(TeachingStaff.isValidEmail(VALID_EMAIL5));
        assertTrue(TeachingStaff.isValidEmail(VALID_EMAIL6));
        assertTrue(TeachingStaff.isValidEmail(VALID_EMAIL7));
        assertTrue(TeachingStaff.isValidEmail(VALID_EMAIL8));
        assertTrue(TeachingStaff.isValidEmail(VALID_EMAIL9));
        assertTrue(TeachingStaff.isValidEmail(VALID_EMAIL10));
        assertTrue(TeachingStaff.isValidEmail(VALID_EMAIL11));
        assertTrue(TeachingStaff.isValidEmail(VALID_EMAIL12));
        assertTrue(TeachingStaff.isValidEmail(VALID_EMAIL13));
        assertTrue(TeachingStaff.isValidEmail(VALID_EMAIL14));
    }

    @Test
    void isValidEmail_invalidEmailInput_expectFalse() {
        assertFalse(TeachingStaff.isValidEmail(INVALID_EMAIL1));
        assertFalse(TeachingStaff.isValidEmail(INVALID_EMAIL2));
        assertFalse(TeachingStaff.isValidEmail(INVALID_EMAIL3));
        assertFalse(TeachingStaff.isValidEmail(INVALID_EMAIL4));
        assertFalse(TeachingStaff.isValidEmail(INVALID_EMAIL5));
        assertFalse(TeachingStaff.isValidEmail(INVALID_EMAIL6));
        assertFalse(TeachingStaff.isValidEmail(INVALID_EMAIL7));
        assertFalse(TeachingStaff.isValidEmail(INVALID_EMAIL8));
        assertFalse(TeachingStaff.isValidEmail(INVALID_EMAIL9));
        assertFalse(TeachingStaff.isValidEmail(INVALID_EMAIL10));
        assertFalse(TeachingStaff.isValidEmail(INVALID_EMAIL11));
        assertFalse(TeachingStaff.isValidEmail(INVALID_EMAIL12));
        assertFalse(TeachingStaff.isValidEmail(INVALID_EMAIL13));
        assertFalse(TeachingStaff.isValidEmail(INVALID_EMAIL14));
    }
}