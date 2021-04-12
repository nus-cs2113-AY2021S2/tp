package movieApp.generator;

import movieApp.Cineplex;

import java.util.ArrayList;

public class CineplexList {

    /**
     * If cineplexList.txt is missing, this is the default data that is used to populate the file that will
     * be created in its place
     *
     * @return an ArrayList of Cineplexes, containing default Cineplex objects.
     */
    public static ArrayList<Cineplex> getDefaultCineplexes() {
        ArrayList<Cineplex> returnList = new ArrayList<Cineplex>();

        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(1);
        temp.add(2);
        temp.add(3);
        temp.add(4);
        Cineplex tempCineplex = new Cineplex(1, "Jurong Point", temp);
        returnList.add(tempCineplex);

        temp = new ArrayList<Integer>();
        temp.add(5);
        temp.add(6);
        temp.add(7);
        temp.add(8);
        tempCineplex = new Cineplex(2, "VivoCity", temp);
        returnList.add(tempCineplex);

        temp = new ArrayList<Integer>();
        temp.add(1);
        temp.add(2);
        temp.add(9);
        temp.add(10);
        tempCineplex = new Cineplex(3, "Bishan", temp);
        returnList.add(tempCineplex);

        /*
        Cinema tempCinema = new Cinema("Jurong Point", 1, 1, 60, 6, 10);
        tempCinema = new Cinema("Jurong Point", 2, 1, 30, 5, 6);
        tempCinema = new Cinema("Jurong Point", 3, 1, 30, 5, 6);
        tempCinema = new Cinema("Jurong Point", 4, 1, 30, 5, 6);
        tempCinema = new Cinema("VivoCity", 5, 2, 30, 5, 6);
        tempCinema = new Cinema("VivoCity", 6, 2, 30, 5, 6);
        tempCinema = new Cinema("VivoCity", 7, 2, 30, 5, 6);
        tempCinema = new Cinema("Bishan", 8, 3, 40, 5, 8);
        tempCinema = new Cinema("Bishan", 9, 3, 40, 5, 8);
        tempCinema = new Cinema("Bishan", 10, 3, 40, 5, 8);
        */

        return returnList;
    }
}
