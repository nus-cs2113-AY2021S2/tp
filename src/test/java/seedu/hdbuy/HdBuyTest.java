package seedu.hdbuy;

import org.junit.jupiter.api.Test;
import seedu.hdbuy.api.ApiRepository;
import seedu.hdbuy.common.QueryKey;
import seedu.hdbuy.common.Unit;
import seedu.hdbuy.common.exception.InvalidParameterException;
import seedu.hdbuy.data.SearchedUnits;
import seedu.hdbuy.parser.CommandEvaluator;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HdBuyTest {
    @Test public void sampleTest() {
        assertTrue(true);
    }

    @Test public void testConnection() {
        HashMap<QueryKey, String> inputs = new HashMap<>();
        inputs.put(QueryKey.LOCATION, "jurong");
        ApiRepository.fetchUnits(inputs);
        assertNotNull(SearchedUnits.getSearchedUnits());
    }

    @Test public void testEmptyResponseException() {
        HashMap<QueryKey, String> inputs = new HashMap<>();
        inputs.put(QueryKey.LEASE_REMAINING, "101");
        SearchedUnits.clearSearchedUnits();
        ApiRepository.fetchUnits(inputs);
        assertTrue(SearchedUnits.getSearchedUnits().isEmpty());
    }

    @Test public void parserTest() {
        try {
            assertEquals(0, CommandEvaluator.extractInfo("filter"));
        } catch (InvalidParameterException e) {
            assertEquals("You must enter the correct number of parameters.", e.getMessage());
        }
        try {
            assertEquals(0, CommandEvaluator.extractInfo("filter location"));
        } catch (InvalidParameterException e) {
            assertEquals("You must enter the correct number of parameters.", e.getMessage());
        }
    }
}
