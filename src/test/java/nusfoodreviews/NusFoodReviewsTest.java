package nusfoodreviews;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class NusFoodReviewsTest {
    private NusFoodReviews nusFoodReviews;

    @BeforeEach
    public void initializeNusFoodReviews() throws IOException {
        InputStream inputStream = NusFoodReviews.class.getClassLoader().getResourceAsStream("storage.txt");
        InputStreamReader streamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(streamReader);
        nusFoodReviews = new NusFoodReviews(reader);
    }

    @Test
    public void resetAllIndexes_null_negatives() {
        nusFoodReviews.resetAllIndex();
        assertTrue(nusFoodReviews.getUserIndex() == -1);
        assertTrue(nusFoodReviews.getCanteenIndex() == -1);
        assertTrue(nusFoodReviews.getStoreIndex() == -1);
    }

    @Test
    public void resetCanteenStoreIndex_null_negatives() {
        nusFoodReviews.resetCanteenStoreIndex();
        assertTrue(nusFoodReviews.getCanteenIndex() == -1);
        assertTrue(nusFoodReviews.getStoreIndex() == -1);
    }
}
