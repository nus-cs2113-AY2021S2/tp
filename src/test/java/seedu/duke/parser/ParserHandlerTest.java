package seedu.duke.parser;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static seedu.duke.parser.ParserHandler.getParseInput;

class ParserHandlerTest {

    @Test
    void parse_testCase_emptyInput() {
        String input = "";
        String[] expected = {""};
        String[] actual = getParseInput(input).toArray(new String[0]);
        assertArrayEquals(expected, actual);
    }

    @Test
    void parse_testCase_oneWord() {
        String[] arrayOfTestCase = {"add", "add ", " add", " add "};
        String[] expected = {"add"};
        for (String testCase : arrayOfTestCase) {
            String[] actual = getParseInput(testCase).toArray(new String[0]);
            assertArrayEquals(expected, actual);
        }
    }

    @Test
    void parse_testCase_oneOption_noArgument() {
        String[] arrayOfTestCase = {"-e", "-e ", " -e", " -e "};
        String[] expected = {"-e", ""};
        for (String testCase : arrayOfTestCase) {
            String[] actual = getParseInput(testCase).toArray(new String[0]);
            assertArrayEquals(expected, actual);
        }
    }

    @Test
    void parse_testCase_TwoOption_noArgument() {
        String[] arrayOfTestCase = {"-e -s", "-e -s ", " -e -s", " -e -s ", " -e   -s "};
        String[] expected = {"-e", "", "-s", ""};
        for (String testCase : arrayOfTestCase) {
            String[] actual = getParseInput(testCase).toArray(new String[0]);
            assertArrayEquals(expected, actual);
        }
    }

    @Test
    void parse_testCase_gotOption_noArgument() {
        String[] arrayOfTestCase = {"add -e", "add -e ", " add -e", " add -e "};
        String[] expected = {"add", "-e", ""};
        for (String testCase : arrayOfTestCase) {
            String[] actual = getParseInput(testCase).toArray(new String[0]);
            assertArrayEquals(expected, actual);
        }
    }

    @Test
    void parse_testCase_TwoOption_noArgument_inMiddle() {
        String[] arrayOfTestCase = {"add -e -s -a 10", "add -e -s -a 10 ",
            " add -e -s -a 10", " add -e -s -a 10 "};
        String[] expected = {"add", "-e", "", "-s", "", "-a", "10"};
        for (String testCase : arrayOfTestCase) {
            String[] actual = getParseInput(testCase).toArray(new String[0]);
            assertArrayEquals(expected, actual);
        }
    }

    @Test
    void parse_testCase_manyWhiteSpace() {
        String[] arrayOfTestCase = {"            add   -e   beer -a     10    -d   2020-01-01       "};
        String[] expected = {"add", "-e", "beer", "-a", "10", "-d", "2020-01-01"};
        for (String testCase : arrayOfTestCase) {
            String[] actual = getParseInput(testCase).toArray(new String[0]);
            assertArrayEquals(expected, actual);
        }
    }

    @Test
    void parse_testCase_help_noArgument() {
        String[] arrayOfTestCase = {"help", "help ", "help  ", " help", "  help", " help "};
        String[] expected = {"help", "all"};
        for (String testCase : arrayOfTestCase) {
            String[] actual = getParseInput(testCase).toArray(new String[0]);
            assertArrayEquals(expected, actual);
        }
    }

    @Test
    void parse_testCase_help_withArguments() {
        String[] arrayOfTestCase = {"help add", "help     asd", "help    asd", " help asd   "};
        String[][] preExpected = {{"help", "add"}, {"help", "asd"}, {"help", "asd"}, {"help", "asd"}};
        for (int i = 0; i < arrayOfTestCase.length; i++) {
            String[] actual = getParseInput(arrayOfTestCase[i]).toArray(new String[0]);
            String[] expected = preExpected[i];
            assertArrayEquals(expected, actual);
        }
    }

    @Test
    void parse_testCase_creditscore_noArgument() {
        String[] arrayOfTestCase = {"creditscore", "creditscore ", "creditscore  ",
            " creditscore", "  creditscore", " creditscore "};
        String[] expected = {"creditscore", ""};
        for (String testCase : arrayOfTestCase) {
            String[] actual = getParseInput(testCase).toArray(new String[0]);
            assertArrayEquals(expected, actual);
        }
    }

    @Test
    void parse_testCase_creditscore_withArguments() {
        String[] arrayOfTestCase = {"creditscore andy", "creditscore     asd",
            "creditscore    asd", " creditscore asd   "};
        String[][] preExpected = {{"creditscore", "andy"}, {"creditscore", "asd"},
            {"creditscore", "asd"}, {"creditscore", "asd"}};
        for (int i = 0; i < arrayOfTestCase.length; i++) {
            String[] actual = getParseInput(arrayOfTestCase[i]).toArray(new String[0]);
            String[] expected = preExpected[i];
            assertArrayEquals(expected, actual);
        }
    }
}
