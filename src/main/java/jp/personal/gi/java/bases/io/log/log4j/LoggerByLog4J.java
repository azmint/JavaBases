package jp.personal.gi.java.bases.io.log.log4j;

import jp.personal.gi.java.bases.io.log.LogLevel;
import jp.personal.gi.java.bases.io.log.Logger;
import jp.personal.gi.java.bases.io.log.MyLogLevel;
import org.apache.logging.log4j.LogManager;

public class LoggerByLog4J implements Logger {
    private final org.apache.logging.log4j.Logger logger;

    private LoggerByLog4J(org.apache.logging.log4j.Logger logger) {
        this.logger = logger;
    }

    public static LoggerByLog4J create() {
        final org.apache.logging.log4j.Logger logger = LogManager.getLogger();
        return new LoggerByLog4J(logger);
    }

    public void addLine(LogLevel level, String message) {
        if (level == LogLevelOnLog4J.FATAL || level == MyLogLevel.FATAL) {
            this.logger.fatal(message);
        } else if (level == MyLogLevel.WARN || level == LogLevelOnLog4J.WARN) {
            this.logger.warn(message);
        } else if (level == MyLogLevel.ERROR || level == LogLevelOnLog4J.ERROR) {
            this.logger.error(message);
        } else if (level == MyLogLevel.DEBUG || level == LogLevelOnLog4J.DEBUG) {
            this.logger.debug(message);
        } else if (level == MyLogLevel.TRACE || level == LogLevelOnLog4J.TRACE) {
            this.logger.trace(message);
        }
    }

    public void addLine(LogLevel level, Throwable cause) {
        if (level == MyLogLevel.FATAL || level == LogLevelOnLog4J.FATAL) {
            this.logger.fatal(cause);
        } else if (level == MyLogLevel.WARN || level == LogLevelOnLog4J.WARN) {
            this.logger.warn(cause);
        } else if (level == MyLogLevel.ERROR || level == LogLevelOnLog4J.ERROR) {
            this.logger.error(cause);
        } else if (level == MyLogLevel.DEBUG || level == LogLevelOnLog4J.DEBUG) {
            this.logger.debug(cause);
        } else if (level == MyLogLevel.TRACE || level == LogLevelOnLog4J.TRACE) {
            this.logger.trace(cause);
        }
    }

    public void addLine(LogLevel level, String message, Throwable cause) {
        if (level == MyLogLevel.FATAL || level == LogLevelOnLog4J.FATAL) {
            this.logger.fatal(message, cause);
        } else if (level == MyLogLevel.WARN || level == LogLevelOnLog4J.WARN) {
            this.logger.warn(message);
        } else if (level == MyLogLevel.ERROR || level == LogLevelOnLog4J.ERROR) {
            this.logger.error(cause, cause);
        } else if (level == MyLogLevel.DEBUG || level == LogLevelOnLog4J.DEBUG) {
            this.logger.debug(cause, cause);
        } else if (level == MyLogLevel.TRACE || level == LogLevelOnLog4J.TRACE) {
            this.logger.trace(cause, cause);
        }
    }
}
