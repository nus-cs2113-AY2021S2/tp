package movieApp.ui;

import movieApp.user.User;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.io.Console;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Random;
import java.util.Scanner;

public class Login {

	private static String name;
	private static String password;
	private static Scanner sc = new Scanner(System.in);
	private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static final int SALT_LENGTH = 30;
	private static final int ITERATIONS = 10000;
	private static final int KEY_LENGTH = 256;
	

	public static int login(ArrayList<User> user, String SALT) {
		int currentUserIndex;
		
		do {			
			System.out.println("-------------------Login----------------");
			System.out.print("Enter Name: ");
			name = sc.nextLine();
			
			password = readPasswordSecure();
			
			if(password == null){
				return -1;
			}
			
			currentUserIndex = Login.authenticate(name, password, user, SALT);
		
			if(currentUserIndex < 0) {
				System.out.println("\nLogin failed, user of selected user type failed to authenticate, " +
						"either name or password is incorrect.\n");
			}
		}while(currentUserIndex < 0);
		return currentUserIndex;
	}
	

	public static String readPasswordSecure() {
		String password;
		Console console = System.console();
		
		if(console == null) {
			System.out.println("Due to a bug in some IDEs, password masking is disabled. Please only run this program on the console!");
			System.out.print("Enter Password : ");
			password = sc.nextLine();
			//return null;
		} else {
			password = String.valueOf(console.readPassword("Enter Password : "));
		}
		return password;
	}

	static String generateSALT(int length) {
		String saltString = "";
		Random RANDOM = new SecureRandom();
		for(int i = 0; i < length; i++) {
			saltString += ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length()));
		}
		return saltString;
	}

	public static String encryptPassword(String password, String SALT) {
		byte[] encryptedPasswordByte = null;
		String encryptedPassword = "";
		PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), SALT.getBytes(), ITERATIONS, KEY_LENGTH);
		try {
			SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			encryptedPasswordByte = secretKeyFactory.generateSecret(spec).getEncoded();
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
		} finally {
			spec.clearPassword();
		}
		encryptedPassword = Base64.getEncoder().encodeToString(encryptedPasswordByte);
		return encryptedPassword;
	}

	private static boolean authenticatePassword(String password, String encryptedPassword, String SALT) {
		if(password.equalsIgnoreCase(encryptedPassword)){
			return true;
		} else {
			return false;
		}
	}

	public static int authenticate(String name, String password, ArrayList<User> user, String SALT) {
		for (int index = 0; index < user.size(); index++)
		{
			if (name.equals(user.get(index).getName())) {
				System.out.println(user.get(index).getPassword());
				System.out.println(user.get(index).getName());
				if(authenticatePassword(password, user.get(index).getPassword(), SALT)) {
						return index;
				}
			}
		}
		return -1;
	}
}
