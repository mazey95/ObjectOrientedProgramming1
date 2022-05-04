package Integration;
import java.util.HashMap;

//This class is responsible for keeping track off the the ID of the customers and the discount they are entitled to.
public class DiscountRegistry {
    private HashMap<String, Double> storedDiscounts = new HashMap<>(); //Create hashmap to store ID's and discount.
    private final double STANDARD_PRICE = 1.0; //The discount rate which equals original price if they are not in the database

    public DiscountRegistry(){ 
        storedDiscounts.put(new String("1234567890"),0.1);  //Customerdata 1
        storedDiscounts.put(new String("0987654321"),0.2);  //Customerdata 2
        storedDiscounts.put(new String("1325476980"),0.3);  //Customerdata 3
    }   

    //Method checks if the customer is in the database and if they are the method returns their discount rate.
    //If they are not in the discountdatabase the standard rate which will give original price is returned by the method.
    public double checkIfDiscountAvailable(String ID){   
        if (storedDiscounts.containsKey(ID)){   
            return storedDiscounts.get(ID).doubleValue();   
        }   
        return STANDARD_PRICE;  //Returns the number 1.0 which doesnt change the price
    }   
}   