package seedu.duke;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

import seedu.duke.command.Command;
import seedu.duke.command.EchoCommand;
import seedu.duke.exception.InvalidInputException;
import seedu.duke.exception.UnknownException;
import seedu.duke.model.Patient;

public class ParserTest {
    Parser parser = new Parser(new Ui(), new Data());
    HashMap<String, String> sampleArguments = new HashMap<>();

    /**
     * This is the constructor for this class. This sets a sample arguments hashmap.
     */
    public ParserTest() {
        sampleArguments.put("command", "echo");
        sampleArguments.put("payload", "pVal1 pVal2");
        sampleArguments.put("keyA", "valA");
        sampleArguments.put("keyB", "valB1 valB2");
        sampleArguments.put("keyC", "");
    }

    private void checkAgainstSampleArguments(String fullCommand) {
        assertDoesNotThrow(() -> {
            Command command = parser.parse(fullCommand);
            assertTrue(command instanceof EchoCommand);
            assertTrue(((EchoCommand) command).getArguments().equals(sampleArguments));
        });
    }

    @Test
    public void parse_emptyString_exceptionThrown() {
        String fullCommand1 = "";
        // Test out a string with only white spaces
        String fullCommand2 = "     ";

        InvalidInputException invalidInputException1 = assertThrows(InvalidInputException.class, () -> {
            parser.parse(fullCommand1);
        });
        InvalidInputException invalidInputException2 = assertThrows(InvalidInputException.class, () -> {
            parser.parse(fullCommand2);
        });

        assertEquals(Constants.INVALID_INPUT_EMPTY_STRING, invalidInputException1.getMessage());
        assertEquals(Constants.INVALID_INPUT_EMPTY_STRING, invalidInputException2.getMessage());
    }

    @Test
    public void parse_malformedCommand_exceptionThrown() {
        String fullCommand = "malformed";
        assertThrows(InvalidInputException.class, () -> {
            parser.parse(fullCommand);
        });
    }

    @Test
    public void parse_invalidCommand_exceptionThrown() {
        String fullCommand = "invalid_command a b c /p x";
        Exception e = assertThrows(InvalidInputException.class, () -> {
            parser.parse(fullCommand);
        });

        assertEquals(Constants.INVALID_INPUT_UNKNOWN_COMMAND, e.getMessage());
    }

    /**
     * This test case tests whether a normal command (with or w/o leading/trailing spaces) can be parsed.
     */
    @Test
    public void parse_normalCommand_parsedSuccessfully() {
        // Normal command
        String fullCommand1 = "echo pVal1 pVal2 /keyA valA /keyB valB1 valB2 /keyC";
        // Command with leading/trailing spaces
        String fullCommand2 = "     echo pVal1 pVal2 /keyA valA /keyB valB1 valB2 /keyC    ";
        // Command with separation of more than 1 spaces
        String fullCommand3 = "     echo     pVal1  pVal2   /keyA valA   /keyB valB1   valB2 /keyC    ";

        checkAgainstSampleArguments(fullCommand1);
        checkAgainstSampleArguments(fullCommand2);
        checkAgainstSampleArguments(fullCommand3);
    }

    /**
     * This test case checks whether command of any cases are valid. It needs to be case-insensitive.
     */
    @Test
    public void parse_captilizedCommand_parsedSuccessfully() {
        String fullCommand1 = "Echo pVal1 pVal2 /keyA valA /keyB valB1 valB2 /keyC";
        String fullCommand2 = "eCHo pVal1 pVal2 /keyA valA /keyB valB1 valB2 /keyC";
        String fullCommand3 = "echO pVal1 pVal2 /keyA valA /keyB valB1 valB2 /keyC";

        checkAgainstSampleArguments(fullCommand1);
        checkAgainstSampleArguments(fullCommand2);
        checkAgainstSampleArguments(fullCommand3);
    }

    /**
     * This test case checks whether swapped arguments location produce the same results.
     */
    @Test
    public void parse_swappedArgument_parsedSuccessfully() {
        String fullCommand1 = "echo pVal1 pVal2 /keyB valB1 valB2 /keyC /keyA valA";
        String fullCommand2 = "echo pVal1 pVal2 /keyA valA /keyC /keyB valB1 valB2";
        String fullCommand3 = "echo pVal1 pVal2 /keyC /keyB valB1 valB2 /keyA valA";

        checkAgainstSampleArguments(fullCommand1);
        checkAgainstSampleArguments(fullCommand2);
        checkAgainstSampleArguments(fullCommand3);
    }

    /**
     * This test case tests single payload (without any parameters).
     */
    public void parse_singlePayload_parsedSuccessfully() {
        String words = "Hi! This is PatientManager!";
        String fullCommand = "echo " + words;
        assertDoesNotThrow(() -> {
            Command command = parser.parse(fullCommand);
            assertTrue(command instanceof EchoCommand);

            // Capture standard output
            final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
            System.setOut(new PrintStream(myOut));
            command.execute();
            final String string = myOut.toString();
            assertEquals(words, string);
        });
    }

    /**
     * This test case tests whether the data class is passed correctly.
     */
    @Test
    public void parse_customData_parsedSuccessfully() {
        String fullCommand = "echo Hi!";
        SortedMap<String, Patient> patients = new TreeMap<>();

        String nric = "S1234567D";
        patients.put(nric, new Patient(nric));
        Data data = new Data(null, patients);
        Parser parser = new Parser(new Ui(), data);

        assertDoesNotThrow(() -> {
            Command command = parser.parse(fullCommand);
            assertTrue(command instanceof EchoCommand);
            Data compareData = ((EchoCommand) command).getData();
            assertTrue(compareData.getPatient(nric) != null);
        });

        assertDoesNotThrow(() -> {
            Command command = this.parser.parse(fullCommand);
            assertTrue(command instanceof EchoCommand);
            Data compareData = ((EchoCommand) command).getData();
            assertTrue(compareData.getPatient(nric) == null);
        });
    }
}
