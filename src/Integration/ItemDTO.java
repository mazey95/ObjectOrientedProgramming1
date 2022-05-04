package src.Integration;


public class ItemDTO {
    private final double itemPrice;
    private final String itemName;
    private final double itemTaxAmount;

    //The class itemDTO has the price, name and taxamount.

    public ItemDTO(double itemPrice, String itemName, double itemTaxAmount){
        this.itemPrice = itemPrice;
        this.itemName = itemName;
        this.itemTaxAmount = itemTaxAmount;
    }


    public String getItemName() {       //Retrieves name of the item
        return itemName;
    }

    public double getTaxAmount() {      //Retrieves taxamount of the item
        return itemTaxAmount;
    }

    public double getPrice() {          //Retrieves price of the item
        return itemPrice;
    }

    public String toString() {          //A toString function that just returns the itemnName
        return this.itemName;
    }


    
   @Override
    public boolean equals(Object obj){
        if (obj instanceof ItemDTO){
            //ItemDTO item = (ItemDTO)obj;
            return this.itemName.equals(((ItemDTO) obj).getItemName()) && this.itemPrice==((ItemDTO) obj).getPrice() && this.itemTaxAmount==((ItemDTO) obj).getTaxAmount();
        }
        return false;
    }   
    
    //obj.itemName.equals(this.itemName) && obj.itemTaxAmount==this.itemTaxAmount && obj.itemPrice==this.itemPrice


}
