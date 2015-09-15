package com.qingbo.ginkgo.common.result;

import java.util.Properties;

import com.qingbo.ginkgo.common.util.config.PropertiesUtil;

/**
 * 
 * Project:c2-common
 * Package:com.qingbo.ginkgo.common.util
 * FileName:ErrorMessage.java
 * Comments:
 * JDK Version:
 * Author XuMaoSen
 * Create Date:2015年8月5日 上午10:08:36
 * Modified By:XuMaoSen
 * Modified Time:
 * What is Modified:
 * Description: 
 * Version:
 */
public class ErrorMessage {
	private Properties props = new Properties();
	private Object nullArg = "null";
	private Object[] nullArgs = new Object[] {nullArg};
	
	public ErrorMessage(String resource) {
		if(resource!=null && resource.length()>0) {
			props = PropertiesUtil.get(resource, "utf-8");
		}
	}
	
	/**
	 * 返回简单错误消息
	 */
	public <T> Result<T> newFailure(String error){
		Result<T> result = new Result<>();
		result.setCode(-1);
		result.setError(error);
		if(props!=null && error!=null) result.setMessage(props.getProperty(error));
		return result;
	}
	
	/**
	 * 返回简单错误消息
	 */
	public <T> Result<T> newFailure(String error, String message){
		Result<T> result = newFailure(error);
		result.setMessage(result.getMessage() + message);
		return result;
	}
	
	/**
	 * 返回带参数的错误消息
	 */
	public <T> Result<T> newFailure(String error, Object ... args){
		Result<T> result = new Result<>();
		result.setCode(-1);
		result.setError(error);
		if(props!=null && error!=null) {
			if(args==null) args = nullArgs;
			else for(int idx=0; idx<args.length; idx++) {
					if(args[idx]==null) args[idx] = nullArg;
					else args[idx] = String.valueOf(args[idx]);
				}
			result.setMessage(PropertiesUtil.getMessage(props, error, args));
		}
		return result;
	}
}
