package Model;
import Integration.Item;
import java.util.HashMap;


public class Sale {
    private double total;
    private double amountOfTaxTotal;
    private int itemAmount;
    private HashMap<String, Item> items = new HashMap<>();

    //The constructor
    public Sale(){
        this.total = 0;
    }

    //Updates the total
    public void updateTotal(double uTotal){
        this.total = this.total+uTotal;
    }

    //Returns the total
    public double getTotal() {
        return total;
    }

    //updats the total amount of tax
    public void updateamountOfTaxTotal(double uamountOfTaxTotal){
        this.amountOfTaxTotal = this.amountOfTaxTotal+uamountOfTaxTotal;
    }

    //returns the total amount of tax
    public double getamountOfTaxTotal() {
        return amountOfTaxTotal;
    }

    //updats the amount
    public void updateItemAmount(int uItemAmount){
        this.itemAmount = this.itemAmount+uItemAmount;
    }

    //returns the amount
    public double getitemAmount() {
        return itemAmount;
    }

    //Changes the total and the the total amount of tax using the discount rate
    public void totalWithDiscount(double discount){
        this.total=this.total*(1-discount);
        this.amountOfTaxTotal=this.amountOfTaxTotal*(1-discount);
    }

    //returns the items in the hashmap
    public HashMap<String, Item> getItems(){
        return items;
    }

    //Handles the items in the sale. Increases amount if it exists.
    //Updates total and the total amount of tax. Also returns the name of the item when called.
    public String updateSale(Item item){
        if (items.containsKey(item.getItemIdentifier())) { 
            items.get(item.getItemIdentifier()).increaseItemQuantity(item.getItemQuantity());
        } else {
            items.put(item.getItemIdentifier(), item);
        }

        this.amountOfTaxTotal = this.amountOfTaxTotal+(item.getItemQuantity()*item.getItemDescription().getTaxAmount());
        this.total = this.total+(item.getItemQuantity()*item.getItemDescription().getPrice());

        return item.getItemDescription().toString();
    }
}
