package br.com.github.ivansjr;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Item> items = new ArrayList<>();
    public void addItem(Item item) {
        items.add(item);
    }
    public double calculateTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }
    public List<Item> getItems() {
        return items;
    }
}
