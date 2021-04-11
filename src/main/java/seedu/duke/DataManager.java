package seedu.duke;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataManager {
    private static final String TXT_FILE_DIRECTORY = "./data";
    private static final String PATH_TO_PROFILE = "./data/profile.txt";
    private static final String PATH_TO_DELIVERY = "./data/delivery.txt";
    private static final String PATH_TO_ROUTES = "./data/routes.txt";

    /**
     * Method to load deliveryman details from a .txt file
     *
     * @return deliveryman object with the default name settings
     */
    public static Deliveryman loadProfile() {
        String driverName;
        String vehicleModel;
        String licensePlate;
        int maxWeight;
        Deliveryman deliverymanProfile = null;

        try {
            File directory = new File(TXT_FILE_DIRECTORY);
            File saveFile = new File(PATH_TO_PROFILE);
            if (!directory.exists()) {
                System.out.println("First time user, you are.... ");
                System.out.println("Creating new files, I am");
                directory.mkdirs();
                saveFile.createNewFile();
                new File(PATH_TO_DELIVERY).createNewFile();
                new File(PATH_TO_ROUTES).createNewFile();
            }
            Scanner sc = new Scanner(saveFile);
            while (sc.hasNext()) {
                String loadedInfo = sc.nextLine();
                String[] userInfo = loadedInfo.split(" \\| ", 4);
                driverName = userInfo[0];
                vehicleModel = userInfo[2];
                licensePlate = userInfo[1];
                maxWeight = Integer.parseInt(userInfo[3]);
                deliverymanProfile = new Deliveryman(driverName, licensePlate, vehicleModel, maxWeight);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Directory and save file not created!!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (deliverymanProfile == null) {
            Generator generator = new Generator();
            deliverymanProfile = generator.profileGenerator();
        }
        assert deliverymanProfile != null : "!!Missing profile";
        return deliverymanProfile;
    }

    /**
     * Method to save the deliveryman's personal details - allowing accessibility on next startup.
     *
     * @param deliveryman the Deliveryman object being used in the program
     */
    public static void saveProfile(Deliveryman deliveryman) {
        FileWriter fw;
        try {
            fw = new FileWriter(PATH_TO_PROFILE);
            String profileInfo = deliveryman.saveFormat();
            fw.write(profileInfo);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to save all the deliveries - required in order to reflect the updated status (isComplete).
     */
    public static void saveDeliveries() {
        FileWriter fw;
        try {
            fw = new FileWriter(PATH_TO_DELIVERY);
            String prefix = "";
            for (Delivery delivery : DeliveryList.deliveries) {
                fw.write(prefix);
                String deliveryData = delivery.saveFormat();
                fw.write(deliveryData);
                prefix = "\n";
            }
            fw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Method to load list of deliveries.
     *
     * @return list of deliveries to be stored in the static DeliveryList class
     * @author Zhi Fah
     */
    public static ArrayList<Delivery> loadDeliveryList() {
        ArrayList<Delivery> deliveries = new ArrayList<>();
        try {
            File saveDelivery = new File(PATH_TO_DELIVERY);
            Scanner fileReader = new Scanner(saveDelivery);
            while (fileReader.hasNext()) {
                String line = fileReader.nextLine();
                String[] stringSplit = line.split(" / ");
                String[] itemSplit = stringSplit[4].split(" , ");

                ArrayList<Item> items = itemRetriever(itemSplit);
                Delivery delivery = new Delivery(stringSplit[0], stringSplit[1], stringSplit[2], stringSplit[3], items);
                deliveries.add(delivery);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot load file...you are clapped! Please load a file.");
            System.exit(0);
        }
        if (deliveries.size() < 1) {
            Generator generator = new Generator();
            deliveries = generator.deliveriesGenerator();
        }
        assert deliveries != null : "!! Deliveries are null";
        System.out.println("File loaded boi...lets gooooooo!");
        return deliveries;
    }

    /**
     * Helper method for loadDeliveryList().
     *
     * @param itemList item list provided in each line of the .txt file
     * @return ArrayList of items as dictated in the .txt
     * @author Zhi Fah
     */
    public static ArrayList<Item> itemRetriever(String[] itemList) {
        ArrayList<Item> itemsArray = new ArrayList<>();
        for (String s : itemList) {
            String[] itemIndexes = s.split("-");
            int itemNumber = Integer.parseInt(itemIndexes[0]);
            int itemWeight = Integer.parseInt(itemIndexes[1]);
            Item item = new Item(itemNumber, itemWeight);
            assert item != null : "!! Item not created";
            itemsArray.add(item);
        }
        assert itemsArray != null : "!! List of items for Delivery object is null";
        return itemsArray;
    }

    /**
     * Method to load list of routes.
     *
     * @return list of routes to be tagged to Delivery object
     */
    public static ArrayList<Route> loadRoutes() {
        ArrayList<Route> routes = new ArrayList<>();
        try {
            File deliveryRoute = new File(PATH_TO_ROUTES);
            Scanner fileReader = new Scanner(deliveryRoute);
            while (fileReader.hasNext()) {
                String line = fileReader.nextLine();
                String[] routeInfo = line.split(" \\| ");
                String destination = routeInfo[0];
                double deliveryFee = Double.parseDouble(routeInfo[1]);
                int distance = Integer.parseInt(routeInfo[2]);
                routes.add(new Route(destination, deliveryFee, distance));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot load file...you are clapped! Please load a file.");
            System.exit(0);
        }
        if (routes.isEmpty()) {
            Generator generator = new Generator();
            routes = generator.routesGenerator();
        }
        assert routes != null : "!! Routes are null";
        return routes;
    }

    /**
     * Method to save all the Routes data.
     */
    public static void saveRoutes() {
        FileWriter fw;
        try {
            fw = new FileWriter(PATH_TO_ROUTES);
            String prefix = "";
            for (Route route : Route.routes) {
                fw.write(prefix);
                String deliveryData = route.saveFormat();
                fw.write(deliveryData);
                prefix = "\n";
            }
            fw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method to save the deliveries, profile and routes data.
     *
     * @param deliveryman object to attribute the saves
     */
    public void saveAll(Deliveryman deliveryman) {
        saveDeliveries();
        saveProfile(deliveryman);
        saveRoutes();
    }
}
