package seedu.connoisseur.recommendation;

public class Recommendation {
    protected String title;
    protected String category;
    protected int price;
    protected String recommendedBy;
    protected static int MAX_RANGE_OF_PRICE = 5;

    /**
     * Creates a recommendation.
     *
     * @param inputTitle    title of the recommendation
     * @param inputCategory category of the recommendation
     * @param inputPrice    price of the recommendation
     * @param inputBy       description of the recommended person
     */
    public Recommendation(String inputTitle, String inputCategory, int inputPrice, String inputBy) {
        this.title = inputTitle;
        this.category = inputCategory;
        this.price = inputPrice;
        this.recommendedBy = inputBy;
    }

    /**
     * Gets the title of the recommendation.
     *
     * @return title of recommendation
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the recommendation.
     *
     * @param newTitle new title to be set
     */
    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    /**
     * Gets the category of the recommendation.
     *
     * @return category of the recommendation as a string
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category of the recommendation.
     *
     * @param newCategory new category of recommendation
     */
    public void setCategory(String newCategory) {
        this.category = newCategory;
    }

    /**
     * Gets the price of the recommendation.
     *
     * @return price of the recommendation as an double
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the price of the recommendation.
     *
     * @param newPrice new price to be set
     */
    public void setPrice(int newPrice) {
        this.price = newPrice;
    }

    /**
     * Gets the description that recommended the area.
     *
     * @return recommended by description as a string
     */
    public String getRecommendedBy() {
        return recommendedBy;
    }

    /**
     * Sets the description that recommended the area.
     *
     * @param newBy new description to be set
     */
    public void setDescription(String newBy) {
        this.recommendedBy = newBy;
    }

    /**
     * Converts the price to visual form.
     *
     * @return pricing range of the experience as a string
     */
    public String dollarRange() {
        String dollarRange = "";
        int dollar = this.price;
        assert dollar >= 0 && dollar <= 5 : "rating should be between 0 and 5";
        for (int i = 0; i < MAX_RANGE_OF_PRICE; i++) {
            if (dollar > 0) {
                dollarRange = dollarRange.concat("$ ");
            } else {
                dollarRange = dollarRange.concat("- ");
            }
            dollar--;
        }
        return dollarRange;
    }

    /**
     * Converts the recommendations to a string.
     *
     * @return recommendations as a string for display
     */
    public String toString() {
        return title + "      " + price;
    }

    /**
     * Converts a recommendations into text for storage.
     *
     * @return recommendations in a single string
     */
    public String recommendationToText() {
        return getTitle() + "|" + getCategory() + "|" + getPrice() + "|" + getRecommendedBy();
    }

    /**
     * Converts a single string into a recommendation.
     *
     * @param recommendation the review saves as a single string
     * @return recommendations as a Review object
     */
    public static Recommendation textToRecommendation(String recommendation) {
        String[] recommendationFields = recommendation.split("\\|", 4);
        Recommendation dataRec = new Recommendation(recommendationFields[0], recommendationFields[1],
                Integer.parseInt(recommendationFields[2]), recommendationFields[3]);
        return dataRec;
    }
}

