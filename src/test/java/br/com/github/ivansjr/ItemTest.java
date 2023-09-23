package br.com.github.ivansjr;

import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;

class ItemTest {

    @Test
    public void testItemCreation() {
        Item item = new Item("TestItem", 10.5);
        assertEquals("TestItem", item.getName());
        assertEquals(10.5, item.getPrice());
    }

}
