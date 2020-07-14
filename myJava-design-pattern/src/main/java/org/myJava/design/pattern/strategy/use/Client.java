package org.myJava.design.pattern.strategy.use;

import org.myJava.design.pattern.strategy.BluePen;
import org.myJava.design.pattern.strategy.Context;

public class Client {

    public static void main(String[] args) {
        Context context = new Context(new BluePen());
        context.executeDraw(10, 0, 0);
    }
}
