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
//        DecimalFormat df = new DecimalFormat("#.##");
//        String formattedCap = df.format(currentCap);
        return currentCap;
    }

    public static int getNumberOfGradedMCsTaken() {
        return numberOfGradedMCsTaken;
    }

    //public static void viewCurrentCAPAndGradedMCs() {
    //String formattedCurrentCAPString = String.format("%.02f", getCurrentCap());
    //System.out.println("[ " + formattedCurrentCAPString + numberOfGradedMCsTaken + " ]");
    //}


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
        }

    }

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


    public Double capCalculator(ArrayList<Double> listOfGrades,
                                        ArrayList<Integer> listOfMCs, Integer totalMCs) {


        System.out.println("Calculating on the following entries: ");
        System.out.println("Grades: " + gradesInString);
        System.out.println("MCs: " + listOfMCs);

        System.out.printf("Current CAP: %.02f\n", getCurrentCap());
        System.out.println("Current Graded MCs taken: " + numberOfGradedMCsTaken);

        Double calculatedCap = 0.0;
        for (int i = 0; i < listOfGrades.size(); i++) {
            calculatedCap += listOfGrades.get(i) * listOfMCs.get(i);
        }

        calculatedCap = (calculatedCap + currentCap * numberOfGradedMCsTaken)
                / (totalMCs + numberOfGradedMCsTaken);
        System.out.println("The simulated cumulative average point (rounded to 2 d.p) you have is: ");
        System.out.printf("%.02f\n", calculatedCap);
        return calculatedCap;
    }

}
