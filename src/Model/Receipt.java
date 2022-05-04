package src.Model;

//This class creates the receipt that the printer will print using information from payment and sale
public class Receipt {
    private Sale sale;
    private Payment payment;

    //The constructor
    public Receipt(Sale sale, Payment payment){
        this.sale = sale;
        this.payment = payment;
    }

    //The string that should be printed by the printer
    public String completeReceipt() {
        return "Thank you for shopping at ShopMart, please keep this receipt." + 
        "\nTotal: " + sale.getTotal() + "\nAmount of tax: " + sale.getamountOfTaxTotal()+ 
        "\nPaid Amount: "+ payment.getPaidAmount() + "\nChange back: " + payment.getChangeAmount(); 
    }
    
}
