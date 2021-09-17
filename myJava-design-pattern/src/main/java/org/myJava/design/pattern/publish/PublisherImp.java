package org.myJava.design.pattern.publish;

/**
 * @author gongwenzhou@hellobike.com
 * @Date 2021/8/25 5:58 下午
 * @Describe TODO
 */
public class PublisherImp implements IPublisher{
    /**
     * 消息类型
     */
    private String messageType;

    public PublisherImp(String messageType) {
        this.messageType = messageType;
    }

    @Override
    public String getMessageType() {
        return messageType;
    }
}
