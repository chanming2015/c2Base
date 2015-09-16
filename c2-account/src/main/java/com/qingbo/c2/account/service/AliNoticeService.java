/*
 *www.shequ2.com
 *Copyright (c) 2015 All Rights Reserved
 */
/**
 * Author XuMaoSen
 */
package com.qingbo.c2.account.service;

import java.util.List;

import com.qingbo.c2.account.entity.AliNotice;
import com.qingbo.ginkgo.common.result.Result;
import com.qingbo.ginkgo.common.util.sql.SpecParam;

/**
 * Project:c2-account
 * Package:com.c2.account.service
 * FileName:AliNoticeService.java
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
public interface AliNoticeService {

	Result<AliNotice> getAliNotice(Long id);
	Result<AliNotice> createAliNotice(AliNotice aliNotice);
	Result<List<AliNotice>> listAliNotices(SpecParam<AliNotice> specs);
}
