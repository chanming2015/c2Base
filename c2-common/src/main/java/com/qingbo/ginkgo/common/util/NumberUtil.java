package com.qingbo.ginkgo.common.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;



/**
 * 解析字符串值为基本类型：整数，长整数，浮点数，布尔值
 * @author hongwei
 */
public class NumberUtil {
	
	public static Integer parseInt(String number, Integer defValue) {
		try {
			if(number!=null && !number.isEmpty()) return Integer.parseInt(number);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return defValue;
	}

	public static Long parseLong(String number, Long defValue) {
		try {
			if(number!=null && !number.isEmpty()) return Long.parseLong(number);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return defValue;
	}

	public static Double parseDouble(String number, Double defValue) {
		try {
			if(number!=null && !number.isEmpty()) return Double.parseDouble(number);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return defValue;
	}
	
	/**
	 * 字符串转换成BigDecimal，最好的方式就是new BigDecimal(string)
	 */
	public static BigDecimal parseBigDecimal(String number, BigDecimal defValue) {
		try {
			if(number!=null && !number.isEmpty()) return new BigDecimal(number);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return defValue;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T parse(String number, Class<T> type, T defValue) {
		if(type==Integer.class) {
			return (T) parseInt(number, (Integer)defValue);
		}else if(type==Long.class) {
			return (T) parseLong(number, (Long)defValue);
		}else if(type==Double.class) {
			return (T) parseDouble(number, (Double)defValue);
		}else if(type==Boolean.class) {
			return (T) parseBoolean(number, (Boolean)defValue);
		}else if(type==BigDecimal.class) {
			return (T) parseBigDecimal(number, (BigDecimal)defValue);
		}
		return null;
	}
	
    private static String[] trueStrings = {"true", "yes", "y", "on", "1"};
    private static String[] falseStrings = {"false", "no", "n", "off", "0"};
    public static Boolean parseBoolean(String value, Boolean defValue) {
		if(value!=null && !value.isEmpty()) {
	        String stringValue = value.toString().toLowerCase();
	        for(int i=0; i<trueStrings.length; ++i) 
	            if (trueStrings[i].equals(stringValue)) return Boolean.TRUE;
	        for(int i=0; i<falseStrings.length; ++i) 
	            if (falseStrings[i].equals(stringValue)) return Boolean.FALSE;
		}
		return defValue;
    }
    
    private static NumberFormat percentFormat = new DecimalFormat("##.##");
    public static String percentFormat(BigDecimal interestRate) {
    	if(interestRate == null) return null;
    	return percentFormat.format(interestRate.doubleValue()*100)+"%";
    }
    
    /**
	 * 
	 * @author XuMaoSen
	 * Create Time:2015年9月1日 下午12:46:56
	 * Description 比较价格是否相等（支付宝金额单位是元，微信金额单位是分）
	 * @param price
	 * @param b
	 * @return
	 */
    public static boolean checkPrice(String price, BigDecimal b) {
		boolean flag = false;
		if(price == null || b == null){
			return flag;
		}
		flag = price.equals(b.toString());
		if(flag) {
			return flag;
		}
		Float f1 = new Float(price);
		Float f2 = new Float(b.toString());
		flag = f1.equals(f2);
		return flag;
	}
}
