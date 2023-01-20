package managers;

import entity.Customer;
import java.util.Arrays;
import java.util.Scanner;

public class CustomerManager {
    private final Scanner scanner;
    private Customer[] customers;
    
    

    public CustomerManager() {
        scanner = new Scanner(System.in);
    }
    
    public Customer createCustomer(){
        Customer customer = new Customer();
        System.out.println("Input customer's name");
        customer.setName(scanner.nextLine());
        System.out.println("Input customer's last name");
        customer.setLastName(scanner.nextLine());
        System.out.println("Input customer's phone");
        customer.setPhone(scanner.nextLine());
        System.out.println("How much cash in vallet (!!must be Integer!!)");
        customer.setCash(scanner.nextInt());
        return customer;
        
    }
    
    public void customersList(Customer customers[]){
        for (int i = 0; i < customers.length; i++) {
            System.out.printf("%d. %s %s, phone: %s, cash in vallet %d%n", i+1, customers[i].getName(), customers[i].getLastName(), customers[i].getPhone(), customers[i].getCash());
        }
    }
    
    public Customer[] editCustomer(Customer[] customers){
        this.customersList(customers);
        System.out.print("Choose customer number to edit: ");
        int custNrToEdit = scanner.nextInt()-1; scanner.nextLine();

        System.out.printf("Edit name '%s'? Choose option: (y / n) ", customers[custNrToEdit].getName());
        String task = scanner.nextLine();
        switch (task.toLowerCase()){
            case "y":
                System.out.print("Input new name: ");
                customers[custNrToEdit].setName(scanner.nextLine());
            break;
        }
        System.out.printf("Edit lastname '%s'? Choose option: (y / n) ", customers[custNrToEdit].getLastName());
        task = scanner.nextLine();
        switch (task.toLowerCase()){
            case "y":
                System.out.print("Input new lastname: ");
                customers[custNrToEdit].setLastName(scanner.nextLine());
            break;
        }
        System.out.printf("Edit phone '%s'? Choose option: (y / n) ", customers[custNrToEdit].getPhone());
        task = scanner.nextLine();
        switch (task.toLowerCase()){
            case "y":
                System.out.print("Input new phone: ");
                customers[custNrToEdit].setPhone(scanner.nextLine());
            break;
        }
        System.out.printf("Edit cash '%d'? Choose option: (y / n) ", customers[custNrToEdit].getCash());
        task = scanner.nextLine();
        switch (task.toLowerCase()){
            case "y":
                System.out.print("Input how much cash: ");
                customers[custNrToEdit].setCash(scanner.nextInt());
            break;
        }
        return customers;
        
    }
    
    
    
    
    
    
    
}   // public class CustomerManager ENDS
