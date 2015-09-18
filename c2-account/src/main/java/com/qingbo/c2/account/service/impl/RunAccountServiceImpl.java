/*
 *www.shequ2.com
 *Copyright (c) 2015 All Rights Reserved
 */
/**
 * Author XuMaoSen
 */
package com.qingbo.c2.account.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qingbo.c2.account.entity.RunAccount;
import com.qingbo.c2.account.repository.RunAccountRepository;
import com.qingbo.c2.account.service.RunAccountService;
import com.qingbo.ginkgo.base.service.QueuingService;
import com.qingbo.ginkgo.common.result.ErrorMessage;
import com.qingbo.ginkgo.common.result.Result;
import com.qingbo.ginkgo.common.util.sql.SpecParam;
import com.qingbo.ginkgo.common.util.sql.SpecUtil;

/**
 * Project:c2-account
 * Package:com.c2.account.service.impl
 * FileName:RunAccountServiceImpl.java
 * Comments:
 * JDK Version:
 * Author XuMaoSen
 * Create Date:2015年8月25日 上午11:00:35
 * Modified By:XuMaoSen
 * Modified Time:
 * What is Modified:
 * Description:
 * Version:
 */
@Service("runAccountService")
public class RunAccountServiceImpl implements RunAccountService {
	
	private static final String QUEUING_MAKE_SRC = "03";
	@Autowired private QueuingService queuingService;
	@Autowired private RunAccountRepository runAccountRepository;
	private ErrorMessage errorResult = new ErrorMessage("c2-errorcode.properties");

	/** @author XuMaoSen 
	 */
	@Override
	public Result<RunAccount> getRunAccount(Long id) {

		Result<RunAccount> result;
		// 参数校验
		if(id == null) {
			result = errorResult.newFailure("CMS1499", "id");
			return result;
		}
		
		// 执行查询
		RunAccount RunJob = null;
		try{
			RunJob = runAccountRepository.findOne(id);
		}catch(Exception e){
			result = errorResult.newFailure("CMS0021");
			return result;
		}
		// 返回结果
		result = Result.newSuccess(RunJob);
		return result;
	}

	/** @author XuMaoSen 
	 */
	@Override
	public Result<RunAccount> createRunAccount(RunAccount runAccount) {

		Result<RunAccount> result;
		// 校验参数
		if(runAccount == null){
			result = errorResult.newFailure("CMS1499", RunAccount.class.toString());
			return result;
		}
		if(runAccount.getUserId() == null){
			result = errorResult.newFailure("CMS1499", "userId");
			return result;
		}
		// 准备序列号
		Result<Long> runAccountQueuing = queuingService.next(QUEUING_MAKE_SRC);
	    if(runAccountQueuing.getError() != null ){
	    	return errorResult.newFailure("CMS0032");
	    }
		// 持久对象
	    RunAccount runAccountSaved = null;
		try{
			runAccount.setId(runAccountQueuing.getObject());
			runAccountSaved = runAccountRepository.save(runAccount);
			
		}catch(Exception e){
			result = errorResult.newFailure("CMS0171");
			return result;
		}
		// 返回结果
		result = Result.newSuccess(runAccountSaved);
		return result;
	}

	/** @author XuMaoSen 
	 */
	@Override
	public Result<RunAccount> updateRunAccount(RunAccount runAccount) {

		Result<RunAccount> result;
		// 校验参数
		if(runAccount == null){
			result = errorResult.newFailure("CMS1499", "runAccount");
			return result;
		}
		if(runAccount.getId() == null){
			result = errorResult.newFailure("CMS1499", "id");
			return result;
		}
		RunAccount runAccountFetched;
		try{
			// 准备对象
			runAccountFetched = runAccountRepository.findOne(runAccount.getId());
			runAccountFetched.setAccountBalance(runAccount.getAccountBalance() == null ? runAccountFetched.getAccountBalance() : runAccount.getAccountBalance());
			// 持久对象
			runAccountRepository.save(runAccountFetched);
		}catch(Exception e){
			result = errorResult.newFailure("CMS0041");
			return result;
		}
		// 返回结果
		result = Result.newSuccess(runAccountFetched);
		return result;
	}

	/** @author XuMaoSen 
	 */
	@Override
	public Result<Boolean> deleteRunAccount(Long id) {

		Result<Boolean> result;
		// 参数校验
		if(id == null){
			result = errorResult.newFailure("CMS1499", "id");
			return result;
		}
		// 准备对象
		RunAccount runAccount = runAccountRepository.findOne(id);
		if(runAccount != null){
			runAccount.setDeleted(true);
		}
		// 持久化操作
		try{
			runAccountRepository.save(runAccount);
		}catch(Exception e){
			result = errorResult.newFailure("CMS0191");
			return result;
		}	
		// 返回结果
		result = Result.newSuccess(true);
		return result;
	}

	/** @author XuMaoSen 
	 */
	@Override
	public Result<List<RunAccount>> listRunAccounts(SpecParam<RunAccount> specs) {

		Result<List<RunAccount>> result;
		// 参数校验
		if(specs == null){
			result = errorResult.newFailure("CMS1499", "specs");
			return result;
		}
		specs.eq("deleted", false);
		List<RunAccount> runAccounts = runAccountRepository.findAll(SpecUtil.spec(specs));
		// 返回结果
		result = Result.newSuccess(runAccounts);
		return result;
	}

	/** @author XuMaoSen 
	 */
	@Override
	public Result<RunAccount> getRunAccountByUserId(Long userId) {
		
		Result<RunAccount> result;
		// 参数校验
		if(userId == null) {
			result = errorResult.newFailure("CMS1499", "id");
			return result;
		}
		
		// 执行查询
		RunAccount RunJob = null;
		try{
			RunJob = runAccountRepository.findByUserId(userId);
		}catch(Exception e){
			result = errorResult.newFailure("CMS0021");
			return result;
		}
		// 返回结果
		result = Result.newSuccess(RunJob);
		return result;
	}

}
