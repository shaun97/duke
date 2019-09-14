package Exceptions;

/**
 * This class is an exception for an invalid event
 */

public class InvalidEventException extends Exception {

    /**
     * This function prints an error message for this exception
     *
     * @return a string of the error message
     */
    public String toString() {
        return "    \u2639 OOPS!! The description of a event cannot be empty.";
    }
}
