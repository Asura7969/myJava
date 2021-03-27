package org.myJava.base.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author asura7969
 * @create 2021-03-27-13:58
 *
 * 动态代理实现
 */
public class ProxyHandler<T> implements InvocationHandler {
    private T targetObject;

    public  Object newProxyInstance(T targetObject){
        this.targetObject = targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),targetObject.getClass().getInterfaces(),this);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理类执行");
        return method.invoke(targetObject,args);
    }
}
