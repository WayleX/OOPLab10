package com.example;

public class PaperDecorator extends ItemDecorator {
    public PaperDecorator(Item item) {
        super(item);
        description = "Paper Decorator";
    }

    @Override
    public double price() {
        return 13 + item.price();
    }

    @Override
    public String getDescription() {
        return item.getDescription() + " with Paper";
    }
}
