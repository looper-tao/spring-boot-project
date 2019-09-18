package com.learn.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: taozhengzhi
 * @Date: 2019/6/19 下午4:56
 * @Version 1.0
 */
public class IntegerBase {
    
    public static void compareToTest(int a, int b) {
        Integer integer1 = Integer.valueOf(a);
        
        Integer integer2 = Integer.valueOf(b);
        
        System.out.println(integer1.compareTo(integer2));
    }
    
    public static void delete(List<User> userList) {
        for(User user : userList) {
            if(user.getAge() == 5 || user.getAge() == 6) {
                userList.remove(user);
                System.out.println("删除成功!");
                return;
            }
        }
    }
    
    public static void main(String[] args) {
//        IntegerBase.compareToTest(2,1);
        
        User user1 = new User("1", 1);
        User user2 = new User("2", 2);
        User user3 = new User("3", 3);
        User user4 = new User("4", 4);
        User user5 = new User("5", 5);
        User user6 = new User("6", 6);
        User user7 = new User("7", 7);
        User user8 = new User("8", 8);
        
        List<User> userList = new ArrayList<>();
        
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        userList.add(user6);
        userList.add(user7);
        userList.add(user8);

//        delete(userList);
//        delete(userList);
        int[] a = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        
        
        for(int i = 0; i < 100000; i++) {
            int index = (int) (Math.random() * userList.size());
            a[index]++;
        }
        
        for(int i = 0; i < 10; i++) {
            System.out.println("i = " + i + "   and count = " + a[i]);
        }

        
    }
    
    
}

@Getter
@Setter
@AllArgsConstructor
class User {
    private String name;
    private int age;
    
    @Override
    public String toString() {
        return "User{" +
            "name='" + name + '\'' +
            ", age=" + age +
            '}';
    }
}