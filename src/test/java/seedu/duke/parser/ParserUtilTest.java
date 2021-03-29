package seedu.duke.parser;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParserUtilTest {

    //@@author ivanchongzhien
    @Test
    // Test check indices method - providing various valid and invalid inputs
    // Invalid inputs : out of bounds, duplicate index, non-integer inputs
    void checkIndices_variousInputs_processedArrayList() {
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        int max = 5;
        String input1 = "1 2 3"; // happy
        assertEquals(expected, ParserUtil.checkIndices(input1, max));

        String input2 = "1 1 2 3 3 3 2 2 1 2"; // duplicates
        assertEquals(expected, ParserUtil.checkIndices(input2, max));

        String input3 = "10 1 99 2 10909 3 99 99 100 10"; // out of bounds and duplicates
        assertEquals(expected, ParserUtil.checkIndices(input3, max));

        String input4 = "10 1 -1 -99 -2 10918 2 3 -99 990 990 10 0 10"; // out of bounds and duplicates and negative
        assertEquals(expected, ParserUtil.checkIndices(input4, max));

        String input5 = "10 1 -1 -99 -2 10918 2 3 abc"; // out of bounds and duplicates and negative and non-integer
        assertEquals(expected, ParserUtil.checkIndices(input5, max));
    }
}