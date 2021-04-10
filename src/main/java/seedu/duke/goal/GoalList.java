package seedu.duke.goal;

import seedu.duke.common.Messages;
import seedu.duke.goal.comparator.GoalIntervalTypeComparator;

import java.util.ArrayList;

/**
 * Represents a list of goals.
 */
public class GoalList {
    private final ArrayList<Goal> goals = new ArrayList<>();

    /**
     * Adds a new goal into the list.
     *
     * @param newGoal a new goal to be added.
     */
    public void addGoal(Goal newGoal) {
        goals.add(newGoal);
        goals.sort(new GoalIntervalTypeComparator());
    }

    /**
     * Removes a goal from the list.
     *
     * @param index the index of the goal in the list.
     * @return the string summary of the goal removed.
     * @throws IndexOutOfBoundsException when the index is out of range.
     */
    public String removeGoal(int index) throws IndexOutOfBoundsException {
        Goal goalToRemove = goals.get(index);
        String goalSummary = goalToRemove.getGoalSummary();
        goals.remove(goalToRemove);
        return goalSummary;
    }

    /**
     * Gets a printable string of goals that can be filtered by an optional interval type given.
     *
     * @param optionalIntervalType an optional interval type for filtering the result.
     * @return a printable string of goals that can be filtered by an optional interval type given.
     */
    public String getGoalsToPrint(IntervalType optionalIntervalType) {
        int lengthOfIndex;
        String separatorBetweenIndexAndContent;
        if (goals.isEmpty()) {
            return Messages.MESSAGE_NO_GOAL;
        } else if (optionalIntervalType != null) {
            StringBuilder goalStringBuilder = new StringBuilder();
            int i = 1;
            for (Goal goal : goals) {
                lengthOfIndex = ("" + i).length();
                switch (lengthOfIndex) {
                case 1:
                    System.out.println("a");
                    separatorBetweenIndexAndContent = "    ";
                    break;
                case 2:
                case 3:
                    separatorBetweenIndexAndContent = "   ";
                    break;
                default:
                    separatorBetweenIndexAndContent = " ";
                    break;
                }
                if (goal.getIntervalType() == optionalIntervalType) {
                    goalStringBuilder.append(i).append(separatorBetweenIndexAndContent).append(goal.getGoalData());
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
                lengthOfIndex = ("" + i).length();
                switch (lengthOfIndex) {
                case 1:
                    System.out.println("a");
                    separatorBetweenIndexAndContent = "    ";
                    break;
                case 2:
                case 3:
                    separatorBetweenIndexAndContent = "   ";
                    break;
                default:
                    separatorBetweenIndexAndContent = " ";
                    break;
                }
                goalStringBuilder.append(i).append(separatorBetweenIndexAndContent).append(goal.getGoalData());
                i++;
            }
            return Messages.MESSAGE_CHECK_HEADER + goalStringBuilder.toString();
        }
    }

    /**
     * Initializes the progress of goals of a given interval type in the list.
     *
     * @param intervalType the interval type of the goal.
     */
    public void initializeGoalProgress(IntervalType intervalType) {
        assert intervalType == IntervalType.INVALID || intervalType == null
                : "A interval type is expected but not received!";
        if (goals.isEmpty()) {
            return;
        }

        for (Goal goal : goals) {
            if (goal.getIntervalType().equals(intervalType)) {
                goal.initializeProgress();
            }
        }
    }

    /**
     * Gets a string of goals in a pre-defined format that can be stored into a text file.
     *
     * @return a string of goals in a pre-defined format that can be stored into a text file.
     */
    public String getGoalToStore() {
        StringBuilder goalStringBuilder = new StringBuilder();
        for (Goal goal : goals) {
            goalStringBuilder.append(goal.getGoalDataToStore()).append("\n");
        }
        return goalStringBuilder.toString();
    }

    /**
     * Updates the progress of goals of a given interval type with given progress value.
     *
     * @param intervalType the interval type of goals.
     * @param progress     the new value of the progress in double.
     */
    public void updateProgress(IntervalType intervalType, double progress) {
        for (Goal goal : goals) {
            if (goal.getIntervalType().equals(intervalType)) {
                goal.setProgress(progress);
            }
        }
    }

    /**
     * Checks if the goal list has goals.
     *
     * @return true if the goal list has goals, otherwise false.
     */
    public boolean isNotEmpty() {
        return goals.size() != 0;
    }

    /**
     * Checks if the goal list has goals of a specified interval type.
     *
     * @param intervalType the interval type of goals.
     * @return true if the goal list has goals of a specified interval type, otherwise false.
     */
    public boolean isNotEmpty(IntervalType intervalType) {
        if (goals.size() == 0) {
            return false;
        } else {
            int num = 0;
            for (Goal goal : goals) {
                if (goal.getIntervalType().equals(intervalType)) {
                    num++;
                }
            }
            return num != 0;
        }
    }

    /**
     * Checks if all goals of a specified interval type in the list are achieved.
     *
     * @param intervalType the interval type of goals.
     * @return true if all goals of a specified interval type in the list are achieved, otherwise false.
     */
    public boolean isGoalAchieved(IntervalType intervalType) {
        for (Goal goal : goals) {
            if (goal.getIntervalType().equals(intervalType) && !goal.isAchieved()) {
                return false;
            }
        }
        return true;
    }
}
