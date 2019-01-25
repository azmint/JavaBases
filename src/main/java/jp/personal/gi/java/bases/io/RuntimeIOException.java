package jp.personal.gi.java.bases.io;

public class RuntimeIOException extends RuntimeException {
    public RuntimeIOException(String message) {
        super(message);
    }

    public RuntimeIOException(String message, Throwable cause) {
        super(message, cause);
    }
}
