package pl.edu.wszib.gui;

import pl.edu.wszib.database.DBInterface;
import pl.edu.wszib.database.SQLDatabase;
import pl.edu.wszib.model.Product;

import java.util.Scanner;

public class GUIconsole {
    private static final GUIconsole instance = new GUIconsole();

    private Scanner scanner = new Scanner(System.in);
    private DBInterface dataBase = SQLDatabase.getInstance();

    private GUIconsole() {
    }

    public static GUIconsole getInstance() {
        return instance;
    }

    public void showMainMenu() {
        System.out.println("1. Umiesc towar\n"+
                           "2. Odbierz towar\n" +
                           "3. Zobac zawartosc magazynu\n" +
                           "4. Wyjdz");

        String choose = scanner.nextLine();
        switch (choose) {
            case "1":
                placeProd();
                showMainMenu();
                break;
            case "2":
                takeProd();
                showMainMenu();
                break;
            case "3":
                showAllProducts();
                showMainMenu();
                break;
            case "4":
                System.exit(0);
            default:
                System.out.println("Nieprawidlowy wybor !!");
                showMainMenu();
                break;
        }
    }

    private void placeProd(){
        System.out.println("Podaj nazwu towara:");
        String nameProd = scanner.nextLine();
        System.out.println("Podaj ilosc towara:");
        int quanProd = scanner.nextInt();

        this.dataBase.placeProduct(nameProd, quanProd);
    }

    private void takeProd(){
        System.out.println("Podaj nazwu towara :");
        String nameProd = scanner.nextLine();
        System.out.println("Podaj ilosc towara:");
        int quanProd = scanner.nextInt();

        this.dataBase.takeProduct(nameProd, quanProd);
    }

    private void showAllProducts() {
        System.out.println("__________ List Towarow w Magazynie __________");
        for(Product currentProd: this.dataBase.getAllProducts()) {
            System.out.println(currentProd);
        }
        System.out.println("______________________________________________");
    }
}
