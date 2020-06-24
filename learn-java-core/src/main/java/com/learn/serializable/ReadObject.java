package com.learn.serializable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author: yeguxin
 * @date: 2020/6/22
 * @description:
 */
public class ReadObject {
    public static void main(String[] args) {
        try{
            FileInputStream fileInputStream = new FileInputStream("/Users/yeguxin/Desktop/persion.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
    
            FileInputStream fileInputStream2 = new FileInputStream("/Users/yeguxin/Desktop/persion1.txt");
            ObjectInputStream objectInputStream2 = new ObjectInputStream(fileInputStream2);
    
            Person person = (Person) objectInputStream.readObject();
    
            Person person2 = (Person) objectInputStream2.readObject();
            
            System.out.println(person.toString());
            System.out.println(person == person2);
            
        } catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
