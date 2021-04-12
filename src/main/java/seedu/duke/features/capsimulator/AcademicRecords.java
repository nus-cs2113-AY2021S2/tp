package seedu.duke.features.capsimulator;

import seedu.duke.features.moduleinfo.Module;
import seedu.duke.features.moduleinfo.ModuleInfo;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AcademicRecords {

    private static Double currentCap = 0.0;
    private static int numberOfGradedMCsTaken = 0;
    private int totalMCs = 0;
    public ArrayList<Double> listOfGrades;
    public ArrayList<Integer> listOfMCs;
    public ArrayList<String> gradesInString;
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


    /**
     * Constructor to store a fresh set of list of grades and modular credits
     * everytime user choose to simulate CAP score.
     */
    public AcademicRecords() {
        this.listOfGrades = new ArrayList<>();
        this.listOfMCs = new ArrayList<>();
        this.gradesInString = new ArrayList<>();
    }

    public static void setCurrentCap(Double currentCap) {
        AcademicRecords.currentCap = currentCap;
    }

    public static void setTotalMcs(int numberOfGradedMCsTaken) {
        AcademicRecords.numberOfGradedMCsTaken = numberOfGradedMCsTaken;
    }

    public static Double getCurrentCap() {
        return currentCap;
    }

    public static int getNumberOfGradedMCsTaken() {
        return numberOfGradedMCsTaken;
    }


    /**
     * Simulates CAP score given user input. If user input equals to 1,
     * CAP score is calculated with the grades and MCs stored in each
     * module in the program, together with and their current CAP
     * and total MCs counted.
     * If user equals to 2, CAP score is calculated with the grades and MCs
     * that is to be keyed in by user.
     * Simulation prints the final CAP score simulated and the simulation score
     * is not saved.
     */
    public void capSimulator() {
        Ui.printCapSimulatorSetting();
        int capSimulatorSetting = Ui.readCommandToInt();
        if (capSimulatorSetting == 1) {
            logger.log(Level.INFO, "Going to start cap simulator version 1");
            for (Module module : ModuleInfo.modules) {
                String grade = module.getGrade();
                int modularCredits = module.getMc();

                if (!ModuleGradeEnum.checkPassFailGrade(grade)) {
                    totalMCs += modularCredits;
                }
                gradesInString.add(grade);
                String moduleName = module.getName();
                listOfGrades.add(ModuleGradeEnum.checkScoreAgainstGrade(grade, moduleName));
                listOfMCs.add(modularCredits);
            }
            Ui.printWelcomeVersion1Message();
            capCalculator(listOfGrades, listOfMCs, totalMCs);
        } else if (capSimulatorSetting == 2) {
            logger.log(Level.INFO, "Going to start cap simulator version 2");
            Ui.printCapSimulatorPrompt();
            while (true) {
                Ui.printGradePerModulePrompt();
                String grades = Ui.readCommand().toUpperCase();
                if (ModuleGradeEnum.checkGradeExist(grades)) {
                    gradesInString.add(grades);
                }
                switch (grades) {
                case "A+":
                case "A":
                    listOfGrades.add(5.0);
                    receivingMCs(false);
                    break;
                case "A-":
                    listOfGrades.add(4.5);
                    receivingMCs(false);
                    break;
                case "B+":
                    listOfGrades.add(4.0);
                    receivingMCs(false);
                    break;
                case "B":
                    listOfGrades.add(3.5);
                    receivingMCs(false);
                    break;
                case "B-":
                    listOfGrades.add(3.0);
                    receivingMCs(false);
                    break;
                case "C+":
                    listOfGrades.add(2.5);
                    receivingMCs(false);
                    break;
                case "C":
                    listOfGrades.add(2.0);
                    receivingMCs(false);
                    break;
                case "D+":
                    listOfGrades.add(1.5);
                    receivingMCs(false);
                    break;
                case "D":
                    listOfGrades.add(1.0);
                    receivingMCs(false);
                    break;
                case "F":
                    listOfGrades.add(0.0);
                    receivingMCs(false);
                    break;
                case "SU":
                    listOfGrades.add(0.0);
                    receivingMCs(true);
                    break;
                case "OK":
                    capCalculator(listOfGrades, listOfMCs, totalMCs);
                    return;
                case "Q":
                    Ui.printEraseSimulationEntriesMessage();
                    return;
                default:
                    Ui.printInvalidGradeMessage();
                }
            }
        } else {
            Ui.printInvalidInputMessage();
        }

    }

    /**
     * Prompts user for a valid MCs for the grade keyed in during simulation.
     * If the grade entered by the user comes with zero grade points,
     * the MCs associated with the grade is not taken into account
     * when calculating CAP.
     *
     * @param isSU boolean value of the grade, whether it is S/U-ed or a normal grade.
     */
    public void receivingMCs(boolean isSU) {
        Ui.printMCsPerModulePrompt();
        Integer numberOfMCs = Ui.readCommandToInt();

        if (ModularCreditEnum.checkMcsExist(numberOfMCs)) {
            listOfMCs.add(numberOfMCs);
            if (!isSU) {
                totalMCs += numberOfMCs;
            }
        } else {
            int gradeIndex = listOfGrades.size() - 1;
            listOfGrades.remove(gradeIndex);
            gradesInString.remove(gradeIndex);
            Ui.printInvalidModularCreditMessage();
        }
    }

    /**
     * Returns the calculated CAP score base on the list of grades, list of MCs
     * and totalMCs, and prints the CAP score in 2 decimal places.
     *
     * @param listOfGrades The list of grade points associated with the grade base on NUS website.
     * @param listOfMCs The list of MCs entered by the user.
     * @param totalMCs The total number of MCs with non-zero grade points.
     * @return
     */
    public Double capCalculator(ArrayList<Double> listOfGrades,
                                        ArrayList<Integer> listOfMCs, Integer totalMCs) {


        Ui.printCapCalculatorMessage(gradesInString, listOfMCs,
                getCurrentCap(), numberOfGradedMCsTaken);

        Double calculatedCap = 0.0;
        for (int i = 0; i < listOfGrades.size(); i++) {
            calculatedCap += listOfGrades.get(i) * listOfMCs.get(i);
        }

        calculatedCap = (calculatedCap + currentCap * numberOfGradedMCsTaken)
                / (totalMCs + numberOfGradedMCsTaken);
        Ui.printSimulatedCapMessage(calculatedCap);
        return calculatedCap;
    }

}
