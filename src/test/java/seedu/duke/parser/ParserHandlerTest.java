package seedu.duke.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ParserHandlerTest {
    private ParserHandler parserHandler;

    @Test
    void parse_testCase_emptyInput() {
        parserHandler = new ParserHandler();
        String input = "";
        String[] expected = {""};
        String[] actual = parserHandler.getParseInput(input).toArray(new String[0]);
        assertArrayEquals(expected, actual);
    }

    @Test
    void parse_testCase_oneWord() {
        parserHandler = new ParserHandler();
        String[] arrayOfTestCase = {"add", "add ", " add", " add "};
        String[] expected = {"add"};
        for (String testCase : arrayOfTestCase) {
            String[] actual = parserHandler.getParseInput(testCase).toArray(new String[0]);
            assertArrayEquals(expected, actual);
        }
    }

    @Test
    void parse_testCase_oneOption_noArgument() {
        parserHandler = new ParserHandler();
        String[] arrayOfTestCase = {"-e", "-e ", " -e", " -e "};
        String[] expected = {"-e", ""};
        for (String testCase : arrayOfTestCase) {
            String[] actual = parserHandler.getParseInput(testCase).toArray(new String[0]);
            assertArrayEquals(expected, actual);
        }
    }

    @Test
    void parse_testCase_TwoOption_noArgument() {
        parserHandler = new ParserHandler();
        String[] arrayOfTestCase = {"-e -s", "-e -s ", " -e -s", " -e -s ", " -e   -s "};
        String[] expected = {"-e", "", "-s", ""};
        for (String testCase : arrayOfTestCase) {
            String[] actual = parserHandler.getParseInput(testCase).toArray(new String[0]);
            assertArrayEquals(expected, actual);
        }
    }

    @Test
    void parse_testCase_gotOption_noArgument() {
        parserHandler = new ParserHandler();
        String[] arrayOfTestCase = {"add -e", "add -e ", " add -e", " add -e "};
        String[] expected = {"add", "-e", ""};
        for (String testCase : arrayOfTestCase) {
            String[] actual = parserHandler.getParseInput(testCase).toArray(new String[0]);
            assertArrayEquals(expected, actual);
        }
    }

    @Test
    void parse_testCase_TwoOption_noArgument_inMiddle() {
        parserHandler = new ParserHandler();
        String[] arrayOfTestCase = {"add -e -s -a 10", "add -e -s -a 10 ",
            " add -e -s -a 10", " add -e -s -a 10 "};
        String[] expected = {"add", "-e", "", "-s", "", "-a", "10"};
        for (String testCase : arrayOfTestCase) {
            String[] actual = parserHandler.getParseInput(testCase).toArray(new String[0]);
            assertArrayEquals(expected, actual);
        }
    }

    @Test
    void parse_testCase_manyWhiteSpace() {
        parserHandler = new ParserHandler();
        String[] arrayOfTestCase = {"            add   -e   beer -a     10    -d   2020-01-01       "};
        String[] expected = {"add", "-e", "beer", "-a", "10", "-d", "2020-01-01"};
        for (String testCase : arrayOfTestCase) {
            String[] actual = parserHandler.getParseInput(testCase).toArray(new String[0]);
            assertArrayEquals(expected, actual);
        }
    }

    @Test
    void parse_testCase_help_noArgument() {
        parserHandler = new ParserHandler();
        String[] arrayOfTestCase = {"help", "help ", "help  ", " help", "  help", " help "};
        String[] expected = {"help", "all"};
        for (String testCase : arrayOfTestCase) {
            String[] actual = parserHandler.getParseInput(testCase).toArray(new String[0]);
            assertArrayEquals(expected, actual);
        }
    }

    @Test
    void parse_testCase_help_withArguments() {
        parserHandler = new ParserHandler();
        String[] arrayOfTestCase = {"help add", "help     asd", "help    asd", " help asd   "};
        String[][] preExpected = {{"help", "add"}, {"help", "asd"}, {"help", "asd"}, {"help", "asd"}};
        for (int i = 0; i < arrayOfTestCase.length; i++) {
            String[] actual = parserHandler.getParseInput(arrayOfTestCase[i]).toArray(new String[0]);
            String[] expected = preExpected[i];
            assertArrayEquals(expected, actual);
        }
    }

    @Test
    void parse_testCase_creditscore_noArgument() {
        parserHandler = new ParserHandler();
        String[] arrayOfTestCase = {"creditscore", "creditscore ", "creditscore  ",
            " creditscore", "  creditscore", " creditscore "};
        String[] expected = {"creditscore", ""};
        for (String testCase : arrayOfTestCase) {
            String[] actual = parserHandler.getParseInput(testCase).toArray(new String[0]);
            assertArrayEquals(expected, actual);
        }
    }

    @Test
    void parse_testCase_creditscore_withArguments() {
        parserHandler = new ParserHandler();
        String[] arrayOfTestCase = {"creditscore andy", "creditscore     asd",
            "creditscore    asd", " creditscore asd   "};
        String[][] preExpected = {{"creditscore", "andy"}, {"creditscore", "asd"},
            {"creditscore", "asd"}, {"creditscore", "asd"}};
        for (int i = 0; i < arrayOfTestCase.length; i++) {
            String[] actual = parserHandler.getParseInput(arrayOfTestCase[i]).toArray(new String[0]);
            String[] expected = preExpected[i];
            assertArrayEquals(expected, actual);
        }
    }
}
