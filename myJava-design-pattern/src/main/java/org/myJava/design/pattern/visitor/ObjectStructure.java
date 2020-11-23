package org.myJava.design.pattern.visitor;

import java.util.LinkedList;
import java.util.List;

public class ObjectStructure {

    private List<Element> elements = new LinkedList<>();

    public void attach(Element element){
        elements.add(element);
    }

    public void detach(Element element) {
        elements.remove(element);
    }

    public void accept(Visitor visitor){
        elements.forEach(element -> element.accept(visitor));
    }
}
