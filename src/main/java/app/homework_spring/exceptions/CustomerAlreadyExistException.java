package app.homework_spring.exceptions;

public class CustomerAlreadyExistException extends Exception {
    public CustomerAlreadyExistException(String message) {
        super(message);
    }

    public CustomerAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerAlreadyExistException() {
        super("Customer with this name already exist");
    }

    public CustomerAlreadyExistException(Throwable cause) {
        super(cause);
    }

    protected CustomerAlreadyExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
