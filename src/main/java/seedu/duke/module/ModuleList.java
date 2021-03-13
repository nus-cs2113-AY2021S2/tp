package seedu.duke.module;


import seedu.duke.storage.Loader;
import seedu.duke.storage.Writer;

import java.util.ArrayList;
import java.util.Collections;

import static java.util.Objects.requireNonNull;

public class ModuleList {

    private static final ArrayList<String> modules = new ArrayList<>();
    private static Module selectedModule;

    public static Module getSelectedModule() {
        return selectedModule;
    }

    /**
     * For testing purposes only.
     */
    public static void hardSetSelectedModule(String moduleCode) {
        ModuleList.selectedModule = new Module(moduleCode);
    }

    public static ArrayList<String> getModules() {
        return modules;
    }

    //@@author 8kdesign
    /**
     * Searches directory for module files.
     * Adds their name (excluding ".txt") to the module list.
     */
    public static void loadModuleNames() {
        modules.clear();
        Loader loader = new Loader();
        for (String name : loader.getModules()) {
            insertModule(name);
        }
    }

    //@@author 8kdesign
    /**
     * Adds a new module to the module list and add create file for new module.
     *
     * @param moduleCode Module name, excluding ".txt".
     */
    public static boolean addModule(String moduleCode) {
        if (insertModule(moduleCode)) {
            Writer writer = new Writer();
            writer.createFile(moduleCode);
            return true;
        }
        return false;
    }

    //@@author 8kdesign
    /**
     * Adds a module to the module list.
     *
     * @param moduleCode Module code, excluding ".txt".
     */
    private static boolean insertModule(String moduleCode) {
        if (modules.contains(moduleCode)) {
            //Error, module already exists
            return false;
        }
        modules.add(moduleCode);
        return true;
    }

    //@@author isaharon
    /**
     * Deletes modules specified.
     *
     * @param moduleNumbers Index of modules to delete.
     * @return List of names of modules that are deleted.
     */
    public static ArrayList<String> deleteModules(ArrayList<Integer> moduleNumbers) {
        ArrayList<String> deletedModules = new ArrayList<>();
        Collections.reverse(moduleNumbers);
        for (Integer moduleNumber : moduleNumbers) {
            int indexToRemove = moduleNumber - 1;
            String name = removeModule(indexToRemove);
            if (name != null) {
                deletedModules.add(0, name);
            }
        }
        return deletedModules;
    }

    //@@author 8kdesign
    /**
     * Removes selected module and deletes module file.
     *
     * @param index Index of module to remove.
     */
    public static String removeModule(int index) {
        if (index < 0 || index >= modules.size()) {
            return null;
        }
        Writer writer = new Writer();
        if (writer.deleteFile(modules.get(index))) {
            String moduleName = modules.get(index);
            modules.remove(index);
            return moduleName;
        } else {
            //Unable to remove
            return null;
        }
    }

    //@@author 8kdesign
    /**
     * Loads the current module from storage.
     *
     * @param moduleCode Module name, excluding ".txt".
     * @return True if successful, false if unable to find file.
     */
    public static boolean setSelectedModule(String moduleCode) {
        Loader loader = new Loader();
        if (!modules.contains(moduleCode)) {
            //Unable to find file
            return false;
        }
        selectedModule = loader.loadModule(moduleCode);
        if (selectedModule != null) {
            //Remove invalid inputs
            Writer writer = new Writer();
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

    /**
     * Writes updated data to file of selected module.
     */
    public static void writeModule() {
        Writer writer = new Writer();
        writer.writeModule();
    }
}
