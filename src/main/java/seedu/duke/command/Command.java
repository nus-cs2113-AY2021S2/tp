package seedu.duke.command;

import seedu.duke.data.BlockAlias;
import seedu.duke.data.DailyRoute;
import seedu.duke.data.Favourite;
import seedu.duke.data.History;
import seedu.duke.data.NusMap;

/**
 * Represents an executable command.
 */
public abstract class Command {
    protected NusMap nusMap;
    protected BlockAlias blockAlias;
    protected History history;
    protected Favourite favourite;
    protected DailyRoute dailyRoute;
    protected boolean isExit;

    public Command() {
    }

    /**
     * Sets the relevant data as the attributes of the command class.
     */
    public void setData(NusMap nusMap, BlockAlias blockAlias, History history,
                        Favourite favourite, DailyRoute dailyRoute) {
        this.nusMap = nusMap;
        this.blockAlias = blockAlias;
        this.history = history;
        this.favourite = favourite;
        this.dailyRoute = dailyRoute;
    }

    /** Checks whether the application should be closed. */
    public boolean isExit() {
        return isExit;
    }

    public void execute() {
    }
}
