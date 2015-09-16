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
 * FileName:AliRefundNotice.java
 * Comments:
 * JDK Version:
 * Author XuMaoSen
 * Create Date:2015年9月7日 上午10:35:58
 * Modified By:XuMaoSen
 * Modified Time:
 * What is Modified:
 * Description:
 * Version:
 */
@Entity
public class AliRefundNotice extends BaseEntity {

	private static final long serialVersionUID = 1723335881396417794L;
	private String notify_time;            // 通知时间  通知的发送时间，格式为 yyyy-MM-dd HH:mm:ss。
	private String notify_type;            // 通知类型 trade_status_sync
	private String notify_id;              // 通知校验 ID 64ce1b6ab92d00ede0ee56ade98fdf2f4c
	private String sign_type;              // 签名方式 RSA
	private String sign;                   // 签名
	private String batch_no;               // 退款批次号
	private String success_num;            // 退款成功总数
	private String result_details;         // 退款结果明细
	
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
	 * @return the success_num
	 */
	public String getSuccess_num() {
		return success_num;
	}
	/**
	 * Author XuMaoSen
	 * @param success_num the success_num to set
	 */
	public void setSuccess_num(String success_num) {
		this.success_num = success_num;
	}
	/**
	 * Author XuMaoSen
	 * @return the result_details
	 */
	public String getResult_details() {
		return result_details;
	}
	/**
	 * Author XuMaoSen
	 * @param result_details the result_details to set
	 */
	public void setResult_details(String result_details) {
		this.result_details = result_details;
	}

}
