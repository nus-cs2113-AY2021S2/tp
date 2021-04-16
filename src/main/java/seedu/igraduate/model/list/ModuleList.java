package seedu.igraduate.model.list;

import seedu.igraduate.exception.UnableToDeletePrereqModuleException;
import seedu.igraduate.exception.ExistingModuleException;
import seedu.igraduate.exception.ModuleNotFoundException;
import seedu.igraduate.exception.PrerequisiteNotFoundException;
import seedu.igraduate.exception.PrerequisiteNotMetException;
import seedu.igraduate.exception.MarkCompletedModuleException;

import seedu.igraduate.model.module.Module;
import seedu.igraduate.model.module.MathModule;
import seedu.igraduate.model.module.CoreModule;
import seedu.igraduate.model.module.ElectiveModule;
import seedu.igraduate.model.module.GeModule;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Handles underlying operations on modules ArrayList.
 */
public class ModuleList {

    /**
     * ArrayList that stores all the modules data.
     */
    private ArrayList<Module> modules;

    /**
     * Default index for array indexing.
     */
    private static final int DEFAULT_INDEX = -1;

    private static final Logger LOGGER = Logger.getLogger(ModuleList.class.getName());

    //@@author kewenlok
    /**
     * Constructs new ArrayList if no data is provided.
     */
    public ModuleList() {
        this(new ArrayList<>());
    }

    /**
     * Assigns the existing ArrayList with modules data as the module storage.
     *
     * @param modules ArrayList consists of existing modules data.
     */
    public ModuleList(ArrayList<Module> modules) {
        this.modules = modules;
    }

    /**
     * Adds new module to the module storage if not already exists and prerequisite modules exists.
     *
     * @param module Module to be added into the module list.
     * @throws ExistingModuleException If the new module already exists.
     * @throws PrerequisiteNotFoundException If any of the prerequisite module does not exists.
     */
    public void add(Module module) throws ExistingModuleException, PrerequisiteNotFoundException {
        String moduleCode = module.getCode();
        if (getModuleIndex(moduleCode) != DEFAULT_INDEX) {
            assert getModuleIndex(moduleCode) != DEFAULT_INDEX : "No repeating modules allowed to be added";
            throw new ExistingModuleException();
        }
        addModuleToRequiredBy(module);
        removeTakenPrerequisiteModule(module);
        modules.add(module);
    }

    /**
     * Removes taken prerequisite module from current untaken prerequisite ArrayList.
     *
     * @param module Module object to be added to moduleList.
     * @throws PrerequisiteNotFoundException If any of the prerequisite module does not exists.
     */
    public void removeTakenPrerequisiteModule(Module module) throws PrerequisiteNotFoundException {
        ArrayList<String> preRequisites = module.getPrerequisites();

        for (String preRequisite : preRequisites) {
            try {
                Module preRequisiteModule = getModuleByCode(preRequisite);
                String status = preRequisiteModule.getStatus();
                if (status.equals("taken")) {
                    module.removeUntakenPrerequisite(preRequisite.toUpperCase());
                }
            } catch (ModuleNotFoundException e) {
                throw new PrerequisiteNotFoundException();
            }
        }
    }

    /**
     * Check if the prerequisite modules exists in the current module list.
     *
     * @param preRequisites ArrayList containing the prerequisite module codes for module to be added.
     * @return Boolean value indicating whether all the prerequisite modules exist.
     */
    public boolean isPrerequisiteExist(ArrayList<String> preRequisites) {
        for (String preRequisite : preRequisites) {
            if (getModuleIndex(preRequisite) == DEFAULT_INDEX) {
                return false;
            }
        }
        return true;
    }

    /**
     * Add the module code of the new module to the requiredBy list of its prerequisite modules.
     *
     * @param module Module object to be added to moduleList.
     * @throws PrerequisiteNotFoundException If any of the prerequisite module does not exists.
     */
    public void addModuleToRequiredBy(Module module) throws PrerequisiteNotFoundException {
        ArrayList<String> prerequisites = module.getPrerequisites();

        if (!isPrerequisiteExist(prerequisites)) {
            throw new PrerequisiteNotFoundException();
        }

        String moduleCode = module.getCode();

        for (String prerequisite : prerequisites) {
            try {
                Module requiredModule = getModuleByCode(prerequisite);
                ArrayList<String> requiredByModules = requiredModule.getRequiredByModules();
                if (!requiredByModules.contains(moduleCode)) {
                    requiredByModules.add(moduleCode);
                    requiredModule.setRequiredByModules(requiredByModules);
                }
            } catch (ModuleNotFoundException e) {
                throw new PrerequisiteNotFoundException();
            }
        }
    }

    /**
     * Removes specified module from the module storage if it is not required by any module.
     *
     * @param module Module to be removed from the module list.
     * @throws PrerequisiteNotFoundException If the prerequisite module is deleted beforehand.
     * @throws UnableToDeletePrereqModuleException If the module is a prerequisite of other modules.
     */
    public void delete(Module module) throws PrerequisiteNotFoundException, UnableToDeletePrereqModuleException {
        ArrayList<String> requiredByModules = module.getRequiredByModules();

        if (requiredByModules.isEmpty()) {
            modules.remove(module);
            removeFromPrerequisiteModuleRequiredBy(module);
        } else {
            throw new UnableToDeletePrereqModuleException(requiredByModules);
        }
    }

    /**
     * Remove deleted module from its prerequisite modules' required by list.
     *
     * @param module Module object deleted from module list.
     * @throws PrerequisiteNotFoundException If the prerequisite module is deleted beforehand.
     */
    public void removeFromPrerequisiteModuleRequiredBy(Module module) throws PrerequisiteNotFoundException {
        ArrayList<String> prerequisites = module.getPrerequisites();
        String moduleCode = module.getCode();

        for (String preRequisite : prerequisites) {
            try {
                Module preRequisiteModule = getModuleByCode(preRequisite);
                preRequisiteModule.removeRequiredByModule(moduleCode);
            } catch (ModuleNotFoundException e) {
                throw new PrerequisiteNotFoundException();
            }
        }
    }

    /**
     * Marks the specified module as taken.
     *
     * @param module Module to be marked as taken.
     * @throws ModuleNotFoundException If module is not found in module list.
     * @throws PrerequisiteNotMetException If any of the prerequisites in not met.
     * @throws MarkCompletedModuleException If the module is already marked as taken.
     */
    public void markAsTaken(Module module) throws ModuleNotFoundException, PrerequisiteNotMetException,
            MarkCompletedModuleException {
        if (!module.isPrerequisitesSatisfied()) {
            LOGGER.log(Level.INFO, "Prerequisites check failed.");
            throw new PrerequisiteNotMetException(module.getCode(), module.getUntakenPrerequisites());
        }
        if (module.isDone()) {
            LOGGER.log(Level.INFO, "Trying to mark an already done module as done.");
            throw new MarkCompletedModuleException();
        }
        module.setStatus("taken");
        String moduleCode = module.getCode();
        ArrayList<String> requiredByModules = module.getRequiredByModules();
        removeFromModuleUntakenPrerequisites(moduleCode, requiredByModules);
    }

    /**
     * Remove taken module from modules requiring it as prerequisite.
     *
     * @param moduleCode Module code of taken module.
     * @param requiredByModules ArrayList of modules requiring taken module as prerequisite.
     * @throws ModuleNotFoundException If requiredBy module does not exists in module list.
     */
    public void removeFromModuleUntakenPrerequisites(String moduleCode, ArrayList<String> requiredByModules)
            throws ModuleNotFoundException {
        for (String requiredByModule : requiredByModules) {
            Module module = getModuleByCode(requiredByModule);
            module.removeUntakenPrerequisite(moduleCode);
        }
    }

    /**
     * Sets the specified module grade.
     *
     * @param module Module to be marked as taken.
     * @param grade  Grade obtained for the specified module.
     */
    public void setGrade(Module module, String grade) {
        module.setGrade(grade);
    }

    /**
     * Retrieves and returns the underlying ArrayList for storing modules.
     *
     * @return The task list used for storing all modules.
     */
    public ArrayList<Module> getModules() {
        return modules;
    }

    /**
     * Obtains and returns the current module list size.
     *
     * @return The number of modules in the ArrayList.
     */
    public int size() {
        return modules.size();
    }

    /**
     * Checks if the entire module list is empty.
     *
     * @return Boolean value indicating whether the module list is empty.
     */
    public boolean isEmpty() {
        return modules.isEmpty();
    }

    //@@author oscarlai1998
    /**
     * Checks if the list for completed module is empty.
     *
     * @return Boolean value indicating whether there are any completed modules.
     */
    public boolean isCompletedModulesEmpty() {
        for (Module module : modules) {
            if (module.isDone()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the list for incomplete module is empty.
     *
     * @return Boolean value indicating whether there are any incomplete modules.
     */
    public boolean isIncompletedModulesEmpty() {
        for (Module module: modules) {
            if (!module.isDone()) {
                return false;
            }
        }
        return true;
    }

    //@@author kewenlok
    /**
     * Checks if there is any available module.
     *
     * @return Boolean value indicating whether there is module available to take.
     */
    public boolean isModuleAvailable() {
        for (Module module: modules) {
            boolean isPrerequisitesCleared = module.isPrerequisitesSatisfied();
            boolean isIncomplete = module.getStatus().equalsIgnoreCase("not taken");
            if (isPrerequisitesCleared && isIncomplete) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the list for core module is empty.
     *
     * @return Boolean value indicating whether there are any core modules.
     */
    public boolean isCoreModulesEmpty() {
        for (Module module: modules) {
            if (module instanceof CoreModule) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the list for elective module is empty.
     *
     * @return Boolean value indicating whether there are any elective modules.
     */
    public boolean isElectiveModulesEmpty() {
        for (Module module: modules) {
            if (module instanceof ElectiveModule) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the list for ge module is empty.
     *
     * @return Boolean value indicating whether there are any ge modules.
     */
    public boolean isGeModulesEmpty() {
        for (Module module: modules) {
            if (module instanceof GeModule) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the list for math module is empty.
     *
     * @return Boolean value indicating whether there are any math modules.
     */
    public boolean isMathModulesEmpty() {
        for (Module module: modules) {
            if (module instanceof MathModule) {
                return false;
            }
        }
        return true;
    }

    /**
     * Retrieves specified module from module list.
     *
     * @param moduleCode Module code of module.
     * @return The retrieved module based on specified module code.
     * @throws ModuleNotFoundException If the module specified is not in the list.
     */
    public Module getModuleByCode(String moduleCode) throws ModuleNotFoundException {
        int moduleIndex = getModuleIndex(moduleCode);
        if (moduleIndex == DEFAULT_INDEX) {
            throw new ModuleNotFoundException();
        }
        assert moduleIndex != DEFAULT_INDEX : "Module code does not exists.";

        return modules.get(moduleIndex);
    }

    /**
     * Retrieves the index of module in module list.
     *
     * @param moduleCode Module code of module.
     * @return The retrieved module index on specified module code.
     */
    public int getModuleIndex(String moduleCode) {
        int index = DEFAULT_INDEX;

        for (int i = 0; i < modules.size(); i++) {
            if (modules.get(i).getCode().equalsIgnoreCase(moduleCode)) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * Retrieves the module type of specified module.
     *
     * @param module Module object for finding type.
     * @return The type of module specified.
     */
    public String getModuleType(Module module) {
        String moduleType = "Undefined";
        if (module instanceof CoreModule) {
            moduleType = "Core";
        } else if (module instanceof MathModule) {
            moduleType = "Math";
        } else if (module instanceof GeModule) {
            moduleType = "GE";
        } else if (module instanceof ElectiveModule) {
            moduleType = "Elective";
        }
        assert !moduleType.equals("Undefined") : "Module type is not valid.";

        return moduleType;
    }

    /**
     * Calculates the total completed MC of all modules.
     *
     * @return The total completed MCs.
     */
    public double getTotalCompletedMCs() {
        double totalCompletedMCs = 0;
        for (Module module : modules) {
            if (module.getStatus().equalsIgnoreCase("taken")) {
                totalCompletedMCs += module.getCredit();
                assert totalCompletedMCs >= module.getCredit()
                    : "Completed MCs should be more or equal to credits" + "of done modules";
            }
        }
        return totalCompletedMCs;
    }
}
