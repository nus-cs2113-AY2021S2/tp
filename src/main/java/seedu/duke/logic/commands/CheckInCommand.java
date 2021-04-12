package seedu.duke.logic.commands;

import seedu.duke.Main;
import seedu.duke.common.Messages;
import seedu.duke.exceptions.CheckInException;
import seedu.duke.exceptions.HistoryStorageException;
import seedu.duke.exceptions.PersonNotFoundException;
import seedu.duke.exceptions.StorageOperationException;
import seedu.duke.storage.HistoryFile;
import seedu.duke.model.Location;
import seedu.duke.model.person.Id;
import seedu.duke.model.person.Name;
import seedu.duke.model.person.Person;
import seedu.duke.model.PersonLog;
import seedu.duke.model.person.Phone;
import seedu.duke.model.TrackingList;

import java.util.logging.Logger;

/**
 * Check in a visitor.
 * Adds a new visitor to the trackingList and personLog.
 */
public class CheckInCommand extends Command {

    public static final String COMMAND = "checkin";
    private final Location location = Main.getInstance().getLocation();
    private static int CURRENT_CAPACITY;
    private static int MAXIMUM_CAPACITY;
    public static final String CHECKIN_SUCCESS_MESSAGE = "%s has been successfully checked-in!"
            + System.lineSeparator();
    public static final String CURRENT_AND_MAX_CAPACITY_MESSAGE = "Current capacity: %d out of %d.";
    public static final String CHECKIN_FAIL_MESSAGE = "Unable to check in! Maximum capacity of %d reached!";
    private final Person toCheckin;
    private final HistoryFile historyFile;
    private final Id id;
    private static final Logger logger = Logger.getLogger(CheckInCommand.class.getName());

    /**
     * Creates a CheckInCommand to checkin a visitor.
     * New visitor is added to the personLog.
     *
     * @param idString ID of the visitor
     * @param nameString name of the visitor
     * @param phoneString phone number of the visitor
     * @throws StorageOperationException if there are errors reading the file
     * @throws PersonNotFoundException if the visitor cannot be found in the personLog
     */
    public CheckInCommand(String idString,
                          String nameString,
                          String phoneString) throws StorageOperationException, PersonNotFoundException {
        id = new Id(idString);
        historyFile = Main.getInstance().getHistoryFile();
        PersonLog personLog = PersonLog.getInstance();
        if (personLog.isFound(id)) {
            toCheckin = personLog.findPerson(id);
            checkSameName(nameString);
        } else if (nameString == null) {
            throw new PersonNotFoundException(Messages.PERSON_NOT_FOUND);
        } else {
            toCheckin = new Person(id, new Name(nameString), new Phone(phoneString));
            personLog.addPerson(toCheckin);
        }
    }

    /**
     * Checks if the visitor checking in has the same ID as someone else in the personLog.
     *
     * @param nameString name of the visitor
     * @throws PersonNotFoundException if another person with the same ID is found in the personLog
     */
    private void checkSameName(String nameString) throws PersonNotFoundException {
        if (nameString == null) {
            return;
        }
        if (!toCheckin.getName().toString().equalsIgnoreCase(nameString)) {
            throw new PersonNotFoundException(Messages.DIFF_NAME_SAME_ID);
        }
    }

    /**
     * Checks if the visitor to be checked in is already checked in.
     * If not, check in the visitor.
     *
     * @param toCheckinId visitor id
     * @param trackingList list of visitors
     * @throws CheckInException if visitor is already checked in
     * @throws PersonNotFoundException if visitor is not found in the tracking list
     */
    private void checkIfAlreadyCheckedIn(Id toCheckinId, TrackingList trackingList) throws CheckInException,
            PersonNotFoundException {
        Person visitor = trackingList.findExactPerson(toCheckinId);
        boolean isSamePerson = toCheckin.getName().getNameString().equals(visitor.getName().getNameString());
        if (!isSamePerson) {
            logger.warning("ID entered does not match the name from the list.");
        }
        assert isSamePerson : "ID does not match name.";
        if (visitor.getCheckedIn()) {
            throw new CheckInException(String.format(Messages.ALREADY_CHECKEDIN, visitor.getName().nameString));
        }
        visitor.setCheckedIn(true);
    }

    /**
     * Executes the CheckinCommand.
     * Restricts visitors from checking in if maximum capacity reached.
     *
     * @param trackingList list of visitors
     * @return check in success message or check in failure message depending on the current capacity
     * @throws HistoryStorageException if there are problems saving into the file
     * @throws PersonNotFoundException if visitor cannot be found in the trackingList with the ID
     */
    @Override
    public CommandOutput execute(TrackingList trackingList) throws HistoryStorageException, PersonNotFoundException,
            CheckInException {
        MAXIMUM_CAPACITY = location.getMaxCapacity();
        if (trackingList.getCurrentCapacity() >= MAXIMUM_CAPACITY) {
            return new CommandOutput(String.format(CHECKIN_FAIL_MESSAGE, MAXIMUM_CAPACITY), COMMAND);
        }
        if (!trackingList.contains(toCheckin)) {
            toCheckin.setCheckedIn(true);
            trackingList.add(toCheckin);
        } else {
            checkIfAlreadyCheckedIn(id, trackingList);
        }
        historyFile.saveToHistory(toCheckin, " checked in at ");
        CURRENT_CAPACITY = trackingList.getCurrentCapacity();
        return new CommandOutput(String.format(CHECKIN_SUCCESS_MESSAGE, toCheckin.getName())
                + String.format(CURRENT_AND_MAX_CAPACITY_MESSAGE, CURRENT_CAPACITY, MAXIMUM_CAPACITY), COMMAND);
    }

}
