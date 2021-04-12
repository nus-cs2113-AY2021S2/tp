package seedu.duke.command;

import java.util.HashMap;
import java.util.Set;

import static seedu.duke.common.Constant.MAX_CREDIT_SCORE;

/**
 * Maintains an internal HashMap of borrower names mapped to their respective credit score,
 * and handles operations relating to this HashMap.
 *
 * NOTE: The credit score referred to in this case is computed based on the list of confirmed returned loans made by
 * the borrower and is not the final credit score.
 */
public class CreditScoreReturnedLoansMap {
    private HashMap<String,Integer> creditScoreReturnedLoansMap;

    /**
     * Constructs a creditScoreReturnedLoansMap with data loaded from the save file.
     * @param mapData contains the mapping of borrower names to their respective creditscore loaded
     *                from the save file.
     */
    public CreditScoreReturnedLoansMap(HashMap<String, Integer> mapData) {
        this.creditScoreReturnedLoansMap = mapData;
    }

    /**
     * Get the credit score of the specified borrower.
     * NOTE: The credit score referred to in this case is computed based on the list of confirmed returned loans
     * made by the borrower and is not the final credit score.
     *
     * @param borrowerName name of the borrower.
     * @return credit score of the specified borrower.
     */
    public int getCreditScoreOf(String borrowerName) {
        if (creditScoreReturnedLoansMap.containsKey(borrowerName)) {
            return creditScoreReturnedLoansMap.get(borrowerName);
        }
        return (int) MAX_CREDIT_SCORE;
    }

    /**
     * Inserts the credit score of the specified borrower.
     * NOTE: The credit score referred to in this case is computed based on the list of confirmed returned loans
     * made by the borrower and is not the final credit score.
     *
     * @param borrowerName name of the borrower.
     * @return credit score of the specified borrower.
     */
    public void insertCreditScoreOf(String borrowerName, int creditScore) {
        creditScoreReturnedLoansMap.put(borrowerName, creditScore);
    }

    /**
     * Get the list of borrower names maintained in this HashMap.
     * @return A Set of borrower names maintained in this HashMap.
     */
    public Set<String> getBorrowersNames() {
        return creditScoreReturnedLoansMap.keySet();
    }
}
