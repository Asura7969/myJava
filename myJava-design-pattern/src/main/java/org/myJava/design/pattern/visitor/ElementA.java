package org.myJava.design.pattern.visitor;

public class ElementA extends Element{
    @Override
    public void accept(Visitor visitor) {
        visitor.visitElementA(this);
    }
}
