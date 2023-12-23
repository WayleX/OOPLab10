package com.example;

public class Main {
    public static void main(String[] args) {
        Item item = new Flower();
        item = new PaperDecorator(item);
        item = new RibbonDecorator(item);
        item = new BasketDecorator(item);
        System.out.println(item.getDescription());
        System.out.println(item.price());
    }
}