package seedu.duke.storage;

import seedu.duke.BlockAlias;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

public class AliasStorage extends Storage{
    public AliasStorage(String path) {
        super(path);
    }

    public void loadAlias(BlockAlias blockAlias) throws IOException {
        try {
            Scanner s = new Scanner(new File(this.filepath)); // create a Scanner using the File as the source
            while (s.hasNext()) {
                String[] blockAliasPair = s.nextLine().split("\\|");
                String block = blockAliasPair[1].trim();
                String alias = blockAliasPair[0].trim();
                blockAlias.getAliasMap().put(alias, block);
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

    public void overwriteAliasListFile(BlockAlias blockAlias) {
        //write to file:
        try {
            PrintWriter writer = new PrintWriter(this.filepath);
            writer.print("");
            writer.close();
            for (Map.Entry<String, String> aliasBlockPair: blockAlias.getAliasMap().entrySet()) {
                String currentAlias = aliasBlockPair.getKey();
                String currentBlock = aliasBlockPair.getValue();
                appendToAliasListFile(currentAlias + " | " + currentBlock);
                appendToAliasListFile(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Write: File not found");
        } catch (IOException e) {
            System.out.print("Unable to write to file");
        }
    }

    public void appendToAliasListFile(String textToAdd) throws IOException {
        FileWriter fw = new FileWriter(this.filepath, true);
        fw.write(textToAdd);
        fw.close();
    }
}
