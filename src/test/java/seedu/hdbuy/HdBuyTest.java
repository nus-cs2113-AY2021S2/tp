package seedu.hdbuy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import seedu.hdbuy.api.ApiRepository;
import seedu.hdbuy.data.QueryKey;
import seedu.hdbuy.data.Unit;

class HdBuyTest {
    @Test
    public void sampleTest() {
        assertTrue(true);
    }

    @Test
    public void testConnection() {
        HashMap<QueryKey,String> inputs = new HashMap<>();
        inputs.put(QueryKey.LOCATION, "jurong");
        assertNotNull(ApiRepository.fetchUnits(inputs));
    }

    @Test
    public void testEmptyResponseException() {
        HashMap<QueryKey,String> inputs = new HashMap<>();
        inputs.put(QueryKey.LEASE_REMAINING, "101");
        HashMap<Integer, Unit> units = ApiRepository.fetchUnits(inputs);
        assertTrue(units.isEmpty());
    }
}
