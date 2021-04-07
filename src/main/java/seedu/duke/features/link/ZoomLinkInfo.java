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

    public static void addZoomLink() {
        Ui.printPsMessage(ModuleInfo.modules.size());
        String moduleCode = AddTask.printAndGetModule();
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

    public static void deleteZoomLink(int deleteIndex) throws NumberFormatException, IndexOutOfBoundsException {
        ZoomLinkInfo deletedZoomLink = zoomLinksList.get(deleteIndex);
        Module moduleInfo = ModuleInfo.getModule(deletedZoomLink.getModuleCode());
        moduleInfo.removeZoomLink();
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
}
