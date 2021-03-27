package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeliverymanTest {
    private Deliveryman deliveryman = new Deliveryman("Obi Wan",
            "HIGHGROUND", "Interceptor", 5);
    @Test
    public void updateProfile_success() {
        deliveryman.updateProfile("Mace Windu | Jedi Interceptor | OUTTHEWINDU | 100");
        assertEquals("Mace Windu", deliveryman.getDriverName());
        assertEquals("Jedi Interceptor", deliveryman.getVehicleModel());
        assertEquals("OUTTHEWINDU", deliveryman.getLicensePlate());
        assertEquals(100, deliveryman.getMaxWeight());
    }

    @Test public void showProfile_message() {
        String expected = deliveryman.toString();
        assertEquals(expected, "Name: " + deliveryman.getDriverName() + '\n'
                + "Vehicle Model: " + deliveryman.getVehicleModel() + '\n'
                + "License Plate: " + deliveryman.getLicensePlate() + '\n'
                + "Max Weight: " + deliveryman.getMaxWeight());
    }
}
