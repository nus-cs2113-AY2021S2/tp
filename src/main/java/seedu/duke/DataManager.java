package seedu.duke;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataManager {
	private static final String TXT_FILE_DIRECTORY= "./data";
	private static final String PATH_TO_PROFILE = "./data/profile.txt";
	private static final String PATH_TO_DELIVERY = "./data/delivery.txt";
	private static final String PATH_TO_ROUTES = "./data/routes.txt";

	/**
	 * Method to load deliveryman details from a .txt file
	 * @return deliveryman object with the default name settings
	 */
	public static Deliveryman loadProfile(){
		String driverName = "Obi Wan";
		String vehicleModel = "YT-1300";
		String licensePlate = "HIGHGROUND";
		int maxWeight = 4;

		try {
			File directory = new File(TXT_FILE_DIRECTORY);
			File saveFile = new File(PATH_TO_PROFILE);
			if (!directory.exists()) {
				directory.mkdirs();
				saveFile.createNewFile();
			}
			Scanner sc = new Scanner(saveFile);
			while(sc.hasNext()){
				String loadedInfo = sc.nextLine();
				String[] userInfo = loadedInfo.split(" \\| ", 4);
				driverName = userInfo[0];
				vehicleModel = userInfo[2];
				licensePlate = userInfo[1];
				maxWeight = Integer.parseInt(userInfo[3]);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Directory and save file not created!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new Deliveryman(driverName, licensePlate, vehicleModel, maxWeight);
	}

	/**
	 * Method to save the deliveryman's personal details - allowing accessibility on next startup
	 * @param deliveryman the Deliveryman object being used in the program
	 */
	public static void saveProfile(Deliveryman deliveryman){
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
	 * @return list of deliveries to be stored in the static DeliveryList class
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

	/**
	 * Helper method for loadDeliveryList()
	 * @param itemList item list provided in each line of the .txt file
	 * @return ArrayList of items as dictated in the .txt
	 */
	private static ArrayList<Item> itemRetriever(String[] itemList){
		ArrayList<Item> itemsArray = new ArrayList<>();
		for (String s : itemList) {
			String[] itemIndexes = s.split("-");
			int itemNumber = Integer.parseInt(itemIndexes[0]);
			int itemWeight = Integer.parseInt(itemIndexes[1]);
			Item item = new Item(itemNumber, itemWeight);
			itemsArray.add(item);
		}
		return itemsArray;
	}

	public static ArrayList<Route> loadRoutes() {
		ArrayList<Route> routes = new ArrayList<>();
		try {
			File deliveryRoute = new File(PATH_TO_ROUTES);
			Scanner fileReader = new Scanner(deliveryRoute);
			while (fileReader.hasNext()) {
				String line = fileReader.nextLine();
				String[] routeInfo = line.split(" \\| ");
				routes.add(new Route(routeInfo[0], Double.parseDouble(routeInfo[1]), Integer.parseInt(routeInfo[2])));
			}
		} catch (FileNotFoundException e) {
			System.out.println("Cannot load file...you are clapped! Please load a file.");
			System.exit(0);
		}
		return routes;
	}
}
