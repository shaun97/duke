package Exceptions;

/**
 * Is an exception class for invalid commands
 */
public class InvalidCommandException extends Exception {

    /**
     * This function returns an error message
     *
     * @return a string of the message
     */
    public String toString() {
        return "    \u2639 OOPS!! I'm sorry, but I don't know what that means :-(";
    }
}
