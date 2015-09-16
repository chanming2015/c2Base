/*
 *www.shequ2.com
 *Copyright (c) 2015 All Rights Reserved
 */
/**
 * Author XuMaoSen
 */
package com.qingbo.c2.account.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.qingbo.ginkgo.base.entity.BaseEntity;

/**
 * Project:c2-account
 * Package:com.c2.account.entity
 * FileName:RunAccount.java
 * Comments:
 * JDK Version:
 * Author XuMaoSen
 * Create Date:2015年8月24日 下午5:17:42
 * Modified By:XuMaoSen
 * Modified Time:
 * What is Modified:
 * Description:
 * Version:
 */
@Entity
public class RunAccount extends BaseEntity {

	private static final long serialVersionUID = -26036261151549381L;
	
	private Long userId;                 // 用户id
	@Column(insertable=false)
	private BigDecimal accountBalance;   // 账户余额

	/**
	 * Author XuMaoSen
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * Author XuMaoSen
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * Author XuMaoSen
	 * @return the accountBalance
	 */
	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	/**
	 * Author XuMaoSen
	 * @param accountBalance the accountBalance to set
	 */
	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

}
