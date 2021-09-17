package org.myJava.design.pattern.publish;

/**
 * @author gongwenzhou@hellobike.com
 * @Date 2021/8/25 6:06 下午
 * @Describe TODO
 */
public class Demo {
    public static void main(String[] args) {


        IPublisher musciPublisher = new PublisherImp("music");
        new SubscriberImp("music");
        new SubscriberImp("book");
        //第一次调用线程池执行任务时，线程池需要消耗一定时间预热（我这大概40毫秒）
        musciPublisher.publishMessageByAsyn("线程池预热");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
			musciPublisher.publishMessageByAsyn("来自musicPublisher的异步消息");
//            musciPublisher.publishMessageBySync("来自musicPublisher的同步消息");
        }
        long end = System.currentTimeMillis();
        System.out.println("用时："+(end-start)+"毫秒");
    }
}
