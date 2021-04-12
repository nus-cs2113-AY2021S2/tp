package seedu.duke.common;

/**
 * Indicates what {@code Record} type is being asked for.
 * {@code EXPENSE} indicates {@code Expense} type.
 * {@code LOAN} indicates {@code Loan} type.
 * {@code SAVING} indicates {@code Saving} type.
 * {@code ALL} indicates all {@code Record} types.
 * {@code RecordType} is used mainly for commands that support mutually exclusive
 * options like the AddCommand {@code add {-e | -l | -s} ...}
 * and the ListCommand {@code list {-e | -l | -s | -a}}.
 *
 * @see seedu.duke.command.AddCommand
 * @see seedu.duke.command.ListCommand
 * @see seedu.duke.command.ViewCommand
 */
public enum RecordType {
    EXPENSE, LOAN, SAVING, ALL
}
