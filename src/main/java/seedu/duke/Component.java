package seedu.duke;

import java.util.ArrayList;
import java.util.Hashtable;

public class Component {
    //String moduleName;
    public static Hashtable<String, Integer> components = new Hashtable<>();

    public Component(Hashtable<String, Integer> components) {
        this.components = components;
    }

    public static void addComponent(ArrayList<Module> modules) {

        int moduleIndex = 0;
        boolean isModuleExist = false;
        System.out.println("Module Name?");
        String moduleName = Ui.readCommand();
        for (int i = 0; i < modules.size(); i++) {
            if (modules.get(i).getName().contains(moduleName)) {
                isModuleExist = true;
                moduleIndex = i;
                break; // safety break
            }
        }

        if (isModuleExist) {
            // prompts user for component and its weightage
            Ui.printModuleComponentPrompt();
            String[] userInput = Ui.readCommand().split(" ");


            //Test2 stores the old components and adds in the new component.
            Hashtable<String, Integer> component = new Hashtable<>();
            component = modules.get(moduleIndex).getComponents();
            component.put(userInput[0], Integer.parseInt(userInput[1]));
            modules.get(moduleIndex).setComponents(component);




            System.out.println("Component and weightage added!");
        } else {
            Ui.printModuleDoesNotExistMessage();
            Ui.printReturnToModuleInfoMenuMessage();
        }

    }

    public static void viewComponent(ArrayList<Module> modules) {

        int moduleIndex = 0;
        boolean isModuleExist = false;
        System.out.println("Module Name?");
        String moduleName = Ui.readCommand();
        for (int i = 0; i < modules.size(); i++) {
            if (modules.get(i).getName().contains(moduleName)) {
                isModuleExist = true;
                moduleIndex = i;
                System.out.println("module index: " + i);
                break; // safety break
            }
        }

        if (isModuleExist) {
            //System.out.println(Component.components);

            System.out.println("From Module object: ");
            System.out.println(modules.get(moduleIndex).getComponents());
            System.out.println("module index: " + moduleIndex);
        } else {
            Ui.printModuleDoesNotExistMessage();
            Ui.printReturnToModuleInfoMenuMessage();
        }
    }

    //
    //    public static void deleteComponent(String component) {
    //        components.remove(component);
    //    }



}
