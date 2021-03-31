package movieApp.storage;

import movieApp.*;
import movieApp.user.Admin;
import movieApp.user.Customer;
import movieApp.user.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    public static ArrayList<Movie> MovieDatabase;
    public static ArrayList<Cineplex> CineplexDatabase;
    public static ArrayList<Showtimes> ShowtimesDatabase;
    public static ArrayList<User> users;

    private static Path dataDirectory = Path.of(System.getProperty("user.dir") + "\\data");
    private static Path movieFileDirectory = Path.of(System.getProperty("user.dir") + "\\data" + "\\movielist.txt");
    private static Path cineplexFileDirectory = Path.of(System.getProperty("user.dir") + "\\data" + "\\cineplexlist.txt");
    private static Path showtimeFileDirectory = Path.of(System.getProperty("user.dir") + "\\data" + "\\showtimelist.txt");

    public Database() throws Exception {
        checkForDatabases();
        importDatabase();
    }

    private static void checkForDatabases() throws IOException {
        checkForDirectory(dataDirectory);
        checkForFile(movieFileDirectory);
        checkForFile(cineplexFileDirectory);
        checkForFile(showtimeFileDirectory);
    }

    private static void checkForDirectory(Path dataDirectory) throws IOException {
        if(!Files.exists(dataDirectory)){
            Files.createDirectory(dataDirectory);
        }
    }

    private static void checkForFile(Path fileDirectory) throws IOException {
        if(!Files.exists(fileDirectory)){
            File newFile = new File(String.valueOf(fileDirectory));
            newFile.createNewFile();
        }
    }

    private static void importDatabase() throws Exception {
        MovieDatabase = importMovieDatabase();
        CineplexDatabase = importCineplexDatabase();
        ShowtimesDatabase = importShowtimesDatabase();
        users = importUserDatabase();
    }

    private static ArrayList<User> importUserDatabase() throws Exception {
        ArrayList<User> users = new ArrayList<>();
        users.add(new Admin("zul", "hello"));
        users.add(new Customer("alex", "12345"));
        return users;
    }

    private static ArrayList<Movie> importMovieDatabase() throws Exception {
        ArrayList<Movie> MList = null;

        File f_movie = new File("data/movieList.txt");
        FileInputStream fis_movie = new FileInputStream(f_movie);
        try {
            ObjectInputStream ois_movie = new ObjectInputStream(fis_movie);
            MList = (ArrayList<Movie>) ois_movie.readObject();
            ois_movie.close();
        } catch (EOFException e) {

        }
        // System.out.println(MList);

        return MList;
    }

    private static ArrayList<Cineplex> importCineplexDatabase() throws Exception {
        ArrayList<Cineplex> CPList = null;

        File f_cineplex = new File("data/cineplexList.txt");
        FileInputStream fis_cineplex = new FileInputStream(f_cineplex);

        try {
            ObjectInputStream ois_cineplex = new ObjectInputStream(fis_cineplex);
            CPList = (ArrayList<Cineplex>) ois_cineplex.readObject();
            ois_cineplex.close();
        } catch (EOFException e) {

        }
        // System.out.println(CPList);

        return CPList;
    }

    private static ArrayList<Showtimes> importShowtimesDatabase() throws Exception {
        ArrayList<Showtimes> STList = null;

        File f_showtime = new File("data/showtimeList.txt");
        FileInputStream fis_showtime = new FileInputStream(f_showtime);
        try {
            ObjectInputStream ois_showtime = new ObjectInputStream(fis_showtime);
            STList = (ArrayList<Showtimes>) ois_showtime.readObject();
            ois_showtime.close();
        } catch(EOFException e) {

        }
        // System.out.println(STList);

        return STList;
    }

    // If you need to update any of the databases, can rip some of the code from here
    // TODO: Need edit Ui class, constructor and getOption, to use this function.
    // TODO: Create a more generic function that can be used to update any of the databases so don't keep repeating code
    // TODO: Something like public static void updateDatabase()
    public static void deleteMovie() throws Exception {
        System.out.println("Select a movie to be deleted from the list (enter the number)");
        int i = 1;
        for(Movie movie : MovieDatabase){
            System.out.println(i + ". " + movie.getMovieTitle());
            i++;
        }

        Scanner sc = new Scanner(System.in);
        int choice = -1;
        while ((choice < 1) || (choice > MovieDatabase.size())) {
            System.out.println("Please enter your choice: ");
            if (!sc.hasNextInt()) {
                System.out.println("Please input an integer.\n");
                sc.next();
                continue;
            }
            choice = sc.nextInt();
            if ((choice <= 0) ||(choice > MovieDatabase.size())) {
                System.out.println("Please input an integer within the range.\n");
            }
        }
        sc.close();

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

    public static void editMovie() throws Exception {
        System.out.println("Select a movie to be edited from the list (enter the number)");
        int i = 1;
        for(Movie movie : MovieDatabase){
            System.out.println(i + ". " + movie.getMovieTitle());
            i++;
        }

        Scanner sc = new Scanner(System.in);
        int choice = -1;
        while ((choice < 1) || (choice > MovieDatabase.size())) {
            System.out.println("Please enter your choice: ");
            if (!sc.hasNextInt()) {
                System.out.println("Please input an integer.\n");
                sc.next();
                continue;
            }
            choice = sc.nextInt();
            if ((choice <= 0) ||(choice > MovieDatabase.size())) {
                System.out.println("Please input an integer within the range.\n");
            }
        }
        sc.close();

        Movie selectedMovie = MovieDatabase.get(choice - 1);
        System.out.println("You have selected " + selectedMovie.getMovieTitle() + "\n");
        Scanner select = new Scanner(System.in);
        int type = -1;
        while ((type < 1) || (type > 4)) {
            System.out.println("======= Edit Movie =======");
            System.out.println(" 1 Edit title\n 2 Edit director\n 3 Edit synopsis\n ============================\nPlease indicate your choice:");
            if (!select.hasNextInt()) {
                System.out.println("Please input an integer.\n");
                select.next();
                continue;
            }
            type = select.nextInt();
            if ((type < 1) ||(type > 4)) {
                System.out.println("Please input a integer between 1 and 3.\n");
                continue;
            }

            switch(type){
                case 1:
                    System.out.println("Current title: " + selectedMovie.getMovieTitle() + ".\nInsert new title:");
                    String newTitle = select.next();
                    selectedMovie.setMovieTitle(newTitle);
                    break;
                case 2:
                    System.out.println("Current director: " + selectedMovie.getDirector() + ".\nInsert new director:");
                    String newDirector = select.next();
                    selectedMovie.setMovieTitle(newDirector);
                    break;
                case 3:
                    System.out.println("Current synopsis: " + selectedMovie.getSynopsis() + ".\nInsert new synopsis:");
                    String newSynopsis = select.next();
                    selectedMovie.setMovieTitle(newSynopsis);
                    break;
            }
        }
        select.close();


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
}
