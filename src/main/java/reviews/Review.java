package reviews;

public class Review {
    private String description;

    public Review(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
