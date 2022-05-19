package src.View;
import src.Controller.Controller;
import src.Integration.InvalidItemIdentifierException;
import src.Integration.ItemRegistryException;
import src.Util.ConsoleLogger;
import src.Util.Logger;


//The vie wis the class that interacts with the controller, a dummy hard coded program is used.
public class View {
    private Controller controller;
    private ErrorMessageHandler errorMessageHandler = ErrorMessageHandler.getErrorMessageHandler();
    private Logger logger = ConsoleLogger.getLogHandler();

    //The constructor
    public View (Controller controller){
        this.controller=controller;
        controller.addRegisterPaymentObserver(new TotalRevenueView());
        
    }

    /**SAMPLE TEST PROGRAM which interacts with the controller and prints what it is doing*/
    public void dummySale() throws InvalidItemIdentifierException, ItemRegistryException{
        
        /**Hardcoded sale number 1 */
        System.out.println("Cashier initiates a sale\n");
        controller.makeNewSale();
        System.out.println("Cashier scans items \n");
        
        /**
         * Every time we scan we try to catch exceptions related to database and itemidentifier. This is similar for the other scans.
         */
        try {
        System.out.println(controller.scanItem("Pringles", 1));
            }catch (InvalidItemIdentifierException exc) {
                exceptionHandler(" Please try again, item did not exist in item registry.", exc);
            }
            catch (ItemRegistryException exc) {
                exceptionHandler(" Operation Failed because database is down.", exc);
            }

        
        try {
        System.out.println(controller.scanItem("Pringless", 5));
            }catch (InvalidItemIdentifierException exc) {
                exceptionHandler(" Please try again, item did not exist in item registry. ", exc);
            }
            catch (ItemRegistryException exc) {
                exceptionHandler(" Operation Failed because database is down.", exc);
            }

        try {
            System.out.println(controller.scanItem("Doritos", 5));
                }catch (InvalidItemIdentifierException exc) {
                    exceptionHandler(" Please try again, item did not exist in item registry. ", exc);
                }
                catch (ItemRegistryException exc) {
                    exceptionHandler(" Operation Failed because database is down.", exc);
                }
    
        try {
            System.out.println(controller.scanItem("Toiletpaper", 5));
                }catch (InvalidItemIdentifierException exc) {
                    exceptionHandler(" Please try again, item did not exist in item registry. ", exc);
                }
                catch (ItemRegistryException exc) {
                    exceptionHandler(" Operation Failed because database is down.", exc);
                }

        try {
            System.out.println(controller.scanItem("Gum", 5));
                }catch (InvalidItemIdentifierException exc) {
                    exceptionHandler(" Please try again, item did not exist in item registry. ", exc);
                }
                catch (ItemRegistryException exc) {
                    exceptionHandler(" Operation Failed because database is down.", exc);
                }
        
        System.out.println("\nCustomer asks for discount.\n");
        controller.discountChecker("1234567890");
        System.out.println("\nCashier shows the total amount including tax \n");
        System.out.println(controller.displayTotalWithTax());
        System.out.println("Cashier registers the amount paid by customer \n");
        System.out.println(controller.makePayment(2000));

        

        /**Hardcoded sale number 2 */
        System.out.println("Cashier initiates a sale\n");
        controller.makeNewSale();
        System.out.println("Cashier scans items \n");
        
        try {
        System.out.println(controller.scanItem("Doritos", 1));
            }catch (InvalidItemIdentifierException exc) {
                exceptionHandler(" Please try again, item did not exist in item registry.", exc);
            }
            catch (ItemRegistryException exc) {
                exceptionHandler(" Operation Failed because database is down.", exc);
            }

        
        try {
        System.out.println(controller.scanItem("Doritos", 5));
            }catch (InvalidItemIdentifierException exc) {
                exceptionHandler(" Please try again, item did not exist in item registry.", exc);
            }
            catch (ItemRegistryException exc) {
                exceptionHandler(" Operation Failed because database is down.", exc);
            }

        try {
            System.out.println(controller.scanItem("Doritos", 5));
                }catch (InvalidItemIdentifierException exc) {
                    exceptionHandler(" Please try again, item did not exist in item registry. ", exc);
                }
                catch (ItemRegistryException exc) {
                    exceptionHandler(" Operation Failed because database is down.", exc);
                }
    
        try {
            System.out.println(controller.scanItem("Toiletpaper", 5));
                }catch (InvalidItemIdentifierException exc) {
                    exceptionHandler(" Please try again, item did not exist in item registry. ", exc);
                }
                catch (ItemRegistryException exc) {
                    exceptionHandler(" Operation Failed because database is down.", exc);
                }

        try {
            System.out.println(controller.scanItem("Gum", 5));
                }catch (InvalidItemIdentifierException exc) {
                    exceptionHandler(" Please try again, item did not exist in item registry. ", exc);
                }
                catch (ItemRegistryException exc) {
                    exceptionHandler(" Operation Failed because database is down.", exc);
                }
        
        System.out.println("\nCustomer asks for discount.\n");
        controller.discountChecker("1234567890");
        System.out.println("\nCashier shows the total amount including tax \n");
        System.out.println(controller.displayTotalWithTax());
        System.out.println("Cashier registers the amount paid by customer \n");
        System.out.println(controller.makePayment(2000));

    }


    private void exceptionHandler(String message, Exception exception){
        errorMessageHandler.displayErrorMessage(message);
        logger.displayExceptionLog(exception);
    }
}

