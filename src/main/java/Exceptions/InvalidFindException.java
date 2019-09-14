package Exceptions;

/**
 * This class is an exception for an invalid find command
 */
public class InvalidFindException extends Exception {

    /**
     * This function returns an error message
     *
     * @return returns a string of the error message
     */
    public String toString() {
        return "    \u2639 OOPS!! Please specify what you want to find.";
    }
}
