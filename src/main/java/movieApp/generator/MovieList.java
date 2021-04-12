package movieApp.generator;

import movieApp.Movie;
import movieApp.Review;

import java.util.ArrayList;
import java.util.Arrays;

public class MovieList {

    /**
     * If movieList.txt is missing, this is the default data that is used to populate the file that will
     * be created in its place
     *
     * @return an ArrayList of Movie, containing default Movie objects.
     */
    public static ArrayList<Movie> getDefaultMovieList() {

        ArrayList<Review> tempReview1 = new ArrayList<Review>();
        tempReview1.add(new Review("Good movie", 5));
        ArrayList<Review> tempReview2 = new ArrayList<Review>();
        tempReview2.add(new Review("Decent movie", 4));
        ArrayList<Review> tempReview3 = new ArrayList<Review>();
        tempReview3.add(new Review("Great movie, enjoyed it a lot", 4));
        tempReview3.add(new Review("Did not like this movie", 2));
        ArrayList<Review> tempReview4 = new ArrayList<Review>();
        tempReview4.add(new Review("I liked it!", 4));
        tempReview4.add(new Review("Bad movie", 1));
        tempReview4.add(new Review("Best movie I've seen", 5));
        ArrayList<Review> tempReview5 = new ArrayList<Review>();
        tempReview5.add(new Review("So so", 3));
        ArrayList<Review> tempReview6 = new ArrayList<Review>();
        tempReview6.add(new Review("It's alright", 3));
        ArrayList<Review> tempReview7 = new ArrayList<Review>();
        tempReview7.add(new Review("Excellent Movie!", 5));
        ArrayList<Review> tempReview10 = new ArrayList<Review>();
        tempReview10.add(new Review("Trashy movie", 1));


        return new ArrayList<Movie>(Arrays.asList(
                new Movie("Tenet", 1, 2021, 4, 10, 2021, 4, 20,
                        "Christopher Nolan", new String[]{"John David Washington", "Robert Pattinson",
                        "Elizabeth Debicki", "Juhan Ulfsak"}, "Action", "Armed with only one word," +
                        " Tenet, and fighting for the survival of the entire world, a Protagonist journeys through" +
                        " a twilight world of international espionage on a mission that will unfold in something" +
                        " beyond real time.", 3, tempReview1),
                new Movie("Soul", 2, 2021, 4, 10, 2021, 4, 20,
                        "Pete Docter", new String[]{"Kemp Powers", "Jamie Foxx", "Tina Fey", "Graham Norton",
                        "Rachel House"}, "Comedy", "After landing the gig of a lifetime, a New" +
                        "York jazz pianist suddenly finds himself trapped in a strange land between Earth" +
                        "and the afterlife.", 3, tempReview2),
                new Movie("Wonder Woman 1984", 3, 2021, 4, 10, 2021,
                        4, 20, "Patty Jenkins", new String[]{"Gal Gadot", "Chris Pine",
                        "Kristen Wiig", "Pedro Pascal"}, "Action", "Diana must contend with a" +
                        "work colleague and businessman, whose desire for extreme wealth sends the world" +
                        "down a path of destruction, after an ancient artifact that grants wishes goes missing.",
                        3, tempReview3),
                new Movie("Birds of Prey", 4, 2021, 5, 10, 2021,
                        6, 10, "Cathy Yan", new String[]{"Margot Robbie", "Rosie Perez",
                        " Mary Elizabeth Winstead", "Jurnee Smollett"}, "Action", "After splitting " +
                        "with the Joker," + "Harley Quinn joins superheroes Black Canary, Huntress and Renee " +
                        "Montoya to save a" + "young girl from an evil crime lord.", 2, tempReview4),
                new Movie("The Invisible Man", 5, 2021, 8, 10, 2021, 9,
                        10, "Leigh Whannell", new String[]{"Elisabeth Moss", "Oliver Jackson-Cohen",
                        "Harriet Dyer", "Aldis Hodge"}, "Drama", "When Cecilia's abusive ex takes his" +
                        "own life and leaves her his fortune, she suspects his death was a hoax. As a series " +
                        "of coincidences turn lethal, Cecilia works to prove that she is being hunted by someone " +
                        "nobody can see.", 1, tempReview5),
                new Movie("Avengers: Endgame", 6, 2020, 1, 1, 2020,
                        1, 10, "Joe Russo", new String[]{"Anthony Russo", "Chris Evans",
                        "Chris Hemsworth", "Robert Downey, Jr."}, "Action", "After Thanos, an" +
                        "intergalactic warlord, disintegrates half of the universe, the Avengers must reunite" +
                        "and assemble again to reinvigorate their trounced allies and restore balance.", 4,
                        tempReview6),
                new Movie("Toy Story 4", 7, 2020, 2, 1, 2020, 4, 2,
                        "Josh Cooley", new String[]{"Tom Hanks", "Tim Allen", "Keanu Reeves"}, "Comedy",
                        "Woody attempts to make Forky, a toy, suffering from existential crisis, realise" +
                                "his importance in the life of Bonnie, their owner. However, things become difficult" +
                                "when Gabby Gabby enters their lives.", 1, tempReview7),
                new Movie("Joker", 8, 2020, 2, 1, 2020, 2, 2,
                        "Todd Phillips", new String[]{"Joaquin Phoenix", "Robert De Niro", "Zazie Beetz"},
                        "Comedy", "Forever alone in a crowd, failed comedian Arthur Fleck seeks" +
                        "connection as he walks the streets of Gotham City. Arthur wears two masks -- the one he" +
                        "paints for his day job as a clown, and the guise he projects in a futile attempt to feel" +
                        "like he's part of the world around him.", 1, new ArrayList<Review>()),
                new Movie("Frozen 2", 9, 2020, 3, 1, 2020, 3, 10,
                        "Jennifer Lee", new String[]{"Chris Buck", "Idina Menzel", "Kristen Bell"},
                        "Family", "Queen Elsa starts hearing a mysterious melodic voice calling to" +
                        "her. Unsettled, she answers it and that awakens the elemental spirits that lead her" +
                        "to a quest to restore an old injustice.", 1, new ArrayList<Review>()),
                new Movie("Charlie's Angels", 10, 2020, 3, 10, 2020, 3,
                        20, "Elizabeth Banks", new String[]{"Kristen Stewart", "Naomi Scott"},
                        "Action", "A team of female private agents, popularly known as Charlie's" +
                        "Angels, are tasked by their mysterious boss to expose an international conspiracy to" +
                        " weaponise an energy conservation device.", 1, tempReview10)
        ));
    }
}
