package seedu.duke.features.capsimulator;

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

