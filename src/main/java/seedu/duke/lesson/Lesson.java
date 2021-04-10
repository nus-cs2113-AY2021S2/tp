package seedu.duke.lesson;

import static seedu.duke.common.Constants.COLON;
import static seedu.duke.common.Constants.FORMAT_LINK;
import static seedu.duke.common.Constants.LESSON_FIELD_2_LINK;
import static seedu.duke.common.Constants.LESSON_FIELD_3_T_NAME;
import static seedu.duke.common.Constants.LESSON_FIELD_4_T_EMAIL;

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

    public String getLessonTypeString() {
        return LessonType.getLessonTypeString(lessonType);
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
    }

    public String getTeachingStaffName() {
        return teachingStaff.getName();
    }

    public String getTeachingStaffEmail() {
        return teachingStaff.getEmail();
    }

    public void setTeachingStaffName(String name) {
        teachingStaff.setName(name);
    }

    public void setTeachingStaffEmail(String email) {
        teachingStaff.setEmail(email);
    }

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

    //@@author aliciatay-zls
    /** 
     * Returns the value of a filled field as a string, in this order of availability: 
     * day and time, link, teacher's name, teacher's email. 
     * Returns null if none of the lesson's fields have been filled by the user yet.
     */
    public String getDetailsStringIfAny() {
        if (!this.time.isEmpty()) {
            return this.time;
        } else if (!this.onlineLink.isEmpty()) {
            return LESSON_FIELD_2_LINK + COLON + this.onlineLink;
        } else if (this.teachingStaff != null) {
            String nameField = this.teachingStaff.getName();
            String emailField = this.teachingStaff.getEmail();
            if (!nameField.isEmpty()) {
                return LESSON_FIELD_3_T_NAME + COLON + nameField;
            }
            if (!emailField.isEmpty()) {
                return LESSON_FIELD_4_T_EMAIL + COLON + emailField;
            }
        }
        return null;
    }
}
