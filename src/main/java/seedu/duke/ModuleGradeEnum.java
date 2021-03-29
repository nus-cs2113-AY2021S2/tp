package seedu.duke;

public enum ModuleGradeEnum {
    A_PLUS("A+"),
    A("A"),
    B_PLUS("B+"),
    B("B"),
    B_MINUS("B-"),
    C_PLUS("C+"),
    C("C"),
    C_MINUS("C-"),
    D_PLUS("D+"),
    D("D"),
    F("F");

    private String grade;

    ModuleGradeEnum(String grade) {
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public static boolean checkGradeExist(String grade) {
        if(grade == null)
            return false;
        for(ModuleGradeEnum g : values())
            if(grade.equalsIgnoreCase(g.getGrade())) return true;
        return false;
    }

}
