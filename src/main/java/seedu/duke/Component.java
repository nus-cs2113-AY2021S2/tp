package seedu.duke;

import java.util.ArrayList;
import java.util.Hashtable;

import static seedu.duke.ModuleInfo.viewAllModules;

public class Component {
    //String moduleName;
    public static Hashtable<String, Integer> components = new Hashtable<>();

    public Component(Hashtable<String, Integer> components) {
        this.components = components;
    }

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
            Ui.printModuleComponentPrompt();
            String[] userInput = Ui.readCommand().split(" ");

            //Test2 stores the old components and adds in the new component.
            Hashtable<String, Integer> component = new Hashtable<>();
            component = modules.get(moduleNumberInt).getComponents();
            component.put(userInput[0], Integer.parseInt(userInput[1]));
            modules.get(moduleNumberInt).setComponents(component);


            System.out.println("Component and weightage added!");
        } else {
            Ui.printModuleDoesNotExistMessage();
        }

    }

    public static void viewComponent(ArrayList<Module> modules) {

        boolean isModuleExist = false;
        viewAllModules();
        System.out.println("Which module would you like to add a component?");
        int moduleNumberInt = Ui.readCommandToInt();
        if (moduleNumberInt >= 1 && moduleNumberInt <= modules.size()) {
            moduleNumberInt--;
            isModuleExist = true;
        }

        if (isModuleExist) {
            //System.out.println(Component.components);
            System.out.println("From Module object: " + modules.get(moduleNumberInt).getName());
            System.out.println(modules.get(moduleNumberInt).getComponents());

        } else {
            Ui.printModuleDoesNotExistMessage();
        }
    }

    //
    //    public static void deleteComponent(String component) {
    //        components.remove(component);
    //    }



}
