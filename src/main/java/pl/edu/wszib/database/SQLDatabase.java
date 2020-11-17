package pl.edu.wszib.database;

import pl.edu.wszib.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SQLDatabase implements DBInterface{
    private static final SQLDatabase instance = new SQLDatabase();
    private List<Product> productList = new ArrayList<Product>();

    private SQLDatabase() {
    }

    public static SQLDatabase getInstance() {
        return instance;
    }

    public void placeProduct(String prod_name, int prod_quan) {
        UUID prod_id = UUID.fromString(prod_name);
        for(Product currentProd : this.productList) {
            if(currentProd.getId().equals(prod_id)) {
                currentProd.setQuan(currentProd.getQuan() + prod_quan);
                return;
            }
        }

        this.productList.add(new Product(prod_id, prod_name, prod_quan));
    }

    public void takeProduct(String prod_name, int prod_quan) {
        UUID prod_id = UUID.fromString(prod_name);
        this.takeProduct(prod_id, prod_quan);
    }

    public void takeProduct(UUID prod_id, int prod_quan) {
        for(Product currentProd : this.productList) {
            if(currentProd.getId().equals(prod_id)) {
                int diff = currentProd.getQuan() - prod_quan;
                if(diff < 0) {
                    System.out.println("Nie mozesz wziac tego produktu wiecej niz "+currentProd.getQuan()+"\n");
                    return;
                }
                if(diff == 0) {
                    //delete
                    this.productList.remove(currentProd);
                }
                else{
                    currentProd.setQuan(diff);
                }

                return;
            }
        }
        System.out.println("Nie ma takiego produktu zobac na liscie! \n");
    }

    public List<Product> getAllProducts() {
        return this.productList ;
    }
}
