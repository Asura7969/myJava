package org.myJava.design.pattern.visitor;

public class VisitorB extends VisitorBase{
    @Override
    public void visitElementB(ElementB elmentB) {
        System.out.println(elmentB.getClass().getName() + " 被 " + this.getClass().getName() + " 访问");
    }

}
