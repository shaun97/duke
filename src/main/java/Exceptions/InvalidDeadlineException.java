package Exceptions;

public class InvalidDeadlineException extends Exception {

    public String toString() {
        return "    \u2639 OOPS!! The description of a deadline cannot be empty.";
    }
}
