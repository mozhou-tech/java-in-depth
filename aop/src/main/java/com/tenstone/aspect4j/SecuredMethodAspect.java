package com.tenstone.aspect4j;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by liuyuancheng on 2022/2/9  <br/>
 *
 * @author liuyuancheng
 */
@Aspect
public class SecuredMethodAspect {

    @Pointcut("@annotation(secured)")
    public void callAt(Secured secured) {
    }

    @Around("callAt(secured)")
    public Object around(ProceedingJoinPoint pjp, Secured secured) throws Throwable {
        if(secured.isLocked()){
            System.out.println("locked");
            return null;
        }else{
            return pjp.proceed();
        }
    }
}
