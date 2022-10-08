package com.info;

import java.util.*;

public class ProductService {
    private Scanner scanner = new Scanner(System.in);
    private BrandService brandService = new BrandService();
    private CategoryService categoryService = new CategoryService();
    private Brand brand;
    private Category category;
    private int id = 0;
    private boolean addNotFirst = false;

    public Product addProduct(int catId) {
        Product product = new Product();
        if (addNotFirst)
            scanner.nextLine();
        System.out.println("Ürün adı: ");
        String name = scanner.nextLine();
        System.out.println("Ürün Markası: ");
        System.out.println("Lütfen seçim yapınız(marka ismini giriniz): ");
        selectBrand();
        String brandChoice = scanner.nextLine();
        brand = brandService.getBrandByName(brandChoice.trim().toLowerCase());
        category = categoryService.getCategoryById(catId);
        System.out.println("Fiyat: ");
        int price = scanner.nextInt();
        scanner.nextLine();//nextInt nextDouble vs kullandıktan sonra String veri alabilmek için önce bu satırdaki gibi nextLine çağırılmalı.
        System.out.println("Renk: ");
        String color = scanner.nextLine();
        if (catId == 2) {//sadece telefonlar için kamera ve batarya bilgisi eklenecek
            System.out.println("Kamera: ");
            int camera = scanner.nextInt();
            System.out.println("Batarya: ");
            int battery = scanner.nextInt();
            product.setCamera(camera);
            product.setBatteryPower(battery);
        }
        System.out.println("RAM:");
        int ram = scanner.nextInt();
        System.out.println("Depolama:");
        int storage = scanner.nextInt();
        System.out.println("Ekran: ");
        float screen = scanner.nextFloat();

        product.setId(id++);
        product.setName(name);
        product.setBrand(brand);
        product.setCategory(category);
        product.setPrice(price);
        product.setColor(color);
        product.setRam(ram);
        product.setStorage(storage);
        product.setScreen(screen);
        addNotFirst = true;

        System.out.println("Ürün başarıyla eklendi...");
        return product;
    }

    public void selectBrand() {
        PriorityQueue<Brand> brands = brandService.getBrands();
        Iterator<Brand> brandIterator = brands.iterator();

        while (brandIterator.hasNext()) {
            Brand b = brandIterator.next();
            System.out.println(" - " + b.getName());
        }
    }

    public void getProductsByCatId(int catId, List<Product> products) {
        boolean isExists = false;
        System.out.println("------------------------------------------------------------------------------------------------------------");
        if (catId == 1) {
            System.out.format("%5s %10s %10s %10s %12s %10s %10s %10s", "ID", "İsim", "Fiyat", "Marka", "Depolama", "Ekran", "RAM", "Renk");
        }
        if (catId == 2) {
            System.out.format("%5s %10s %10s %10s %12s %10s %10s %10s %10s %10s", "ID", "İsim", "Fiyat", "Marka", "Depolama", "Kamera", "Ekran", "RAM", "Pil", "Renk");
        }
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getCategory().getId() == catId) {
                if (catId == 1) {
                    System.out.format("%5s %10s %10s %10s %10s %11s %10s %11s",
                            products.get(i).getId(), products.get(i).getName(), products.get(i).getUnitPrice(),
                            products.get(i).getBrand().getName(), products.get(i).getStorage(), products.get(i).getScreen(),
                            products.get(i).getRam(), products.get(i).getColor()
                    );
                    System.out.println();
                }
                if (catId == 2) {
                    System.out.format("%5s %10s %10s %10s %10s %10s %10s %11s %10s %11s",
                            products.get(i).getId(), products.get(i).getName(), products.get(i).getUnitPrice(),
                            products.get(i).getBrand().getName(), products.get(i).getStorage(), products.get(i).getCamera(),
                            products.get(i).getScreen(),  products.get(i).getRam(),products.get(i).getBatteryPower(),
                            products.get(i).getColor()
                    );
                    System.out.println();
                }
                isExists = true;
            }
        }

        if (!isExists) {
            System.out.println("Bu kategoride gösterilecek ürün bulunamadı!\n");
        }
    }

    public void deleteProductById(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("Silinecek ürün bulunamadı!");
        } else {
            System.out.println("Lütfen silmek istediğiniz ürünün ID'sini giriniz: ");
            int productId = scanner.nextInt();
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getId() == productId) {
                    products.remove(i);
                }
            }
            System.out.println("Ürün başarıyla silindi...");
        }
    }

    public void getProductsByBrand(List<Product> products) {
        PriorityQueue<Brand> brands = new PriorityQueue<>();
        brands = brandService.getBrands();

        for (Brand b :
                brands) {
            System.out.println(b.getName() + " Ürünleri");
            System.out.println();
            System.out.println("------------------------------------------------------------------------------------------------------------");
            for (Product p :
                    products) {
                if (p.getBrand().getName().equals(b.getName())) {
                    System.out.format("%5s %10s %10s %10s %12s %10s %10s %10s %10s %10s", "ID", "İsim", "Fiyat", "Marka", "Depolama", "Kamera", "Ekran", "RAM", "Pil", "Renk");
                    System.out.println();
                    System.out.println("------------------------------------------------------------------------------------------------------------");
                    System.out.format("%5s %10s %10s %10s %10s %10s %10s %11s %10s %11s",
                            p.getId(), p.getName(), p.getUnitPrice(), p.getBrand().getName(), p.getStorage(),
                            p.getCamera(), p.getScreen(), p.getRam(), p.getBatteryPower(), p.getColor()
                    );
                    System.out.println("\n------------------------------------------------------------------------------------------------------------");

                }
            }
        }
    }
}
