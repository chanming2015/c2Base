/*
 *www.shequ2.com
 *Copyright (c) 2015 All Rights Reserved
 */
/**
 * Author XuMaoSen
 */
package com.qingbo.c2.account.entity;

import javax.persistence.Entity;

import com.qingbo.ginkgo.base.entity.BaseEntity;

/**
 * Project:c2-account
 * Package:com.qingbo.c2.account.entity
 * FileName:AliTransNotice.java
 * Comments:
 * JDK Version:
 * Author XuMaoSen
 * Create Date:2015年9月7日 上午10:39:51
 * Modified By:XuMaoSen
 * Modified Time:
 * What is Modified:
 * Description:
 * Version:
 */
@Entity
public class AliTransNotice extends BaseEntity {

	private static final long serialVersionUID = 3253250858070391058L;
	private String notify_time;            // 通知时间  通知的发送时间，格式为 yyyy-MM-dd HH:mm:ss。
	private String notify_type;            // 通知类型 trade_status_sync
	private String notify_id;              // 通知校验 ID 64ce1b6ab92d00ede0ee56ade98fdf2f4c
	private String sign_type;              // 签名方式 RSA
	private String sign;                   // 签名
	private String batch_no;               // 付款批次号
	private String pay_user_id;            // 付款账号ID
	private String pay_user_name;          // 付款账号姓名
	private String pay_account_no;         // 付款账号
	private String success_details;        // 转账成功的详细信息
	private String fail_details;           // 转账失败的详细信息
	/**
	 * Author XuMaoSen
	 * @return the notify_time
	 */
	public String getNotify_time() {
		return notify_time;
	}
	/**
	 * Author XuMaoSen
	 * @param notify_time the notify_time to set
	 */
	public void setNotify_time(String notify_time) {
		this.notify_time = notify_time;
	}
	/**
	 * Author XuMaoSen
	 * @return the notify_type
	 */
	public String getNotify_type() {
		return notify_type;
	}
	/**
	 * Author XuMaoSen
	 * @param notify_type the notify_type to set
	 */
	public void setNotify_type(String notify_type) {
		this.notify_type = notify_type;
	}
	/**
	 * Author XuMaoSen
	 * @return the notify_id
	 */
	public String getNotify_id() {
		return notify_id;
	}
	/**
	 * Author XuMaoSen
	 * @param notify_id the notify_id to set
	 */
	public void setNotify_id(String notify_id) {
		this.notify_id = notify_id;
	}
	/**
	 * Author XuMaoSen
	 * @return the sign_type
	 */
	public String getSign_type() {
		return sign_type;
	}
	/**
	 * Author XuMaoSen
	 * @param sign_type the sign_type to set
	 */
	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}
	/**
	 * Author XuMaoSen
	 * @return the sign
	 */
	public String getSign() {
		return sign;
	}
	/**
	 * Author XuMaoSen
	 * @param sign the sign to set
	 */
	public void setSign(String sign) {
		this.sign = sign;
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
	 * @return the pay_user_id
	 */
	public String getPay_user_id() {
		return pay_user_id;
	}
	/**
	 * Author XuMaoSen
	 * @param pay_user_id the pay_user_id to set
	 */
	public void setPay_user_id(String pay_user_id) {
		this.pay_user_id = pay_user_id;
	}
	/**
	 * Author XuMaoSen
	 * @return the pay_user_name
	 */
	public String getPay_user_name() {
		return pay_user_name;
	}
	/**
	 * Author XuMaoSen
	 * @param pay_user_name the pay_user_name to set
	 */
	public void setPay_user_name(String pay_user_name) {
		this.pay_user_name = pay_user_name;
	}
	/**
	 * Author XuMaoSen
	 * @return the pay_account_no
	 */
	public String getPay_account_no() {
		return pay_account_no;
	}
	/**
	 * Author XuMaoSen
	 * @param pay_account_no the pay_account_no to set
	 */
	public void setPay_account_no(String pay_account_no) {
		this.pay_account_no = pay_account_no;
	}
	/**
	 * Author XuMaoSen
	 * @return the success_details
	 */
	public String getSuccess_details() {
		return success_details;
	}
	/**
	 * Author XuMaoSen
	 * @param success_details the success_details to set
	 */
	public void setSuccess_details(String success_details) {
		this.success_details = success_details;
	}
	/**
	 * Author XuMaoSen
	 * @return the fail_details
	 */
	public String getFail_details() {
		return fail_details;
	}
	/**
	 * Author XuMaoSen
	 * @param fail_details the fail_details to set
	 */
	public void setFail_details(String fail_details) {
		this.fail_details = fail_details;
	}

}
