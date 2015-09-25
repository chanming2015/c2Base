package com.tencent;

import com.tencent.common.Util;
import com.tencent.protocol.pay_protocol.ScanPayResData;

public class Main {

    public static void main(String[] args) {

        try {

            //--------------------------------------------------------------------
            //温馨提示，第一次使用该SDK时请到com.tencent.common.Configure类里面进行配置
            //--------------------------------------------------------------------
        	
        	String key = "84ef95dr1f584sf498s4f8s4ds84df84";

        	//微信分配的公众号ID（开通公众号之后可以获取到）
        	String appID = "wxc3334da803774c67";

        	//微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）
        	String mchID = "1234720902";

        	//受理模式下给子商户分配的子商户号
        	String subMchID = "";

        	//HTTPS证书的本地路径
        	String certLocalPath = "/aliyun/cert/apiclient_cert.p12";

        	//HTTPS证书密码，默认密码等于商户号MCHID
        	String certPassword = "1234720902";
        	
        	//机器IP
        	String ip = "120.25.215.147";
        	
        	WXPay wp = new WXPay();
        	
        	StringBuffer payServiceResponseString = new StringBuffer("<xml encoding='UTF-8'><appid><![CDATA[wxbf7392ebd1782686]]></appid><attach><![CDATA[token=eeodbq1422333040&wecha_id=oZX3Ws6YW_mPOWzTAM3jqXshmcQU&from=Runner]]></attach><bank_type><![CDATA[CFT]]></bank_type><cash_fee><![CDATA[1]]></cash_fee><fee_type><![CDATA[CNY]]></fee_type><is_subscribe><![CDATA[Y]]></is_subscribe><mch_id><![CDATA[1239271502]]></mch_id><nonce_str><![CDATA[alfgn6mxi28nok21k3h5g5mkk75evwam]]></nonce_str><openid><![CDATA[oZX3Ws6YW_mPOWzTAM3jqXshmcQU]]></openid><out_trade_no><![CDATA[250921155633020004]]></out_trade_no><result_code><![CDATA[SUCCESS]]></result_code><return_code><![CDATA[SUCCESS]]></return_code><sign><![CDATA[849D9E35ADF90F3B99753B70F895BD06]]></sign><time_end><![CDATA[20150924161344]]></time_end><total_fee>1</total_fee><trade_type><![CDATA[JSAPI]]></trade_type><transaction_id><![CDATA[1002520099201509240978597376]]></transaction_id></xml>");
        	ScanPayResData scanPayResData = (ScanPayResData) Util.getObjectFromXML(payServiceResponseString.toString(), ScanPayResData.class);
        	System.out.println("aaa");
//        	wp.initSDKConfiguration(key, appID, mchID, subMchID, certLocalPath, certPassword);
        	
            //--------------------------------------------------------------------
            //PART One:基础组件测试
            //--------------------------------------------------------------------

            //1）https请求可用性测试
//            HTTPSPostRquestWithCert.test();

            //2）测试项目用到的XStream组件，本项目利用这个组件将Java对象转换成XML数据Post给API
//            XStreamTest.test();


            //--------------------------------------------------------------------
            //PART Two:基础服务测试
            //--------------------------------------------------------------------

            //1）测试被扫支付API
//            PayServiceTest.test();

            //2）测试被扫订单查询API
            //PayQueryServiceTest.test();

            //3）测试撤销API
            //温馨提示，测试支付API成功扣到钱之后，可以通过调用PayQueryServiceTest.test()，将支付成功返回的transaction_id和out_trade_no数据贴进去，完成撤销工作，把钱退回来 ^_^v
            //ReverseServiceTest.test();

            //4）测试退款申请API
            //RefundServiceTest.test();

            //5）测试退款查询API
            //RefundQueryServiceTest.test();

            //6）测试对账单API
            //DownloadBillServiceTest.test();


            //本地通过xml进行API数据模拟的时候，先按需手动修改xml各个节点的值，然后通过以下方法对这个新的xml数据进行签名得到一串合法的签名，最后把这串签名放到这个xml里面的sign字段里，这样进行模拟的时候就可以通过签名验证了
           // Util.log(Signature.getSignFromResponseString(Util.getLocalXMLString("/test/com/tencent/business/refundqueryserviceresponsedata/refundquerysuccess2.xml")));

            //Util.log(new Date().getTime());
            //Util.log(System.currentTimeMillis());

        } catch (Exception e){
            Util.log(e.getMessage());
        }

    }

}
