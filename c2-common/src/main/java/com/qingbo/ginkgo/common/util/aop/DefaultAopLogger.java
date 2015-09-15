/*
 *www.shequ2.com
 *Copyright (c) 2015 All Rights Reserved
 */
/**
 * Author XuMaoSen
 */
package com.qingbo.ginkgo.common.util.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qingbo.ginkgo.common.result.Result;

/**
 * Project:c2-base
 * Package:com.qingbo.ginkgo.base.aop
 * FileName:DefaultAopLogger.java
 * Comments:
 * JDK Version:
 * Author XuMaoSen
 * Create Date:2015年8月13日 上午10:45:00
 * Modified By:XuMaoSen
 * Modified Time:
 * What is Modified:
 * Description:
 * Version:
 */
public class DefaultAopLogger implements LoggerAop {

	/** @author XuMaoSen 
	 */
	@Override
	public void beforeAdvice(String param) {
	}

	/** @author XuMaoSen 
	 */
	@Override
	public void afterReturningAdvice(Object retVal) {
	}

	/** @author XuMaoSen 
	 */
	@Override
	public void afterThrowingAdvice(Exception exception) {
	}

	/** @author XuMaoSen 
	 */
	@Override
	public void afterFinallyAdvice() {
	}

	/** @author XuMaoSen 
	 */
	@Override
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
		
		// 获取被代理的对象名
		String targetName = joinPoint.getSignature().getDeclaringTypeName();
		// 获取被调用的方法名
        String methodName = joinPoint.getSignature().getName();
        // 获取方法参数
        Object[] arguments = joinPoint.getArgs();
        Logger logger = LoggerFactory.getLogger(targetName);
        logger.info(SimpleLogFormater.formatParams(methodName + "()", arguments));
        try {
        	// 调用被代理对象方法
			Object proceed = joinPoint.proceed();
			if(proceed instanceof Result) {
				Result<?> result = (Result<?>)proceed;
				String responseInfo = SimpleLogFormater.formatParams(result);
				if(result.success()) {
					logger.info(responseInfo);
				}else {
					logger.error(responseInfo);
				}
			}else {
				String responseInfo = proceed!=null ? proceed.toString() : "Result is null";
				logger.info(responseInfo);
			}
			return proceed;
		} catch (Exception e) {
			Result<Object> result = Result.newException(e);
			result.setMessage(e.getMessage());
			String responseInfo = SimpleLogFormater.formatParams(result);
			logger.error(responseInfo);
			return result;
		}
	}

}
