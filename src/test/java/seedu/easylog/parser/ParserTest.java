package seedu.easylog.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {
    @Test
    @DisplayName("(Raw User Input) Should Be Split Correctly")
    public void parser_shouldBeSplitCorrectly() {
        // an empty raw user input
        assertEquals("", Parser.splitCommandWordAndArgs("")[0]);
        assertEquals("", Parser.splitCommandWordAndArgs("")[1]);

        // a raw user input with only the command
        assertEquals("items", Parser.splitCommandWordAndArgs("items")[0]);
        assertEquals("", Parser.splitCommandWordAndArgs("items")[1]);

        // a raw user input with both the command and further description
        assertEquals("items", Parser.splitCommandWordAndArgs("items PS5")[0]);
        assertEquals("PS5", Parser.splitCommandWordAndArgs("items PS5")[1]);
    }
}
