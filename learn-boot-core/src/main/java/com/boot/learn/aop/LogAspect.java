package com.boot.learn.aop;

import com.boot.learn.aop.annotate.Log;
import com.boot.learn.untils.KJsonUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: yeguxin
 * @date: 2020/1/2
 * @description:
 */
@Aspect
@Component
public class LogAspect {
    @Pointcut("@annotation(com.boot.learn.aop.annotate.Log)")
    public void pointcut(){
    
    }
    
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point){
        Object result = null;
        try {
            result = point.getTarget();
        } catch(Throwable throwable) {
            throwable.printStackTrace();
        }
        saveLog(point);
        return result;
    }
    
    private void saveLog(ProceedingJoinPoint point){
        Map<String,String> logMap= new HashMap<>();
        
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Log log = method.getAnnotation(Log.class);
        if(log != null){
            logMap.put("operation",log.value());
        }
        // 请求的方法名
        String className = point.getTarget().getClass().getName();
        String methodName = signature.getName();
        logMap.put("className",className + "." + methodName + "()");
    
        // 请求的方法参数值
        Object[] args = point.getArgs();
        // 请求的方法参数名称
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
        if (args != null && paramNames != null) {
            String params = "";
            for (int i = 0; i < args.length; i++) {
                params += "  " + paramNames[i] + ": " + args[i];
            }
            logMap.put("params",params);
        }
       System.out.println(KJsonUtils.toJson(logMap));
       
    
    }
}
