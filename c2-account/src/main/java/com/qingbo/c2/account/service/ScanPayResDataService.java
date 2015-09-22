/**
 * Author XuMaoSen
 */
package com.qingbo.c2.account.service;

import java.util.List;

import com.qingbo.ginkgo.common.result.Result;
import com.qingbo.ginkgo.common.util.sql.SpecParam;
import com.tencent.protocol.pay_protocol.ScanPayResData;

/**
 * Project:c2-account
 * Package:com.qingbo.c2.account.service
 * FileName:ScanPayResDataService.java
 * Comments:
 * JDK Version:
 * Author XuMaoSen
 * Create Date:2015年9月22日 下午3:48:49
 * Modified By:XuMaoSen
 * Modified Time:
 * What is Modified:
 * Description:
 * Version:
 */
public interface ScanPayResDataService {

	Result<ScanPayResData> getScanPayResData(Long id);
	Result<ScanPayResData> createScanPayResData(ScanPayResData scanPayResData);
	Result<List<ScanPayResData>> listScanPayResDatas(SpecParam<ScanPayResData> specs);
}
