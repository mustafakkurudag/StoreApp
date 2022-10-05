package com.info;

import java.util.Iterator;
import java.util.PriorityQueue;

public class BrandService {
    private Iterator<Brand> it;

    public PriorityQueue<Brand> getBrands() {
        Brand b1 = new Brand(1, "Samsung");
        Brand b2 = new Brand(2, "Lenovo");
        Brand b3 = new Brand(3, "Apple");
        Brand b4 = new Brand(4, "Huawei");
        Brand b5 = new Brand(5, "Casper");
        Brand b6 = new Brand(6, "Asus");
        Brand b7 = new Brand(7, "HP");
        Brand b8 = new Brand(8, "Xiaomi");
        Brand b9 = new Brand(9, "Monster");

        PriorityQueue<Brand> brands = new PriorityQueue<>();
        brands.add(b1);
        brands.add(b2);
        brands.add(b3);
        brands.add(b4);
        brands.add(b5);
        brands.add(b6);
        brands.add(b7);
        brands.add(b8);
        brands.add(b9);

        return brands;
    }

    public void printBrands() {
        PriorityQueue<Brand> brands = getBrands();
        Iterator<Brand> it = brands.iterator();
        while (it.hasNext()) {
            Brand b = it.next();
            System.out.println(" - " + b.getName());
        }
    }

    public Brand getBrandByName(String name) {
        PriorityQueue<Brand> brands = getBrands();
        it = brands.iterator();
        while (it.hasNext()) {
            Brand b = it.next();
            if (b.getName().toLowerCase().equals(name)) {
                return b;
            }
        }
        return null;
    }
}
