package final_assignment_jp2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Customer customerList = new Customer();
        // menu
        try {
            int luaChon;
            Scanner sc = new Scanner(System.in);
            while (true){
                System.out.println("------------MENU-------------");
                System.out.println("1. Add new customer");
                System.out.println("2. Find by name");
                System.out.println("3. Display all");
                System.out.println("0. Exit");
                System.out.println("Enter a number (0-3)");
                luaChon = sc.nextInt();
                sc.nextLine();
                switch (luaChon) {
                    case 1:
                        System.out.println("Enter customer name: ");
                        String customerName = sc.nextLine();
                        System.out.println("Enter customer email: ");
                        String customerEmail = sc.nextLine();
                        System.out.println("Enter customer phone number: ");
                        String customerPhoneNumber = sc.nextLine();
                        Customer customer = new Customer(customerName, customerEmail, customerPhoneNumber);
                        customerList.addCustomer(customer);
                        System.out.println("\nCustomer added successfully!");
                        break;
                    case 2:
                        System.out.println("Enter customer name: ");
                        String customerFindingName = sc.nextLine();
                        customerList.findByName(customerFindingName);
                        System.out.println("\nCustomer found successfully!");
                        break;
                    case 3:
                        customerList.printAllCustomer();
                        System.out.println("\nCustomer printed successfully!");
                        break;
                    case 0:
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            System.out.println("Wrong input");
        }
    }
}
