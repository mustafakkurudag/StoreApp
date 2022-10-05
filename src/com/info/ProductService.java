package com.info;

import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ProductService {
    private Scanner scanner = new Scanner(System.in);
    private BrandService brandService = new BrandService();
    private CategoryService categoryService = new CategoryService();
    private Brand brand;
    private Category category;

    public void addProduct(int catId) {
        System.out.println("Ürün adı: ");
        String name = scanner.nextLine();
        System.out.println("Ürün Markası: ");
        System.out.print("Lütfen seçim yapınız(marka ismini giriniz): ");
        selectBrand();
        String brandChoice = scanner.nextLine();
        brand = brandService.getBrandByName(brandChoice.trim().toLowerCase());
        /*System.out.println("Ürün Kategorisi: ");
        System.out.print("Lütfen seçim yapınız: ");
        selectCategory();
        int categoryChoice = scanner.nextInt();*/
        category = categoryService.getCategoryById(catId);

        Product product = new Product();
        product.setId(1);
        product.setName(name);
        product.setBrand(brand);
        product.setCategory(category);

        //System.out.format(String.valueOf(product), "Sütun");
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

    public void selectCategory() {
        List<Category> categories = categoryService.getCategories();
        Iterator<Category> categoryIterator = categories.iterator();
        int count = 1;
        while (categoryIterator.hasNext()) {
            Category c = categoryIterator.next();
            System.out.print((count++) + " - " + c.getName() + " | ");
        }
    }


}
