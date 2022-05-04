package Model;

//this class handles the payment and what change should be returned
public class Payment {
    private double customerPaidAmount;
    private double totalAmount;

    //the constructor of this class
    public Payment(double paidAmount, double total){
        this.customerPaidAmount = paidAmount;
        this.totalAmount = total;
    }

    //returns paid amount
    public double getPaidAmount() {
        return this.customerPaidAmount;
    }

    //returns the total amount
    public double getTotalAmount() {
        return totalAmount;
    }

    //retuns the change amount
    public  double getChangeAmount(){
        return customerPaidAmount-totalAmount;  
    }
    
}
