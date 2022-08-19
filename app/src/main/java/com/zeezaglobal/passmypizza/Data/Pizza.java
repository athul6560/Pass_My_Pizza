package com.zeezaglobal.passmypizza.Data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="pizza")
public class Pizza {
    @PrimaryKey(autoGenerate = true)
    private int  id;
    private String  pizzaName;
    private String  topings;
    private String  size;
    private String  crust;
    private double  price;

    public Pizza( String pizzaName, String topings, String size, String crust, double price) {

        this.pizzaName = pizzaName;
        this.topings = topings;
        this.size = size;
        this.crust = crust;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public String getTopings() {
        return topings;
    }

    public String getSize() {
        return size;
    }

    public String getCrust() {
        return crust;
    }

    public double getPrice() {
        return price;
    }
}
