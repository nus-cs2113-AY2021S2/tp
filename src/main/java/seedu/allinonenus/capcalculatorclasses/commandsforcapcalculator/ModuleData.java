package seedu.allinonenus.capcalculatorclasses.commandsforcapcalculator;

public class ModuleData {


    public String moduleCode;
    public String grade;
    public int mcs;
    public int sem;

    public ModuleData(String moduleCode, String grade, int mcs, int sem) {
        this.moduleCode = moduleCode;
        this.grade = grade;
        this.mcs = mcs;
        this.sem = sem;

    }

    public void gradeChange(String newGrade) {
        this.grade = newGrade;
    }


    public String toString() {
        return "[" + moduleCode + "] " + "[" + grade + "] "
                + "[" + mcs + "]\n";
    }

    public String fileFormat() {
        return moduleCode + "|" + grade + "|" + mcs + "|" + sem + "\n";
    }


}
