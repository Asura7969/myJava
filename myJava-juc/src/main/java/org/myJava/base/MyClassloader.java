package org.myJava.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.sun.xml.internal.messaging.saaj.packaging.mime.util.ASCIIUtility.getBytes;


public class MyClassloader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz = null;
        name = "/Users/gongwenzhou/IdeaProjects/myJava/myJava-juc/src/main/java/org/myJava/base/Hello";
        String classFilename = name + ".class";
        File classFile = new File(classFilename);
        if (classFile.exists()) {
            try {
                byte[] raw = getBytes(classFilename);
                clazz = defineClass(name, raw, 0, raw.length);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("class 文件不存在！");
        }
        if (clazz == null) {
            throw new ClassNotFoundException(name);
        }
        return clazz;
    }

    public static void main(String[] args) throws Exception {
        MyClassloader myClassLoader = new MyClassloader();
//        Class clazz = myClassLoader.loadClass("org.myJava.base.Hello");
        Class<?> clazz = myClassLoader.findClass("file:///Users/gongwenzhou/IdeaProjects/myJava/myJava-juc/src/main/java/org/myJava/base/Hello");
        Method sayHello = clazz.getMethod("sayHello");
        sayHello.invoke(null, null);
    }


}
