package seedu.duke.login;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public class LoginInfoFileManager {
    private File loginInfoFile;

    /**
     * Handles the database(LoginInfo.txt) of user's LoginInfo
     */
    public LoginInfoFileManager() {
        loginInfoFile = new File("data/LoginInfo.txt");
        Path dirPath = Paths.get("data");
        if (!Files.exists(dirPath)) {
            try {
                Files.createDirectory(dirPath);
            } catch (IOException e) {
                System.err.println("Failed to create directory 'data'!" + e.getMessage());
            }
        }

        if (!loginInfoFile.exists()) {
            try {
                loginInfoFile.createNewFile();
            } catch (IOException e) {
                System.err.println("Failed to create file 'data/LoginInfo.txt'!" + e.getMessage());
            }
        }
    }

    /**
     * Registers a new user by writing the information into the file.
     * @param loginInfo new user LoginInfo object
     */
    public void addLoginInfoForNewUser(LoginInfo loginInfo) {
        try {
            FileWriter fw = new FileWriter(loginInfoFile, true);
            fw.write(loginInfo.getUserId() + " | " + loginInfo.getPassword() + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the user LoginInfo from the LoginInfo.txt file
     * @return an ArrayList of LoginInfo from the test file
     */
    public ArrayList<LoginInfo> retrieveLoginInfoList() {
        ArrayList<LoginInfo> loginInfoList = new ArrayList<>();
        try {
            Scanner sc = new Scanner(loginInfoFile);
            while (sc.hasNext()) {
                String[] lineSplit = sc.nextLine().split("\\|");
                loginInfoList.add(new LoginInfo(lineSplit[0].trim(), lineSplit[1].trim()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return loginInfoList;
    }

    public void writeToTxt(ArrayList<LoginInfo> loginInfoList) throws IOException {
        FileWriter fw = new FileWriter(loginInfoFile, false);
        for (LoginInfo loginInfo : loginInfoList) {
            fw.write(loginInfo.strAddToTxt());
            fw.write("\n");
        }
        fw.close();
    }


}

