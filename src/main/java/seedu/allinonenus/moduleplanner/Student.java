package seedu.allinonenus.moduleplanner;

public class Student implements Comparable<Student> {
    protected String name;
    protected boolean graduationRequirement;
    protected int year;
    protected int score;
    protected int rank;

    public Student(String name, int year, boolean graduationRequirement, int rank) {
        this.name = name;
        this.graduationRequirement = graduationRequirement;
        this.year = year;
        this.rank = rank;
        this.score = getYear() + getGraduationRequirementScore() - (rank - 6);
    }

    public String getName() {
        return name;
    }

    public boolean isGraduationRequirement() {
        return graduationRequirement;
    }

    public int getYear() {
        return year;
    }

    public int getGraduationRequirementScore() {
        return (isGraduationRequirement() ? 3 : 0);
    }

    public int getScore() {
        return score;
    }

    public boolean getGraduationRequirement() {
        return graduationRequirement;
    }

    public int getRank() {
        return rank;
    }


    @Override
    public String toString() {
        return name + ", " + getScore();
    }

    public int compareTo(Student student) {
        return this.score - student.score;
    }
}
