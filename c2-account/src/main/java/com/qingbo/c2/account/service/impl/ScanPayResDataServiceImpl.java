/**
 * Author XuMaoSen
 */
package com.qingbo.c2.account.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qingbo.c2.account.entity.RunAccount;
import com.qingbo.c2.account.repository.ScanPayResDataRepository;
import com.qingbo.c2.account.service.ScanPayResDataService;
import com.qingbo.ginkgo.base.service.QueuingService;
import com.qingbo.ginkgo.common.result.ErrorMessage;
import com.qingbo.ginkgo.common.result.Result;
import com.qingbo.ginkgo.common.util.sql.SpecParam;
import com.qingbo.ginkgo.common.util.sql.SpecUtil;
import com.tencent.protocol.pay_protocol.ScanPayResData;

/**
 * Project:c2-account
 * Package:com.qingbo.c2.account.service.impl
 * FileName:ScanPayResDataServiceImpl.java
 * Comments:
 * JDK Version:
 * Author XuMaoSen
 * Create Date:2015年9月22日 下午3:52:10
 * Modified By:XuMaoSen
 * Modified Time:
 * What is Modified:
 * Description:
 * Version:
 */
@Service("scanPayResDataService")
public class ScanPayResDataServiceImpl implements ScanPayResDataService {
	
	private static final String QUEUING_MAKE_SRC = "03";
	@Autowired private QueuingService queuingService;
	@Autowired private ScanPayResDataRepository scanPayResDataRepository;
	private ErrorMessage errorResult = new ErrorMessage("c2-errorcode.properties");

	/** @author XuMaoSen 
	 */
	@Override
	public Result<ScanPayResData> getScanPayResData(Long id) {

		Result<ScanPayResData> result;
		// 参数校验
		if(id == null) {
			result = errorResult.newFailure("CMS1499", "id");
			return result;
		}
		
		// 执行查询
		ScanPayResData scanPayResData = null;
		try{
			scanPayResData = scanPayResDataRepository.findOne(id);
		}catch(Exception e){
			result = errorResult.newFailure("CMS0021");
			return result;
		}
		// 返回结果
		result = Result.newSuccess(scanPayResData);
		return result;
	}

	/** @author XuMaoSen 
	 */
	@Override
	public Result<ScanPayResData> createScanPayResData(	ScanPayResData scanPayResData) {

		Result<ScanPayResData> result;
		// 校验参数
		if(scanPayResData == null){
			result = errorResult.newFailure("CMS1499", RunAccount.class.toString());
			return result;
		}
		// 准备序列号
		Result<Long> runAccountQueuing = queuingService.next(QUEUING_MAKE_SRC);
	    if(runAccountQueuing.getError() != null ){
	    	return errorResult.newFailure("CMS0032");
	    }
		// 持久对象
	    ScanPayResData scanPayResDataSaved = null;
		try{
			scanPayResData.setId(runAccountQueuing.getObject());
			scanPayResDataSaved = scanPayResDataRepository.save(scanPayResData);
			
		}catch(Exception e){
			result = errorResult.newFailure("CMS0171");
			return result;
		}
		// 返回结果
		result = Result.newSuccess(scanPayResDataSaved);
		return result;
	}

	/** @author XuMaoSen 
	 */
	@Override
	public Result<List<ScanPayResData>> listScanPayResDatas(SpecParam<ScanPayResData> specs) {

		Result<List<ScanPayResData>> result;
		// 参数校验
		if(specs == null){
			result = errorResult.newFailure("CMS1499", "specs");
			return result;
		}
		specs.eq("deleted", false);
		List<ScanPayResData> scanPayResDatas = scanPayResDataRepository.findAll(SpecUtil.spec(specs));
		// 返回结果
		result = Result.newSuccess(scanPayResDatas);
		return result;
	}

}
