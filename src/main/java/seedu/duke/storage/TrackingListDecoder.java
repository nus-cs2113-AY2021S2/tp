package seedu.duke.storage;

import seedu.duke.exceptions.StorageOperationException;
import seedu.duke.model.person.Id;
import seedu.duke.model.person.Name;
import seedu.duke.model.person.Person;
import seedu.duke.model.person.Phone;
import seedu.duke.model.TrackingList;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

import static seedu.duke.storage.StorageFile.PERSON_ENCODED_FORMAT;

/**
 * Decodes the storage data file into a {@code TrackingList} object.
 */
public class TrackingListDecoder {
    /**
     * Decodes {@code encodedTrackingList} into a {@code trackingList} containing the decoded persons.
     *
     * @throws StorageOperationException if the {@code encodedTrackingList} is in an invalid format.
     */
    public static TrackingList decodeTrackingList(List<String> encodedTrackingList) throws StorageOperationException {
        final List<Person> decodedPersons = new ArrayList<>();
        for (String encodedPerson : encodedTrackingList) {
            decodedPersons.add(decodePerson(encodedPerson));
        }
        return new TrackingList(decodedPersons);
    }

    /**
     * Decodes {@code encodedPerson} to a {@code Person}.
     *
     * @throws StorageOperationException if the {@code encodedPerson} is in an invalid format.
     */
    private static Person decodePerson(String encodedPerson) throws StorageOperationException {
        final Matcher matcher = PERSON_ENCODED_FORMAT.matcher(encodedPerson);
        if (!matcher.matches()) {
            throw new StorageOperationException("Failed to decode encoded file!");
        }

        // Check if Phone is stored as string null
        Phone phone;
        if (matcher.group("phone").equals("null")) {
            phone = new Phone(null);
        } else {
            phone = new Phone(matcher.group("phone"));
        }

        Person decodedPerson = new Person(
                new Id(matcher.group("id")),
                new Name(matcher.group("name")),
                phone
        );

        // Parse the check in status of the file which is stored as int
        try {
            decodedPerson.setCheckedIn(Integer.parseInt(matcher.group("checkedIn")) == 1);
        } catch (NumberFormatException nfe) {
            throw new StorageOperationException("Failed to parse check in status in file!");
        }
        return decodedPerson;
    }
}
