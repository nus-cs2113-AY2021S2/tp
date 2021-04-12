package seedu.duke;

import java.util.ArrayList;

public class Deliveryman {
    private String driverName;
    private String licensePlate;
    private String vehicleModel;
    private int maxWeight;
    private ArrayList<Delivery> records = new ArrayList<>();

    public Deliveryman(String driverName, String licensePlate, String vehicleModel, int maxWeight) {
        this.driverName = driverName;
        this.licensePlate = licensePlate;
        this.vehicleModel = vehicleModel;
        this.maxWeight = maxWeight;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Override
    public String toString() {
        return "Name: " + getDriverName() + '\n'
            + "Vehicle Model: " + getVehicleModel() + '\n'
            + "License Plate: " + getLicensePlate() + '\n'
            + "Max Weight: " + getMaxWeight();
    }

    public String saveFormat() {
        return getDriverName() + " | " + getLicensePlate() + " | " + getVehicleModel() + " | " + getMaxWeight();
    }

    public void editProfile(String name, String vehicleModel, String licensePlate, int maxWeight) {
        this.setDriverName(name);
        this.setVehicleModel(vehicleModel);
        this.setLicensePlate(licensePlate);
        this.setMaxWeight(maxWeight);
    }

    public void updateProfile(String inputProfileData) {
        if (!inputProfileData.equals("fail")) {
            String[] splitInputProfileData = inputProfileData.split(" \\| ");
            Ui.printDivider();
            System.out.println("Based on your input:");
            System.out.printf(" Name: %s\n Vehicle Model: %s\n License plate: %s\n Max Weight: %s\n",
                splitInputProfileData[0],
                splitInputProfileData[1],
                splitInputProfileData[2],
                splitInputProfileData[3]
            );
            try {
                if (Integer.parseInt(splitInputProfileData[3]) == 0) {
                    throw new NumberFormatException();
                }
                editProfile(
                    splitInputProfileData[0],
                    splitInputProfileData[1],
                    splitInputProfileData[2],
                    Integer.parseInt(splitInputProfileData[3])
                );
            } catch (NumberFormatException e) {
                System.out.println("You have entered an invalid integer for weight!!");
                System.out.println("If you require any assistance with regards to what an integer is...");
                System.out.println("Please visit: https://www.mathsisfun.com/definitions/integer.html");
            }
            DataManager.saveProfile(this);
        }

    }

    public void completeDelivery(Delivery delivery) {
        records.add(delivery);
    }

    public ArrayList<Delivery> getRecords() {
        return records;
    }
}
