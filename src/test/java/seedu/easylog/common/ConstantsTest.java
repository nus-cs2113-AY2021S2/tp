package seedu.easylog.common;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConstantsTest {

    @Test

    public void testArrayOffset() {
        assertEquals(Constants.ARRAY_OFFSET, 1);
    }

    @Test
    public void testCommandFindString() {
        assertEquals(Constants.COMMAND_FIND, "find");
    }
}
