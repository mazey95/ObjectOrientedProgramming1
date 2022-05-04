package src.Integration;
import src.Model.Sale;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

//The external inventory system handles the inventory and the quantity available
public class ExternalInventorySystem {
    private HashMap<String, Item> inventoryLog = new HashMap<>();

    ExternalInventorySystem(){
        inventoryLog.put("Pringles", new Item(new ItemDTO(20, "Pringles", 10), "Pringles", 25));
        inventoryLog.put("Doritos", new Item(new ItemDTO(30, "Doritos", 15), "Doritos", 30));
        inventoryLog.put("Toiletpaper", new Item(new ItemDTO(42, "Toiletpaper", 20), "Toiletpaper", 16));
        inventoryLog.put("Gum", new Item(new ItemDTO(5, "Gum", 2), "Gum", 241));
    }

    //This method changes the inventory in the inventorylog, it retrieves the itemidentifier and decreases the itemquantity
    public void changeInventoryLog(Sale sale){
        HashMap<String, Item> items = sale.getItems();
        Set<Entry<String, Item>> entries = items.entrySet();

        for (Map.Entry<String, Item> set : entries) {
            if(inventoryLog.containsKey(set.getKey())){
                Item updatedItem = inventoryLog.get(set.getValue().getItemIdentifier());
                updatedItem.decreaseItemQuantity(set.getValue().getItemQuantity());
            }
        }
    }  
}