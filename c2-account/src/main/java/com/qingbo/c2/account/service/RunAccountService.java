/*
 *www.shequ2.com
 *Copyright (c) 2015 All Rights Reserved
 */
/**
 * Author XuMaoSen
 */
package com.qingbo.c2.account.service;

import java.util.List;

import com.qingbo.c2.account.entity.RunAccount;
import com.qingbo.ginkgo.common.result.Result;
import com.qingbo.ginkgo.common.util.sql.SpecParam;

/**
 * Project:c2-account
 * Package:com.c2.account.service
 * FileName:RunAccountService.java
 * Comments:
 * JDK Version:
 * Author XuMaoSen
 * Create Date:2015年8月24日 下午5:54:30
 * Modified By:XuMaoSen
 * Modified Time:
 * What is Modified:
 * Description:
 * Version:
 */
public interface RunAccountService {

	Result<RunAccount> getRunAccount(Long id);
	Result<RunAccount> getRunAccountByUserId(Long userId);
	Result<RunAccount> createRunAccount(RunAccount runAccount);
	Result<RunAccount> updateRunAccount(RunAccount runAccount);
	Result<Boolean> deleteRunAccount(Long id);
	Result<List<RunAccount>> listRunAccounts(SpecParam<RunAccount> specs);
}
