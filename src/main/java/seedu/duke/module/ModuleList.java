package seedu.duke.module;


import java.lang.reflect.Array;
import seedu.duke.storage.Loader;
import seedu.duke.storage.Writer;

import java.util.ArrayList;
import java.util.Collections;

import static java.util.Objects.requireNonNull;

public class ModuleList {

    private static final ArrayList<String> modules = new ArrayList<>();
    public static Module selectedModule;

    public static Module getSelectedModule() {
        return selectedModule;
    }

    public static ArrayList<String> getModuleList() {
        return modules;
    }

    /**
     * Searches directory for module files.
     * Adds their name (excluding ".txt") to the module list.
     *
     * @param loader Instance of Loader class.
     */
    public static void loadModuleNames(Loader loader) {
        modules.clear();
        for (String name : loader.getModuleNames()) {
            insertModule(name);
        }
    }


    /**
     * Adds a new module to the module list and add create file for new module.
     *
     * @param name Module name, excluding ".txt".
     * @param writer Instance of Writer class.
     */
    public static void addModule(String name, Writer writer) {
        if (insertModule(name)) {
            writer.createFile(name);
        }
    }
    
    public void addModule(String moduleCode) {
        modules.add(moduleCode);
    }

    /**
     * Adds a module to the module list.
     *
     * @param name Module name, excluding ".txt".
     */
    private static boolean insertModule(String name) {
        if (modules.contains(name)) {
            //Error, module already exists
            return false;
        }
        modules.add(name);
        return true;
    }


    /**
     * Removes selected module and deletes module file.
     *
     * @param index index of module to remove.
     */
    public static void removeModule(int index, Writer writer) {
        if (index < 0 || index >= modules.size()) {
            return;
        }
        if (writer.deleteFile(modules.get(index))) {
            modules.remove(index);
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
        if (!modules.contains(name)) {
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
  
    public ArrayList<String> getModules() {
        return modules;
    }

    public boolean hasModuleCode(String moduleCode) {
        requireNonNull(moduleCode);
        return modules.contains(moduleCode);
    }

    public ArrayList<String> deleteModules(ArrayList<Integer> moduleNumbers) {
        ArrayList<String> deletedModules = new ArrayList<>();
        Collections.reverse(moduleNumbers);
        for (Integer moduleNumber : moduleNumbers) {
            int indexToRemove = moduleNumber - 1;
            deletedModules.add(0, modules.remove(indexToRemove));
        }
        return deletedModules;
    }

    public void clearModules() {
        modules.clear();
    }
}
