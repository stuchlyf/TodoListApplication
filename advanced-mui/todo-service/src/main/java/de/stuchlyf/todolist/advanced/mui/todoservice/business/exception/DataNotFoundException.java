package de.stuchlyf.todolist.advanced.mui.todoservice.business.exception;

import de.stuchlyf.todolist.advanced.mui.todoservice.exception.TodoServiceException;

public class DataNotFoundException extends TodoServiceException {

    public DataNotFoundException() {
    }

    public DataNotFoundException(String message) {
        super(message);
    }

    public DataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataNotFoundException(Throwable cause) {
        super(cause);
    }

    public DataNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
