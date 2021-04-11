package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.features.capsimulator.AcademicRecords;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

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



}
