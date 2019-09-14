package Exceptions;

/**
 * This class is an exception of an invalid to-do task
 */
public class InvalidToDoException extends Exception {

    /**
     * This function returns a string of the error message
     *
     * @return a string of the error
     */
    public String toString() {
        return "    \u2639 OOPS!! The description of a todo cannot be empty.";
    }
}
