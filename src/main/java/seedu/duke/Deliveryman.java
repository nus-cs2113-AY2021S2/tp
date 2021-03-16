package seedu.duke;

public class Deliveryman {
    private String driverName;
    private String licensePlate;
    private String vehicleModel;
    public static Deliveryman deliveryman;

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

    @Override
    public String toString() {
        return "Name: " + getDriverName() + '\n'
                + "Vehicle Model: " + getVehicleModel() + '\n'
                + "License Plate: " + getLicensePlate()
        ;
    }

    public String saveFormat() {
        return getDriverName() + " | " + getLicensePlate() + " | " + getVehicleModel();
    }

    public void editProfile(String name, String vehicleModel, String licensePlate) {
        this.setDriverName(name);
        this.setVehicleModel(vehicleModel);
        this.setLicensePlate(licensePlate);
    }
}
