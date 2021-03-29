package seedu.duke.command;

import java.util.HashMap;
import java.util.Set;

public class BorrowersCreditScoreForReturnedLoans {
    private HashMap<String,Integer> borrowersCreditScoreForReturnedLoansMap;
    private static final long MAX_CREDIT_SCORE = 100;

    public BorrowersCreditScoreForReturnedLoans(HashMap<String, Integer> borrowersCreditScoreForReturnedLoansMapData) {
        this.borrowersCreditScoreForReturnedLoansMap = borrowersCreditScoreForReturnedLoansMapData;
    }

    public int getCurrentBorrowerCreditScoreForReturnedLoans(String borrowerNameInLowerCase) {
        if (borrowersCreditScoreForReturnedLoansMap.containsKey(borrowerNameInLowerCase)) {
            return borrowersCreditScoreForReturnedLoansMap.get(borrowerNameInLowerCase);
        }
        return (int) MAX_CREDIT_SCORE;
    }

    public void insertCurrentBorrowerCreditScoreForReturnedLoans(String borrowerNameInLowerCase, int creditScore) {
        borrowersCreditScoreForReturnedLoansMap.put(borrowerNameInLowerCase, creditScore);
    }

    public Set<String> getBorrowersNamesInLowerCase() {
        return borrowersCreditScoreForReturnedLoansMap.keySet();
    }
}
