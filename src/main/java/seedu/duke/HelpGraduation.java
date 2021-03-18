package seedu.duke;

import java.util.ArrayList;

public class HelpGraduation {

    private static Double currentCap = 0.0;
    private static int numberOfGradedMCsTaken = 0;
    public int totalMCs;
    public ArrayList<Double> listOfGrades;
    public ArrayList<Integer> listOfMCs;

    public HelpGraduation() {
        this.totalMCs = 0;
        this.listOfGrades = new ArrayList<>();
        this.listOfMCs = new ArrayList<>();
    }

    public static void setCurrentCap(Double currentCap) {
        HelpGraduation.currentCap = currentCap;
    }

    public static void setNumberOfGradedMCsTaken(int numberOfGradedMCsTaken) {
        HelpGraduation.numberOfGradedMCsTaken = numberOfGradedMCsTaken;
    }

    public static Double getCurrentCap() {
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
        Ui.printCapSimulatorPrompt();
        while (true) {
            Ui.printGradePerModulePrompt();
            String grades = Ui.readCommand();
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
            case "ok":
                capCalculator(listOfGrades, listOfMCs, totalMCs);
                break;
            case "q":
                // to remove last grade keyed in by user due to exit of program.
                // Acts as a safety net
                // since new Object HelpGraduation is always created before
                // this method is called.
                int gradeIndex = listOfGrades.size() - 1;
                listOfGrades.remove(gradeIndex);
                return;
            default:
                Ui.printInvalidGradeMessage();
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
            return;
        default:
            // to remove last grade keyed in by user due to
            // unexpected input for MCs associated with the last grade.
            gradeIndex = listOfGrades.size() - 1;
            listOfGrades.remove(gradeIndex);
            Ui.printInvalidIntegerMessage();
        }
    }


    public Double capCalculator(ArrayList<Double> listOfGrades,
                                        ArrayList<Integer> listOfMCs, Integer totalMCs) {
        Double calculatedCap = 0.0;
        for (int i = 0; i < listOfGrades.size(); i++) {
            calculatedCap += listOfGrades.get(i) * listOfMCs.get(i);
        }

        calculatedCap = (calculatedCap + currentCap * numberOfGradedMCsTaken)
                / (totalMCs + numberOfGradedMCsTaken);
        System.out.println("The simulated cumulative average point you have is: ");
        System.out.println(calculatedCap);
        return calculatedCap;
    }

}
