package org.myJava.design.pattern.observer.use;

import org.myJava.design.pattern.observer.BinaryObserver;
import org.myJava.design.pattern.observer.HexaObserver;
import org.myJava.design.pattern.observer.Subject;

/**
 * https://juejin.im/post/5bc96afff265da0aa94a4493#heading-22
 */
public class Client {

    public static void main(String[] args) {
        Subject subject = new Subject();
        // 定义观察者
        new BinaryObserver(subject);
        new HexaObserver(subject);

        // 模拟数据变更，这个时候，观察者们的 update 方法将会被调用
        subject.setState(11);
    }
}
