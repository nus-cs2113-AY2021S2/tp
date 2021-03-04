package seedu.duke.lesson;

public class Lesson {

    private String time = "";
    private final LessonType LESSON_TYPE;
    private TeachingStaff teachingStaff = new TeachingStaff("","");
    private String onlineLink = "";

    public Lesson(LessonType lessonType) {
        LESSON_TYPE = lessonType;
    }

    public String getTime() {
        return time;
    }

    public LessonType getLessonType() {
        return LESSON_TYPE;
    }

    public TeachingStaff getTeachingStaff() {
        return teachingStaff;
    }

    public String getOnlineLink() {
        return onlineLink;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setTeachingStaff(TeachingStaff teachingStaff) {
        this.teachingStaff = teachingStaff;
    }

    public void setOnlineLink(String onlineLink) {
        this.onlineLink = onlineLink;
    }
}
