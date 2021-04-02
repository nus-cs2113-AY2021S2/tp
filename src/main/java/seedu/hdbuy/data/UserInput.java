package seedu.hdbuy.data;

import java.util.LinkedHashMap;

import seedu.hdbuy.common.QueryKey;

public class UserInput {

    private static LinkedHashMap<QueryKey, String> inputs = null;

    private static UserInput instance = null;

    private UserInput() {
        inputs = new LinkedHashMap<>();
    }

    public static UserInput getInstance() {
        if (instance == null) {
            instance = new UserInput();
        }
        return instance;
    }

    public static LinkedHashMap<QueryKey, String> getInputs() {
        return inputs;
    }

    public static void clearInputs() {
        inputs.clear();
    }
}
