package src.Integration;

/**
 * Throws this exception when database is down. Returns the message.
 */

public class ItemRegistryException extends RuntimeException {
    public ItemRegistryException(String message){
        super(message);
    }
}
