package org.myJava.design.pattern.singleton;

public class SingletonDoubleCheck {

    private volatile static SingletonDoubleCheck single = null;

    private SingletonDoubleCheck() {
    }

    private static SingletonDoubleCheck newSingle(){
        if(single == null){
            synchronized (SingletonDoubleCheck.class){
                if(single == null){
                    single = new SingletonDoubleCheck();
                    return single;
                }
            }
        }
        return single;
    }
}
