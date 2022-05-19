package src.Controller;
import java.util.ArrayList;
import java.util.List;

import src.Integration.*;
import src.Model.Register;
import src.Model.RegisterPaymentObserver;
import src.Model.Payment;
import src.Model.Receipt;
import src.Model.Sale;



//This is the controller class which starts a lot of systems and also handles the interaction
//From the view to the system
public class Controller {
    private ExternalAccountingSystem externalAccountingSystem;
    private ExternalInventorySystem externalInventorySystem;
    private DiscountRegistry discountRegistry;
    private ItemRegistry itemRegistry;
    private Printer printer;
    private Register register;
    private Sale sale;
    private List<RegisterPaymentObserver> registerPaymentObservers = new ArrayList<>();
    private TotalRevenueFileOutput totalRevenueFileOutput = new TotalRevenueFileOutput();


    //The constructor
    public Controller(Printer printer){
        SystemGenerator systemGenerator = new SystemGenerator();
        CatalogGenerator catalogGenerator = new CatalogGenerator();
        this.discountRegistry = catalogGenerator.getDiscountRegistry();
        this.itemRegistry = catalogGenerator.getItemCatalog();
        this.externalAccountingSystem = systemGenerator.getAccountingSystem();
        this.externalInventorySystem = systemGenerator.getInventorySystem();
        this.printer = printer;
        this.register = new Register();
    }

    //Starts a sale
    public void makeNewSale(){
        this.sale = new Sale();
    }

    /**
     * This method scan item and in the same process checks if its valid before updating the other methods such as the sale.
     * @param itemIdentifier is checked if it is valid
     * @throws ItemRegistryException if item registry is unavailable, in this case it is when it is a hardcoded itemidentifier
     * @throws InvalidItemIdentifierException if the itemidentifier is not in the itemregistry
     */
    public String scanItem(String itemIdentifier, int itemQuantity) 
    throws ItemRegistryException, InvalidItemIdentifierException{
            if (itemRegistry.checkForItem(itemIdentifier)){
                Item item = itemRegistry.getItem(itemIdentifier, itemQuantity);
                return sale.updateSale(item) + ", quantity: " + itemQuantity +
                    "\nRunning total: " + showTotal();
            }
        return "\nRunning total: " + showTotal();
    }

    //Show the total amount including tax
    public String displayTotalWithTax(){        
        return "Total amount including taxes: " + sale.getTotal();
    }

    //Checks if customer has discount and then applies it
    public void discountChecker(String customerID){     
        double discountRate = this.discountRegistry.checkIfDiscountAvailable(customerID);
        if (discountRate<1){
            sale.totalWithDiscount(discountRate);
        }
    }

    //Shows the total amount
    private double showTotal(){
        return sale.getTotal();
    }

    //Makes the payment and ends sale
    public String makePayment(double paidAmount){
        Payment payment = new Payment(paidAmount, sale.getTotal());
        //System.out.println("dachri");
        payment.addPaymentObservers(registerPaymentObservers);
        payment.setTotalRevenueFileOutput(totalRevenueFileOutput);  //
        register.updateRegisterBalance(payment);
        externalAccountingSystem.updateAccounting(sale);
        externalInventorySystem.changeInventoryLog(sale);
        Receipt receipt = new Receipt(sale, payment);
        printer.printTheReceipt(receipt);
        sale = null;
        //System.out.println("\n\ndachri");
        return "\n***Display to cashier*** \nChange: " + payment.getChangeAmount();
    }

    public void addRegisterPaymentObserver(RegisterPaymentObserver registerPaymentObserver){
        registerPaymentObservers.add(registerPaymentObserver);
    }
}
