/*
 *www.qingbo.com
 *Copyright (c) 2015 All Rights Reserved
 */
/**
 * Author XuMaoSen
 */
package com.qingbo.ginkgo.common.util;

/**
 * Project:c2-base
 * Package:com.qingbo.ginkgo.base.util
 * FileName:TableEntityUtil.java
 * Comments:
 * JDK Version:
 * Author XuMaoSen
 * Create Date:2015年5月13日 上午9:44:33
 * Modified By:XuMaoSen
 * Modified Time:
 * What is Modified:
 * Description:
 * Version:
 */
public interface TableEntity {
	
	/**
	 * 得到该对象的列名数组
	 * @return
	 */
	public abstract String[] getColumnNames();
	
	/**
	 * 返回该实体对象的所有属性构成的数组
	 * @return
	 */
	public abstract Object[] toArray();
	
	/**
	 * 
	 * @author XuMaoSen
	 * Create Time:2015年8月5日 上午11:02:25
	 * Description 
	 * @return 返回敏感信息*处理后的数据
	 */
	public abstract Object[] toSpeArray();

}
