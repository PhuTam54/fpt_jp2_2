package final_assignment_jp2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Customer {
     private String customerName, customerEmail, customerPhoneNumber;
    private final Map<String, Customer> customerMap = new HashMap<>();
    public void addCustomer(Customer customer) {
        this.customerMap.put(customer.getCustomerName(), customer);
    }
    public void findByName(String customerName) {
        if (customerMap.get(customerPhoneNumber) == null) {
            System.out.println("Not found");
        }
        System.out.println(this.customerMap.get(customerName));
    }
    public void printAllCustomer() {
        Set<String> customerList = this.customerMap.keySet();
        System.out.println((customerList));
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
        return "CustomerName: " + customerName + " - CustomerEmail: " + customerEmail + " - CustomerPhoneNumber: " + customerPhoneNumber;
    }
}
