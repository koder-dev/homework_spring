package app.homework_spring.exceptions;

public class DishAlreadyExistException extends Exception {
    public DishAlreadyExistException() {
        super("Dish already exists");
    }

    public DishAlreadyExistException(String message) {
        super(message);
    }

    public DishAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public DishAlreadyExistException(Throwable cause) {
        super(cause);
    }

    protected DishAlreadyExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
