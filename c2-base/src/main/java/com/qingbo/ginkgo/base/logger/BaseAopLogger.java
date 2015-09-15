package com.qingbo.ginkgo.base.logger;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.qingbo.ginkgo.common.util.aop.DefaultAopLogger;

/**
 * 
 * Project:c2-account
 * Package:com.qingbo.c2.account.aop
 * FileName:AccountAopLogger.java
 * Comments:
 * JDK Version:
 * Author XuMaoSen
 * Create Date:2015年8月26日 上午11:47:43
 * Modified By:XuMaoSen
 * Modified Time:
 * What is Modified:
 * Description:
 * Version:
 */
@Aspect
@Component
public class BaseAopLogger extends DefaultAopLogger{
	
	@Pointcut(value="execution(* com.qingbo.ginkgo.base.service.impl.TongjiServiceImpl.*(..))")
	public void doBasePoint() {	}
	
	@Around(value="doBasePoint()")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		return super.aroundAdvice(pjp);
	}
	
}
