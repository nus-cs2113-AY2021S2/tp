package movieApp.storage;

import movieApp.Cineplex;
import movieApp.Movie;
import movieApp.Review;
import movieApp.Showtimes;
import movieApp.generator.CineplexList;
import movieApp.generator.MovieList;
import movieApp.generator.ShowtimeList;
import movieApp.generator.UserList;
import movieApp.parser.MovieFilter;
import movieApp.user.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Database {
    public static ArrayList<Movie> MovieDatabase;
    public static ArrayList<Cineplex> CineplexDatabase;
    public static ArrayList<Showtimes> ShowtimesDatabase;
    public static ArrayList<User> users;

    public static Path dataDirectory = Path.of(System.getProperty("user.dir") + "/data");

    public static Path movieListDirectory = Path.of(System.getProperty("user.dir") + "/data" + "/movieList.txt");
    public static Path cineplexListDirectory = Path.of(System.getProperty("user.dir") + "/data"
            + "/cineplexList.txt");
    public static Path showtimeListDirectory = Path.of(System.getProperty("user.dir") + "/data"
            + "/showtimeList.txt");
    public static Path userListDirectory = Path.of(System.getProperty("user.dir") + "/data"
            + "/userSerialList.txt");

    /**
     * Initialize all the methods.
     */
    public Database() throws Exception {
        checkIfDirectoryExists();
        checkIfMovieListExists();
        checkIfCineplexListExists();
        checkIfShowtimeListExists();
        checkIfUserListExists();
        importDatabase();
    }

    /**
     * Check if the user text file exists in storage.
     */
    private static void checkIfUserListExists() throws IOException {
        if (!Files.exists(userListDirectory)) {
            File newFile = new File(String.valueOf(userListDirectory));
            newFile.createNewFile();
            writeToFile("data/userSerialList.txt", UserList.getDefaultUsers());
        }
    }

    /**
     * Check if the showtime text file exists in storage.
     */
    private static void checkIfShowtimeListExists() throws IOException {
        if (!Files.exists(showtimeListDirectory)) {
            File newFile = new File(String.valueOf(showtimeListDirectory));
            newFile.createNewFile();
            writeToFile("data/showtimeList.txt", ShowtimeList.getDefaultShowtimes());
        }
    }

    /**
     * Check if the cineplex text file exists in storage.
     */
    private static void checkIfCineplexListExists() throws IOException {
        if (!Files.exists(cineplexListDirectory)) {
            File newFile = new File(String.valueOf(cineplexListDirectory));
            newFile.createNewFile();
            writeToFile("data/cineplexList.txt", CineplexList.getDefaultCineplexes());
        }
    }

    /**
     * Check if the movie list text file exists in storage.
     */
    private static void checkIfMovieListExists() throws IOException {
        if (!Files.exists(movieListDirectory)) {
            File newFile = new File(String.valueOf(movieListDirectory));
            newFile.createNewFile();
            writeToFile("data/movieList.txt", MovieList.getDefaultMovieList());
        }
    }

    /**
     * Check if the directory that stores data exists in storage.
     */
    private static void checkIfDirectoryExists() throws IOException {
        if (!Files.exists(dataDirectory)) {
           Files.createDirectory(dataDirectory);
        }
    }

    /**
     * Check if the the file that stores data exists in storage.
     */
    private static void checkIfFileExists(Path databaseFile) throws IOException {
        if (!Files.exists(databaseFile)) {
            File newFile = new File(String.valueOf(databaseFile));
            newFile.createNewFile();
        }
    }

    /**
     * Import data to populate the object array list.
     */
    private static void importDatabase() throws Exception {
        MovieDatabase = importMovieDatabase();
        CineplexDatabase = importCineplexDatabase();
        ShowtimesDatabase = importShowtimesDatabase();
        users = importUserDatabaseUsingSerialization();
    }

    /**
     * Import user database from text file.
     *
     * @return an array list of user objects.
     */
    private static ArrayList<User> importUserDatabaseUsingSerialization() throws Exception {
        File f_movie = new File("data/userSerialList.txt");
        FileInputStream fis_movie = new FileInputStream(f_movie);
        ObjectInputStream ois_movie = new ObjectInputStream(fis_movie);

        ArrayList<User> MList = (ArrayList<User>) ois_movie.readObject();
        ois_movie.close();
        return MList;
    }

    /**
     * Import movie database from text file.
     *
     * @return an array list of movie objects.
     */
    private static ArrayList<Movie> importMovieDatabase() throws Exception {
        File f_movie = new File("data/movieList.txt");
        FileInputStream fis_movie = new FileInputStream(f_movie);
        ObjectInputStream ois_movie = new ObjectInputStream(fis_movie);

        ArrayList<Movie> MList = (ArrayList<Movie>) ois_movie.readObject();
        ois_movie.close();
        MList = updateMovieStatus(MList);
        return MList;
    }

    /**
     * Import cineplex database from text file.
     *
     * @return an array list of cineplex objects.
     */
    private static ArrayList<Cineplex> importCineplexDatabase() throws Exception {
        File f_cineplex = new File("data/cineplexList.txt");
        FileInputStream fis_cineplex = new FileInputStream(f_cineplex);
        ObjectInputStream ois_cineplex = new ObjectInputStream(fis_cineplex);

        ArrayList<Cineplex> CPList = (ArrayList<Cineplex>) ois_cineplex.readObject();
        ois_cineplex.close();
        return CPList;
    }

    /**
     * Import showtime database from text file.
     *
     * @return an array list of showtime objects.
     */
    private static ArrayList<Showtimes> importShowtimesDatabase() throws Exception {
        File f_showtime = new File("data/showtimeList.txt");
        FileInputStream fis_showtime = new FileInputStream(f_showtime);
        ObjectInputStream ois_showtime = new ObjectInputStream(fis_showtime);

        ArrayList<Showtimes> STList = (ArrayList<Showtimes>) ois_showtime.readObject();
        ois_showtime.close();
        return STList;
    }

    /**
     * Update the showing status of the movie list.
     *
     * @param MList the list of movies to update.
     */
    private static ArrayList<Movie> updateMovieStatus(ArrayList<Movie> MList) {
        Date currentDate = new Date();
        Calendar startCalendar = null;
        Calendar endCalendar = null;
        for (int i = 0; i < MList.size(); i++) {
            startCalendar = MList.get(i).getStartDate();
            endCalendar = MList.get(i).getEndDate();
            Date startDate = startCalendar.getTime();
            Date endDate = endCalendar.getTime();
            if (currentDate.compareTo(startDate) < 0) {
                MList.get(i).setMovieStatus(1);
            } else if (currentDate.compareTo(endDate) > 0) {
                MList.get(i).setMovieStatus(4);
            } else {
                MList.get(i).setMovieStatus(3);
            }
        }
        return MList;
    }

    /**
     * Delete a movie from the movie list.
     *
     * @param choice the index of movie to delete.
     */
    public static void deleteMovie(int choice) throws Exception {
        MovieDatabase.remove(choice - 1);
        try {
            File f_movie = new File("data/movieList.txt");
            FileOutputStream fos_movie = new FileOutputStream(f_movie);
            ObjectOutputStream oos_movie = new ObjectOutputStream(fos_movie);
            oos_movie.writeObject(MovieDatabase);
            oos_movie.close();
            fos_movie.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        System.out.println("The movie has been removed from the database.");
    }

    /**
     * Edit a movie in the movie list.
     *
     * @param choice the index of movie to edit.
     * @param type   the movie attribute to edit.
     */
    public static void editMovie(int choice, int type) throws Exception {
        Movie selectedMovie = MovieDatabase.get(choice - 1);
        Scanner select = new Scanner(System.in);
        switch (type) {
            case 1:
                System.out.println("Current title: " + selectedMovie.getMovieTitle() + "\nInsert new title:");
                String newTitle = select.nextLine();
                while (newTitle.equals("")) {
                    System.out.println("Insert new title: ");
                    newTitle = select.nextLine();
                }
                selectedMovie.setMovieTitle(newTitle);
                break;
            case 2:
                System.out.println("Current director: " + selectedMovie.getDirector() + "\nInsert new director:");
                String newDirector = select.nextLine();
                while (newDirector.equals("")) {
                    System.out.println("Insert new director: ");
                    newDirector = select.nextLine();
                }
                selectedMovie.setDirector(newDirector);
                break;
            case 3:
                System.out.println("Current synopsis: " + selectedMovie.getSynopsis() + "\nInsert new synopsis:");
                String newSynopsis = select.nextLine();
                while (newSynopsis.equals("")) {
                    System.out.println("Insert new synopsis: ");
                    newSynopsis = select.nextLine();
                }
                selectedMovie.setSynopsis(newSynopsis);
                break;
            case 4:
                int newStartDate, newStartMonth, newStartYear, newEndDate, newEndMonth, newEndYear;
                do {
                    System.out.println("Insert new start date:");
                    int[] newStart = getDateTime();
                    newStartDate = newStart[0];
                    newStartMonth = newStart[1];
                    newStartYear = newStart[2];

                    System.out.println("Insert new end date:");
                    int[] newEnd = getDateTime();
                    newEndDate = newEnd[0];
                    newEndMonth = newEnd[1];
                    newEndYear = newEnd[2];

                    if (newEndYear < newStartYear) {
                        System.out.println("The end year cannot be earlier than the start year.");
                        continue;
                    } else if (newEndYear == newStartYear && newEndMonth < newStartMonth) {
                        System.out.println("The end month cannot be earlier than the start month.");
                        continue;
                    } else if (newEndYear == newStartYear && newEndMonth == newStartMonth && newEndDate < newStartDate) {
                        System.out.println("The end date cannot be earlier than the start date.");
                        continue;
                    }
                    break;
                } while (true);
                Calendar startDate = Calendar.getInstance();
                startDate.set(newStartYear, newStartMonth - 1, newStartDate, 0, 0, 0);
                selectedMovie.setStartDate(startDate);
                Calendar endDate = Calendar.getInstance();
                endDate.set(newEndYear, newEndMonth - 1, newEndDate, 0, 0, 0);
                selectedMovie.setEndDate(endDate);
                MovieDatabase = updateMovieStatus(MovieDatabase);
                break;
            case 5:
                System.out.println("Insert new movie casts (separated with comma): ");
                String casts = select.nextLine();
                while (casts.equals("")) {
                    System.out.println("Movie casts (separated with comma): ");
                    casts = select.nextLine();
                }
                String[] castList = casts.split(",");
                selectedMovie.setCast(castList);
                break;
            default:
                System.out.println("Please input a integer between 1 and 5.\n");
        }

        try {
            File f_movie = new File("data/movieList.txt");
            FileOutputStream fos_movie = new FileOutputStream(f_movie);
            ObjectOutputStream oos_movie = new ObjectOutputStream(fos_movie);
            oos_movie.writeObject(MovieDatabase);
            oos_movie.close();
            fos_movie.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        System.out.println("The changes have been saved to the database.");
    }

    /**
     * Get an integaer input from the user.
     *
     * @param prompt   the prompt to display to user.
     * @param maxValue the max value range the user can choose from.
     */
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
            if ((integer_input < 1) || (integer_input > maxValue)) {
                System.out.println("Please input an integer in range 1 to " + maxValue + "\n");
            }
        }

        return integer_input;
    }

    /**
     * Check if the user input comply to a valid date format.
     *
     * @param input input from the user.
     * @return a boolean value, which indicates whether the input date format is valid.
     */
    private static boolean isValidDate(String input) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            format.setLenient(false);
            format.parse(input);
        } catch (ParseException e) {
            System.out.println("Invalid Date. The format must be dd-MM-yyyy");
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Date. The format must be dd-MM-yyyy");
            return false;
        }

        return true;
    }

    /**
     * Read in user's date input string and convert it to int.
     *
     * @return an int value of date.
     */
    public static int[] getDateTime() throws Exception {
        System.out.println("Input the date using the format dd-mm-yyyy");
        Scanner scanner = new Scanner(System.in);
        String date = scanner.nextLine();
        while (!isValidDate(date)) {
            date = scanner.nextLine();
        }
        Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
        int[] dates = new int[3];
        dates[0] = date1.getDate();
        dates[1] = date1.getMonth() + 1;
        dates[2] = date1.getYear() + 1900;

        return dates;
    }

    /**
     * Add a new movie to the movie list.
     */
    public static void addMovie() throws Exception {

        Scanner select = new Scanner(System.in);

        System.out.println("Movie title: ");
        String newTitle = select.nextLine();
        while (newTitle.equals("")) {
            System.out.println("Movie title: ");
            newTitle = select.nextLine();
        }

        int newID = MovieDatabase.size() + 1;

        int newStartDate, newStartMonth, newStartYear, newEndDate, newEndMonth, newEndYear;

        do {
            System.out.println("Enter movie start date ");
            int[] newStart = getDateTime();
            newStartDate = newStart[0];
            newStartMonth = newStart[1];
            newStartYear = newStart[2];

            System.out.println("Enter movie end date ");
            int[] newEnd = getDateTime();
            newEndDate = newEnd[0];
            newEndMonth = newEnd[1];
            newEndYear = newEnd[2];

            if (newEndYear < newStartYear) {
                System.out.println("The end year cannot be earlier than the start year.");
                continue;
            } else if (newEndYear == newStartYear && newEndMonth < newStartMonth) {
                System.out.println("The end month cannot be earlier than the start month.");
                continue;
            } else if (newEndYear == newStartYear && newEndMonth == newStartMonth && newEndDate < newStartDate) {
                System.out.println("The end date cannot be earlier than the start date.");
                continue;
            }

            break;
        } while (true);


        System.out.println("Movie director: ");
        String newDirector = select.nextLine();
        while (newDirector.equals("")) {
            System.out.println("Movie director: ");
            newDirector = select.nextLine();
        }
        System.out.println("Movie casts (separated with comma): ");
        String casts = select.nextLine();
        while (casts.equals("")) {
            System.out.println("Movie casts (separated with comma): ");
            casts = select.nextLine();
        }
        String[] castList = casts.split(",");

        String newGenre = MovieFilter.getGenre();

        System.out.println("Movie synopsis: ");
        String newSynopsis = select.nextLine();
        while (newSynopsis.equals("")) {
            System.out.println("Movie synopsis: ");
            newSynopsis = select.nextLine();
        }

        int newStatus = 1;
        ArrayList<Review> newReview = new ArrayList<>();

        Movie newMovie = new Movie(
                newTitle, newID,
                newStartYear, newStartMonth, newStartDate,
                newEndYear, newEndMonth, newEndDate,
                newDirector, castList, newGenre,
                newSynopsis, newStatus, newReview);

        MovieDatabase.add(newMovie);
        MovieDatabase = updateMovieStatus(MovieDatabase);

        try {
            File f_movie = new File("data/movieList.txt");
            FileOutputStream fos_movie = new FileOutputStream(f_movie);
            ObjectOutputStream oos_movie = new ObjectOutputStream(fos_movie);
            oos_movie.writeObject(MovieDatabase);
            oos_movie.close();
            fos_movie.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        System.out.println("The new movie \"" + newMovie.getMovieTitle() + "\" have been saved to the database.");

    }

    /**
     * Update any changes made to the database.
     */
    public static void updateDatabase() {
        writeToFile("data/showtimeList.txt", ShowtimesDatabase);
        writeToFile("data/userSerialList.txt", users);
        writeToFile("data/cineplexList.txt", CineplexDatabase);
        writeToFile("data/movieList.txt", MovieDatabase);
    }

    /**
     * Store the object to file.
     *
     * @param fileName file to store the object.
     * @param object   object to be stored in file.
     */
    private static void writeToFile(String fileName, Object object) {
        try {
            File f_movie = new File(fileName);
            FileOutputStream fos_movie = new FileOutputStream(f_movie);
            ObjectOutputStream oos_movie = new ObjectOutputStream(fos_movie);
            oos_movie.writeObject(object);
            oos_movie.close();
            fos_movie.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
