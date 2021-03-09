package seedu.duke.module;

import seedu.duke.storage.Storage;

import java.util.ArrayList;

public class ModuleList {

    private static final Storage storage = new Storage();

    private ArrayList<String> modules;
    public static Module selectedModule;

    public static boolean setSelectedModule(String name) {
        // dummy module created
        selectedModule = new Module(name);
        // selectedModule = storage.loadModule(name);
        return true;
    }

    public static Module getSelectedModule() {
        return selectedModule;
    }

    public static void reset() {
        selectedModule = null;
    }
}
