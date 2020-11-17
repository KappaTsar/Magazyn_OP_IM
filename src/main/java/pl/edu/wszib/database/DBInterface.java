package pl.edu.wszib.database;

import pl.edu.wszib.model.Product;

import java.util.List;

public interface DBInterface {
    public void placeProduct(String prod_name, int prod_quan);
    public void takeProduct(String prod_name, int prod_quan);
    public List<Product> getAllProducts();
}
