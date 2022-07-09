package com.zeezaglobal.passmypizza.Data;

public class Pizza {
    private String  id;
    private String  pizzaName;

    private String  image_base64;
    private double  price;
    private int  rating;

    public Pizza(String pizzaName, String image_base64, double price, int rating) {
        this.pizzaName = pizzaName;
        this.image_base64 = image_base64;
        this.price = price;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public String getImage_base64() {
        return image_base64;
    }

    public double getPrice() {
        return price;
    }

    public int getRating() {
        return rating;
    }
}
