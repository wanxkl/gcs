//
// Built on Sun Sep 24 04:09:28 CEST 2017 by logback-translator
// For more information on configuration files in Groovy
// please see http://logback.qos.ch/manual/groovy.html

// For assistance related to this tool or configuration files
// in general, please contact the logback user mailing list at
//    http://qos.ch/mailman/listinfo/logback-user

// For professional support please see
//   http://www.qos.ch/shop/products/professionalSupport

import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.classic.filter.LevelFilter
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy
import java.nio.charset.Charset

import static ch.qos.logback.classic.Level.DEBUG
import static ch.qos.logback.classic.Level.ERROR
import static ch.qos.logback.classic.Level.INFO
import static ch.qos.logback.core.spi.FilterReply.ACCEPT
import static ch.qos.logback.core.spi.FilterReply.DENY

scan("60 seconds")
def LOG_HOME = "../logs/gateway/"
appender("CONSOLE", ConsoleAppender) {
  encoder(PatternLayoutEncoder) {
    pattern = "%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} %method - %msg%n"
  }
}
appender("INFO_FILE", RollingFileAppender) {
  file = "${LOG_HOME}/infoFile.log"
  filter(LevelFilter) {
    level = INFO
    onMatch = ACCEPT
    onMismatch = DENY
  }
  rollingPolicy(TimeBasedRollingPolicy) {
    fileNamePattern = "${LOG_HOME}/%d{yyyy-MM-dd}.info.zip"
  }
  encoder(PatternLayoutEncoder) {
    pattern = "%d{yyyy-MM-dd HH:mm:ss.SSS} %msg%n"
    charset = Charset.forName("UTF-8")
  }
}
appender("DEBUG_FILE", RollingFileAppender) {
  file = "${LOG_HOME}/debugFile.log"
  filter(LevelFilter) {
    level = DEBUG
    onMatch = ACCEPT
    onMismatch = DENY
  }
  rollingPolicy(TimeBasedRollingPolicy) {
    fileNamePattern = "${LOG_HOME}/%d{yyyy-MM-dd}.debug.zip"
  }
  encoder(PatternLayoutEncoder) {
    pattern = "%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} %method - %msg%n"
    charset = Charset.forName("UTF-8")
  }
}
appender("ERROR_FILE", RollingFileAppender) {
  file = "${LOG_HOME}/errorFile.log"
  filter(LevelFilter) {
    level = ERROR
    onMatch = ACCEPT
    onMismatch = DENY
  }
  rollingPolicy(TimeBasedRollingPolicy) {
    fileNamePattern = "${LOG_HOME}/%d{yyyy-MM-dd}.error.zip"
  }
  encoder(PatternLayoutEncoder) {
    pattern = "%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} %method - %msg%n"
    charset = Charset.forName("UTF-8")
  }
}
logger("com.learning.gcs", DEBUG, [ "ERROR_FILE", "DEBUG_FILE", "INFO_FILE"])
root(ERROR,["CONSOLE"])