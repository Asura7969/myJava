package org.myJava.base.proxy;

/**
 * @author asura7969
 * @create 2021-03-27-14:02
 */
public class GoodsA implements IGoods{
    @Override
    public void sell() {
        System.out.println("出售商品A");
    }
}
