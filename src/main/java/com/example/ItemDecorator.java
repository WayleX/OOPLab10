package com.example;

abstract class ItemDecorator extends Item {
    protected Item item;

    public ItemDecorator(Item item) {
        this.item = item;
    }

    public abstract String getDescription();
}
