package seedu.duke.features.capsimulator;

public enum ModuleGradeEnum {
    A_PLUS("A+", 5.0),
    A("A", 5.0),
    A_MINUS("A-", 4.5),
    B_PLUS("B+", 4.0),
    B("B", 3.5),
    B_MINUS("B-", 3.0),
    C_PLUS("C+", 2.5),
    C("C", 2.0),
    D_PLUS("D+", 1.5),
    D("D", 1.0),
    F("F", 0.0),
    PASS_FAIL("SU", 0.0);

    private String grade;
    private double score;

    ModuleGradeEnum(String grade, double score) {
        this.grade = grade;
        this.score = score;
    }

    public String getEnumGrade() {
        return grade;
    }

    public double getEnumScore() {
        return score;
    }

    public static boolean checkGradeExist(String grade) {
        if (grade == null) {
            return false;
        }
        for (ModuleGradeEnum g : values()) {
            if (grade.equalsIgnoreCase(g.getEnumGrade())) {
                return true;
            }
        }
        return false;
    }

    public static double checkScoreAgainstGrade(String grade, String module) {
        double score = 0;


        for (ModuleGradeEnum g : values()) {
            try {
                if (grade.equalsIgnoreCase(g.getEnumGrade())) {
                    score = g.getEnumScore();
                    break;
                }
            } catch (NullPointerException e) {
                System.out.println("There is no grade entered for " + module);
                score = 0;
                break;
            }
        }
        return score;
    }

    public static boolean checkPassFailGrade(String grade) {
        if (grade == null) {
            return false;
        }

        if (grade.equalsIgnoreCase("SU")) {
            return true;
        }
        return false;
    }
}
