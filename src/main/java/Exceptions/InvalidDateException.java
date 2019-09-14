package Exceptions;

/**
 * This class is an exception for invalid date
 */
public class InvalidDateException extends Exception {

    /**
     * This function returns an error message
     *
     * @return a string of the message to be printed
     */
    public String toString() {
        return "     \u2639 OOPS!! Please enter a valid date";
    }
}
