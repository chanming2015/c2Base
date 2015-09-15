/*
 *www.shequ2.com
 *Copyright (c) 2015 All Rights Reserved
 */
/**
 * Author XuMaoSen
 */
package com.qingbo.ginkgo.common.util.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Project:c2-base
 * Package:com.qingbo.ginkgo.base.aop
 * FileName:LoggerAop.java
 * Comments:
 * JDK Version:
 * Author XuMaoSen
 * Create Date:2015年8月13日 上午10:34:05
 * Modified By:XuMaoSen
 * Modified Time:
 * What is Modified:
 * Description:
 * Version:
 */
public interface LoggerAop {
	
	/**
	 * 
	 * @author XuMaoSen
	 * Create Time:2015年8月13日 上午10:49:43
	 * Description 前置通知
	 * @param param
	 */
	void beforeAdvice(String param);
	/**
	 * 
	 * @author XuMaoSen
	 * Create Time:2015年8月13日 上午10:40:35
	 * Description 后置返回通知
	 * @param retVal
	 */
	void afterReturningAdvice(Object retVal);
	/**
	 * 
	 * @author XuMaoSen
	 * Create Time:2015年8月13日 上午10:41:06
	 * Description 后置异常通知
	 * @param exception
	 */
	void afterThrowingAdvice(Exception exception);
	/**
	 * 
	 * @author XuMaoSen
	 * Create Time:2015年8月13日 上午10:41:40
	 * Description 后置最终通知
	 */
	void afterFinallyAdvice();
	/**
	 * 
	 * @author XuMaoSen
	 * Create Time:2015年8月13日 上午10:42:51
	 * Description 环绕通知
	 * @param pjp
	 */
	Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable;

}
