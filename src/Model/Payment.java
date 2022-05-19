package src.Model;

import java.util.ArrayList;
import java.util.List;
import src.Integration.TotalRevenueFileOutput;

//this class handles the payment and what change should be returned
public class Payment {
    private double customerPaidAmount;
    private double totalAmount;
    private List<RegisterPaymentObserver> registerPaymentObservers = new ArrayList<>();
    private TotalRevenueFileOutput totalRevenueFileOutput;
    //private double totalpungkula;


    //the constructor of this class
    public Payment(double paidAmount, double total){
        this.customerPaidAmount = paidAmount;
        this.totalAmount = total;
        //this.totalpungkula=0;
    }
    
    //returns paid amount
    public double getPaidAmount() {
        return this.customerPaidAmount;
    }

    //returns the total amount
    public double getTotalAmount() {
        notifyObservers();
        updateTotalRevenueLog();
        return totalAmount;
    }

    //retuns the change amount
    public  double getChangeAmount(){
        //notifyObservers();
        return customerPaidAmount-totalAmount;  
    }
    
    /**
     * Sets the totalamount
     */
    public void setAmount(double totalAmount){
        this.totalAmount=totalAmount;
    }
    
    private void notifyObservers(){
        for (RegisterPaymentObserver obs : registerPaymentObservers) {
            obs.updateTotal(totalAmount);
        }
    }
    
    /**
     * Registers observer that will be notified of changes in customer payments
     */
    public void addPaymentObservers(List<RegisterPaymentObserver> observers) {
        registerPaymentObservers.addAll(observers);
    }  

    /**
     * Sets the totalRevenuefile
     */
    public void setTotalRevenueFileOutput(TotalRevenueFileOutput totalRevenueFileOutput) {  //
        this.totalRevenueFileOutput = totalRevenueFileOutput;
    }

    /**
     * updates the totalRevenue File with the total amount
     */
    private void updateTotalRevenueLog(){   //
        totalRevenueFileOutput.updateTotal(totalAmount);
    }

    /**
     *updates the total amount
     */
    void updateTotal(double total){
        this.totalAmount=total;
    }
    

}
