//@@author KimIdeas8

package seedu.duke.storage;

import seedu.duke.data.BlockAlias;
import seedu.duke.data.DailyRoute;
import seedu.duke.data.Favourite;
import seedu.duke.data.History;
import seedu.duke.data.NusMap;
import seedu.duke.exception.InvalidFilePathException;
import seedu.duke.exception.LoadDataException;
import seedu.duke.exception.SaveDataException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class Storage {

    protected final Path filepath;

    protected NusMap nusMap;
    protected BlockAlias blockAlias;
    protected History history;
    protected Favourite favourite;
    protected DailyRoute dailyRoute;

    public Storage(String filepath) throws InvalidFilePathException {
        this.filepath = Paths.get(filepath);
        createDirectory();
        createFile();
    }

    public void createDirectory() throws InvalidFilePathException {
        if (!Files.exists(filepath.getParent())) {
            try {
                Files.createDirectory(filepath.getParent());
            } catch (IOException ioe) {
                throw new InvalidFilePathException();
            }
        }
    }

    public void createFile() throws InvalidFilePathException {
        if (!Files.exists(filepath)) {
            try {
                Files.createFile(filepath);
            } catch (IOException ioe) {
                throw new InvalidFilePathException();
            }
        }
    }

    public void setData(NusMap nusMap, BlockAlias blockAlias, History history,
                           Favourite favourite, DailyRoute dailyRoute) {
        this.nusMap = nusMap;
        this.blockAlias = blockAlias;
        this.history = history;
        this.favourite = favourite;
        this.dailyRoute = dailyRoute;
    }

    public void saveData() throws SaveDataException {
    }

    public void loadData() throws LoadDataException {
    }

}
