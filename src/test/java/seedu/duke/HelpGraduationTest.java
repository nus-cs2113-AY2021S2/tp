package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.features.capsimulator.HelpGraduation;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelpGraduationTest {

    @Test
    public void capCalculator_validCap_success() {
        ArrayList<Double> grades = new ArrayList<>();
        ArrayList<Integer> mcs = new ArrayList<>();
        grades.add(5.0);
        grades.add(1.0);
        mcs.add(4);
        mcs.add(6);
        assertEquals(1.3, new HelpGraduation()
                .capCalculator(grades, mcs, 20));

    }



}
