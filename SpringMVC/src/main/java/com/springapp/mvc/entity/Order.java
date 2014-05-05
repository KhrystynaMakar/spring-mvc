package com.springapp.mvc.entity;

import java.util.ArrayList;

/**
 * Created by Admin on 16.04.14.
 */
public class Order {
    private int iID;
    private String city;
    private ArrayList<Fruit> fruits;

    public Order() {
    }

    public Order(int iID, String city) {
        this.iID = iID;
        this.city = city;
    }

    public int getiID() {
        return iID;
    }

    public void setiID(int iID) {
        this.iID = iID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ArrayList<Fruit> getFruits() {
        return fruits;
    }

    public void setFruits(ArrayList<Fruit> fruits) {
        this.fruits = fruits;
    }

    @Override
    public String toString() {
        String str = "ID: " + this.iID + ", \n" +
                "city: " +this.city;
        return str;
    }
}
