package src.Util;

/**
 * Program that handles and prints the error to the console. 
 */
public class ConsoleLogger extends Logger {
    private static final ConsoleLogger CONSOLE_LOG_HANDLER = new ConsoleLogger();

    private ConsoleLogger(){ }

    /**
     * Gets the instance of <code>ConsoleLogger</code>
     * @return The <code>ConsoleLogger</code>
     */
    public static ConsoleLogger getLogHandler() {
        return CONSOLE_LOG_HANDLER;
    }

    /**
     * Prints the exceptions to the console.
     */
    @Override
    public void displayExceptionLog(Exception exc) {
        StringBuilder builder = new StringBuilder();
        builder.append("************ LOGS *************");
        builder.append("\n");
        builder.append("An exception was thrown: ");
        builder.append(exc.getMessage());
        builder.append("\n");
        System.out.println(builder.toString());
        exc.printStackTrace(System.out);
        System.out.println("******************************");
    }
}