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
     * @param input_title       title of the review
     * @param input_category    category of the experience
     * @param input_price      rating of the experience
     * @param input_by description of the experience
     */
    public Recommendation(String input_title, String input_category, int input_price, String input_by){
        this.title = input_title;
        this.category = input_category;
        this.price = input_price;
        this.recommendedBy = input_by;
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
     * @param title new title to be set
     */
    public void setTitle(String title) {
        this.title = title;
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
     * @param category new category of recommendation
     */
    public void setCategory(String category) {
        this.category = category;
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
     * @param new_price new price to be set
     */
    public void setPrice(int new_price) {
        this.price = new_price;
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
     * @param input_by new description to be set
     */
    public void setDescription(String input_by) {
        this.recommendedBy = input_by;
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
        return  getTitle() + "|" + getCategory() + "|" + getPrice() + "|" + getRecommendedBy();
    }

    /**
     * Converts a single string into a recommendation.
     *
     * @param recommendation the review saves as a single string
     * @return recommendations as a Review object
     */
    public static Recommendation textToRecommendation(String recommendation) {
        String[] recommendationFields = recommendation.split("\\|", 4);
        Recommendation data_rec = new Recommendation(recommendationFields[0], recommendationFields[1], Integer.parseInt(recommendationFields[1]),
                recommendationFields[3]);
        return data_rec;
    }
}

