package sptech.school.exception;

public class VacinaNaoEncontradaException extends RuntimeException {

    public VacinaNaoEncontradaException() {
    }

    public VacinaNaoEncontradaException(String message) {
        super(message);
    }

    public VacinaNaoEncontradaException(String message, Throwable cause) {
        super(message, cause);
    }

    public VacinaNaoEncontradaException(Throwable cause) {
        super(cause);
    }

    public VacinaNaoEncontradaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
