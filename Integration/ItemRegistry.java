package Integration;
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
    public boolean checkForItem(String itemIdentifier){
        return itemBasket.containsKey(itemIdentifier);
    }

    //gets the items information
    public Item getItem(String itemIdentifier, int quantity){
        if (checkForItem(itemIdentifier)){
            return new Item(itemBasket.get(itemIdentifier), itemIdentifier, quantity);
        }
        return null;
    }

}
