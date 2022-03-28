package ExceptionsAndLogging;

public class ValidationException extends Exception {
    private final String errorCode;

    public ValidationException(String mesaj, String errorCode) {
        super(mesaj);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
