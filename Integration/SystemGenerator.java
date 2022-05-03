package Integration;

//This class is used to create the external accountingsystem and inventorysystem.
//It has methods used to return the sytems

public class SystemGenerator {
    private ExternalAccountingSystem externalAccountingSystem;
    private ExternalInventorySystem externalInventorySystem;

    //The constructor, creates the external systems
    public SystemGenerator(){
        externalAccountingSystem = new ExternalAccountingSystem();
        externalInventorySystem = new ExternalInventorySystem();
    }

    //returns the externalinventorysystem
    public ExternalInventorySystem getInventorySystem() {
        return externalInventorySystem;
    }

    //returns the externalaccountingsystem
    public ExternalAccountingSystem getAccountingSystem() {
        return externalAccountingSystem;
    }
}
