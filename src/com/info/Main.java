package com.info;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    private static CategoryService categoryService = new CategoryService();
    private static Scanner scanner = new Scanner(System.in);
    private static BrandService brandService = new BrandService();
    private static ProductService productService = new ProductService();


    public static void main(String[] args) {
        System.out.println("PatikaStore Ürün Yönetim Paneli...");
        menu();
    }
    public static void menu() {
        List<Category> categories = categoryService.getCategories();

        System.out.println("1 - Notebook İşlemleri");
        System.out.println("2 - Cep Telefonu İşlemleri");
        System.out.println("3 - Marka Listele");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                productService.addProduct(1);
                //Notebook listele
                //Notebook sil
                break;
            case 2:
                productService.addProduct(2);
                //cep telefonu listele
                //cep telefonu sil
                break;
            case 3:
                brandService.printBrands();
                break;
            default:
                System.out.println("Lütfen geçerli bir seçim yapınız!");
        }
    }
}
