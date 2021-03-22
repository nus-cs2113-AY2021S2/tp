package seedu.duke.lesson;

import static seedu.duke.common.Constants.FORMAT_LINK;

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

    public void setOnlineLink(String onlineLink) {
        this.onlineLink = onlineLink;
    }

    public void setTeachingStaff(TeachingStaff teachingStaff) {
        this.teachingStaff = teachingStaff;

    //@@author ivanchongzhien
    /**
     * Check if given string is a valid link.
     *
     * @param link string to be checked
     * @return true if string follows the format of a valid email
     */
    public static boolean isValidLink(String link) {
        return link.matches(FORMAT_LINK);
    }
}
