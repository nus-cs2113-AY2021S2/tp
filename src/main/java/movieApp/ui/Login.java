package movieApp.ui;

import movieApp.user.User;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.io.Console;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Scanner;

public class Login {

    private static final Scanner sc = new Scanner(System.in);
    private static String name;
    private static char[] password;

    /**
     * Displays the main Login page
     *
     * @param user an ArrayList of User objects, that contain all users in the database
     * @return an int corresponding to the index of User in the ArrayList, upon successful login
     */
    public static int login(ArrayList<User> user) throws Exception {
        int currentUserIndex;

        do {
            final String LOGO = "\n" +
                    "___  ___           _       ___                    \n" +
                    "|  \\/  |          (_)     / _ \\                 \n" +
                    "| .  . | _____   ___  ___/ /_\\ \\_ __  _ __      \n" +
                    "| |\\/| |/ _ \\ \\ / / |/ _ \\  _  | '_ \\| '_ \\ \n" +
                    "| |  | | (_) \\ V /| |  __/ | | | |_) | |_) |     \n" +
                    "\\_|  |_/\\___/ \\_/ |_|\\___\\_| |_/ .__/| .__/  \n" +
                    "                               | |   | |          \n" +
                    "                               |_|   |_|            ";

            System.out.println(LOGO);
            System.out.println("-------------------Login----------------");
            System.out.print("Enter Name: (input \"out\" to quit the application)\n");
            name = sc.nextLine().toUpperCase();

            if (name.equals("OUT")) {
                System.exit(0);
            }

            password = readPasswordSecure().toCharArray();

            if (password == null) {
                return -1;
            }

            currentUserIndex = Login.authenticate(name, password, user);

            if (currentUserIndex < 0) {
                System.out.println("\nLogin failed, user of selected user type failed to authenticate, " +
                        "either name or password is incorrect.\n");
            }
        } while (currentUserIndex < 0);
        return currentUserIndex;
    }

    /**
     * Returns the password entered by the user, for verification purposes
     *
     * @return password a String corresponding user input password
     */
    public static String readPasswordSecure() {
        String password;
        Console console = System.console();

        if (console == null) {
            System.out.println("Due to a bug in some IDEs, password masking is disabled. Please only run this program on the console!");
            System.out.print("Enter Password :\n");
            password = sc.nextLine();
            //return null;
        } else {
            password = String.valueOf(console.readPassword("Enter Password : "));
        }
        return password;
    }

    /**
     * Returns the hashed password entered by the user, for verification purposes
     *
     * @param password a char array of the user input
     * @param salt     a byte array used to hash the input
     * @param bytes    an integer used to hash the input
     * @return password a byte array corresponding user input password
     */
    private static byte[] generatePBKDF2(char[] password, byte[] salt, int bytes) throws Exception {
        KeySpec spec = new PBEKeySpec(password, salt, 32768, bytes * 8);
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return factory.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new Exception("Hashing error!");
        }
    }

    /**
     * Returns a boolean, indicating whether two hashed passwords match
     *
     * @param hash1 a byte array of corresponding hashed password in the user list
     * @param hash2 a byte array of hashed user input
     * @return boolean of matching result
     */
    private static boolean slowEquals(byte[] hash1, byte[] hash2) {
        int diff = hash1.length ^ hash2.length;
        for (int i = 0; i < hash1.length && i < hash2.length; i++) {
            diff |= hash1[i] ^ hash2[i];
        }

        return diff == 0;
    }

    /**
     * Returns a boolean, indicating whether a user input
     * matches with the hashed password in the user list
     *
     * @param password a char array of user input
     * @param goodHash a char array of corresponding hashed password in the database
     * @return boolean of matching result
     */
    private static boolean validatePassword(char[] password, char[] goodHash) throws Exception {
        String[] params = String.valueOf(goodHash).split("~");
        byte[] salt = Base64.getDecoder().decode(params[0].trim());
        byte[] hash = Base64.getDecoder().decode(params[1].trim());
        byte[] testHash = generatePBKDF2(password, salt, hash.length);
        return slowEquals(hash, testHash);
    }

    /**
     * Returns an index of the logged user in the user list
     *
     * @param name     String of the username input
     * @param password a char array of the user input
     * @param user     an array list of the users collection
     * @return integer of the logged user index
     */
    public static int authenticate(String name, char[] password, ArrayList<User> user) throws Exception {
        for (int index = 0; index < user.size(); index++) {
            name = name.trim();
            if (name.equals(user.get(index).getName())) {
                if (validatePassword(password, user.get(index).getPassword().toCharArray())) {
                    return index;
                }
            }
        }
        return -1;
    }
}
