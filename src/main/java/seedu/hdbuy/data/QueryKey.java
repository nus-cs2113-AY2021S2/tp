package seedu.hdbuy.data;

public enum QueryKey {
    LOCATION {
        @Override public String toString() {
            return "location";
        }
    }, TYPE {
        @Override public String toString() {
            return "type";
        }
    }, LEASE_REMAINING {
        @Override public String toString() {
            return "lease_remaining";
        }
    }
}
