package org.myJava.design.pattern.strategy;

public class GreenPen implements Strategy{

    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("用绿色画笔画图, radius:" + radius + ", x:" + x + ", y:" + y);
    }
}
