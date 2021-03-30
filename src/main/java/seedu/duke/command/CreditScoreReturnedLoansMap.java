package seedu.duke.command;

import java.util.HashMap;
import java.util.Set;

import static seedu.duke.common.Constant.MAX_CREDIT_SCORE;

public class CreditScoreReturnedLoansMap {
    private HashMap<String,Integer> creditScoreReturnedLoansMap;

    public CreditScoreReturnedLoansMap(HashMap<String, Integer> mapData) {
        this.creditScoreReturnedLoansMap = mapData;
    }

    public int getCreditScoreOf(String borrowerName) {
        if (creditScoreReturnedLoansMap.containsKey(borrowerName)) {
            return creditScoreReturnedLoansMap.get(borrowerName);
        }
        return (int) MAX_CREDIT_SCORE;
    }

    public void insertCreditScoreOf(String borrowerName, int creditScore) {
        creditScoreReturnedLoansMap.put(borrowerName, creditScore);
    }

    public Set<String> getBorrowersNames() {
        return creditScoreReturnedLoansMap.keySet();
    }
}
