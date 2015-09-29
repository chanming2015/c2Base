/**
 * Author XuMaoSen
 */
package com.qingbo.c2.account.service;

import java.util.List;

import com.qingbo.ginkgo.common.result.Result;
import com.qingbo.ginkgo.common.util.sql.SpecParam;
import com.tencent.protocol.refund_protocol.RefundResData;

/**
 * Project:c2-account
 * Package:com.qingbo.c2.account.service
 * FileName:RefundResDataService.java
 * Comments:
 * JDK Version:
 * Author XuMaoSen
 * Create Date:2015年9月29日 下午1:33:25
 * Modified By:XuMaoSen
 * Modified Time:
 * What is Modified:
 * Description:
 * Version:
 */
public interface RefundResDataService {

	Result<RefundResData> getRefundResData(Long id);
	Result<RefundResData> createRefundResData(RefundResData refundResData);
	Result<List<RefundResData>> listRefundResDatas(SpecParam<RefundResData> specs);
}
