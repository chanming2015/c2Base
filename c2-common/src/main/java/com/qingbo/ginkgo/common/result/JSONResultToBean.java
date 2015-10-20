/**
 * Author XuMaoSen
 */
package com.qingbo.ginkgo.common.result;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.druid.support.json.JSONUtils;
import com.qingbo.ginkgo.common.util.DateUtil;

/**
 * Project:c2-web-run
 * Package:com.qingbo.c2.web.pojo
 * FileName:JSONResultToBean.java
 * Comments:
 * JDK Version:
 * Author XuMaoSen
 * Create Date:2015年10月19日 上午10:34:23
 * Modified By:XuMaoSen
 * Modified Time:
 * What is Modified:
 * Description:
 * Version:
 */
@SuppressWarnings("unchecked")
public class JSONResultToBean {
	
	/**
	 * 
	 * @author XuMaoSen
	 * Create Time:2015年10月20日 下午3:16:51
	 * Description 将Json字符串转换成Map
	 * @param jsonString
	 * @return
	 */
    private static Map<String, Object> toMap(String jsonString){
		Map<String, Object> map = (Map<String, Object>) JSONUtils.parse(jsonString);
        return map;

    }
    
    /**
     * 
     * @author XuMaoSen
     * Create Time:2015年10月20日 下午3:17:28
     * Description JSONString到JavaBean
     * @param javabean
     * @param jsonString
     * @param cls
     */
	public static <T> void toJavaBean(Result<T> javabean, String jsonString, Class<T> cls) {
    	Map<String, Object> map = toMap(jsonString);
        toJavaBean(javabean, map, cls);
    }
	
	 /**
	  * 
	  * @author XuMaoSen
	  * Create Time:2015年10月20日 下午3:17:46
	  * Description 将Map转换成Javabean
	  * @param javabean
	  * @param data
	  * @param cls
	  */
	private static <T> void toJavaBean(Result<T> javabean, Map<String, Object> data, Class<T> cls) {

		Method[] methodsResult = Result.class.getDeclaredMethods();
		Method[] methodsT = cls.getMethods();
		for (Method methodRe : methodsResult) {
			try {
				if (methodRe.getName().startsWith("set")) {
					String field = initField(methodRe);
					
					if (methodRe.getName().equals("setObject")) {
						// 设置object对象
						if (javabean.getObject() == null) {
							javabean.setObject(cls.newInstance());
						}
						Map<String, Object> dataT = (Map<String, Object>) data.get(field);
						for (Method methodT : methodsT) {
							if (methodT.getName().startsWith("set")) {
								field = initField(methodT);
								if (methodT.getName().equals("setCreateAt")) {
									methodT.invoke(javabean.getObject(), DateUtil.parse(dataT.get(field) + ""));
								} else {
									methodT.invoke(javabean.getObject(), new Object[] { dataT.get(field) });
								}
							} 
						}
					}else {
						methodRe.invoke(javabean, new Object[] { data.get(field) });
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * @author XuMaoSen
	 * Create Time:2015年10月20日 下午3:18:04
	 * Description JSONString到JavaBean
	 * @param javabean
	 * @param jsonString
	 * @param cls
	 */
	public static <T> void toJavaBeanPager(Result<Pager<T>> javabean, String jsonString, Class<T> cls) {
    	Map<String, Object> map = toMap(jsonString);
        toJavaBeanPager(javabean, map, cls);
    }
    
    /**
     * 
     * @author XuMaoSen
     * Create Time:2015年10月20日 下午3:18:18
     * Description 将Map转换成Javabean
     * @param javabean
     * @param data
     * @param cls
     */
	private static <T> void toJavaBeanPager(Result<Pager<T>> javabean, Map<String, Object> data, Class<T> cls) {

		Method[] methodsResult = Result.class.getDeclaredMethods();
		Method[] methodsPager = Pager.class.getDeclaredMethods();
		Method[] methodsT = cls.getMethods();
		for (Method methodRe : methodsResult) {
			try {
				if (methodRe.getName().startsWith("set")) {
					String field = initField(methodRe);
					
					if (methodRe.getName().equals("setObject")) {
						// 设置object对象
						if (javabean.getObject() == null) {
							javabean.setObject(Pager.class.newInstance());
						}
						Map<String, Object> dataPager = (Map<String, Object>) data.get(field);
						for (Method methodPa : methodsPager) {
							if (methodPa.getName().startsWith("set")) {
								field = initField(methodPa);
								
								if (methodPa.getName().equals("setElements")) {
									// 设置List对象
									List<Object> listT = (List<Object>) dataPager.get(field);
									List<T> list = new ArrayList<T>();
									javabean.getObject().setElements(list);
									
									for (int i = 0; i < listT.size(); i++) {
										Map<String, Object> dataT = (Map<String, Object>) listT.get(i);
										T t = cls.newInstance();
										list.add(t);
										for (Method methodT : methodsT) {
											if (methodT.getName().startsWith("set")) {
												field = initField(methodT);
												if (methodT.getName().equals("setMoney")) {
													methodT.invoke(javabean.getObject().getElements().get(i), new Float(dataT.get(field)+""));
												} else if (methodT.getName().equals("setCreateAt")) {
													methodT.invoke(javabean.getObject().getElements().get(i), DateUtil.parse(dataT.get(field)+""));
												} else if (methodT.getName().equals("setAccountBalance")) {
													methodT.invoke(javabean.getObject().getElements().get(i), new BigDecimal(dataT.get(field)+""));
												} else {
													methodT.invoke(javabean.getObject().getElements().get(i), new Object[] { dataT.get(field) });
												}
											}
										}
									}
									
								}else {
									methodPa.invoke(javabean.getObject(), new Object[] { dataPager.get(field) });
								}
							}
						}
					}else {
						methodRe.invoke(javabean, new Object[] { data.get(field) });
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * @author XuMaoSen
	 * Create Time:2015年10月20日 下午4:10:11
	 * Description 初始化方法字段
	 * @param m
	 * @return
	 */
	private static String initField(Method m){
		String field = m.getName();
		field = field.substring(field.indexOf("set") + 3);
		field = field.toLowerCase().charAt(0) + field.substring(1);
		return field;
	}

}
