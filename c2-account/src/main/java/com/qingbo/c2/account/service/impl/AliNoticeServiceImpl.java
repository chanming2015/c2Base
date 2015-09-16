/*
 *www.shequ2.com
 *Copyright (c) 2015 All Rights Reserved
 */
/**
 * Author XuMaoSen
 */
package com.qingbo.c2.account.service.impl;

import java.util.List;

import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qingbo.c2.account.entity.AliNotice;
import com.qingbo.c2.account.repository.AliNoticeRepository;
import com.qingbo.c2.account.service.AliNoticeService;
import com.qingbo.ginkgo.base.service.QueuingService;
import com.qingbo.ginkgo.common.result.ErrorMessage;
import com.qingbo.ginkgo.common.result.Result;
import com.qingbo.ginkgo.common.util.sql.SpecParam;
import com.qingbo.ginkgo.common.util.sql.SpecUtil;

/**
 * Project:c2-account
 * Package:com.qingbo.c2.account.service.impl
 * FileName:AliNoticeServiceImpl.java
 * Comments:
 * JDK Version:
 * Author XuMaoSen
 * Create Date:2015年9月7日 下午2:52:59
 * Modified By:XuMaoSen
 * Modified Time:
 * What is Modified:
 * Description:
 * Version:
 */
@Service("aliNoticeService")
public class AliNoticeServiceImpl implements AliNoticeService {
	
	@Autowired private AliNoticeRepository aliNoticeRepository;
	private static final String QUEUING_MAKE_SRC = "03";
	@Autowired private QueuingService queuingService;
	private ErrorMessage errorResult = new ErrorMessage("c2-errorcode.properties");

	/** @author XuMaoSen 
	 */
	@Override
	public Result<AliNotice> getAliNotice(Long id) {

		Result<AliNotice> result;
		// 参数校验
		if(id == null) {
			result = errorResult.newFailure("CMS1499", "id");
			return result;
		}
		
		// 执行查询
		AliNotice aliNotice = null;
		try{
			aliNotice = aliNoticeRepository.findOne(id);
		}catch(Exception e){
			result = errorResult.newFailure("CMS0021");
			return result;
		}
		// 返回结果
		result = Result.newSuccess(aliNotice);
		return result;
	}

	/** @author XuMaoSen 
	 */
	@Override
	public Result<AliNotice> createAliNotice(AliNotice aliNotice) {

		Result<AliNotice> result;
		// 校验参数
		if(aliNotice == null){
			result = errorResult.newFailure("CMS1499", AliNotice.class.toString());
			return result;
		}
		if(TextUtils.isEmpty(aliNotice.getNotify_id())){
			result = errorResult.newFailure("CMS1499", "notify_id");
			return result;
		}
		if(TextUtils.isEmpty(aliNotice.getNotify_time())){
			result = errorResult.newFailure("CMS1499", "notify_time");
			return result;
		}
		if(TextUtils.isEmpty(aliNotice.getNotify_type())){
			result = errorResult.newFailure("CMS1499", "notify_type");
			return result;
		}
		if(TextUtils.isEmpty(aliNotice.getSign_type())){
			result = errorResult.newFailure("CMS1499", "sign_type");
			return result;
		}
		// 准备序列号
		Result<Long> runUserQueuing = queuingService.next(QUEUING_MAKE_SRC);
	    if(runUserQueuing.getError() != null ){
	    	return errorResult.newFailure("CMS0032");
	    }
		// 持久对象
	    AliNotice aliNoticeSaved = null;
		try{
			aliNotice.setId(runUserQueuing.getObject());
			aliNoticeSaved = aliNoticeRepository.save(aliNotice);
		}catch(Exception e){
			result = errorResult.newFailure("CMS0171");
			return result;
		}
		// 返回结果
		result = Result.newSuccess(aliNoticeSaved);
		return result;
	}

	/** @author XuMaoSen 
	 */
	@Override
	public Result<List<AliNotice>> listAliNotices(SpecParam<AliNotice> specs) {

		Result<List<AliNotice>> result;
		// 参数校验
		if(specs == null){
			result = errorResult.newFailure("CMS1499", "specs");
			return result;
		}
		specs.eq("deleted", false);
		List<AliNotice> runUsers = aliNoticeRepository.findAll(SpecUtil.spec(specs));
		// 返回结果
		result = Result.newSuccess(runUsers);
		return result;
	}

}
