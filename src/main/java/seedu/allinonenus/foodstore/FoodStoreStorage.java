package seedu.allinonenus.foodstore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FoodStoreStorage {

    private static final String filepath = "Food Recommendation.txt";

    public static void saveFile(ArrayList<FoodStore> foodStores) throws IOException {
        FileWriter fileWriter = new FileWriter(filepath);
        for (FoodStore foodStore : foodStores) {
            fileWriter.write(foodStore.toString() + "\n");
        }
        fileWriter.close();
    }

    public static void loadFile(ArrayList<FoodStore> foodStores) throws FileNotFoundException {
        File file = new File(filepath);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            String[] inputArguments = input.split("\\[");
            String locationInput = inputArguments[0].substring(inputArguments[0].indexOf(": ") + 1).trim();
            String halalInput = input.substring(input.indexOf("[") + 1, input.indexOf("]"));
            input = input.substring(input.lastIndexOf("]") + 1);
            inputArguments = input.split(": ");
            String storeName = inputArguments[0];
            String storeDescription = inputArguments[1];
            FoodStore foodStore;
            boolean isDeck = locationInput.equals("The Deck");
            boolean isFrontier = locationInput.equals("Frontier");
            boolean isUTown = locationInput.equals("UTown");
            boolean isTechno = locationInput.equals("Techno Edge");
            boolean isHalal = halalInput.equals("Halal");
            if (isDeck) {
                foodStore = new DeckStore(storeName, storeDescription);
            } else if (isFrontier) {
                foodStore = new FrontierStore(storeName, storeDescription);
            } else if (isUTown) {
                foodStore = new UTownStore(storeName, storeDescription);
            } else if (isTechno) {
                foodStore = new TechnoStore(storeName, storeDescription);
            } else {
                foodStore = new FoodStore(storeName, storeDescription);
            }
            if (isHalal) {
                foodStore.setHalal();
            }
            foodStores.add(foodStore);
        }
    }

}
