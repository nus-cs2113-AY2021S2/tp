package seedu.duke.module;

import seedu.duke.storage.Loader;
import seedu.duke.storage.Writer;

import java.util.ArrayList;

public class ModuleList {

    private static final ArrayList<String> moduleList = new ArrayList<>();
    public static Module selectedModule;

    public static ArrayList<String> getModuleList() {
        return moduleList;
    }


    /**
     * Searches directory for module files.
     * Adds their name (excluding ".txt") to the module list.
     *
     * @param loader Instance of Loader class.
     */
    public static void loadModuleNames(Loader loader) {
        for (String name : loader.getModuleNames()) {
            insertModule(name);
        }
    }


    /**
     * Adds a new module to the moduleList and add create file for new module.
     *
     * @param name Module name, excluding ".txt".
     * @param writer Instance of Writer class.
     */
    public static void addModule(String name, Writer writer) {
        if (insertModule(name)) {
            writer.createFile(name);
        }
    }


    /**
     * Adds a module to the moduleList.
     *
     * @param name Module name, excluding ".txt".
     */
    private static boolean insertModule(String name) {
        if (moduleList.contains(name)) {
            //Error, module already exists
            return false;
        }
        moduleList.add(name);
        return true;
    }


    /**
     * Removes selected module and deletes module file.
     *
     * @param index index of module to remove.
     */
    public static void removeModule(int index, Writer writer) {
        if (index < 0 || index >= moduleList.size()) {
            return;
        }
        if (writer.deleteFile(moduleList.get(index))) {
            moduleList.remove(index);
        } else {
            //Unable to remove
        }
    }


    /**
     * Loads the current module from storage.
     *
     * @param name Module name, excluding ".txt".
     * @return True if successful, false if unable to find file.
     */
    public static boolean setSelectedModule(String name, Loader loader, Writer writer) {
        if (!moduleList.contains(name)) {
            //Unable to find file
            return false;
        }
        selectedModule = loader.loadModule(name);
        if (selectedModule != null) {
            //Remove invalid inputs
            writer.writeModule();
        }
        return selectedModule != null;
    }


    /**
     * Resets selected module by setting it to null.
     */
    public static void reset() {
        selectedModule = null;
    }
}
