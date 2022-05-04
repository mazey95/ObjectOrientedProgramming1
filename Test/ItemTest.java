package Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import Integration.Item;
import Integration.ItemDTO;


public class ItemTest {
    @BeforeEach
    void setup() {}

    @AfterEach
    void tearDown() {}

    //Test getItemQuantity
    @Test
    void getItemQuantityTest() {
        Item one = new Item(new ItemDTO(20, "Potato", 10), "Potato", 3);
        int expected = 3;
        int actual = one.getItemQuantity();
        assertEquals(expected, actual, "GetValue fails!");
    }

    
    //Test getItemIdentifier
    @Test
    void getItemIdentifier() {
        Item one = new Item(new ItemDTO(20, "Potato", 10), "Potato", 10);
        String expected = "Potato";
        String actual = one.getItemIdentifier();
        assertEquals(expected, actual, "GetValue fails!");
    }

    //Test increaseItemQuantity
    @Test
    void increaseItemQuantityTest() {
        Item one = new Item(new ItemDTO(20, "Potato", 10), "Potato", 10);
        int expected = 15;
        one.increaseItemQuantity(5);
        int actual = one.getItemQuantity();
        assertEquals(expected, actual, "increaseItemQuantity fails!");
    }

    //Test decreaseItemQuantity
    @Test
    void decreaseItemQuantityTest() {
        Item one = new Item(new ItemDTO(20, "Potato", 10), "Potato", 10);
        int expected = 5;
        one.decreaseItemQuantity(5);
        int actual = one.getItemQuantity();
        assertEquals(expected, actual, "decreaseItemQuantity fails!");
    }
    
    //Test get itemDescription    
    @Test
    void getItemDesriptionTest() {
        Item one = new Item(new ItemDTO(20, "Potato", 10), "Potato", 3);
        ItemDTO expected = new ItemDTO(20, "Potato", 10);
        ItemDTO actual = one.getItemDescription();
        assertEquals(expected, actual, "GetValue fails!");
    }

}