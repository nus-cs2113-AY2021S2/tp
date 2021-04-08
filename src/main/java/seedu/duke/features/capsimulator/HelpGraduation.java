package seedu.duke.features.capsimulator;

import seedu.duke.features.moduleinfo.Module;
import seedu.duke.features.moduleinfo.ModuleInfo;
import seedu.duke.ui.Ui;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class HelpGraduation {

    private static Double currentCap = 0.0;
    private static int numberOfGradedMCsTaken = 0;
    private int totalMCs = 0;
    public ArrayList<Double> listOfGrades;
    public ArrayList<Integer> listOfMCs;
    public ArrayList<String> gradesInString;


    public HelpGraduation() {
        this.listOfGrades = new ArrayList<>();
        this.listOfMCs = new ArrayList<>();
        this.gradesInString = new ArrayList<>();
    }

    public static void setCurrentCap(Double currentCap) {
        HelpGraduation.currentCap = currentCap;
    }

    public static void setTotalMcs(int numberOfGradedMCsTaken) {
        HelpGraduation.numberOfGradedMCsTaken = numberOfGradedMCsTaken;
    }

    public static Double getCurrentCap() {
        DecimalFormat df = new DecimalFormat("#.##");
        String formattedCap = df.format(currentCap);
        return Double.parseDouble(formattedCap);
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
                    receivingMCs();
                    break;
                case "A-":
                    listOfGrades.add(4.5);
                    receivingMCs();
                    break;
                case "B+":
                    listOfGrades.add(4.0);
                    receivingMCs();
                    break;
                case "B":
                    listOfGrades.add(3.5);
                    receivingMCs();
                    break;
                case "B-":
                    listOfGrades.add(3.0);
                    receivingMCs();
                    break;
                case "C+":
                    listOfGrades.add(2.5);
                    receivingMCs();
                    break;
                case "C":
                    listOfGrades.add(2.0);
                    receivingMCs();
                    break;
                case "D+":
                    listOfGrades.add(1.5);
                    receivingMCs();
                    break;
                case "D":
                    listOfGrades.add(1.0);
                    receivingMCs();
                    break;
                case "F":
                    listOfGrades.add(0.0);
                    receivingMCs();
                    break;
                case "SU":
                    // work in progress here
                    break;
                case "OK":
                    capCalculator(listOfGrades, listOfMCs, totalMCs);
                    break;
                case "Q":
                    Ui.printEraseSimulationEntriesMessage();
                    return;
                default:
                    Ui.printInvalidGradeMessage();
                }
            }
        }

    }

    public void receivingMCs() {
        Ui.printMCsPerModulePrompt();
        String numberOfMCs = Ui.readCommand().trim();
        switch (numberOfMCs) {
        case "1":
            listOfMCs.add(1);
            totalMCs += 1;
            break;
        case "2":
            listOfMCs.add(2);
            totalMCs += 2;
            break;
        case "4":
            listOfMCs.add(4);
            totalMCs += 4;
            break;
        case "6":
            listOfMCs.add(6);
            totalMCs += 6;
            break;
        case "8":
            listOfMCs.add(8);
            totalMCs += 8;
            break;
        case "10":
            listOfMCs.add(10);
            totalMCs += 10;
            break;
        case "12":
            listOfMCs.add(12);
            totalMCs += 12;
            break;
        case "q":
            // to remove last grade keyed in by user due to
            // unexpected input for MCs associated with the last grade.
            int gradeIndex = listOfGrades.size() - 1;
            listOfGrades.remove(gradeIndex);
            Ui.printEraseSimulationEntriesMessage();
            return;
        default:
            // to remove last grade keyed in by user due to
            // unexpected input for MCs associated with the last grade.
            gradeIndex = listOfGrades.size() - 1;
            listOfGrades.remove(gradeIndex);
            gradesInString.remove(gradeIndex);
            Ui.printInvalidModularCreditMessage();
        }
    }


    public Double capCalculator(ArrayList<Double> listOfGrades,
                                        ArrayList<Integer> listOfMCs, Integer totalMCs) {


        System.out.println("Calculating on the following entries entered: ");
        System.out.println("Grades entered: " + gradesInString);
        System.out.println("MCs entered: " + listOfMCs);

        System.out.println("Current CAP: " + currentCap);
        System.out.println("Current Graded MCs taken: " + numberOfGradedMCsTaken);

        Double calculatedCap = 0.0;
        for (int i = 0; i < listOfGrades.size(); i++) {
            calculatedCap += listOfGrades.get(i) * listOfMCs.get(i);
        }

        calculatedCap = (calculatedCap + currentCap * numberOfGradedMCsTaken)
                / (totalMCs + numberOfGradedMCsTaken);
        System.out.println("The simulated cumulative average point (rounded to 2 d.p) you have is: ");
        DecimalFormat df = new DecimalFormat("#.##");
        String formattedCap = df.format(calculatedCap);
        System.out.println(formattedCap);
        return calculatedCap;
    }

}
