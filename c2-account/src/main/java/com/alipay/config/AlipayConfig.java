package com.alipay.config;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.3
 *日期：2012-08-10
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
	
 *提示：如何获取安全校验码和合作身份者ID
 *1.用您的签约支付宝账号登录支付宝网站(www.alipay.com)
 *2.点击“商家服务”(https://b.alipay.com/order/myOrder.htm)
 *3.点击“查询合作者身份(PID)”、“查询安全校验码(Key)”

 *安全校验码查看时，输入支付密码后，页面呈灰色的现象，怎么办？
 *解决方法：
 *1、检查浏览器配置，不让浏览器做弹框屏蔽设置
 *2、更换浏览器或电脑，重新登录查询。
 */

public class AlipayConfig {
	
	//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	// 合作身份者ID，以2088开头由16位纯数字组成的字符串
	public static final String partner = "2088911945537640";
	// 商户的私钥
	public static final String private_key = "MIIEoAIBADANBgkqhkiG9w0BAQEFAASCBIowggSGAgEAAoH8N71pOh4g41OC5THvk5ZmjkI/ysGXdFU/NK5A0/tVCdOe7uXPS/45zI1WaL0hmfFPQtx7jb+EZHYiOwzXG+3UeewRqeqyYCbygH/eNnfgFh1WFPBXQMHXY+zukmr+3jna2ODBZNW160GNV38wHdU0orT26MGLgA0BO/i5tp4uqKtFln4jLbaBVkdxIdBvGTTdQYq+DqeAQwzaZYnPOtbueB9CYd/m+Sai3TNKUsZwqpSDcoTXoEoFIGeYVkhQMVz6NkkwIKkHG/GrpvGJ+OKgk5f4MNbZDV5Ksx1uF2+hMbcJ0ueoW61O0coHZTu0/qDZ9wl6tWaysda1FWO/AgMBAAECgfwzOXqu0mlfAKxWfWGyvJFbQz7k0qyhWIZRn6IsLdmkwjpZShELwYLUnT8/2jA7DSzOQVm6lrrQqFAk/FPjctnFglFpWiq7eo950Aki/V+Ocz9c1tMYzAtp5aAKJxI6n+ijT0nrpQsePIvsURKjGADbVntixBuzfkAYIShqz0suEzXrOjPSeflN7HOK58KHt3pc6zA8zG2QJsImDZPwpLMutfM1RwofNzaQFTHaux2ZQKLuLVPhZtNPhU6X0vt2NqjcDoqyCPh7FWlqVH1s/Bn9YhrVrseFsAwOhqI0qnYYb07rGuHVdTIeCqCKTpYlynC79ykSD7GuklH3FgECfn3Z9mbEvRnJripZlCRiGEbKx1Iu4gm3u9jeCyk0NfbIU1tXQtTD1DKd/5ThTqArXT30YDkQLzABSkIQpvJ5VPkyN1zoRqJCZ3WjsTqdXNbq/gi3+UiVXf1dk8HqbzZE5u7IyjVDmLJCbfhjksDx03KcvyjxE0hl2zz+DtAZQQJ+cWIMQYZc02liBfkcxHXHqrS/+IzjcwFNpyafKtt/ma08YSRG+uqZk0RQ5L1++IxREnz1pZ8nhHQ8NdAFyZwy/4HVJhgqY154DTXD4bPzLvNNw4830GUhACigxw6Bj3PBtonntHMxejlRsfPIY9IMcQgBI4OdVYmFs25MoTz/An58HoooAuKpW0H9HInBdEmTEAySnhBqGx4VnbAOPCL4t8uWKzKLWnOeVDssHyWHTB1SrAB2ZuLTCoKtM3UjcMyAVKlLZP28q5cT65QwReC5Sduux5sAneerqS2/szFpqXzEhZz/+SHQtTl2HuYuipHK2JKjk1c8MNCPj9UWIcECfiXTeBNEKCO/vJwRh69jO8GPm5voJNlxTd6928wIfoFecg5Wc/ex3Jps6C/nqDxzU3i/h5RBjIV74bpyM/wWyEzFm76hwUJ1eceucDMUPcUkFoVvekdj9aZ/52OBS2f4Tl//kfV5mMAV71NW6TukD9KFwRuABTVMM/awjZAdMQJ+J/ihvmPvy/dCIWGylsZ165TpZd2T81RfWkklRfFLXgauG+jFDC8W1mjEPnWqxoB6R21v9/PyP5KYGsalqqzNG7esw9ROVNUFQeUDFwF7i+MtsR9UCQVBKn2s9Fc1h9xFLiWow7m5TbRNUcNnd3HD/4eXWuzaZo6Q2OsesIhV";
	
	// 支付宝的公钥，无需修改该值
	public static final String ali_public_key  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";

	//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	

	// 调试用，创建TXT日志文件夹路径
	public static final String log_path = "/aliyun/log/webapps/c2/account/";

	// 字符编码格式 目前支持 gbk 或 utf-8
	public static final String input_charset = "utf-8";
	
	// 签名方式 不需修改
	public static final String sign_type = "RSA";

}
