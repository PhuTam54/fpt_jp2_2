package final_assignment_jp2;

import java.util.*;

public class Customer {
    private String customerName, customerEmail, customerPhoneNumber;
    private final Map<String, Customer> customerMap = new HashMap<>();
    public void addCustomer(Customer customer) {
        this.customerMap.put(customer.getCustomerName(), customer);
    }
    public void findByName(String customerName) {
        if (customerMap.containsKey(customerName)) {
            Customer foundCustomer = customerMap.get(customerName);
            System.out.println(foundCustomer);
        } else {
            System.out.println("Not found");
        }
    }
    public void printAllCustomer() {
        System.out.println("\t\tCRM");
        System.out.println("Name\t\tPhone number");
        // Print values
        for (Customer i : customerMap.values()) {
            System.out.println(i);
        }
    }
    public Customer(String customerName, String customerEmail, String customerPhoneNumber) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public Customer() {

    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    @Override
    public String toString() {
        return customerName + "\t\t   " + customerPhoneNumber;
    }
}
