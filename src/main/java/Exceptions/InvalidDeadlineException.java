package Exceptions;

/**
 * This class is an exception for Invalid Deadline
 */
public class InvalidDeadlineException extends Exception {

    /**
     * This function returns an error message
     *
     * @return the error message to be printed
     */
    public String toString() {
        return "    \u2639 OOPS!! The description of a deadline cannot be empty.";
    }
}
