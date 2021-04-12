package movieApp.generator;

import movieApp.Cinema;
import movieApp.Movie;
import movieApp.Review;
import movieApp.Showtimes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class ShowtimeList {
    /**
     * If showtimeList.txt is missing, this is the default data that is used to populate the file that will
     * be created in its place
     * @return an ArrayList of Showtimes, containing default Showtimes objects.
     */
    public static ArrayList<Showtimes> getDefaultShowtimes(){
        ArrayList<Showtimes> returnList = new ArrayList<Showtimes>();

        Cinema tempCinema = new Cinema("Jurong Point", 1, 1, 60, 6, 10);
        Movie tempMovie = new Movie("Tenet", 1, 2021, 4, 10, 2021, 4,
                20, "Christopher Nolan", new String[]{"John David Washington", "Robert Pattinson",
                "Elizabeth Debicki", "Juhan Ulfsak"}, "Action", "Armed with only one word," +
                " Tenet, and fighting for the survival of the entire world, a Protagonist journeys through" +
                " a twilight world of international espionage on a mission that will unfold in something" +
                " beyond real time.", 3, new ArrayList<Review>());
        Calendar tempCalendar = Calendar.getInstance();
        tempCalendar.set(2021, 4, 19);
        Showtimes temp = new Showtimes(1, tempCalendar, tempCinema, tempMovie);
        returnList.add(temp);

        tempCinema = new Cinema("Jurong Point", 2, 1, 30, 5, 6);
        temp = new Showtimes(2, tempCalendar, tempCinema, tempMovie);

        tempCinema = new Cinema("VivoCity", 5, 2, 30, 5, 6);
        tempCalendar.set(2021, 4, 20);
        temp = new Showtimes(4, tempCalendar, tempCinema, tempMovie);
        returnList.add(temp);

        tempCinema = new Cinema("Bishan", 8, 3, 40, 5, 8);
        temp = new Showtimes(5, tempCalendar, tempCinema, tempMovie);
        returnList.add(temp);

        tempCinema = new Cinema("Jurong Point", 3, 1, 30, 5, 6);
        tempMovie = new Movie("Soul", 2, 2021, 4,10, 2021, 4, 20,
                "Pete Docter", new String[]{"Kemp Powers", "Jamie Foxx", "Tina Fey", "Graham Norton",
                "Rachel House"}, "Comedy", "After landing the gig of a lifetime, a New" +
                "York jazz pianist suddenly finds himself trapped in a strange land between Earth" +
                "and the afterlife.", 3, new ArrayList<Review>());
        tempCalendar.set(2021, 4, 19);
        temp = new Showtimes(5, tempCalendar, tempCinema, tempMovie);
        returnList.add(temp);
        return returnList;
    }
}
