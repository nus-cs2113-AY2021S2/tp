package reviews;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Review {
    private double rating = 0.0;
    private String description;
    private String date;

    public Review(String description) {
        this.description = description;
    }

    public Review(String description,double rating) {
        this.description = description;
        this.rating = rating;
        Date dateTime = new Date();
        Format formatter = new SimpleDateFormat("yyy-MM-dd");
        this.date = formatter.format(dateTime);
    }

    public Review(String description,double rating,String date) {
        this.description = description;
        this.rating = rating;
        this.date = date;
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

    public String getDate() {
        return date;
    }
}
