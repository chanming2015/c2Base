/**
 * Author XuMaoSen
 */
package com.qingbo.c2.account.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qingbo.c2.account.repository.RefundResDataRepository;
import com.qingbo.c2.account.service.RefundResDataService;
import com.qingbo.ginkgo.base.service.QueuingService;
import com.qingbo.ginkgo.common.result.ErrorMessage;
import com.qingbo.ginkgo.common.result.Result;
import com.qingbo.ginkgo.common.util.sql.SpecParam;
import com.qingbo.ginkgo.common.util.sql.SpecUtil;
import com.tencent.protocol.refund_protocol.RefundResData;

/**
 * Project:c2-account
 * Package:com.qingbo.c2.account.service.impl
 * FileName:RefundResDataServiceImpl.java
 * Comments:
 * JDK Version:
 * Author XuMaoSen
 * Create Date:2015年9月29日 下午1:34:37
 * Modified By:XuMaoSen
 * Modified Time:
 * What is Modified:
 * Description:
 * Version:
 */
@Service("refundResDataService")
public class RefundResDataServiceImpl implements RefundResDataService {
	
	private static final String QUEUING_MAKE_SRC = "03";
	@Autowired private QueuingService queuingService;
	@Autowired private RefundResDataRepository refundResDataRepository;
	private ErrorMessage errorResult = new ErrorMessage("c2-errorcode.properties");

	/** @author XuMaoSen 
	 */
	@Override
	public Result<RefundResData> getRefundResData(Long id) {

		Result<RefundResData> result;
		// 参数校验
		if(id == null) {
			result = errorResult.newFailure("CMS1499", "id");
			return result;
		}
		
		// 执行查询
		RefundResData refundResData = null;
		try{
			refundResData = refundResDataRepository.findOne(id);
		}catch(Exception e){
			result = errorResult.newFailure("CMS0021");
			return result;
		}
		// 返回结果
		result = Result.newSuccess(refundResData);
		return result;
	}

	/** @author XuMaoSen 
	 */
	@Override
	public Result<RefundResData> createRefundResData(RefundResData refundResData) {

		Result<RefundResData> result;
		// 校验参数
		if(refundResData == null){
			result = errorResult.newFailure("CMS1499", RefundResData.class.toString());
			return result;
		}
		// 准备序列号
		Result<Long> runAccountQueuing = queuingService.next(QUEUING_MAKE_SRC);
	    if(runAccountQueuing.getError() != null ){
	    	return errorResult.newFailure("CMS0032");
	    }
		// 持久对象
	    RefundResData refundResDataSaved = null;
		try{
			refundResData.setId(runAccountQueuing.getObject());
			refundResDataSaved = refundResDataRepository.save(refundResData);
			
		}catch(Exception e){
			result = errorResult.newFailure("CMS0171");
			return result;
		}
		// 返回结果
		result = Result.newSuccess(refundResDataSaved);
		return result;
	}

	/** @author XuMaoSen 
	 */
	@Override
	public Result<List<RefundResData>> listRefundResDatas(
			SpecParam<RefundResData> specs) {

		Result<List<RefundResData>> result;
		// 参数校验
		if(specs == null){
			result = errorResult.newFailure("CMS1499", "specs");
			return result;
		}
		specs.eq("deleted", false);
		List<RefundResData> scanPayResDatas = refundResDataRepository.findAll(SpecUtil.spec(specs));
		// 返回结果
		result = Result.newSuccess(scanPayResDatas);
		return result;
	}

}
