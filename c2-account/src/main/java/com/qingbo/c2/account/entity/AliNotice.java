/*
 *www.shequ2.com
 *Copyright (c) 2015 All Rights Reserved
 */
/**
 * Author XuMaoSen
 */
package com.qingbo.c2.account.entity;

import javax.persistence.Entity;
import javax.persistence.Transient;

import com.qingbo.ginkgo.base.entity.BaseEntity;

/**
 * Project:c2-account
 * Package:com.qingbo.c2.account.entity
 * FileName:AliNotice.java
 * Comments:
 * JDK Version:
 * Author XuMaoSen
 * Create Date:2015年8月26日 下午3:50:57
 * Modified By:XuMaoSen
 * Modified Time:
 * What is Modified:
 * Description:
 * Version:
 */
@Entity
public class AliNotice extends BaseEntity{

	private static final long serialVersionUID = -8992327880269847247L;
	
	private String notify_time;            // 通知时间  通知的发送时间，格式为 yyyy-MM-dd HH:mm:ss。
	private String notify_type;            // 通知类型 trade_status_sync
	private String notify_id;              // 通知校验 ID 64ce1b6ab92d00ede0ee56ade98fdf2f4c
	private String sign_type;              // 签名方式 RSA
	@Transient private String sign;        // 签名
	private String out_trade_no;           // 商户网站唯一订单号
	private String subject;                // 商品名称
	private String payment_type;           // 支付类型。默认值为：1（商品	购买）
	private String trade_no;               // 该交易在支付宝系统中的交易流水号。最短 16 位，最长 64 位
	private String trade_status;           // 交易状态，取值范围请参见“11.3 交易状态”。
	private String seller_id;              // 卖家支付宝账号对应的支付宝唯一用户号。以 2088 开头的纯 16 位数字。
	private String seller_email;           // 卖家支付宝账号，可以是 email和手机号码。
	private String buyer_id;               // 买家支付宝账号对应的支付宝唯一用户号。以 2088 开头的纯 16 位数字。
	private String buyer_email;            // 买家支付宝账号，可以是 Email或手机号码。
	private String total_fee;              // 交易金额
	private String quantity;               // 购买数量
	private String price;                  // 商品单价
	private String body;                   // 商品描述
	private String gmt_create;             // 交易创建时间
	private String gmt_payment;            // 交易付款时间
	private String refund_status;          // 退款状态
	private String gmt_refund;             // 退款时间
	
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
	 * @return the out_trade_no
	 */
	public String getOut_trade_no() {
		return out_trade_no;
	}
	/**
	 * Author XuMaoSen
	 * @param out_trade_no the out_trade_no to set
	 */
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	/**
	 * Author XuMaoSen
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * Author XuMaoSen
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * Author XuMaoSen
	 * @return the payment_type
	 */
	public String getPayment_type() {
		return payment_type;
	}
	/**
	 * Author XuMaoSen
	 * @param payment_type the payment_type to set
	 */
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
	/**
	 * Author XuMaoSen
	 * @return the trade_no
	 */
	public String getTrade_no() {
		return trade_no;
	}
	/**
	 * Author XuMaoSen
	 * @param trade_no the trade_no to set
	 */
	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}
	/**
	 * Author XuMaoSen
	 * @return the trade_status
	 */
	public String getTrade_status() {
		return trade_status;
	}
	/**
	 * Author XuMaoSen
	 * @param trade_status the trade_status to set
	 */
	public void setTrade_status(String trade_status) {
		this.trade_status = trade_status;
	}
	/**
	 * Author XuMaoSen
	 * @return the seller_id
	 */
	public String getSeller_id() {
		return seller_id;
	}
	/**
	 * Author XuMaoSen
	 * @param seller_id the seller_id to set
	 */
	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
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
	 * @return the buyer_id
	 */
	public String getBuyer_id() {
		return buyer_id;
	}
	/**
	 * Author XuMaoSen
	 * @param buyer_id the buyer_id to set
	 */
	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}
	/**
	 * Author XuMaoSen
	 * @return the buyer_email
	 */
	public String getBuyer_email() {
		return buyer_email;
	}
	/**
	 * Author XuMaoSen
	 * @param buyer_email the buyer_email to set
	 */
	public void setBuyer_email(String buyer_email) {
		this.buyer_email = buyer_email;
	}
	/**
	 * Author XuMaoSen
	 * @return the total_fee
	 */
	public String getTotal_fee() {
		return total_fee;
	}
	/**
	 * Author XuMaoSen
	 * @param total_fee the total_fee to set
	 */
	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}
	/**
	 * Author XuMaoSen
	 * @return the quantity
	 */
	public String getQuantity() {
		return quantity;
	}
	/**
	 * Author XuMaoSen
	 * @param quantity the quantity to set
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	/**
	 * Author XuMaoSen
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * Author XuMaoSen
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * Author XuMaoSen
	 * @return the body
	 */
	public String getBody() {
		return body;
	}
	/**
	 * Author XuMaoSen
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}
	/**
	 * Author XuMaoSen
	 * @return the gmt_create
	 */
	public String getGmt_create() {
		return gmt_create;
	}
	/**
	 * Author XuMaoSen
	 * @param gmt_create the gmt_create to set
	 */
	public void setGmt_create(String gmt_create) {
		this.gmt_create = gmt_create;
	}
	/**
	 * Author XuMaoSen
	 * @return the gmt_payment
	 */
	public String getGmt_payment() {
		return gmt_payment;
	}
	/**
	 * Author XuMaoSen
	 * @param gmt_payment the gmt_payment to set
	 */
	public void setGmt_payment(String gmt_payment) {
		this.gmt_payment = gmt_payment;
	}
	/**
	 * Author XuMaoSen
	 * @return the refund_status
	 */
	public String getRefund_status() {
		return refund_status;
	}
	/**
	 * Author XuMaoSen
	 * @param refund_status the refund_status to set
	 */
	public void setRefund_status(String refund_status) {
		this.refund_status = refund_status;
	}
	/**
	 * Author XuMaoSen
	 * @return the gmt_refund
	 */
	public String getGmt_refund() {
		return gmt_refund;
	}
	/**
	 * Author XuMaoSen
	 * @param gmt_refund the gmt_refund to set
	 */
	public void setGmt_refund(String gmt_refund) {
		this.gmt_refund = gmt_refund;
	}
	
}
