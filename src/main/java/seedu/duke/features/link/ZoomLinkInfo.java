package seedu.duke.features.link;

import seedu.duke.features.moduleinfo.Module;
import seedu.duke.features.moduleinfo.ModuleInfo;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import seedu.duke.features.task.command.AddTask;

public class ZoomLinkInfo {

    private String linkDescription;
    private String moduleCode;
    private String password;

    public static ArrayList<ZoomLinkInfo> zoomLinksList = new ArrayList<>();

    public ZoomLinkInfo(String linkDescription, String moduleCode, String password) {
        this.linkDescription = linkDescription;
        this.moduleCode = moduleCode;
        this.password = password;
    }

    public ZoomLinkInfo(String linkDescription, String moduleCode) {
        this.linkDescription = linkDescription;
        this.moduleCode = moduleCode;
        password = "no password entered";
    }

    /**
     * Gets the password (if required),zoom link and password from the user and creates a
     * ZoomLinkInfo object using those parameters and adds the object to the zoomLinksList.
     */
    public static void addZoomLink() {
        String moduleCode;
        if (!ModuleInfo.modules.isEmpty()) {
            Ui.printChooseModule();
            moduleCode = AddTask.printAndGetModule();
            if (searchListForExistingLink(moduleCode)) {
                Ui.printModuleAlreadyHasZoomLink();
                return;
            }
        } else {
            moduleCode = addModuleWhenModuleIsEmpty();
        }
        Ui.printEnterZoomLinkMessage();
        String linkDescription = Ui.readCommand();
        String passwordCommand = Ui.printEnterRequirePassword();
        if (moduleCode.equals("")) {
            moduleCode = "Zoom link has no module code";
        }
        if (passwordCommand.equals("y")) {
            String password = Ui.printEnterPassword();
            assert !password.isEmpty() : "password cannot be empty";
            ZoomLinkInfo zoomLink = new ZoomLinkInfo(linkDescription, moduleCode, password);
            zoomLinksList.add(zoomLink);
        } else {
            assert passwordCommand.equals("n") : "password should be y or n";
            ZoomLinkInfo zoomLink = new ZoomLinkInfo(linkDescription, moduleCode);
            zoomLinksList.add(zoomLink);
        }
        if (moduleCode.equals("Zoom link has no module code")) {
            Ui.printZoomLinksAdded(linkDescription, moduleCode);
            return;
        }
        Module moduleInfo = ModuleInfo.getModule(moduleCode);
        moduleInfo.setZoomLink(linkDescription);
        Ui.printZoomLinksAdded(linkDescription, moduleCode);
    }

    /**
     * Removes the zoom link object from the zoomLinksList.
     *
     * @param deleteIndex is the index of the object to be deleted
     * @throws IndexOutOfBoundsException if the index specified is out of bounds
     */
    public static void deleteZoomLink(int deleteIndex) throws IndexOutOfBoundsException {
        ZoomLinkInfo deletedZoomLink = zoomLinksList.get(deleteIndex);
        Module moduleInfo = ModuleInfo.getModule(deletedZoomLink.getModuleCode());
        try {
            moduleInfo.removeZoomLink();
        } catch (NullPointerException e) {
            System.out.println(
                    "Whoops that zoom link didn't have a module tagged to it... I'll delete it anyway!");
        }
        zoomLinksList.remove(deleteIndex);
        Ui.printZoomLinkDeleted(deletedZoomLink);
    }

    public String getDescription() {
        return linkDescription;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public String getPassword() {
        return password;
    }

    public static void deleteModuleCode(String moduleToDelete) {
        for (ZoomLinkInfo link : zoomLinksList) {
            if (link.getModuleCode().equals(moduleToDelete)) {
                link.moduleCode = "Zoom link has no module code";
            }
        }
    }

    public static String addModuleWhenModuleIsEmpty() {
        String moduleCode;
        Ui.printNoModulesMessage();
        String input = Ui.readCommand().trim();
        if (input.equalsIgnoreCase("N")) {
            moduleCode = "";
        } else {
            ModuleInfo.addNewModule();
            moduleCode = ModuleInfo.modules.get(ModuleInfo.modules.size() - 1).getName();
        }
        return moduleCode;
    }

    public static boolean searchListForExistingLink(String linkToCompare) {
        for (ZoomLinkInfo link : zoomLinksList) {
            if (link.moduleCode.equals(linkToCompare)) {
                return true;
            }
        }
        return false;
    }
}
