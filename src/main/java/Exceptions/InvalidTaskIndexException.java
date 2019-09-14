package Exceptions;

/**
 * This class is an excepton for an invalid task
 */
public class InvalidTaskIndexException extends Exception {

    /**
     * This function returns an error message
     *
     * @return a string of the error message
     */
    public String toString() {
        return "    \u2639 OOPS!! Please specify what you did.";
    }
}
