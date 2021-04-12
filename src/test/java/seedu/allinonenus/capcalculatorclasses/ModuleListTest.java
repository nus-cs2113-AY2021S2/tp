
package seedu.allinonenus.capcalculatorclasses;

import org.junit.jupiter.api.Test;
import seedu.allinonenus.capcalculatorclasses.exceptionsforcapcalculator.InvalidGradeException;
import seedu.allinonenus.capcalculatorclasses.exceptionsforcapcalculator.InvalidYearAndSemException;
import seedu.allinonenus.capcalculatorclasses.logicforcapcalculator.ModuleList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ModuleListTest {

    //@@author soepaingzaw

    @Test
    void verifyNumberPrintedForgradesToPoints() throws InvalidGradeException {
        ModuleList ml = new ModuleList();
        String inputString = "A-";
        assertEquals(4.5,ml.gradesToPoints(inputString));
        inputString = "B";
        assertEquals(3.5,ml.gradesToPoints(inputString));
    }

    @Test
    void computeSemThrowException()  {
        ModuleList ml = new ModuleList();
        String yearAndSem = "y2s4";
        assertThrows(InvalidYearAndSemException.class , () -> ml.computeSem(yearAndSem),
                "Should not process invalid command\n");
    }

    @Test
    void printYearAndSemTest() {
        ModuleList ml = new ModuleList();
        int sem = 2;
        assertEquals("Year 1 Semester 2",ml.printYearAndSem(sem));
        sem = 5;
        assertEquals("Year 3 Semester 1",ml.printYearAndSem(sem));

    }


}

