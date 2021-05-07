package com.dong.springaoptest.aop;

import com.dong.springaoptest.annotation.MyAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @version 1.0 2021/5/7
 * @author dongliyang
 */
@Aspect
@Component
public class CalAop {

    private final Logger logger = LoggerFactory.getLogger(CalAop.class);

    /**
     * 定义切入点
     */
    @Pointcut("execution(* com.dong.springaoptest.service.CalService.divide(..))")
    public void pointcut(){};

    /**
     * 前置通知，在连接点方法前调用
     */
    @Before("pointcut()")
    public void before() {
        logger.info("===before前置通知===");
    }

    /**
     * 后置通知，在连接点方法后调用
     */
    @After("pointcut()")
    public void after() {
        logger.info("===after后置通知===");
    }

    /**
     * 环绕通知
     * @return
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("===around环绕通知BEGIN===");

//        //获取切入点所在目标对象，即被代理的对象
//        Object target = joinPoint.getTarget();
//        logger.info("被代理对象的类:" + target.getClass().getName());
//
//        //获取切入点签名
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        logger.info("切入点方法名:" + signature.getName());
//
//        //获取方法
//        Method method = signature.getMethod();
//        //进而可以获取方法的一些信息，比如有没有某个注解
//        if (method != null) {
//            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
//            logger.info((annotation != null ? "有" : "无") + "注解@MyAnnotation" );
//        }
//        //获取参数
//        Object[] args = joinPoint.getArgs();
//        logger.info("方法参数:" + Arrays.toString(args));
        //真正执行
        Object result = joinPoint.proceed();
//        logger.info("方法执行结果:" + result);
        logger.info("===around环绕通知END===");
        return result;
    }

    /**
     * 返回通知，在连接点方法执行并正常返回后调用，要求连接点方法在执行过程中没有发生异常
     */
    @AfterReturning("pointcut()")
    public void afterReturning() {
        logger.info("===afterReturning返回通知===");
    }

    /**
     * 异常通知，当连接点方法异常时调用
     */
    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        logger.info("===afterThrowing异常通知===");
    }
}
