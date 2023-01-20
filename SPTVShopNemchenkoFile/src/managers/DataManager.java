package managers;

import entity.Product;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;



public class DataManager {
    private final String FILENAME_PRODUCTS = "files/Myproducts";
    private final File file;

    public DataManager() {
        file = new File("files");
        file.mkdirs();
    }
    
    public void saveProductsToFile (Product[] products){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILENAME_PRODUCTS);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(products);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "The file does not exist", ex);
        } catch (IOException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Error input / output", ex);
        }
        
    }
    
    public Product[] loadProductsFromFile(){
        Product[] products = new Product[0];
        try {
            FileInputStream fielInputStream = new FileInputStream(FILENAME_PRODUCTS);
            ObjectInputStream objectInputStream = new ObjectInputStream(fielInputStream);
            products = (Product[]) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "The file does not exist", ex);
        } catch (IOException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Error input / output", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "The class doesn't exist", ex);
        }
        return products;
        
    }
    
    
    
    
    
    
    
    
    
    
}   // public class DataManager ENDS
