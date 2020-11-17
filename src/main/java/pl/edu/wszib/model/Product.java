package pl.edu.wszib.model;

public class Product {
    private int id;
    private String name;
    private int quan;

    public Product(String name, int quan) {
        this.name = name;
        this.quan = quan;
    }

    @Override
    public String toString() {
        return "product_id: " + id + " w/ name: " + name + " in quantity: " + quan;
    }
}
