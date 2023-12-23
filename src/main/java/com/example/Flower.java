package com.example;

public class Flower extends Item{
    protected String description;
    public Flower(){
        description = "A flower";
    }
    public String getDescription() {
        return description;
    }

    public double price(){
        return 10;
    };    
}
