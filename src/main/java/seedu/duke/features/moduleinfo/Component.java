package seedu.duke.features.moduleinfo;

import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import static seedu.duke.features.moduleinfo.ModuleInfo.viewAllModules;

public class Component {
    public static Hashtable<String, Integer> components = new Hashtable<>();
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public Component(Hashtable<String, Integer> components) {
        this.components = components;
    }

    /**
     * Adds components and its associated weightage for a module to a Hashtable.
     *
     * @param modules the list of modules users entered.
     */
    public static void addComponent(ArrayList<Module> modules) {


        boolean isModuleExist = false;
        viewAllModules();
        System.out.println("Which module would you like to add a component?");
        int moduleNumberInt = Ui.readCommandToInt();
        if (moduleNumberInt >= 1 && moduleNumberInt <= modules.size()) {
            moduleNumberInt--;
            isModuleExist = true;
        }


        if (isModuleExist) {
            // prompts user for component and its weightage
            int weightage;
            String componentName;
            Ui.printModuleComponentPrompt();
            String[] userInput = Ui.readCommand().split(" ");

            //Test2 stores the old components and adds in the new component.
            Hashtable<String, Integer> component;
            component = modules.get(moduleNumberInt).getComponents();
            try {
                componentName = userInput[0];
                isNumeric(componentName);
                weightage = Integer.parseInt(userInput[1]);
                checkHundredPercent(component, weightage);
                Ui.printConfirmComponentsMessage();
                int confirmation = Ui.readCommandToInt();
                if (confirmation == 1) {
                    component.put(componentName, weightage);
                    modules.get(moduleNumberInt).setComponents(component);
                    setComponentsHere(component);
                    //component.values()
                    System.out.println("Component and weightage added!");
                } else {
                    System.out.println("Component and weightage not added.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Component name cannot be an integer "
                        + "or weightage should be an integer.");
            } catch (InvalidComponentException e) {
                System.out.println("The components' weightage added should not be negative "
                        + "or exceed 100 percent in total.");
            } catch (ArrayIndexOutOfBoundsException e) {
                Ui.printModuleComponentPrompt();
            }

        } else {
            Ui.printInvalidInputMessage();
        }

    }

    /**
     * Checks if the component name is numeric.
     *
     * @param componentName the name of the component.
     * @throws NumberFormatException if component name is numeric
     */
    private static void isNumeric(String componentName) throws NumberFormatException {
        boolean isNumeric = componentName.chars().allMatch(Character::isDigit);
        if (isNumeric) {
            throw new NumberFormatException();
        }
    }

    /**
     * Prompts user for a module and
     * allows users to view the components and its associated weightages
     * for the module specified by the user.
     *
     * @param modules the list of modules users entered.
     */
    public static void viewComponent(ArrayList<Module> modules) {

        boolean isModuleExist = false;
        viewAllModules();
        System.out.println("Which module would you like to view components?");
        int moduleNumberInt = Ui.readCommandToInt();
        if (moduleNumberInt >= 1 && moduleNumberInt <= modules.size()) {
            moduleNumberInt--;
            isModuleExist = true;
        }

        if (isModuleExist) {
            //System.out.println(Component.components);
            System.out.println("From Module object: " + modules.get(moduleNumberInt).getName());
            System.out.println(modules.get(moduleNumberInt).getComponentsToString());

        } else {
            Ui.printInvalidInputMessage();
        }


    }

    /**
     * Checks for all weightages in a module does not exceed 100
     * and are valid weightages, i.e. weightage cannot be negative.
     *
     * @param components the components and its weightage in Hashtable.
     * @param newWeightage the next weightage entered by the user.
     * @throws InvalidComponentException if total weightage exceeds 100 or negative.
     */
    public static void checkHundredPercent(Hashtable<String, Integer> components,
                                           int newWeightage) throws InvalidComponentException {

        Set<String> setOfComponents = components.keySet();
        int total = 0;
        for (String key : setOfComponents) {
            total += Integer.parseInt(String.valueOf(components.get(key)));
        }
        total += newWeightage;

        if (total > 100) {
            logger.log(Level.WARNING, "Weightage exceeds 100%.");
            throw new InvalidComponentException();
        }

        if (newWeightage < 0) {
            logger.log(Level.WARNING, "Weightage falls below 0.");
            throw new InvalidComponentException();
        }
    }

    public static void setComponentsHere(Hashtable<String, Integer> components) {
        Component.components = components;
    }

}
