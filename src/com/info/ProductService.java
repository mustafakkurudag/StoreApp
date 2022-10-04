package com.info;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ProductService {
    private Scanner scanner = new Scanner(System.in);
    private BrandService brandService = new BrandService();
    private Brand brand;

    public void addProduct() {
        System.out.println("Ürün adı: ");
        String name = scanner.nextLine();
        System.out.println("Ürün Markası: ");
        System.out.print("Lütfen seçim yapınız: ");
        selectBrand();
        int choice = scanner.nextInt();
        brand = brandService.getBrandById(choice);

        Product product = new Product();
        product.setId(1);
        product.setName(name);
        product.setBrand(brand);

        System.out.println(product);

    }

    public void selectBrand() {
        PriorityQueue<Brand> brands = brandService.getBrands();
        Iterator<Brand> brandIterator = brands.iterator();
        int count = 1;
        while (brandIterator.hasNext()) {
            Brand b = brandIterator.next();
            System.out.print((count++) + " - " + b.getName() + " | ");
        }
    }
}
