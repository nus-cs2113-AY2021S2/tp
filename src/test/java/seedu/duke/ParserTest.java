package seedu.duke;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

//@author geezzzyyy
class ParserTest {

    @Test
    void getFindFacilityLocation() {
        Parser parser = new Parser();
        String userInput = "findFacility <library1> <CANTEEN> <2>";
        String expectedOutput = "library1";
        assertEquals(expectedOutput, parser.getFindFacilityLocation(userInput));
    }


    @Test
    void getFindFacilityType() {
        Parser parser = new Parser();
        String userInput = "findFacility <library1> <CANTEEN> <2>";
        String expectedOutput = "CANTEEN";
        assertEquals(expectedOutput, parser.getFindFacilityType(userInput));
    }

    @Test
    void getTopK() {
        Parser parser = new Parser();
        String userInput = "findFacility <library1> <CANTEEN> <2>";
        assertEquals(2, parser.getTopK(userInput));
    }

    @Test
    void isFind() {
        Parser parser = new Parser();
        String userInput = "findFacility <library1> <CANTEEN> <2>";
        assertEquals(true, parser.isFind(userInput));
    }
}