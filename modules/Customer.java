package modules;

// Customer class
// This class is used to create a customer object with a customer ID, name, and address
// It also contains methods to get and set the customer's information
public class Customer {
    private String customerId;
    private String name;
    private String address;

    public Customer(String customerId, String name, String address) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
    }

    // Getters

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    // Setters

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}