package seedu.duke.lesson;

public class Lesson {

    private final LessonType lessonType;
    private String time;

    private String onlineLink;
    private TeachingStaff teachingStaff;

    public Lesson(LessonType lessonType, String time, String onlineLink, TeachingStaff teachingStaff) {
        this.lessonType = lessonType;
        this.time = time;
        this.onlineLink = onlineLink;
        this.teachingStaff = teachingStaff;
    }

    public String getTime() {
        return time;
    }

    public LessonType getLessonType() {
        return lessonType;
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
