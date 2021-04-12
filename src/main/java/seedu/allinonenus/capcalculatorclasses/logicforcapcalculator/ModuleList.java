package seedu.allinonenus.capcalculatorclasses.logicforcapcalculator;

import seedu.allinonenus.capcalculatorclasses.commandsforcapcalculator.ModuleData;
import seedu.allinonenus.capcalculatorclasses.exceptionsforcapcalculator.InvalidGradeException;
import seedu.allinonenus.capcalculatorclasses.exceptionsforcapcalculator.InvalidYearAndSemException;

import java.util.ArrayList;

public class ModuleList {
    protected ArrayList<ModuleData> moduleList = new ArrayList<>();

    public ModuleList() {

    }

    public ModuleList(ArrayList<ModuleData> moduleList) {
        this.moduleList = moduleList;
    }

    public void add(ModuleData moduleData) {

        moduleList.add(moduleData);
    }

    public int size() {
        return moduleList.size();
    }

    public ModuleData get(int index) {
        return moduleList.get(index);
    }

    public void delete(String moduleName) {

        for (int i = 0; i < moduleList.size(); i++) {
            String moduleToRemove = moduleList.get(i).moduleCode;
            if (moduleToRemove.equals(moduleName)) {
                moduleList.remove(moduleList.get(i));
            }
        }

    }

    public int edit(String moduleName, String newGrade) {
        int index;
        for (index = 0; index < moduleList.size(); index++) {
            String moduleToEdit = moduleList.get(index).moduleCode;
            if (moduleToEdit.equals(moduleName)) {
                moduleList.get(index).gradeChange(newGrade);
                break;
            }
        }
        return index;

    }


    public int totalMcs(int startSem, int endSem) {
        boolean isNotSUmod;
        boolean isNotPassFailMod;
        String score;
        int summationOfMCs = 0;
        for (int i = 0; i < moduleList.size(); i++) {
            if (moduleList.get(i).sem >= startSem && moduleList.get(i).sem <= endSem) {

                score = moduleList.get(i).grade;

                isNotSUmod = !score.equals("S") && !score.equals("U");
                isNotPassFailMod = !score.equals("CS") && !score.equals("CU");

                if (isNotPassFailMod && isNotSUmod) {
                    summationOfMCs += moduleList.get(i).mcs;
                }
            }

        }
        return summationOfMCs;
    }

    public double totalMcsTimesGrade(int beginSem, int finalSem) throws InvalidGradeException {
        double summationOfMCsTimesGrade = 0.0;
        String score;
        for (int j = 0; j < moduleList.size(); j++) {
            if (moduleList.get(j).sem >= beginSem && moduleList.get(j).sem <= finalSem) {
                score = moduleList.get(j).grade;
                summationOfMCsTimesGrade += gradesToPoints(score) * moduleList.get(j).mcs;

                assert summationOfMCsTimesGrade >= 0.0 : "The summation is negative";
            }
        }
        return summationOfMCsTimesGrade;
    }

    public double calculate(int start, int end) throws InvalidGradeException {
        return totalMcsTimesGrade(start, end) / totalMcs(start, end);

    }


    public double suggest(int currentSem, double desiredGrade) throws InvalidGradeException {

        return (desiredGrade * (totalMcs(1, currentSem)) - totalMcsTimesGrade(1, currentSem - 1))
                / totalMcs(currentSem, currentSem);
    }


    public double gradesToPoints(String letterGrade) throws InvalidGradeException {
        double points;

        switch (letterGrade) {
        case "A+":
        case "A":
        case "a+":
        case "a":
            points = 5.0;
            break;
        case "A-":
        case "a-":
            points = 4.5;
            break;
        case "B+":
        case "b+":
            points = 4.0;
            break;
        case "B":
        case "b":
            points = 3.5;
            break;
        case "B-":
        case "b-":
            points = 3.0;
            break;
        case "C+":
        case "c+":
            points = 2.5;
            break;
        case "C":
        case "c":
            points = 2.0;
            break;
        case "D+":
        case "d+":
            points = 1.5;
            break;
        case "D":
        case "d":
            points = 1.0;
            break;
        case "F":
        case "f":
        case "S":
        case "s":
        case "U":
        case "u":
        case "CS":
        case "CU":

            points = 0.0;
            break;
        default:
            throw new InvalidGradeException();
        }

        assert points <= 5.0 : "The grade point is larger than 5.0";

        return points;
    }

    public int computeSem(String yearAndSem) throws InvalidYearAndSemException {

        int year;
        int sem;


        year = Character.getNumericValue(yearAndSem.charAt(1));
        sem = Character.getNumericValue(yearAndSem.charAt(3));

        char charY = yearAndSem.charAt(0);
        char charS = yearAndSem.charAt(2);

        char isY = Character.toLowerCase(charY);
        char isS = Character.toLowerCase(charS);

        if (sem > 2 || isY != 'y' || isS != 's' || yearAndSem.length() != 4 || year > 4 || year == 0 || sem == 0) {
            throw new InvalidYearAndSemException();
        }

        return year * 2 - (2 - sem);

    }

    public String printYearAndSem(int sem) {
        int year = (sem + 1) / 2;
        int semester = 2 - sem % 2;

        return "Year " + year + " Semester " + semester;

    }

    public String printString() {
        StringBuilder list = new StringBuilder();

        for (ModuleData moduleData : moduleList) {
            list.append(moduleData.fileFormat());
        }
        return list.toString();
    }

    public boolean checkOverallCap(int currentSem) {

        for (int checkingSem = 1; checkingSem <= currentSem; checkingSem++) {

            boolean semExists = false;

            for (int i = 0; i < moduleList.size(); i++) {

                if (moduleList.get(i).sem == checkingSem) {
                    semExists = true;
                }
            }

            if (!semExists) {
                return false;
            }
        }
        return true;

    }


}
