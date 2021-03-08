package seedu.duke.module;

import seedu.duke.storage.Storage;

import java.util.ArrayList;

public class ModuleList {

    private static final Storage storage = new Storage();

    public static ArrayList<String> moduleList;
    public static Module selectedModule;

    public static boolean setSelectedModule(Module name) {
        selectedModule = name;
        return true;
    }

    public static Module getSelectedModule() {
        return selectedModule;
    }


    public static void reset() {
        selectedModule = null;
    }
}
