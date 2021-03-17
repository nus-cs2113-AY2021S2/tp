package reviews;

public class Review {
    private double rating = 0.0;
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

    public String getDescription() {
        return description;
    }

    public double getRating() {
        return rating;
    }
}
