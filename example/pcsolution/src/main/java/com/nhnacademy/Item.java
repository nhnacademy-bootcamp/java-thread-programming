package com.nhnacademy;

class Item {
    String name;
    int stock;

    public Item(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }
}
