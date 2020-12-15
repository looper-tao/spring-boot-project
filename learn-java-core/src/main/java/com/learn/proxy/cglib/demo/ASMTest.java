package com.learn.proxy.cglib.demo;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: yeguxin
 * @date: 2020/12/15
 * @description:
 */
public class ASMTest {
    
    public static void main(String[] args) {
        //ClassReader用于读取原有字节码，ClassWriter用于写入字节码，
        ClassWriter cs = new ClassWriter(0);
        //通过vist确定类的同步信息 java版本号 类修饰符 类的权限定名
        cs.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "ProxyCglibDemo", null, "java/lang/Object", null);
        //构造函数
        MethodVisitor mv = cs.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
        mv.visitCode();
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(1, 1);
        mv.visitEnd();
        // 定义code方法
        MethodVisitor methodVisitor = cs.visitMethod(Opcodes.ACC_PUBLIC, "remark", "()V", null, null);
        methodVisitor.visitCode();
        methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        methodVisitor.visitLdcInsn("我是一个经过asm框架创建出来的ProxyCglibDemo.class文件");
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");
        methodVisitor.visitInsn(Opcodes.RETURN);
        methodVisitor.visitMaxs(2, 2);
        methodVisitor.visitEnd();
        cs.visitEnd();
        // 使classWriter类已经完成
        // 将classWriter转换成字节数组写到文件里面去
        byte[] data = cs.toByteArray();
        File file = new File("/Users/yeguxin/Documents/myCode/spring-boot-project/learn-java-core/target/classes/com/learn/proxy/cglib/demo/ProxyCglibDemo.class");
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream(file);
            fout.write(data);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if(fout != null) {
                try {
                    fout.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
