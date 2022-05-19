package src.View;
import src.Model.RegisterPaymentObserver;

public class TotalRevenueView implements RegisterPaymentObserver{
    private double totalRevenue;

    /**
     * Creates an instance of <code>TotalRevenueView</code>
     */
    public TotalRevenueView(){
        totalRevenue = 0.0;
    }

    /**
     * Updates the total revenue.
     * @param total the total that will be added to this <code>totalRevenue</code>
     */
    @Override
    public void updateTotal(double total) {
        //System.out.println("dachri");
        this.totalRevenue+=total;
        printCurrentRevenue();
    }
    

    private void printCurrentRevenue(){
        System.out.println("\n \n****** DISPLAY ******");
        System.out.println("*** TOTAL REVENUE ***");
        System.out.println("   Amount: " + this.totalRevenue );
        System.out.println("*********************\n");
    }
 }