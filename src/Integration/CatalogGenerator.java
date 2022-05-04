package Integration;

//Catalaloggenerator is used to create the itemcatalaog and the dicountregistry
//There are also methods to retrieve the item registry and discountregistry

public class CatalogGenerator {
    private DiscountRegistry discountRegistry;
    private ItemRegistry itemRegistry;

    //When the constructor is called it created a discountregistry and an itemregistry
    public CatalogGenerator(){
        discountRegistry = new DiscountRegistry();
        itemRegistry = new ItemRegistry();
    }

    //return the itemregistry
    public ItemRegistry getItemCatalog() {
        return itemRegistry;
    }
    
    //returns the discount registry
    public DiscountRegistry getDiscountRegistry() {
        return discountRegistry;
    }

}
