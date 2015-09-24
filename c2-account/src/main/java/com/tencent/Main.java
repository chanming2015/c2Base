package com.tencent;

import com.tencent.common.Util;

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
