package seedu.duke.module;

import java.util.ArrayList;

public class ModuleList {

    private final ArrayList<String> modules;
    public static Module selectedModule;

    public ModuleList() {
        this.modules = new ArrayList<>();
    }

    public ModuleList(ArrayList<String> modules) {
        this.modules = modules;
    }

    public ArrayList<String> getModules() {
        return modules;
    }

    public String addModule(String moduleCode) {
        modules.add(moduleCode);
        return moduleCode;
    }
}
