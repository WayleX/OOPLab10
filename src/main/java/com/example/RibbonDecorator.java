package com.example;

public class RibbonDecorator extends ItemDecorator{
    public RibbonDecorator(Item item) {
        super(item);
        description = "Ribbon Decorator";
    }

    @Override
    public double price() {
        return 40 + item.price();
    }

    @Override
    public String getDescription() {
        return item.getDescription() + " with Ribbon";
    }
}