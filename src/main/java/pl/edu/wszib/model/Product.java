package pl.edu.wszib.model;

import java.util.UUID;
public class Product {
    private UUID id;
    private String name;
    private int quan;

    public Product(UUID id, String name, int quan) {
        this.id = id;
        this.name = name;
        this.quan = quan;
    }

    public UUID getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public int getQuan(){
        return this.quan;
    }

    public void setQuan(int n_quan){
        this.quan = n_quan;
    }

    @Override
    public String toString() {
        return "product_id: " + id + " w/ name: " + name + " in quantity: " + quan;
    }
}
