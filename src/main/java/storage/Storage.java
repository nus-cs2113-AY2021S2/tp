package storage;

import canteens.Canteen;
import java.io.IOException;
import java.util.ArrayList;


public abstract class Storage {

    public static final String DEFAULT_STORAGE_FILEPATH = "data/DoNotEdit.txt";


    public Storage() {
    }

    public abstract ArrayList<Canteen> execute() throws IOException;

}