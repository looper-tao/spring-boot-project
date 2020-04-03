package com.learn.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: yeguxin
 * @date: 2020/2/6
 * @description:
 */
public class ReflectionMain {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<Apple> appleClass = Apple.class;
        
        System.out.println("1.通过反射获取所有参数 getDeclaredFields");
        Field[] field1 = appleClass.getDeclaredFields();
        for(Field field : field1) {
            System.out.println(field.toString());
        }
        System.out.println();
        
        System.out.println("2. 通过反射获取指定参数 getDeclaredField");
        Field colorField = appleClass.getDeclaredField("color");
        System.out.println("color:" + colorField.toString());
        
        Field sizeField = appleClass.getDeclaredField("size");
        System.out.println("size:" + sizeField.toString());
        
        Field priceField = appleClass.getDeclaredField("price");
        System.out.println("price:" + priceField.toString());
        
        // 不能获取到父类的任何属性
//        Field tasteField=appleClass.getDeclaredField("taste");
//        System.out.println("taste:"+tasteField.toString());
        
        System.out.println();
        
        System.out.println("3.通过反射获取所有pubic类型的参数 getFields");
        Field[] fields3 = appleClass.getFields();
        for(Field field : fields3) {
            System.out.println(field.toString());
        }
        System.out.println();
        
        System.out.println("4.通过反射获取指定public类型的参数 getField");
        Field sizeField4 = appleClass.getField("size");
        System.out.println("color:" + sizeField4.toString());
        
        // getField只能获取public类型的参数,其他的类型无法获取
//        Field colorField4=appleClass.getField("color");
//        System.out.println("color:"+colorField4.toString());
        
        System.out.println();
        
        System.out.println("5.通过反射获取所有方法 getDeclaredMethods");
        Method[] methods = appleClass.getDeclaredMethods();
        for(Method method : methods) {
            System.out.println(method.toString());
        }
        System.out.println();
        
        //指定方法
        System.out.println("6.通过反射获取指定方法 getDeclaredMethod");
        
        //default
        Method getColorMethod = appleClass.getDeclaredMethod("getColor");
        System.out.println("getColorMethod:" + getColorMethod.toString());
        
        //public
        Method getSizeMethod = appleClass.getDeclaredMethod("getSize");
        System.out.println("getSizeMethod:" + getSizeMethod.toString());
        
        //private
        Method getPriceMethod = appleClass.getDeclaredMethod("getPrice");
        System.out.println("getPriceMethod:" + getPriceMethod.toString());
        
        //父类的public 不可根据getDeclaredMethod获取方法
//        Method getTasteMethod = appleClass.getDeclaredMethod("getTaste");
//        System.out.println("getTasteMethod:" + getTasteMethod.toString());
        
        System.out.println();
        
        // getMethods可以通过反射获取所有的public方法，包括父类的public方法。
        System.out.println("7.通过反射获取所有public类型的方法 getMethods");
        Method[] method7 = appleClass.getMethods();
        for(Method method : method7) {
            System.out.println(method.toString());
        }
        System.out.println();
        
        // getMethod可以通过反射获取所有的public方法，包括父类的public方法。
        System.out.println("8.通过反射获取指定public类型的方法 getMethod");
        Method toStringMethod = appleClass.getMethod("toString");
        System.out.println(toStringMethod.toString());
        
        Method waitMethod = appleClass.getMethod("wait");
        System.out.println(waitMethod.toString());
        System.out.println();
        
        System.out.println("9.通过反射获取所有构造方法 getDeclaredConstuctors");
        Constructor[] constructors = appleClass.getDeclaredConstructors();
        for(Constructor constructor : constructors) {
            System.out.println(constructor.toString());
        }
        System.out.println();
        
        System.out.println("10.通过反射获取某个带参数的构造方法 getDeclaredConstructor");
        Class[] cArg = new Class[3];
        cArg[0] = String.class;
        cArg[1] = int.class;
        cArg[2] = int.class;
        Constructor constructor = appleClass.getDeclaredConstructor(cArg);
        System.out.println(constructor.toString());
        System.out.println();
        
        System.out.println("11.通过反射获取所有public类型的构造方法 getConstructors");
        Constructor[] constructors11 = appleClass.getConstructors();
        for(Constructor constructor11 : constructors11) {
            System.out.println(constructor11.toString());
        }
        System.out.println();
        
        System.out.println("12.通过反射获取某个public类型的构造方法 getConstructor");
        Constructor constructor1 = appleClass.getConstructor(String.class, int.class, int.class);
        System.out.println("public类型的有参构造：" + constructor1.toString());
        
        // getConstructor方法无法获取public之外的构造函数
//        Constructor constructor2 = appleClass.getConstructor(String.class, int.class);
//        System.out.println("private类型的有参构造：" + constructor2.toString());
        System.out.println();
        
        System.out.println("13.通过无参构造来获取该类对象 newInstance()");
        Class appleClass13 = Class.forName("com.learn.reflection.Apple");
        Apple apple = (Apple) appleClass13.newInstance();
        System.out.println();
        
        System.out.println("14.通过有参构造来获取该类对象 newInstance（XXXX）");
        Constructor constructor14 = appleClass.getConstructor(String.class, int.class, int.class);
        Apple apple14 = (Apple) constructor14.newInstance("红色", 10, 5);
        System.out.println();
        
        System.out.println("15.获取类名包含包路径 getName()");
        String name = appleClass.getName();
        System.out.println("name:" + name);
        System.out.println();
        
        System.out.println("16.获取类名不包含包路径 getSimpleName()");
        String simpleName = appleClass.getSimpleName();
        System.out.println("simpleName:" + simpleName + "\n");
        
        System.out.println("17.通过反射调用方法 invoke");
        //调用无参构造创建对象
        Class appleClass17 = Class.forName("com.learn.reflection.Apple");
        
        //调用有参构造
        Constructor constructor17 = appleClass17.getDeclaredConstructor(String.class, int.class, int.class);
        Apple apple17 = (Apple) constructor17.newInstance("红色", 10, 20);
        
        //获取toString方法并调用
        Method method = appleClass17.getDeclaredMethod("toString");
        String str = (String) method.invoke(apple17);
        System.out.println(str);
        System.out.println();
    
        System.out.println("18.判断方法是否能调用isAccessible");
        //调用无参构造创建对象
        Class appleClass18 = Class.forName("com.learn.reflection.Apple");

        //调用有参构造
        Constructor constructor18 = appleClass18.getDeclaredConstructor(String.class, int.class, int.class);
        Apple apple18 = (Apple) constructor18.newInstance("红色", 10, 20);

        //获取public的getSize方法并调用
        Method method18 = appleClass18.getDeclaredMethod("getSize");
        System.out.println("getSize方法的isAccessible：" + method18.isAccessible());
        int size = (Integer) method18.invoke(apple18);
        System.out.println("size:" + size);

        //获取private的getPrice方法并调用
        method18 = appleClass18.getDeclaredMethod("getPrice");
        System.out.println("getPrice的isAccessible：" + method18.isAccessible());
        int price = (Integer) method18.invoke(apple18);
        System.out.println("price:" + price);
    }
}
