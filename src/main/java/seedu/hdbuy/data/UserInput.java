package seedu.hdbuy.data;

import seedu.hdbuy.common.QueryKey;

import java.util.LinkedHashMap;

public class UserInput {

    private final LinkedHashMap<QueryKey, String> inputs;

    public UserInput() {
        this.inputs = new LinkedHashMap<>();
    }

    public LinkedHashMap<QueryKey, String> getInputs() {
        return inputs;
    }

    public void clearInputs() {
        inputs.clear();
    }
}
