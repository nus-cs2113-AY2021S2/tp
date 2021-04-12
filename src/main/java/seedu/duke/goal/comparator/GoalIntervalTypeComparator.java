package seedu.duke.goal.comparator;

import seedu.duke.goal.Goal;
import seedu.duke.goal.IntervalType;

import java.util.Comparator;

public class GoalIntervalTypeComparator implements Comparator<Goal> {
    @Override
    public int compare(Goal goal1, Goal goal2) {
        IntervalType intervalType1 = goal1.getIntervalType();
        IntervalType intervalType2 = goal2.getIntervalType();
        if (IntervalType.getIntervalTypeWeight(intervalType1) == IntervalType.getIntervalTypeWeight(intervalType2)) {
            if (goal1.getDaySet().isBefore(goal2.getDaySet())) {
                return -1;
            } else if (goal1.getDaySet().isAfter(goal2.getDaySet())) {
                return 1;
            } else {
                return 0;
            }
        } else if (IntervalType.getIntervalTypeWeight(intervalType1)
                < IntervalType.getIntervalTypeWeight(intervalType2)) {
            return -1;
        } else {
            return 1;
        }
    }
}
