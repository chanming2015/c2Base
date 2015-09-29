/**
 * Author XuMaoSen
 */
package com.tencent.business;

import org.springframework.stereotype.Component;

import com.tencent.business.ScanPayBusiness.ResultListener;
import com.tencent.protocol.pay_protocol.ScanPayResData;
import com.tencent.protocol.pay_query_protocol.ScanPayQueryResData;
import com.tencent.protocol.reverse_protocol.ReverseResData;

/**
 * Project:c2-account
 * Package:com.tencent.business
 * FileName:WeiXinResult.java
 * Comments:
 * JDK Version:
 * Author XuMaoSen
 * Create Date:2015年9月28日 下午3:22:56
 * Modified By:XuMaoSen
 * Modified Time:
 * What is Modified:
 * Description:
 * Version:
 */
@Component
public class WeiXinPayResult implements ResultListener{

	/** @author XuMaoSen 
	 *  API返回ReturnCode不合法，支付请求逻辑错误，请仔细检测传过去的每一个参数是否合法，或是看API能否被正常访问
	 */
	@Override
	public void onFailByReturnCodeError(ScanPayResData scanPayResData) {
	}

	/** @author XuMaoSen 
	 *  API返回ReturnCode为FAIL，支付API系统返回失败，请检测Post给API的数据是否规范合法
	 */
	@Override
	public void onFailByReturnCodeFail(ScanPayResData scanPayResData) {
	}

	/** @author XuMaoSen 
	 *  支付请求API返回的数据签名验证失败，有可能数据被篡改了
	 */
	@Override
	public void onFailBySignInvalid(ScanPayResData scanPayResData) {
	}

	/** @author XuMaoSen 
	 *  查询请求API返回的数据签名验证失败，有可能数据被篡改了
	 */
	@Override
	public void onFailByQuerySignInvalid(ScanPayQueryResData scanPayQueryResData) {
	}

	/** @author XuMaoSen 
	 *  撤销请求API返回的数据签名验证失败，有可能数据被篡改了
	 */
	@Override
	public void onFailByReverseSignInvalid(ReverseResData reverseResData) {
	}

	/** @author XuMaoSen 
	 *  用户用来支付的二维码已经过期，提示收银员重新扫一下用户微信“刷卡”里面的二维码
	 */
	@Override
	public void onFailByAuthCodeExpire(ScanPayResData scanPayResData) {
	}

	/** @author XuMaoSen 
	 *  授权码无效，提示用户刷新一维码/二维码，之后重新扫码支付"
	 */
	@Override
	public void onFailByAuthCodeInvalid(ScanPayResData scanPayResData) {
	}

	/** @author XuMaoSen 
	 *  用户余额不足，换其他卡支付或是用现金支付
	 */
	@Override
	public void onFailByMoneyNotEnough(ScanPayResData scanPayResData) {
	}

	/** @author XuMaoSen 
	 *  支付失败
	 */
	@Override
	public void onFail(ScanPayResData scanPayResData) {
	}

	/** @author XuMaoSen 
	 *  支付成功
	 */
	@Override
	public void onSuccess(ScanPayResData scanPayResData, String transactionID) {
	}

}
