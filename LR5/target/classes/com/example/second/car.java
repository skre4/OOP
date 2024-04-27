package com.example.third.model;
public class Car {
    private int id;
    private String stamp;
    private String model;
    private String generation;
    private String year;
    private int price;
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public String getGeneration() {
        return generation;
    }
    public void setGeneration(String generation) {
        this.generation = generation;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getStamp() {
        return stamp;
    }
    public void setStamp(String stamp) {
        this.stamp = stamp;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return id + "-" + stamp + "-" + model + "-" + generation + "-" + year + "-" + price;
    }
}