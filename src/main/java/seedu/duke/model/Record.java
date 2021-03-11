package seedu.duke.model;

/**
 * Each instance of this class represent a visit record. It can contain
 * medical diagnosis, prescription, test results, etc.
 * TODO: For v1.0 iteration, we will just implement a single string field to store everything
 */
public class Record {
    protected String consultationDetail;

    /**
     * Create a new visit record with details as a single string.
     *
     * @param consultationDetail detail of the visit record (diagnosis, prescription, etc.)
     */
    public Record(String consultationDetail) {
        this.consultationDetail = consultationDetail;
    }

    /**
     * Obtain the consultation detail of this record.
     *
     * @return Consultation detail related to this record
     */
    public String getConsultationDetail() {
        return consultationDetail;
    }

    @Override
    public String toString() {
        return consultationDetail;
    }
}
