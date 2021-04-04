package seedu.duke.command.generalcommand;

import seedu.duke.command.Command;
import seedu.duke.ui.UiManager;

public class ShowVenuesCommand extends Command {
    protected UiManager ui;
    private static final String TD = " | ";
    private static final String MESSAGE_SUCCESS = "Venues in Engineering faculty:\n"
            + "1. E1  " + TD + "7.  E4 " + TD + "13. EW1 " + TD + "19. LT6        " + TD + "\n"
            + "2. E1A " + TD + "8.  E4A" + TD + "14. EW1A" + TD + "20. LT7        " + TD + "\n"
            + "3. E2  " + TD + "9.  E5 " + TD + "15. EW2 " + TD + "21. LT7A       " + TD + "\n"
            + "4. E2A " + TD + "10. E6 " + TD + "16. LT1 " + TD + "22. IT         " + TD + "\n"
            + "5. E3  " + TD + "11. E7 " + TD + "17. LT2 " + TD + "23. T-LAB      " + TD + "\n"
            + "6. E3A " + TD + "12. EA " + TD + "18. LT5 " + TD + "24. TECHNO EDGE" + TD + "\n"
            + "\n"
            + "Links between Engineering and Computing faculties:\n"
            + "1. LT3" + TD + "4. CENTRAL LIBRARY" + TD + "\n"
            + "2. LT4" + TD + "5. CHINESE LIBRARY" + TD + "\n"
            + "3. AS6" + TD + "\n"
            + "\n"
            + "Venues in Computing faculty:\n"
            + "1. COM1" + TD + "4. LT16" + TD + "\n"
            + "2. COM2" + TD + "5. LT17" + TD + "\n"
            + "3. COM3" + TD + "\n"
            + "\n"
            + "Eateries:\n"
            + "1. TECHNO EDGE CANTEEN" + TD + "5. SPINELLI COFFEE" + TD + "\n"
            + "2. CHEERS MINIMART    " + TD + "6. MAXX COFFEE    " + TD + "\n"
            + "3. ARISE & SHINE      " + TD + "7. STARBUCKS      " + TD + "\n"
            + "4. PLATYPUS FOOD BAR  " + TD;

    public ShowVenuesCommand() {
        this.ui = new UiManager();
    }

    public void execute() {
        ui.showMessageWithDivider(MESSAGE_SUCCESS);
    }
}
