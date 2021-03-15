package reviews;

public class Review {
    private double rating;
    private String description;

    public Review(String description) {
        this.description = description;
    }

    public Review(String description,double rating) {
        this.description = description;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return description;
    }
}
