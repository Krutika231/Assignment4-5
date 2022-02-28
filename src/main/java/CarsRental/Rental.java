package CarsRental;

public class Rental {
    private String customerName;
    private String vehicleName;
    private long identificationCode;
    private String model;
    private int numberOfSeat;
    private String licensePlate;
    public String startDate;
    public String endDate;
    private long charges;
    private long numberOfDays;


    public Rental(){};
    public Rental(String customerName, String vehicleName, long identificationCode, String model, int numberOfSeat, String licensePlate, String startDate, String endDate, long charges, long numberOfDays) {
        this.customerName = customerName;
        this.vehicleName = vehicleName;
        this.identificationCode = identificationCode;
        this.model = model;
        this.numberOfSeat = numberOfSeat;
        this.licensePlate = licensePlate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.charges = charges;
        this.numberOfDays = numberOfDays;
    }

    public long getRental(long numberOfDays) {
        long rental;
        if(numberOfDays<0)
            rental=0;
        else if(numberOfDays<=10)
        {
            rental=numberOfDays*700;
        }
        else if(numberOfDays<=30)
        {
            rental=numberOfDays*600;
        }
        else if(numberOfDays<=90)
        {
            rental=numberOfDays*550;
        }
        else if(numberOfDays<=365)
        {
            rental=numberOfDays*500;
        }
        else {
            rental=numberOfDays*400;
        }
        return rental;
    }


    //getter methods for variable
    public String getModel() {
        return model;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public long getIdentificationCode() {
        return identificationCode;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public long getCharges() {
        return charges;
    }

    public long getNumberOfDays() {
        return numberOfDays;
    }


}