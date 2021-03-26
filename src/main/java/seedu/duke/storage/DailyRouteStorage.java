package seedu.duke.storage;

import seedu.duke.DailyRoute;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DailyRouteStorage extends Storage {
    public DailyRouteStorage(String filepath) {
        super(filepath);
    }

    public void loadDailyRoute(DailyRoute dailyRoute) throws IOException {
        try {
            Scanner s = new Scanner(new File(this.filepath)); // create a Scanner using the File as the source
            while (s.hasNext()) {
                String input = s.nextLine();
                String[] daySchedulePair = input.split("\\+");
                String day = daySchedulePair[0];
                String[] schedule = daySchedulePair[1].split("\\|");
                ArrayList<String> blocks = new ArrayList<>(Arrays.asList(schedule));
                dailyRoute.addDailyRoute(day, blocks);
            }
        } catch (FileNotFoundException e) {
            //Split given filepath by "/":
            String[] storagePathArray = this.filepath.split("/");
            //For the first time, create a new file for the user:
            File dataDirectory = new File(storagePathArray[0]);
            dataDirectory.mkdir();
            File dukeFile = new File(storagePathArray[0], storagePathArray[1]); //File(parent, child)
            dukeFile.createNewFile();
        }
    }

    public void overwriteDailyRouteFile(DailyRoute dailyRoute) {
        //write to file:
        ArrayList<String> selectableDays = dailyRoute.getSelectableDays();
        try {
            PrintWriter writer = new PrintWriter(this.filepath);
            writer.print("");
            writer.close();
            for (String day : selectableDays) {
                String savedLine = dailyRoute.saveDaySchedule(day);
                appendToDailyRouteFile(savedLine);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Write: File not found");
        } catch (IOException e) {
            System.out.print("Unable to write to file");
        }
    }

    public void appendToDailyRouteFile(String textToAdd) throws IOException {
        FileWriter fw = new FileWriter(this.filepath, true);
        fw.write(textToAdd);
        fw.close();
    }


}
