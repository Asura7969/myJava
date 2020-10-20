package org.myJava.design.pattern.singleton;

public class SingletonHolder {

    private static class InnerSingletonHolder{
        private static final SingletonHolder singletonHolder = new SingletonHolder();
    }

    private static SingletonHolder newInstance(){
        return InnerSingletonHolder.singletonHolder;
    }

    private SingletonHolder() {
    }
}
