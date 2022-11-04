package de.stuchlyf.todolist.advanced.mui.todoservice.exception;

public class TodoServiceException extends RuntimeException {

    public TodoServiceException() {
    }

    public TodoServiceException(String message) {
        super(message);
    }

    public TodoServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public TodoServiceException(Throwable cause) {
        super(cause);
    }

    public TodoServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
