package seedu.duke;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//@@author nivikcivik-reused
//Reused from https://github.com/nivikcivik/ip/blob/master/src/main/java/dukehandler/FileManager.java with minor modifications
public class StorageModuleInfo {
    public static String filePath = new File("").getAbsolutePath();

    /**
     * Checks if file exists, or creates new file if it doesn't already exist.
     * Edits filepath variable within storage
     */
    public static void loadModuleInfoFile() {
        filePath += "/UniTracker Data";
        File data = new File(filePath);
        if (!data.exists()) {
            boolean isCreated = data.mkdir();
            if (!isCreated) {
                System.out.println("New directory could not be created:(");
            }
        }
        try {
            filePath += "/modules.txt";
            data = new File(filePath);
            if (data.createNewFile()) {
                // System.out.println("New file created at:\n" + data.getAbsolutePath());
                return;
            }
            downloadModules();
        } catch (IOException e) {
            System.out.println("There was an I/O error:(");
        }
    }


    /**
     * Downloads the contents from file (modules.txt) into modules ArrayList
     *
     * @throws FileNotFoundException if modules.txt file cannot be accessed.
     */
    public static void downloadModules() throws FileNotFoundException {
        File f = new File(filePath); // create a File for the given file path
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        while (s.hasNext()) {
            String[] part = s.nextLine().split(" ~~ ");
            Module module = new Module(part[0], part[1]);
            StringBuilder review = new StringBuilder();
            while (true) {
                String line = s.nextLine();
                if (line.contains(" -- end of module -- ")) {
                    review.append(line.split(" -- end of module -- ")[0]);
                    break;
                }
                review.append(line).append("\n");
            }
            module.setReview(review.toString());
            ModuleInfo.modules.add(module);
        }
    }

    /**
     * Writes tasks ArrayList data into modules.txt file on computer
     * Delimiter is ' ~~ '
     *
     * @throws IOException if modules.txt file cannot be accessed.
     */
    public static void modulesFileSaver() throws IOException {
        FileWriter fw = new FileWriter(filePath);
        for (Module module : ModuleInfo.modules) {
            fw.write(module.getName() + " ~~ "
                    + module.getDescription() + "\n"
                    + module.getReview());
            fw.write(" -- end of module -- ");
            fw.write(System.lineSeparator());
        }
        fw.close();
    }

}
