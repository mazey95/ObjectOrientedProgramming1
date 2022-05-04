package src.Integration;
import src.Model.Sale;
import java.time.LocalDateTime;
import java.util.HashMap;

//The external accountingsystem doesnt log much except for storing the sale and date and time.

public class ExternalAccountingSystem {
    private HashMap<LocalDateTime, Sale> accountingLogs = new HashMap<>(); //New hashmap

    //Updates the accountsystem with a sale and the date and time
    public void updateAccounting(Sale sale){
        LocalDateTime saleDateTime = LocalDateTime.now();  //Retrieves time and date
        accountingLogs.put(saleDateTime, sale); //Stores into logs
    }
}
