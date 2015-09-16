/*
 *www.shequ2.com
 *Copyright (c) 2015 All Rights Reserved
 */
/**
 * Author XuMaoSen
 */
package com.qingbo.c2.account.entity;

/**
 * Project:c2-account
 * Package:com.qingbo.c2.account.entity
 * FileName:BatchRefund.java
 * Comments:
 * JDK Version:
 * Author XuMaoSen
 * Create Date:2015年9月2日 下午4:44:07
 * Modified By:XuMaoSen
 * Modified Time:
 * What is Modified:
 * Description: 批量退款实体
 * Version:
 */
public class BatchEntity {
	
	private String seller_email;           // 卖家支付宝账号，可以是 email和手机号码。
	private String refund_date;            // 退款请求时间 2011-01-12 11:21:00
	private String batch_no;               // 批次号 201101120001
	private String batch_num;              // 总笔数  1
	private String detail_data;            // 单笔数据集 2011011201037066^5.	00^协商退款
	
	private String account_name;           // 付款账号名 付款方的支付宝账户名
	private String batch_fee;              // 付款总金额 20000
	private String email;                  // 付款账号
	private String pay_date;               // 支付日期 20080107
	
	/**
	 * Author XuMaoSen
	 * @return the account_name
	 */
	public String getAccount_name() {
		return account_name;
	}
	/**
	 * Author XuMaoSen
	 * @param account_name the account_name to set
	 */
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	/**
	 * Author XuMaoSen
	 * @return the batch_fee
	 */
	public String getBatch_fee() {
		return batch_fee;
	}
	/**
	 * Author XuMaoSen
	 * @param batch_fee the batch_fee to set
	 */
	public void setBatch_fee(String batch_fee) {
		this.batch_fee = batch_fee;
	}
	/**
	 * Author XuMaoSen
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Author XuMaoSen
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Author XuMaoSen
	 * @return the pay_date
	 */
	public String getPay_date() {
		return pay_date;
	}
	/**
	 * Author XuMaoSen
	 * @param pay_date the pay_date to set
	 */
	public void setPay_date(String pay_date) {
		this.pay_date = pay_date;
	}
	/**
	 * Author XuMaoSen
	 * @return the seller_email
	 */
	public String getSeller_email() {
		return seller_email;
	}
	/**
	 * Author XuMaoSen
	 * @param seller_email the seller_email to set
	 */
	public void setSeller_email(String seller_email) {
		this.seller_email = seller_email;
	}
	/**
	 * Author XuMaoSen
	 * @return the refund_date
	 */
	public String getRefund_date() {
		return refund_date;
	}
	/**
	 * Author XuMaoSen
	 * @param refund_date the refund_date to set
	 */
	public void setRefund_date(String refund_date) {
		this.refund_date = refund_date;
	}
	/**
	 * Author XuMaoSen
	 * @return the batch_no
	 */
	public String getBatch_no() {
		return batch_no;
	}
	/**
	 * Author XuMaoSen
	 * @param batch_no the batch_no to set
	 */
	public void setBatch_no(String batch_no) {
		this.batch_no = batch_no;
	}
	/**
	 * Author XuMaoSen
	 * @return the batch_num
	 */
	public String getBatch_num() {
		return batch_num;
	}
	/**
	 * Author XuMaoSen
	 * @param batch_num the batch_num to set
	 */
	public void setBatch_num(String batch_num) {
		this.batch_num = batch_num;
	}
	/**
	 * Author XuMaoSen
	 * @return the detail_data
	 */
	public String getDetail_data() {
		return detail_data;
	}
	/**
	 * Author XuMaoSen
	 * @param detail_data the detail_data to set
	 */
	public void setDetail_data(String detail_data) {
		this.detail_data = detail_data;
	}

}
