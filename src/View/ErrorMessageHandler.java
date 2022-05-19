package src.View;


/**
 * Takes care of the error messages for the user interface.
 */
public class ErrorMessageHandler {
    private static final ErrorMessageHandler ERROR_MESSAGE_HANDLER = new ErrorMessageHandler();
    private final String NEW_LINE = "\n";

    private ErrorMessageHandler(){}

    /**
     * Gets  instance of <code>ErrorMessageHandler</code>
     * @return
     */
    public static ErrorMessageHandler getErrorMessageHandler(){
        return ERROR_MESSAGE_HANDLER;
    }

    /**
     * Prints the error and message to the user interface.
     * @param msg the message that will be printed out.
     */
    void displayErrorMessage(String msg) {
        StringBuilder builder = new StringBuilder();
        builder.append("**** NOTIFICATION REGISTRY TO CASHIER ****");
        builder.append(NEW_LINE);
        builder.append("ERROR: ");
        builder.append(msg);
        builder.append(NEW_LINE);
        builder.append("**************************************");
        builder.append(NEW_LINE);
        System.out.println(builder.toString());
    }


}