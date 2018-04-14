package cn.fc.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class LogAdvice {

    public Object around(ProceedingJoinPoint pj) throws Throwable {

        return pj.proceed(pj.getArgs());
    }
}
