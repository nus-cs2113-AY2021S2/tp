package seedu.duke.command;

import java.util.HashMap;
import java.util.Set;

public class CreditScoreMap {
    private HashMap<String,Integer> creditScoreHashMap;
    private static final long MAX_CREDIT_SCORE = 100;

    public CreditScoreMap(HashMap<String, Integer> creditScoreHashMapData) {
        this.creditScoreHashMap = creditScoreHashMapData;
    }

    public int getCreditScore(String borrowerName) {
        if (creditScoreHashMap.containsKey(borrowerName)) {
            return creditScoreHashMap.get(borrowerName);
        }
        return (int) MAX_CREDIT_SCORE;
    }

    public void updateCreditScoreMap(String borrowerName, int creditScore) {
        creditScoreHashMap.put(borrowerName, creditScore);
    }

    public Set<String> getBorrowersNames() {
        return creditScoreHashMap.keySet();
    }
}
