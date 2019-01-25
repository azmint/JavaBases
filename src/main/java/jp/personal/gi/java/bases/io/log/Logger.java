package jp.personal.gi.java.bases.io.log;

public interface Logger {
    void addLine(LogLevel level, String message);

    void addLine(LogLevel level, Throwable cause);

    void addLine(LogLevel level, String message, Throwable cause);
}
