package seedu.duke;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DeliveryList {

    public static ArrayList<Delivery> deliveries = new ArrayList<Delivery>();

    /**
     * Constructor to load list of deliveries from a .txt file
     * If the .txt file is not present, terminate the program and request for a file to be loaded
     */
    public static ArrayList<Delivery> loadDeliveryList() {
        // todo create (load) the list of deliveries using a .txt containing delivery information
        boolean isDone;
        try {
            File saveDelivery = new File("delivery.txt");
            Scanner fileReader = new Scanner(saveDelivery);
            while (fileReader.hasNext()) {
                String line = fileReader.nextLine();
                String[] stringSplit = line.split(" / ");
                String[] itemSplit = stringSplit[4].split(" , ");

                ArrayList<Item> items = itemRetriever(itemSplit);
                Delivery delivery = new Delivery(stringSplit[1], stringSplit[2], stringSplit[3], items);
                deliveries.add(delivery);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot load file...you are clapped! Please load a file.");
           System.exit(0);
        }
        System.out.println("File loaded boi...lets gooooooo!");
        return deliveries;
    }

    public static ArrayList<Item> itemRetriever(String[] itemList){
        ArrayList<Item> itemsArray = new ArrayList<>();
        for (int i = 0; i<itemList.length; i++){
            String[] itemIndexes = itemList[i].split("-");
            int itemNumber = Integer.parseInt(itemIndexes[0]);
            int itemWeight = Integer.parseInt(itemIndexes[1]);
            Item item = new Item(itemNumber, itemWeight);
            itemsArray.add(item);
        }
        return itemsArray;
    }
}
