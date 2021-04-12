package seedu.duke.testutil;

import seedu.duke.model.person.Id;
import seedu.duke.model.person.Name;
import seedu.duke.model.person.Person;
import seedu.duke.model.person.Phone;

public class PersonBuilder {
    private Id id;
    private Name name;
    private Phone phone;
    private Boolean isCheckedIn;

    public PersonBuilder withId(String id) {
        this.id = new Id(id);
        return this;
    }

    public PersonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    public PersonBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    public PersonBuilder withCheckedInStatus(boolean isCheckedIn) {
        this.isCheckedIn = isCheckedIn;
        return this;
    }

    public Person build() {
        Person person = new Person(id,name,phone);
        person.setCheckedIn(isCheckedIn);
        return person;
    }
}
