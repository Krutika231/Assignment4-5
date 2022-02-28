package CarsRental;

public class Vehicle {

    private long identificationCode;
    private String brand;
    private String model;
    private int numberOfSeat;
    private String licensePlate;
    private String startDate;
    private String endDate;

    public Vehicle(){};

    public Vehicle(long identificationCode, String brand, String model, int numberOfSeat, String licensePlate, String startDate, String endDate) {
        this.identificationCode = identificationCode;
        this.brand = brand;
        this.model = model;
        this.numberOfSeat = numberOfSeat;
        this.licensePlate = licensePlate;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    //getter methods for variable
    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public long getIdentificationCode() {
        return identificationCode;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public String getLicensePlate() {
        return licensePlate;
    }


}
