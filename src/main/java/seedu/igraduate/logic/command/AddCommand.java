package seedu.igraduate.logic.command;

import seedu.igraduate.model.list.ModuleList;
import seedu.igraduate.storage.Storage;
import seedu.igraduate.ui.Ui;

import seedu.igraduate.exception.SaveModuleFailException;
import seedu.igraduate.exception.InvalidModuleTypeException;
import seedu.igraduate.exception.ExistingModuleException;
import seedu.igraduate.exception.ModuleNotFoundException;
import seedu.igraduate.exception.PrerequisiteNotFoundException;
import seedu.igraduate.exception.InvalidModularCreditException;

import seedu.igraduate.model.module.CoreModule;
import seedu.igraduate.model.module.ElectiveModule;
import seedu.igraduate.model.module.GeModule;
import seedu.igraduate.model.module.MathModule;
import seedu.igraduate.model.module.Module;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Handles add command.
 */
public class AddCommand extends Command {
    // Module information of module to be added
    protected String moduleCode;
    protected String moduleName;
    protected String moduleType;
    protected double moduleCredits;
    protected ArrayList<String> prerequisites;
    protected ArrayList<String> untakenPreRequisites;

    // Module types
    private static final String CORE = "core";
    private static final String UE = "ue";
    private static final String MATH = "math";
    private static final String GE = "ge";

    // Default values
    private static final String DEFAULT_STATUS = "not taken";
    private static final String DEFAULT_GRADE = "nil";

    private static final Logger LOGGER = Logger.getLogger(AddCommand.class.getName());

    //@@author kewenlok
    /**
     * Constructs a new AddCommand object.
     * 
     * @param moduleCode module code. 
     * @param moduleName module name, customised according to user input. 
     * @param moduleType module type (core, ue, ge or math). 
     * @param moduleCredits number of credits for the module.
     * @param prerequisites ArrayList containing all prerequisite modules.
     * @param untakenPrerequisites ArrayList containing all unsatisfied prerequisite modules.
     */
    public AddCommand(String moduleCode, String moduleName, String moduleType, double moduleCredits,
                      ArrayList<String> prerequisites, ArrayList<String> untakenPrerequisites) {
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.moduleType = moduleType;
        this.moduleCredits = moduleCredits;
        this.prerequisites = prerequisites;
        this.untakenPreRequisites = untakenPrerequisites;
    }

    //@@author LJ-37
    /**
     * Retrieves and return module code for the current module.
     *
     * @return module code.
     */
    private String getModuleCode() {
        return moduleCode;
    }

    /**
     * Create a new module object based on module type and add it to module list.
     * Prints add module message after successful execution.
     *
     * @param moduleList Module list consisting of all modules.
     * @param ui User interface for printing result.
     * @param storage Storage for storing module list data.
     * @throws SaveModuleFailException If storage fail to save module data to disk.
     * @throws InvalidModuleTypeException If the module type is invalid.
     * @throws ExistingModuleException If the module to be added already exists in module list.
     * @throws ModuleNotFoundException If the module code is not found.
     * @throws PrerequisiteNotFoundException If any of the prerequisite module does not exists.
     * @throws InvalidModularCreditException If the modular credit is invalid.
     */
    @Override
    public void execute(ModuleList moduleList, Ui ui, Storage storage) throws SaveModuleFailException,
        InvalidModuleTypeException, ExistingModuleException, ModuleNotFoundException, PrerequisiteNotFoundException,
        InvalidModularCreditException {
        LOGGER.log(Level.INFO, "Executing add command...");
        try {
            Module module = createModuleByType();
            moduleList.add(module);
            storage.saveModulesToFile(moduleList);
            ui.printAddModuleMessage(module);
            LOGGER.log(Level.INFO, String.format("Successfully added %s module to module list.",
                    getModuleCode()));
        } catch (InvalidModuleTypeException exception) {
            LOGGER.log(Level.WARNING, "Failed to add invalid module type.", exception);
            throw new InvalidModuleTypeException();
        } catch (ExistingModuleException exception) {
            LOGGER.log(Level.WARNING, "Failed to add duplicated module to module list.", exception);
            throw new ExistingModuleException();
        } catch (PrerequisiteNotFoundException exception) {
            LOGGER.log(Level.WARNING, "Failed to add non-existing prerequisite modules", exception);
            throw new PrerequisiteNotFoundException();
        } finally {
            LOGGER.log(Level.INFO, "End of add command execution.");
        }
    }

    /**
     * Creates a module object based on the module type.
     *
     * @return The created module object.
     * @throws InvalidModuleTypeException If the module type is invalid.
     */
    public Module createModuleByType() throws InvalidModuleTypeException {
        LOGGER.log(Level.INFO, "Creating module...");
        Module module;
        switch (moduleType) {
        case CORE:
            module = new CoreModule(moduleCode, moduleName, moduleCredits, DEFAULT_STATUS,
                    DEFAULT_GRADE, prerequisites, untakenPreRequisites);
            break;
        case UE:
            module = new ElectiveModule(moduleCode, moduleName, moduleCredits, DEFAULT_STATUS,
                    DEFAULT_GRADE, prerequisites, untakenPreRequisites);
            break;
        case MATH:
            module = new MathModule(moduleCode, moduleName, moduleCredits, DEFAULT_STATUS,
                    DEFAULT_GRADE, prerequisites, untakenPreRequisites);
            break;
        case GE:
            module = new GeModule(moduleCode, moduleName, moduleCredits, DEFAULT_STATUS,
                    DEFAULT_GRADE, prerequisites, untakenPreRequisites);
            break;
        default:
            LOGGER.log(Level.INFO, "Failed to create invalid module type.");
            LOGGER.log(Level.INFO, "End of module creation.");
            throw new InvalidModuleTypeException();
        }
        LOGGER.log(Level.INFO, "End of module creation.");

        return module;
    }

    //@@author kewenlok
    /**
     * {@inheritDoc}
     *
     * @return false
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
