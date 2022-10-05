package com.info;

public class Product {
    private int id;
    private String name;
    private Brand brand;
    private Category category;
    private double price;
    private double unitPrice;
    private int discount;
    private int stockAmount;
    private int storage;
    private float screen;
    private int batteryPower;
    private int ram;
    private String color;

    public Product() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getUnitPrice() {
        return price - (price*discount/100);
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public float getScreen() {
        return screen;
    }

    public void setScreen(float screen) {
        this.screen = screen;
    }

    public int getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Ürün Bilgileri" +
                "id=" + id +
                ", İsim:'" + name + '\'' +
                ", Marka:" + brand.getName() +
                ", category=" + category.getName() +
                ", price=" + price +
                ", unitPrice=" + unitPrice +
                ", discount=" + discount +
                ", stockAmount=" + stockAmount +
                ", storage=" + storage +
                ", screen=" + screen +
                ", batteryPower=" + batteryPower +
                ", ram=" + ram +
                ", color='" + color + '\'' ;
    }
}
