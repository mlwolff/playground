package com.lupus.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.util.StopWatch;

@Aspect
public class PerfAspect {
    @Around("methodsToBeProfiled()")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch sw = new StopWatch(getClass().getSimpleName());
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
		PerfTracker perfTracker = method.getAnnotation(PerfTracker.class);
        String id="";
        
        if (perfTracker != null) {
        	id = perfTracker.trackerId();
        }

        if (id.trim().isEmpty()) {
        	id = signature.getDeclaringType().getSimpleName() + "." + signature.getName();
        }
        
        try {
            sw.start(id);
            return pjp.proceed();
        } finally {
            sw.stop();
            System.out.println(sw.prettyPrint());
        }
    }

//    @Pointcut("execution(public void com.lupus.perf..*.execute(..))")
    @Pointcut("@annotation(com.lupus.aop.PerfTracker)")
    public void methodsToBeProfiled(){}

}
