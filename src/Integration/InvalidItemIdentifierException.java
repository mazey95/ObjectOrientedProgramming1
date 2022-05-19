package src.Integration;

public class InvalidItemIdentifierException extends Exception {
    String itemIdentifier;

    /**
     * 
     * @param itemIdentifier is received when this exception is thrown and a message is returned
     */
    public InvalidItemIdentifierException(String itemIdentifier){
        super("The itemidentifier: " + itemIdentifier + ", is not valid.");
        this.itemIdentifier = itemIdentifier;
    }

    /**
     * @return @param itemIdentifier that was invalid
     */
    public String retrieveInvalidItemIdentifier(){
        return itemIdentifier;
    }
}
