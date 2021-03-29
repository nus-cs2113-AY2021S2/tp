package seedu.duke.command;

import seedu.duke.account.FitCenter;
import seedu.duke.common.Messages;
import seedu.duke.goal.*;

import java.util.HashMap;

public class SetCommand extends Command {
    private final Goal goal;
    private final CommandRecordType recordType;

    public SetCommand(CommandRecordType recordType, HashMap<String, String> params) {
        this.recordType = recordType;
        PeriodType periodType = PeriodType.valueOf(params.get("periodType"));
        double target = Double.parseDouble(params.get("target"));
        switch (recordType) {
        case EXERCISE:
            goal = new ExerciseGoal(periodType, target);
            break;
        case SLEEP:
            goal = new SleepGoal(periodType, target);
            break;
        case DIET:
            goal = new DietGoal(periodType, target);
            break;
        case BODY_WEIGHT:
            goal = new BodyWeightGoal(periodType, target);
            break;
        default:
            goal = null;
            break;
        }
    }

    @Override
    public CommandResult execute(FitCenter fitCenter) {
        if (goal != null) {
            fitCenter.addGoalToList(recordType, goal);
            feedback = "A new " + goal.getType().toString().toLowerCase()
                    + " goal is set successfully!\n" + goal.getGoalSummary();
        } else {
            feedback = Messages.MESSAGE_CANT_SET_GOAL;
        }
        return new CommandResult(feedback);
    }
}
