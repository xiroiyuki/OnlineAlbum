package cn.fc.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class MyAdvice {

    public void before() {
        System.out.println("前置通知");
    }

    public void after() {
        System.out.println("后置通知");
    }

    public Object around(ProceedingJoinPoint pj) throws Throwable {
        System.out.println("=======开始查询===========");
        long start = System.currentTimeMillis();
        System.out.println("Execute Method:" + pj.toShortString());
        System.out.println("Start:" + start);
        Object obj = pj.proceed(pj.getArgs());
        long end = System.currentTimeMillis();
        System.out.println("End:" + end);
        System.out.println("Used:" + (end - start));
        System.out.println("=======结束查询===========");
        return obj;
    }


}
