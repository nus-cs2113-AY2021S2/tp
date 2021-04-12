package seedu.duke.model;

import seedu.duke.common.Messages;
import seedu.duke.exceptions.InvalidArgumentSizeException;
import seedu.duke.exceptions.InvalidMaxCapacityException;

import static seedu.duke.common.Messages.INVALID_MAX_CAPACITY_CHECKED_IN;

/**
 * Details of the venue for managing the crowd levels.
 */
public class Location {

    private int maxCapacity;
    private static final String MAX_CAPACITY_REGEX = "^[0-9]{1,6}$";

    /**
     * Creates a Location using the arguments the user had provided when running the jar file.
     *
     * @param args provided by the user when running the jar file. Contains the maximum capacity.
     * @throws InvalidMaxCapacityException if the maximum capacity provided does not meet the requirements
     * @throws InvalidArgumentSizeException if the user did not provide exactly 1 argument
     */
    public Location(String[] args, int currentCapacity) throws InvalidMaxCapacityException,
            InvalidArgumentSizeException {
        checkArgumentValidity(args);
        setMaxCapacity(Integer.parseInt(args[0]), currentCapacity);
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    /**
     * Sets the maximum capacity of the current location.
     *
     * @param maxCapacity New maximum capacity of the location
     * @param currentCapacity The number of visitors currently checked in
     * @throws InvalidMaxCapacityException Exception thrown if maxCapacity is less than
     *      the number of people currently checked in
     */
    public void setMaxCapacity(int maxCapacity, int currentCapacity) throws InvalidMaxCapacityException {

        if (this.maxCapacity < currentCapacity) { // If max capacity not initialised
            this.maxCapacity = currentCapacity;
        }

        if (maxCapacity < currentCapacity) {
            throw new InvalidMaxCapacityException(INVALID_MAX_CAPACITY_CHECKED_IN + currentCapacity);
        }
        this.maxCapacity = maxCapacity;
    }

    /**
     * Checks if the arguments entered by the user is valid and meets the requirements specified.
     *
     * @param args provided by the user when running the jar file. Contains the maximum capacity.
     * @throws InvalidArgumentSizeException if the user did not provide exactly 1 argument
     * @throws InvalidMaxCapacityException if the maximum capacity provided does not meet the requirements
     */
    private void checkArgumentValidity(String[] args) throws InvalidArgumentSizeException, InvalidMaxCapacityException {
        if (args.length != 1) {
            throw new InvalidArgumentSizeException(Messages.INVALID_ARGUMENT_SIZE);
        }
        if (!args[0].matches(MAX_CAPACITY_REGEX) || Integer.parseInt(args[0]) < 0) {
            throw new InvalidMaxCapacityException(Messages.INVALID_MAX_CAPACITY_ARG);
        }
    }

}