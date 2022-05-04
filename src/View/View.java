package src.View;
import src.Controller.Controller;

//The vie wis the class that interacts with the controller, a dummy hard coded program is used.
public class View {
    private Controller controller;

    //The constructor
    public View (Controller controller){
        this.controller=controller;
    }

    //SAMPLE TEST PROGRAM which interacts with the controller and prints what it is doing
    public void dummySale(){
        System.out.println("Cashier initiates a sale\n");
        controller.makeNewSale();
        System.out.println("Cashier scans items \n");
        System.out.println(controller.scanItem("Pringles", 1));
        System.out.println(controller.scanItem("Doritos", 4));
        System.out.println(controller.scanItem("Pringles", 5));
        System.out.println(controller.scanItem("Toiletpaper", 20));
        System.out.println(controller.scanItem("Gum", 2));
        System.out.println("\nCustomer asks for discount.\n");
        controller.discountChecker("1234567890");
        System.out.println("\nCashier shows the total amount including tax \n");
        System.out.println(controller.displayTotalWithTax());
        System.out.println("Cashier registers the amount paid by customer \n");
        System.out.println(controller.makePayment(2000));
    }
}

