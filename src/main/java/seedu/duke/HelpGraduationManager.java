package seedu.duke;

public class HelpGraduationManager {

    public static void execute() {
        while (true) {
            Ui.printHelpGraduationMenu();
            String command = Ui.readCommand();
            Ui.printHorizontalLine();
            try {
                int helpGraduationIndex = Integer.parseInt(command);
                switch (helpGraduationIndex) {
                case 1:
                    Ui.getCurrentCapPrompt();
                    //missing exception to catch <0 >5 CAP user input
                    double cap = Double.parseDouble(Ui.readCommand());
                    assert cap >= 0.0: "Not Valid";
                    assert cap <= 5.0: "Not Valid";
                    HelpGraduation.setCurrentCap(cap);
                    System.out.println(cap);
                    //assert false;



                    Ui.getNumberOfGradedMCsTakenPrompt();
                    //missing exception to catch <0 >180? MCs user input
                    HelpGraduation.setNumberOfGradedMCsTaken(Integer.parseInt(Ui.readCommand()));
                    Ui.printRegisteredCapAndMCsTakenMessage();
                    Ui.printHorizontalLine();
                    break;
                case 2:
                    Ui.printRegisteredCapAndMCsTakenMessage();
                    Ui.printHorizontalLine();
                    break;
                case 3:
                    HelpGraduation helpGraduation = new HelpGraduation();
                    helpGraduation.capSimulator();
                    break;
                case 4:
                    return;
                default:
                    Ui.printInvalidIntegerMessage();
                }
            } catch (NumberFormatException e) {
                Ui.printInvalidIntegerMessage();
                Ui.printHorizontalLine();
            }
        }
    }
}
