package org.myJava.design.pattern.visitor.use;

import org.myJava.design.pattern.visitor.*;

public class Client {

    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();

        objectStructure.attach(new ElementA());
        objectStructure.attach(new ElementB());

        VisitorA visitorA = new VisitorA();
        VisitorB visitorB = new VisitorB();
        objectStructure.accept(visitorA);
        objectStructure.accept(visitorB);

    }
}
