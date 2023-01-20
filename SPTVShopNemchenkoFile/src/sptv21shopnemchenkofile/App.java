package sptv21shopnemchenkofile;

import entity.Customer;
import entity.Product;
import entity.Order;
import java.util.Scanner;
import java.util.Arrays;
import managers.CustomerManager;
import managers.ProductsManager;
import managers.OrderManager;
import managers.DataManager;


public class App {
    private final Scanner scanner;
    private final CustomerManager customerManager;
    private Customer[] customers;
    
    private final ProductsManager productsManager;
    private Product[] products;
    
    private final OrderManager ordersManager;
    private Order[] orders;
    
    private DataManager dataManager;

    public App() {
        scanner = new Scanner(System.in);
        customerManager = new CustomerManager();
        customers = new Customer[0];
        
        dataManager = new DataManager();
        productsManager = new ProductsManager();
        products  = dataManager.loadProductsFromFile();
        
        ordersManager = new OrderManager();
        orders = new Order[0];
        
//        testAddCustomer();
//        testAddProduct();
        
    }
    
    public void run(){
        String splitter = "\n------------------------------------------------------------------------------";
        
        boolean repeat = true;
        
        do{
            System.out.println("\t\t\t\tApp options:");
            System.out.println("0 - Quit");
            System.out.println("1 - Add product\t\t|\t2 - Edit product\t|\t3 - Products list" );
            System.out.println("4 - Add customer\t|\t5 - Edit customer\t|\t6 - Customers list");
            System.out.println("7 - Place order\t\t|\t8 - Orders list\t\t|\t9 - Money turnover");
            System.out.print("Choose options number: ");
            int option = scanner.nextInt();
            System.out.println("\n");
            switch (option){
                case 0:
                   repeat = false;
                   break;
                case 1:
                    System.out.println("1 - Add product");
                    addProduct(productsManager.createProduct());
                    dataManager.saveProductsToFile(products);
                    System.out.println(splitter);
                   break;
                case 2:
                    System.out.println("2 - Edit product");
                    products = productsManager.editProduct(products);
                    
                    System.out.println(splitter);
                    break;
                case 3:
                    System.out.println("3 - Products list");
                    productsManager.productsList(products);
                    
                    System.out.println(splitter);
                    break;
                case 4:
                    System.out.println("4 - Add customer");
                    addCustomer(customerManager.createCustomer());
                    
                    System.out.println(splitter);
                    break;
                case 5:
                    System.out.println("5 - Edit customer");
                    customers = customerManager.editCustomer(customers);
                    
                    System.out.println(splitter);
                    break;
                case 6:
                    System.out.println("6 - Customers list");
                    customerManager.customersList(customers);
                    
                    System.out.println(splitter);
                    break;
                case 7:
                    System.out.println("7 - Place order");
                    addOrder(ordersManager.placeOrder(customers, products));
                    
                    System.out.println(splitter);
                    break;
                case 8:
                    System.out.println("8 - Orders list");
                    ordersManager.ordersList(orders);
                    
                    System.out.println(splitter);
                    break;
                case 9:
                    System.out.println("9 - Money turnover");
                    int shopMoney = 0;
//                    int totalSpent = orders[i].getProduct().getPrice() * orders[i].getQuantity();
                    for (int i = 0; i < orders.length; i++) {
                        int totalSpent = orders[i].getProduct().getPrice() * orders[i].getQuantity();
                        System.out.printf("%d. %s, Price per item: %d, Ordered quantiy: %d, Total spent: %d%n",i+1, orders[i].getProduct().getTitle(), orders[i].getProduct().getPrice(), orders[i].getQuantity(), totalSpent); 
                        shopMoney += orders[i].getQuantity() * orders[i].getProduct().getPrice();
                    }
                    System.out.println("Total turnover: " + shopMoney);
                    System.out.println(splitter);
                    break;
                    
                default:
                    System.out.println("There is no function with such number\nChoose function number from the list!\n" + splitter);
            }
            
            
        }while(repeat);
        System.out.println("Good bye!");
        
        
        
    }   // run ends
    
    public void addCustomer(Customer customer){
        customers = Arrays.copyOf(customers, customers.length+1);
        customers[customers.length-1] = customer;
    }
    
    public void addProduct(Product product){
        products = Arrays.copyOf(products, products.length+1);
        products[products.length-1] = product;
    }
    
    public void addOrder(Order order){
        orders = Arrays.copyOf(orders, orders.length+1);
        orders[orders.length-1] = order;
    }
    
    
    
    
    //------------------- TEST FUNCTIONS ---------------------
    // to add customer automatically
    private void testAddCustomer(){
        Customer customer = new Customer("Tolik", "Pruzhinkin", "55123123", 55);
        this.customers = Arrays.copyOf(this.customers, this.customers.length+1);
        this.customers[this.customers.length-1] = customer;
        
        Customer customer1 = new Customer("Vasily", "Pupkin", "587896321", 120);
        this.customers = Arrays.copyOf(this.customers, this.customers.length+1);
        this.customers[this.customers.length-1] = customer1;
    }
    
    // to add product automatically
    private void testAddProduct(){
        Product product = new Product("Bread", 5, 23);
        this.products = Arrays.copyOf(this.products, this.products.length+1);
        this.products[this.products.length-1] = product;
        
        Product product1 = new Product("Milk", 1, 36);
        this.products = Arrays.copyOf(this.products, this.products.length+1);
        this.products[this.products.length-1] = product1;
        
    }
    
    
}   // public class App ENDS
