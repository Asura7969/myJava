package org.myJava.design.pattern.chain.use;

import org.myJava.design.pattern.chain.AbstractLogger;
import org.myJava.design.pattern.chain.ConsoleLogger;
import org.myJava.design.pattern.chain.ErrorLogger;
import org.myJava.design.pattern.chain.InfoLogger;

public class Client {

    private static AbstractLogger getChainOfLoggers(){
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger infoLogger = new InfoLogger(AbstractLogger.INFO);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.DEBUG);

        errorLogger.setNextLogger(infoLogger);
        infoLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger chainOfLoggers = getChainOfLoggers();
        chainOfLoggers.logMessage(AbstractLogger.INFO, "this is an information");
        chainOfLoggers.logMessage(AbstractLogger.DEBUG, "this is an debug level information");
        chainOfLoggers.logMessage(AbstractLogger.ERROR, "this is an error level information");
    }
}
