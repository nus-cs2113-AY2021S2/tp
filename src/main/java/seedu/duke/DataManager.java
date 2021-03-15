package seedu.duke;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DataManager {
	private static final String TXT_FILE_DIRECTORY= "./data";
	private static final String PATH_TO_PROFILE = "./data/profile.txt";
	private static final String PATH_TO_DELIVERY = "./data/delivery.txt";

	public Deliveryman loadProfile(){
		String driverName = "Obi Wan";
		String vehicleModel = "YT-1300";
		String licensePlate = "HIGHGROUND";

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
				String[] userInfo = loadedInfo.split(" \\| ", 3);
				driverName = userInfo[0];
				vehicleModel = userInfo[2];
				licensePlate = userInfo[1];
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Directory and save file not created!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new Deliveryman(driverName, licensePlate, vehicleModel);
	}

	public void saveProfile(Deliveryman deliveryman){
		FileWriter fw = null;
		try {
			fw = new FileWriter(PATH_TO_PROFILE);
			String profileInfo = deliveryman.saveFormat();
			fw.write(profileInfo);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
