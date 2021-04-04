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

        int max = 3;
        String input1 = "1 2 3"; // happy
        assertEquals(expected, ParserUtil.checkIndices(input1, max));
        
        String input2 = "2 1 3"; // unsorted
        assertEquals(expected, ParserUtil.checkIndices(input2, max));

        String input3 = "3 2 3 3 2 2 1 2 1 1"; // duplicates, unsorted
        assertEquals(expected, ParserUtil.checkIndices(input3, max));

        String input4 = "10 3 99 2 10909 3 99 99 100 1 10"; // out of bounds, duplicates, unsorted
        assertEquals(expected, ParserUtil.checkIndices(input4, max));

        String input5 = "10 1 -1 -99 -2 10918 2 3 -99 990 990 10 0 10"; // out of bounds, duplicates, unsorted
        assertEquals(expected, ParserUtil.checkIndices(input5, max));

        String input6 = "10 2 3 3 -1 -99 -2 10918 2 3 1 abc"; // out of bounds, duplicates, unsorted, non-integer
        assertEquals(expected, ParserUtil.checkIndices(input6, max));
    }
}