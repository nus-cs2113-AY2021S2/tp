package seedu.hdbuy.api;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import seedu.hdbuy.common.QueryKey;
import seedu.hdbuy.data.SearchedUnits;

import static org.junit.jupiter.api.Assertions.*;

class ApiRepositoryTest {

    @Test void fetchUnits() {
        HashMap<QueryKey, String> inputs = new HashMap<>();
        inputs.put(QueryKey.LOCATION, "ang mo kio");
        inputs.put(QueryKey.TYPE, "4 room");
        inputs.put(QueryKey.LEASE_REMAINING, "80");
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
}