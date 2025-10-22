package sptech.school.exception;

public class ArgumentoInvalidoException extends RuntimeException {

    public ArgumentoInvalidoException() {
    }

    public ArgumentoInvalidoException(String message) {
        super(message);
    }

    public ArgumentoInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArgumentoInvalidoException(Throwable cause) {
        super(cause);
    }

    public ArgumentoInvalidoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
