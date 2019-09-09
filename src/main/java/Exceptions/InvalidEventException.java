package Exceptions;

public class InvalidEventException extends Exception {
    public String toString() {
        return "    \u2639 OOPS!! The description of a event cannot be empty.";
    }
}
