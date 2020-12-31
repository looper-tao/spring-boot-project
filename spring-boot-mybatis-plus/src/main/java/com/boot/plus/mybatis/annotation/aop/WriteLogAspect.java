package com.boot.plus.mybatis.annotation.aop;

import com.boot.learn.untils.KJsonUtils;
import com.boot.plus.mybatis.annotation.WriteLog;
import com.boot.plus.mybatis.entity.TPerson;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author: yeguxin
 * @date: 2020/12/31
 * @description:
 */
@Aspect
@Component
public class WriteLogAspect {
    @Pointcut("@annotation(com.boot.plus.mybatis.annotation.WriteLog)")
    public void writeLogCut() {
    
    }
    
    @Before("writeLogCut()")
    public void writeLogBefore(JoinPoint point) {
        // 目标方法名
        String targetMethodName = point.getSignature().getName();
        System.out.println("目标方法名: " + targetMethodName);
        
        // 目标方法所属类的简单类名
        String targetClassSimpleName = point.getSignature().getDeclaringType().getSimpleName();
        System.out.println("目标方法所属类的简单类名: " + targetClassSimpleName);
        
        // 目标方法所属类的类名
        String targetClassName = point.getSignature().getDeclaringTypeName();
        System.out.println("目标方法所属类的类名: " + targetClassName);
        
        Method targetMethod = ((MethodSignature) point.getSignature()).getMethod();
        WriteLog writeLog = targetMethod.getAnnotation(WriteLog.class);
        Class[] paramsTypes = new Class[3];
        if(writeLog != null) {
            paramsTypes = writeLog.value();
        }
        
        Object[] methodArgs = point.getArgs();
        for(int i = 0; i < methodArgs.length; i++) {
            System.out.println("第" + (i + 1) + "个参数值为: " + methodArgs[i]);
        }
        TPerson person = null;
        for(int i = 0; i < paramsTypes.length; i++) {
            Class c = paramsTypes[i];
            if(c.getName().equals("com.boot.plus.mybatis.entity.TPerson")) {
                person = (TPerson) methodArgs[i];
            }
        }
        System.out.println(person == null ? "TPerson为空 " : person.toString());
        
    }
}
