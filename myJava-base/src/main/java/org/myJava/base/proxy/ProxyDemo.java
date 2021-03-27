package org.myJava.base.proxy;

/**
 * @author asura7969
 * @create 2021-03-27-14:02
 */
public class ProxyDemo {
    public static void main(String[] args) {
        ProxyHandler proxyHandler = new ProxyHandler();
        IGoods IGoods = (IGoods) proxyHandler.newProxyInstance(new GoodsA());
        IGoods.sell();
    }
}
