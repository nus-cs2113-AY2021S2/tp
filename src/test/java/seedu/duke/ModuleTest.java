package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.assignment.Assignment;
import seedu.duke.assignment.LongAnswerAssignment;
import seedu.duke.assignment.McqAssignment;
import seedu.duke.assignment.ShortAnswerAssignment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

class ModuleTest {
    @Test
    void testGetModuleCode() {
        assertEquals("CS2113T", new Module("CS2113T").getModuleCode());
    }

    //    @Test
    //    void testPrintAssignments() {
    //        Module testModule = new Module("CS2113T");
    //        testModule.addAssignment(new Assignment("tP"));
    //        String output = tapSystemOut(() -> {testModule.printAssignments();});
    //        assertEquals("Here are your assignments for CS2113T:\n" + "tP\n", output);
    //    }

    @Test
    void testGetAssignmentAtIndex() {
        Module testModule = new Module("CS2113T");
        testModule.addAssignment(new McqAssignment("tP"));
        assertEquals("tP", testModule.getAssignmentAtIndex(0).toString());
    }

    @Test
    void getAssignmentAtIndex_indexNonExistent_exceptionThrown() {
        Module testModule = new Module("CS2113T");
        testModule.addAssignment(new LongAnswerAssignment("tP"));
        assertThrows(IndexOutOfBoundsException.class, () -> {
            testModule.getAssignmentAtIndex(1);
        });
    }

    @Test
    void testFindAssignment_AssignmentExists_AssignmentFound() {
        String moduleCode = "CS2113T";
        String assignmentName = "quiz1";
        Module testModule = new Module(moduleCode);
        testModule.addAssignment(new ShortAnswerAssignment(assignmentName));
        assertEquals("quiz1", testModule.findAssignment(assignmentName).getName());
    }

    @Test
    void testFindAssignment_AssignmentDoesNotExists_AssignmentNull() {
        String moduleCode = "CS2113T";
        String assignmentName = "quiz1";
        String assignmentToBeFound = "quiz2";
        Module testModule = new Module(moduleCode);
        testModule.addAssignment(new McqAssignment(assignmentName));
        assertNull(testModule.findAssignment(assignmentToBeFound));
    }

    @Test
    void testFindStudent_StudentExists_StudentFound() {
        String moduleCode = "CS2113T";
        String studentName = "Bryan";
        String studentNumber = "A0123456X";
        String email = "hello@u.nus.edu";
        Module testModule = new Module(moduleCode);
        Student testStudent = new Student(studentName, studentNumber, email);
        testModule.addStudent(testStudent);
        assertEquals(testStudent, testModule.findStudent(studentName));
    }

    @Test
    void testFindStudent_StudentDoesNotExists_StudentNull() {
        String moduleCode = "CS2113T";
        String studentName = "Bryan";
        String studentNumber = "A0123456X";
        String email = "hello@u.nus.edu";
        String studentToBeFound = "Jianning";
        Module testModule = new Module(moduleCode);
        Student testStudent = new Student(studentName, studentNumber, email);
        testModule.addStudent(testStudent);
        assertNull(testModule.findStudent(studentToBeFound));
    }
}