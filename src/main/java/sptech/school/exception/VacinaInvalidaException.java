package sptech.school.exception;

public class VacinaInvalidaException extends RuntimeException {

    public VacinaInvalidaException() {
    }

    public VacinaInvalidaException(String message) {
        super(message);
    }

    public VacinaInvalidaException(String message, Throwable cause) {
        super(message, cause);
    }

    public VacinaInvalidaException(Throwable cause) {
        super(cause);
    }

    public VacinaInvalidaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
