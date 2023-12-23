package com.example;

public class BasketDecorator extends ItemDecorator{
    public BasketDecorator(Item item) {
        super(item);
        description = "Basket Decorator";
    }

    @Override
    public double price() {
        return 4 + item.price();
    }

    @Override
    public String getDescription() {
        return item.getDescription() + " with Basket";
    }
}
