package seedu.easylog.commands;

import seedu.easylog.storage.Logging;
import seedu.easylog.storage.SaveData;
import seedu.easylog.ui.Ui;

/**
 * Command class constructor.
 */
public abstract class Command {

    public Ui ui = new Ui();
    public SaveData saveData = new SaveData();
    public Logging logging = new Logging();
}
