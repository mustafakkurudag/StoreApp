package com.info;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    private static CategoryService categoryService = new CategoryService();
    private static Scanner scanner = new Scanner(System.in);
    private static BrandService brandService = new BrandService();
    private static ProductService productService = new ProductService();
    private static List<Product> currentProducts = new ArrayList<>();
    private static boolean runState = true;


    public static void main(String[] args) {
        System.out.println("PatikaStore Ürün Yönetim Paneli...");
        menu();
    }
    public static void menu() {
        List<Category> categories = categoryService.getCategories();

        while (runState) {
            System.out.println("1 - Notebook İşlemleri");
            System.out.println("2 - Cep Telefonu İşlemleri");
            System.out.println("3 - Marka Listele");
            System.out.println("0 - Çıkış");
            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("Program sonlandırıldı!");
                    runState = false;
                    break;
                case 1:
                    System.out.println("Notebook menü");
                    showMenuByChoice(1);
                    break;
                case 2:
                    System.out.println("Cep telefonu menü");
                    showMenuByChoice(2);
                    break;
                case 3:
                    brandService.printBrands();
                    productService.getProductsByBrand(currentProducts);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir seçim yapınız!");
            }
        }
    }

    public static void showMenuByChoice(int choice) {
        System.out.println("1 - Ürün ekle \t 2- Ürün Listele \t 3- Ürün Sil");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                currentProducts.add(productService.addProduct(choice));
                break;
            case 2:
                System.out.println(categoryService.getCategoryById(2).getName() + " Listesi\n");
                productService.getProductsByCatId(choice, currentProducts);
                break;
            case 3:
                productService.getProductsByCatId(choice, currentProducts);
                productService.deleteProductById(currentProducts);
                break;
        }
    }
}
