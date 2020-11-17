package pl.edu.wszib.database;

import pl.edu.wszib.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SQLDatabase {
    private static final SQLDatabase instance = new SQLDatabase();
    private List<Product> productList = new ArrayList<Product>();

    private SQLDatabase() {
    }

    public static SQLDatabase getInstance() {
        return instance;
    }

    public void placeProduct(String prod_name, int prod_quan) {


        this.productList.add(new Product(UUID.fromString(prod_name), prod_name, prod_quan));
    }

    public void takeProduct(String prod_name) {

    }

    public void takeProduct(int prod_id) {

    }

    public List<Product> getAllProducts() {
        return this.productList ;
    }
}
