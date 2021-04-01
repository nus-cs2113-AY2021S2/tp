package movieApp.storage;

import movieApp.*;
import movieApp.user.Admin;
import movieApp.user.Customer;
import movieApp.user.User;
import movieApp.parser.MovieFilter;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Database {
    public static ArrayList<Movie> MovieDatabase;
    public static ArrayList<Cineplex> CineplexDatabase;
    public static ArrayList<Showtimes> ShowtimesDatabase;
    public static ArrayList<User> users;

    public Database() throws Exception {
        importDatabase();
    }

    private static void importDatabase() throws Exception {
        MovieDatabase = importMovieDatabase();
        CineplexDatabase = importCineplexDatabase();
        ShowtimesDatabase = importShowtimesDatabase();
        users = importUserDatabase();
    }

    private static ArrayList<User> importUserDatabase() throws Exception {
        File f_user = new File("data/userList.txt");
        FileReader r_user = new FileReader(f_user);
        BufferedReader br_user = new BufferedReader(r_user);
        String line;

        ArrayList<User> users = new ArrayList<>();

        while((line=br_user.readLine())!=null)
        {
            String[] userSplit = line.split("\\|");
            String username = userSplit[1].trim();
            String password = userSplit[2].trim();
            String type = userSplit[0].trim().toUpperCase();
            switch (type) {
                case "USER":
                    users.add(new Customer(username, password));
                    break;
                case "ADMIN":
                    users.add(new Admin(username, password));
                    break;
                default:
                    throw new Exception(type);
            }
        }
        r_user.close();
        return users;
    }

    private static ArrayList<Movie> importMovieDatabase() throws Exception {
        File f_movie = new File("data/movieList.txt");
        FileInputStream fis_movie = new FileInputStream(f_movie);
        ObjectInputStream ois_movie = new ObjectInputStream(fis_movie);

        ArrayList<Movie> MList = (ArrayList<Movie>) ois_movie.readObject();
        // System.out.println(MList);
        ois_movie.close();
        return MList;
    }

    private static ArrayList<Cineplex> importCineplexDatabase() throws Exception {
        File f_cineplex = new File("data/cineplexList.txt");
        FileInputStream fis_cineplex = new FileInputStream(f_cineplex);
        ObjectInputStream ois_cineplex = new ObjectInputStream(fis_cineplex);

        ArrayList<Cineplex> CPList = (ArrayList<Cineplex>) ois_cineplex.readObject();
        // System.out.println(CPList);
        ois_cineplex.close();
        return CPList;
    }

    private static ArrayList<Showtimes> importShowtimesDatabase() throws Exception {
        File f_showtime = new File("data/showtimeList.txt");
        FileInputStream fis_showtime = new FileInputStream(f_showtime);
        ObjectInputStream ois_showtime = new ObjectInputStream(fis_showtime);

        ArrayList<Showtimes> STList = (ArrayList<Showtimes>) ois_showtime.readObject();
        // System.out.println(STList);
        ois_showtime.close();
        return STList;
    }

    public static void deleteMovie(int choice) throws Exception {
        MovieDatabase.remove(choice - 1);
        try {
            File f_movie = new File("data/movieList.txt");
            FileOutputStream fos_movie = new FileOutputStream(f_movie);
            ObjectOutputStream oos_movie = new ObjectOutputStream(fos_movie);
            oos_movie.writeObject(MovieDatabase);
            oos_movie.close();
            fos_movie.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        System.out.println("The movie has been removed from the database.");
    }

    public static void editMovie(int choice, int type) throws Exception {
        Movie selectedMovie = MovieDatabase.get(choice - 1);
        Scanner select = new Scanner(System.in);
        switch(type){
            case 1:
                System.out.println("Current title: " + selectedMovie.getMovieTitle() + "\nInsert new title:");
                String newTitle = select.nextLine();
                selectedMovie.setMovieTitle(newTitle);
                break;
            case 2:
                System.out.println("Current director: " + selectedMovie.getDirector() + "\nInsert new director:");
                String newDirector = select.nextLine();
                selectedMovie.setDirector(newDirector);
                break;
            case 3:
                System.out.println("Current synopsis: " + selectedMovie.getSynopsis() + "\nInsert new synopsis:");
                String newSynopsis = select.nextLine();
                selectedMovie.setSynopsis(newSynopsis);
                break;
        }

        try {
            File f_movie = new File("data/movieList.txt");
            FileOutputStream fos_movie = new FileOutputStream(f_movie);
            ObjectOutputStream oos_movie = new ObjectOutputStream(fos_movie);
            oos_movie.writeObject(MovieDatabase);
            oos_movie.close();
            fos_movie.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        System.out.println("The changes have been saved to the database.");
    }


    public static int getIntegerInput(String prompt, int maxValue) {
        int integer_input = -1;
        Scanner sc = new Scanner(System.in);


        while ((integer_input < 1) || (integer_input > maxValue)) {
            System.out.println(prompt);

            if (!sc.hasNextInt()) {
                System.out.println("Please input an integer.\n");
                sc.next();
                continue;
            }
            integer_input = sc.nextInt();
            if ((integer_input < 1) || (integer_input > maxValue))  {
                System.out.println("Please input an integer in range 1 to " + maxValue + "\n");
            }
        }

        return integer_input;
    }

    public static void addMovie() throws Exception {

        Scanner select = new Scanner(System.in);

        System.out.println("Movie title: ");
        String newTitle = select.nextLine();
        System.out.println(newTitle);

        int newID = MovieDatabase.size() + 1;
        System.out.println(newID);


        System.out.println("Enter movie start date ");
        int newStartDate = getIntegerInput("Date (DD): ", 31);
        int newStartMonth = getIntegerInput("Month (MM): ", 12);
        int newStartYear = getIntegerInput("Year (YYYY): ", 2100);


        System.out.println("Enter movie end date ");
        int newEndDate = getIntegerInput("Date (DD): ", 31);
        int newEndMonth = getIntegerInput("Month (MM): ", 12);
        int newEndYear = getIntegerInput("Year (YYYY): ", 2100);


        System.out.println("Movie director: ");
        String newDirector = select.nextLine();
        System.out.println("Movie casts (separated with comma) : ");
        String casts = select.nextLine();

        String[] castList = casts.split(",");
        String newGenre = MovieFilter.getGenre();
        System.out.println("Movie synopsis: ");
        String newSynopsis = select.nextLine();
        int newStatus = 1;
        ArrayList<Review> newReview = new ArrayList<>();

        Movie newMovie = new Movie(
                newTitle, newID,
                newStartYear, newStartMonth, newStartDate,
                newEndYear, newEndMonth, newEndDate,
                newDirector, castList, newGenre,
                newSynopsis, newStatus, newReview);

        MovieDatabase.add(newMovie);

        try {
            File f_movie = new File("data/movieList.txt");
            FileOutputStream fos_movie = new FileOutputStream(f_movie);
            ObjectOutputStream oos_movie = new ObjectOutputStream(fos_movie);
            oos_movie.writeObject(MovieDatabase);
            oos_movie.close();
            fos_movie.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        System.out.println("The new movie \"" + newMovie.getMovieTitle() + "\" have been saved to the database.");

    }
}
