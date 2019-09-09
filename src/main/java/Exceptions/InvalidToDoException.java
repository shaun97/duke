package Exceptions;

public class InvalidToDoException extends Exception {

    public String toString() {
        return "    \u2639 OOPS!! The description of a todo cannot be empty.";
    }
}
