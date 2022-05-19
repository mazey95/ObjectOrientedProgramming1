package src.Integration;

import src.Model.RegisterPaymentObserver;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

public class TotalRevenueFileOutput implements RegisterPaymentObserver {
    private double totalRevenue;
    private PrintWriter printWriter;


    /**
     * Creates the printwriter and generates the file that will hold the purchases.
     */
    public TotalRevenueFileOutput(){
        try{
            printWriter = new PrintWriter(new FileWriter("TotalRevenue.txt"),true);
        } catch (IOException ioException) {
            System.out.println("Was not able to log");
            ioException.printStackTrace();
        }
    }

    /**
     * Updated the @param totalRevenue before printing it to the file.
     */
    @Override
    public void updateTotal(double total) {
        totalRevenue += total;
        printWriter.println("Time of purchase: " + LocalTime.now() +" | Total of all purchases: " + totalRevenue);
    }
}
