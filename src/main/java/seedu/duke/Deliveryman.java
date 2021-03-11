package seedu.duke;

public class Deliveryman {
    private String driverName;
    private String licensePlate;
    private String vehicleModel;

    public Deliveryman(String driverName, String licensePlate, String vehicleModel) {
        this.driverName = driverName;
        this.licensePlate = licensePlate;
        this.vehicleModel = vehicleModel;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }
}
