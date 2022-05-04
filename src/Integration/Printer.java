package Integration;
import Model.Receipt;

//The printer class has only two functions, the first one is to create a printer and the second 
//one is to receive a receipt and print it using an .tostring function.
public class Printer {
    public Printer(){}

    //The printer has only one method which prints the receipt.
    public void printTheReceipt(Receipt receipt){
        String receiptToBePrinted = receipt.completeReceipt();
        System.out.println(receiptToBePrinted);
    }
}
