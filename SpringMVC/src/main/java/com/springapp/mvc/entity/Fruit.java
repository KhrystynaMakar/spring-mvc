package com.springapp.mvc.entity;

/**
 * Created by Admin on 15.04.14.
 */
public class Fruit {
    private int iID;
    private String name;
    private double price;
    private double weight;
    private boolean citrus;
    private int orderID;

    public Fruit() {}

    public Fruit(String name, double price, double weight, boolean citrus, int orderID){
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.citrus = citrus;
        this.orderID = orderID;
    }

    public int getiID() {
        return iID;
    }

    public void setiID(int iID) {
        this.iID = iID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isCitrus() {
        return citrus;
    }

    public void setCitrus(boolean citrus) {
        this.citrus = citrus;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    @Override
    public String toString() {
        String str = "ID " + this.iID + ", \n" +
                "name: " + this.name + ", \n" +
                "price: " + this.price + ", \n" +
                "weight: " + this.weight + ", \n" +
                "citrus: " + this.citrus + ", \n" +
                "orderID: " + this.orderID;
        return str;
    }
}
