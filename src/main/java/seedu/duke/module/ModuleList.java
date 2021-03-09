package seedu.duke.module;

import java.util.ArrayList;

import static java.util.Objects.requireNonNull;

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

    public boolean hasModuleCode(String moduleCode) {
        requireNonNull(moduleCode);
        return modules.contains(moduleCode);
    }
}
