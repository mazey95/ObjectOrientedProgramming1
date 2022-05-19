package src.Integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;

public class InvalidItemIdentifierExceptionTest {
    private ItemRegistry itemRegistry = new ItemRegistry();
    
    /**
     * Creates a new @param itemRegistry after each run.
     */
    @AfterEach
    void cleanup(){
        itemRegistry = new ItemRegistry();
    }

    /**
     * Send in an invalid itemIdentifier and expects an exception to be thrown
     */
    @Test
    public void testInventoryShouldThrowInvalidItemIdentifier(){
        int quantity = 5;
        String invalidIdentifierString = "LaLaLa";

        Exception databaseDown = assertThrows(Exception.class, () -> itemRegistry.getItem(invalidIdentifierString, quantity));

        assertEquals(databaseDown.getMessage(),"Given item identifer: " + invalidIdentifierString + ", doesn't exist.");
    }    

    /**
     * Send in a valid itemIdentifier and expects an exception to not be thrown
     */
    @Test
    public void validItemIdentifier() 
    throws ItemRegistryException, InvalidItemIdentifierException
    {
    int quantity = 5;
    String itemDatabaseDown = "Doritos";
    try {
        itemRegistry.getItem(itemDatabaseDown, quantity);
        } catch(ItemRegistryException e){}
        catch(InvalidItemIdentifierException exc){};
        assertAll(() -> itemRegistry.getItem(itemDatabaseDown, quantity));
    }
    

}
