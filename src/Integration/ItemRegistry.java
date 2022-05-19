package src.Integration;
import java.util.HashMap;

//The is a dummy item database
public class ItemRegistry {
    private HashMap<String, ItemDTO> itemBasket = new HashMap<>();

    //The constructor when called also created the items in the database, storing them in the hashmap.
    ItemRegistry(){
        itemBasket.put("Pringles", new ItemDTO(20, "Pringles", 10));
        itemBasket.put("Doritos", new ItemDTO(30, "Doritos", 15));
        itemBasket.put("Toiletpaper", new ItemDTO(42, "Toiletpaper", 20));
        itemBasket.put("Gum", new ItemDTO(5, "Gum", 2));
    }

    //Checks if item exists in database
    public boolean checkForItem(String itemIdentifier)
    throws InvalidItemIdentifierException
    {
        if(!itemBasket.containsKey(itemIdentifier)){
            throw new InvalidItemIdentifierException(itemIdentifier);           
        };
        return itemBasket.containsKey(itemIdentifier);
    }

    //gets the items information
    public Item getItem(String itemIdentifier, int quantity) 
    throws InvalidItemIdentifierException
    {
        if (!checkForItem(itemIdentifier)){
            throw new InvalidItemIdentifierException(itemIdentifier);
        }

        if (itemIdentifier.equals("Pringles")){
            throw new ItemRegistryException("Database is unreachable at the moment");
        }

        return new Item(itemBasket.get(itemIdentifier), itemIdentifier, quantity);
    }

}
