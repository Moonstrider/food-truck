package com.mountains.micro.food.truck.aop;

import com.mountains.micro.common.util.DbUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DbOperationAop {

    private static final String POINTCUT = "execution(* com.mountains.micro.food.truck.repository..*.save*(..))";

    @Before(POINTCUT)
    public void before(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if (args != null) {
            for (Object arg : args) {
                DbUtil.setAuditInfo(arg);
            }
        }
    }


}
