package seedu.duke.storage;

import seedu.duke.exceptions.HealthVaultException;
import seedu.duke.ui.UI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class CommonStorage {
    protected File file;
    protected String filePath;
    UI ui = new UI();

    public CommonStorage(String filePath) {
        this.filePath = filePath;
        createFile(filePath);
    }

    protected void createFile(String filePath) {
        try {
            file = new File(filePath);
            if(!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
                ui.fileCreatedMessage();
            }
        } catch (IOException e) {
            ui.fileCreateErrorMessage();
            e.printStackTrace();
        }
    }

    protected File getFile() {
        return file;
    }


}
