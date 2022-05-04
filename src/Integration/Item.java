package src.Integration;

//The class item has the items description, identifier and the quantity.

public class Item {
    private ItemDTO itemDescription;
    private String itemIdentifier;
    private int itemQuantity;

    //This is the constructor of the class
    public Item(ItemDTO itemDescription, String itemIdentifier, int itemQuantity) {
        this.itemDescription = itemDescription;
        this.itemIdentifier = itemIdentifier;
        this.itemQuantity = itemQuantity;
    }

    //return item quantity
    public int getItemQuantity() {
        return itemQuantity;
    }

    //return item description
    public ItemDTO getItemDescription() {
        return itemDescription;
    }

    //returns item identifier
    public String getItemIdentifier() {
        return itemIdentifier;
    }

    //increases the item quantity
    public void increaseItemQuantity(int quantityChange){
        this.itemQuantity = this.itemQuantity+quantityChange;
    }

    //decreases the item quantity
    public void decreaseItemQuantity(int quantityChange){
        this.itemQuantity = this.itemQuantity-quantityChange;
    }


    
}
