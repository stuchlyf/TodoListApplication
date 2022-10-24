package de.stuchlyf.todolist.simple.simpletodolistapplication.exception;

public class DataNotFoundException extends IllegalStateException {
    public DataNotFoundException() {
    }

    public DataNotFoundException(String s) {
        super(s);
    }

    public DataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataNotFoundException(Throwable cause) {
        super(cause);
    }
}
