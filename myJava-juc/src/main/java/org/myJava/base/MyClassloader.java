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


public class MyClassloader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz = null;
        String classFilename = name + ".class";
        File classFile = new File(classFilename);
        if (classFile.exists()) {
            try (FileChannel fileChannel = new FileInputStream(classFile).getChannel()) {
//                MappedByteBuffer mappedByteBuffer = fileChannel
//                        .map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
//
//                byte[] b = mappedByteBuffer.array();
                byte[] b = Files.readAllBytes(Paths.get(new URI(classFilename)));
                clazz = defineClass(name, b, 0, b.length);
            } catch (IOException | URISyntaxException e) {
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
        Class clazz = myClassLoader.loadClass("file://./Users/gongwenzhou/IdeaProjects/myJava/myJava-juc/src/main/java/org/myJava/base/Hello");
        Method sayHello = clazz.getMethod("sayHello");
        sayHello.invoke(null, null);
    }


}
