package seedu.duke.features.capsimulator;

/**
 * ModularCreditEnum contains the list of modular credits(MCs) that is deemed valid
 * for simulation of CAP.
 */
public enum ModularCreditEnum {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    TEN(10),
    TWELVE(12),
    THIRTEEN(13),
    FOURTEEN(14),
    FIFTEEN(15),
    SIXTEEN(20);


    private int modularCredit;

    ModularCreditEnum(int modularCredit) {
        this.modularCredit = modularCredit;
    }

    public int getModularCredit() {
        return modularCredit;
    }

    /**
     * Checks if MCs entered by the user exists in the ModularCreditEnum.
     *
     * @param mcs MCs from user input.
     * @return boolean value of whether MCs exists.
     */
    public static boolean checkMcsExist(Integer mcs) {
        if (mcs == null) {
            return false;
        }

        for (ModularCreditEnum m : values()) {
            if (mcs.equals(m.getModularCredit())) {
                return true;
            }
        }
        return false;
    }
}

