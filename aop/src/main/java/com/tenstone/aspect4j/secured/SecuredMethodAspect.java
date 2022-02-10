package com.tenstone.aspect4j.secured;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by liuyuancheng on 2022/2/9  <br/>
 *
 * @author liuyuancheng
 */
@Aspect
public class SecuredMethodAspect {

    /**
     * 切点
     * 丰富的pointCut语法，可以灵活的定义切点
     * //@Pointcut("execution(* com.test.spring.aop.pointcutexp..JoinPointObjP2.*(..))")
     * 	//@Pointcut("within(com.test.spring.aop.pointcutexp..*)")
     * 	//@Pointcut("this(com.test.spring.aop.pointcutexp.Intf)")
     * 	//@Pointcut("target(com.test.spring.aop.pointcutexp.Intf)")
     * 	//@Pointcut("@within(org.springframework.transaction.annotation.Transactional)")
     * 	//@Pointcut("@annotation(org.springframework.transaction.annotation.Transactional)")
     *  //@Pointcut("args(String)")
     *  //@Pointcut("handler(java.lang.Exception+)&&args(e)")
     * @param secured
     */
    @Pointcut("@annotation(secured)")
    public void callAt(Secured secured) {
    }

    /**
     * 环绕通知(功能最全)
     * 环绕通知必须有返回值, 返回值即为目标方法的返回值。
     *
     * @param pjp
     * @param secured
     * @return
     * @throws Throwable
     */
    @Around(value = "callAt(secured)", argNames = "pjp,secured")
    public Object around(ProceedingJoinPoint pjp, Secured secured) throws Throwable {
        Object result = null;
        String methodName = pjp.getSignature().getName();
        System.out.println("aspect:around:before:" + methodName);
        if (secured.isLocked()) {
            System.out.println("aspect:method " + methodName + " locked");
        } else {
            result = pjp.proceed();
        }
        System.out.println("aspect:around:after:" + methodName);
        return result;
    }

    /**
     * 返回通知, 在方法返回结果之后执行
     *
     * @return
     */
    @AfterReturning(value = "execution(public String com.tenstone.aspect4j.secured.SecuredMethod.returningMethod(String))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("aspect: " + "retuning..." + result.toString());
    }

    /**
     * 异常通知, 在方法抛出异常之后
     *
     * @return
     */
    @AfterThrowing(value = "execution(public void com.tenstone.aspect4j.secured.SecuredMethod.throwMethod())")
    public void afterThrowing(JoinPoint joinPoint) {
        System.out.println("aspect: " + "throwing...");
    }

    /**
     * 后置通知, 在方法执行之后执行
     *
     * @return
     */
    @After(value = "execution(public void com.tenstone.aspect4j.secured.SecuredMethod.afterMethod())")
    public void after(JoinPoint joinPoint) {
        System.out.println("aspect: " + "after...");
    }

    /**
     * 前置通知, 在方法执行之前执行
     *
     * @return
     */
    @Before(value = "execution(public void com.tenstone.aspect4j.secured.SecuredMethod.beforeMethod())")
    public void before(JoinPoint joinPoint) {
        System.out.println("aspect: " + "before...");
    }


}
