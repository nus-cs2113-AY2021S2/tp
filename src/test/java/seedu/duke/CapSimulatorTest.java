package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.features.capsimulator.AcademicRecords;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.duke.features.capsimulator.ModularCreditEnum.checkMcsExist;
import static seedu.duke.features.capsimulator.ModuleGradeEnum.checkGradeExist;

public class CapSimulatorTest {

    @Test
    public void capCalculator_validCap_success() {
        ArrayList<Double> grades = new ArrayList<>();
        ArrayList<Integer> mcs = new ArrayList<>();
        grades.add(5.0);
        grades.add(1.0);
        mcs.add(4);
        mcs.add(6);
        assertEquals(1.3, new AcademicRecords()
                .capCalculator(grades, mcs, 20));

    }

    @Test
    public void checkMcsExist_validMCs_true() {
        Integer mcs = 1;
        assertEquals(true, checkMcsExist(mcs));
    }

    @Test
    public void checkMcsExist_validMCs_false() {
        Integer mcs = 100;
        assertEquals(false, checkMcsExist(mcs));
    }

    @Test
    public void checkGradeExist_validMCs_true() {
        String grade = "A+";
        assertEquals(true, checkGradeExist(grade));
    }

    @Test
    public void checkGradeExist_validMCs_false() {
        String grade = "Q";
        assertEquals(false, checkGradeExist(grade));
    }




}
