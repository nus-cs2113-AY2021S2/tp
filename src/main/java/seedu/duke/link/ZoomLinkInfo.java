package seedu.duke.link;

import seedu.duke.Module;
import seedu.duke.ModuleInfo;
import seedu.duke.Ui;

import java.util.ArrayList;

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

    public static void addZoomLink(String instruction) {
        String[] words = checkWordValidity(instruction.split(" "));
        String linkDescription = words[0];
        String moduleCode = words[1];
        String passwordCommand = Ui.printEnterRequirePassword();

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
        try {
            Module moduleInfo = ModuleInfo.getModule(linkDescription);
            moduleInfo.setZoomLink(linkDescription);
        } catch (NullPointerException e) {
            Module module = new Module(moduleCode, "no description");
            ModuleInfo.modules.add(module);
            module.setZoomLink(linkDescription);
        }
    }

    public static String[] checkWordValidity(String[] words) {
        while (words.length != 2) {
            System.out.println("Please enter only your link and module code!");
            String instruction = Ui.readCommand();
            words = instruction.split(" ");
        }
        return words;
    }

    public static void deleteZoomLink(int deleteIndex) throws IndexOutOfBoundsException {
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
