package org.myJava.design.pattern.visitor;

public class VisitorA extends VisitorBase{
    @Override
    public void visitElementA(ElementA elmentA) {
        System.out.println(elmentA.getClass().getName() + " 被 " + this.getClass().getName() + " 访问");
    }
}
