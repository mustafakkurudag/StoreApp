package com.info;

import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        System.out.println("PatikaStore Ürün Yönetim Paneli...");
        ProductService service = new ProductService();
        service.addProduct();
    }
}
