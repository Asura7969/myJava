package org.myJava.design.pattern.chain;

public class InfoLogger extends AbstractLogger{
    public InfoLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Info Console::Logger:" + message);
    }
}
