package org.myJava.design.pattern.strategy;

public class BluePen implements Strategy{

    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("用蓝色画笔画图, radius:" + radius + ", x:" + x + ", y:" + y);
    }
}
