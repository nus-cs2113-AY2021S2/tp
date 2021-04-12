package movieApp;

import java.io.Serializable;

public class Review implements Serializable {
    private static final long serialVersionUID = -7155346385146047745L;
    private String comment;
    private int rating;

    /**
     * Class constructor.
     */
    public Review(String c, int r) {
        comment = c;
        rating = r;
    }

    /**
     * Returns the comment attached to the specified Review object
     *
     * @return returns a string, which is the comment attached to the Review object
     */
    public String getComment() {
        return comment;
    }

    /**
     * Returns the rating value attached to the specified Review object
     *
     * @return returns an int, which is the rating value attached to the Review object
     */
    public int getRating() {
        return rating;
    }

}
