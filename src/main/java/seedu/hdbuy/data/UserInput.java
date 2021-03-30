package seedu.hdbuy.data;

import seedu.hdbuy.common.QueryKey;

import java.util.HashMap;

public class UserInput {

    private final HashMap<QueryKey, String> inputs;


    public UserInput() {
        this.inputs = new HashMap<>();
    }

    public HashMap<QueryKey, String> getInputs() {
        return inputs;
    }

    public void clearInputs() {
        inputs.clear();
    }
}
