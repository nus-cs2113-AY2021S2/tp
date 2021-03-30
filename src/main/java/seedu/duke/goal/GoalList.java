package seedu.duke.goal;

import seedu.duke.common.Messages;
import seedu.duke.goal.comparator.GoalPeriodTypeComparator;
import seedu.duke.record.Record;
import seedu.duke.record.RecordType;

import java.util.ArrayList;

public class GoalList {
    private final ArrayList<Goal> goals = new ArrayList<>();

    public void addGoal(Goal newGoal) {
        goals.add(newGoal);
        goals.sort(new GoalPeriodTypeComparator());
    }

    public String removeGoal(int index) throws IndexOutOfBoundsException {
        Goal goalToRemove = goals.get(index);
        String goalSummary = goalToRemove.getGoalSummary();
        goals.remove(goalToRemove);
        return goalSummary;
    }

    public String getGoalsToPrint(PeriodType optionalPeriodType) {
        if (goals.isEmpty()) {
            return Messages.MESSAGE_NO_GOAL;
        } else if (optionalPeriodType != null) {
            StringBuilder goalStringBuilder = new StringBuilder();
            int i = 1;
            for (Goal goal : goals) {
                if (goal.getPeriodType() == optionalPeriodType) {
                    goalStringBuilder.append(i).append(goal.getGoalData()).append("\n");
                    i++;
                }
            }
            if (i == 1) {
                return Messages.MESSAGE_NO_ELIGIBLE_GOAL;
            }
            return Messages.MESSAGE_CHECK_HEADER + goalStringBuilder.toString();
        } else {
            StringBuilder goalStringBuilder = new StringBuilder();
            int i = 1;
            for (Goal goal : goals) {
                goalStringBuilder.append(i).append(goal.getGoalData()).append("\n");
                i++;
            }
            return Messages.MESSAGE_CHECK_HEADER + goalStringBuilder.toString();
        }
    }

    public String getGoalToStore() {
        StringBuilder goalStringBuilder = new StringBuilder();
        for (Goal goal : goals) {
            goalStringBuilder.append(goal.getGoalDataToStore()).append("\n");
        }
        return goalStringBuilder.toString();
    }
}
