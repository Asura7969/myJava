package org.myJava.design.pattern.visitor;

public class ElementB extends Element{
    @Override
    public void accept(Visitor visitor) {
        visitor.visitElementB(this);
    }
}