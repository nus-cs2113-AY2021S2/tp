package seedu.allinonenus.moduleplanner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {
    private final Student alice = new Student("Alice", 1, true, 1);
    private final Student bob = new Student("Bob", 2, false, 2);

    @Test
    void testScore() {
        assertEquals(9, alice.getScore());
        assertEquals(6, bob.getScore());
    }
}