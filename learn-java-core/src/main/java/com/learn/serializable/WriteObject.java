package com.learn.serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author: yeguxin
 * @date: 2020/6/22
 * @description:
 */
public class WriteObject {
    public static void main(String[] args) {
        
        try {
            FileOutputStream outputStream = new FileOutputStream("/Users/yeguxin/Desktop/persion.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
    
            FileOutputStream outputStream2 = new FileOutputStream("/Users/yeguxin/Desktop/persion1.txt");
            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(outputStream2);
    
            Person person = new Person("张三", 18);
            objectOutputStream.writeObject(person);
            objectOutputStream2.writeObject(person);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
