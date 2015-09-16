package com.qingbo.c2.account.logger;


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
public class AccountAopLogger extends DefaultAopLogger{
	
	@Pointcut(value="execution(* com.qingbo.c2.account.service.impl.*.*(..))")
	public void doAccountPoint() {	}
	
	@Around(value="doAccountPoint()")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		return super.aroundAdvice(pjp);
	}
	
}
