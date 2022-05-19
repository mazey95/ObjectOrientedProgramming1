package src.Integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ItemRegistryExceptionTest {
    private ItemRegistry itemRegistry = new ItemRegistry();

    /**
     * Creates a new itemregistry after every run.
     */
    @AfterEach
    void cleanup(){
        itemRegistry = new ItemRegistry();
    }

    /**
     * Tests if an ItemRegistryException is thrown when expected. In this case when a hardcoded itemIdentifier is sent
     */
    @Test
    void testInventoryDataShouldThrowServerDownException(){
        int quantity = 5;
        String itemDatabaseDown = "Pringles";

        RuntimeException databaseDown = assertThrows(RuntimeException.class, () -> itemRegistry.getItem(itemDatabaseDown, quantity));

        assertEquals(databaseDown.getMessage(),"Database is unreachable at the moment");
    }
    
    /**
     * Tests if an ItemRegistryException is not thrown when a valid itemidentifier is used.
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
