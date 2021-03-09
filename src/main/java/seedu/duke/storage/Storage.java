package seedu.duke.storage;

import seedu.duke.record.Record;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

public class Storage {
    public static final Path SAVED_FILE_PATH = Paths.get("finux.txt");

    public Path dataFilePath;

    public Storage() {
        this(SAVED_FILE_PATH);
    }

    public Storage(Path dataFilePath) {
        this.dataFilePath = dataFilePath;
    }

    private boolean saveFileExists(Path filePath) {
        return Files.exists(filePath);
    }

    public void saveFile(ArrayList<Record> records) throws IOException {
        FileWriter fw = new FileWriter(dataFilePath.toString(), false);
        fw.write("Test Save!");
        for (Record r : records) {
            fw.write(r.convertFileFormat() + System.lineSeparator());
        }
        fw.close();
    }

    public void loadFile() {
        try {
            File loadFile = dataFilePath.toFile();
            Scanner sc = new Scanner(loadFile);
            StringJoiner jn = new StringJoiner(" ");
            while(sc.hasNextLine()){
                String rawData = sc.nextLine();
                jn.add(rawData);
            }
            System.out.println(jn.toString());
        } catch (Exception e) {
            System.exit(-1);
        }
    }
}
