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
            int weightage;
            String componentName;
            Ui.printModuleComponentPrompt();
            String[] userInput = Ui.readCommand().split(" ");

            //Test2 stores the old components and adds in the new component.
            Hashtable<String, Integer> component;
            component = modules.get(moduleNumberInt).getComponents();
            try {
                componentName = userInput[0];
                weightage = Integer.parseInt(userInput[1]);
                component.put(componentName, weightage);

//                System.out.println("TEST");
//                System.out.println(component);

                modules.get(moduleNumberInt).setComponents(component);
                setComponentsHere(component);
                //component.values()
                System.out.println("Component and weightage added!");

            } catch (NumberFormatException e) {
                Ui.printModuleComponentPrompt();
            }

        } else {
            Ui.printModuleDoesNotExistMessage();
        }

        //toStringComponent(modules.get(moduleNumberInt).getComponents());

//        System.out.println("getComponent: ");
//        System.out.println(getComponentsHere());


    }

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
            System.out.println(modules.get(moduleNumberInt).getComponents());

        } else {
            Ui.printModuleDoesNotExistMessage();
        }


    }

    //
    //    public static void deleteComponent(String component) {
    //        components.remove(component);
    //    }


    public static void setComponentsHere(Hashtable<String, Integer> components) {
        Component.components = components;
    }

    public static Hashtable<String, Integer> getComponentsHere() {
        return components;
    }

    public static void toStringComponent(Hashtable<String, Integer> components) {

        ArrayList<String> com = new ArrayList<>();
        components.forEach((k,v)->com.add(k + " ~~ " + v));
        System.out.println(com);

    }

}
