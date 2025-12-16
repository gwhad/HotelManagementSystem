package Classes;

public class Service {
    private int serviceID;
    private String name;
    private double price;

    public Service() {
    }

    public Service(int serviceID, String name, double price) {
        this.serviceID = serviceID;
        this.name = name;
        this.price = price;
    }

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws InvalidDataException {
        if (price < 0) throw new InvalidDataException("Service price cannot be negative.");
        this.price = price;
    }
    @Override
    public String toString() {
        return "Service { " +
                "id=" + serviceID +
                ", name='" + name + '\'' +
                ", price=" + price +
                " }";
    }


}
