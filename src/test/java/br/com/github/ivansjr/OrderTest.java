package br.com.github.ivansjr;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {

    @Test
    public void testAddItemInOrder() {
        Order order = new Order();
        Item item = new Item("TestItem", 10.5);
        order.addItem(item);

        List<Item> items = order.getItems();
        assertEquals(1, items.size());
        assertEquals(item, items.get(0));
    }

    @Test
    public void testCalculateTotalItemsInOrder() {
        Order order = new Order();
        order.addItem(new Item("Item1", 5.5));
        order.addItem(new Item("Item2", 4.5));

        double total = order.calculateTotal();
        assertEquals(10, total);
    }

}
