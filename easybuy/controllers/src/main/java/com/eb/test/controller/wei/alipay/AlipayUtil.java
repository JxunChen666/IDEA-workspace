package com.eb.test.controller.wei.alipay;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;

public class AlipayUtil {
	
	public static String connect(AliBean alipayBean) throws AlipayApiException{
		 //1、获得初始化的AlipayClient
		    AlipayClient alipayClient = new DefaultAlipayClient(
		        Config.getKey("gatewayUrl"),//支付宝网关
		        Config.getKey("app_id"),//appid
		        Config.getKey("merchant_private_key"),//商户私钥
		        "json",
		        Config.getKey("charset"),//字符编码格式
		        Config.getKey("alipay_public_key"),//支付宝公钥
		        Config.getKey("sign_type")//签名方式
		     );
		/*
		 * System.err.println(Config.getKey("gatewayUrl"));
		 * System.err.println(Config.getKey("app_id"));
		 * System.err.println(Config.getKey("merchant_private_key"));
		 * System.err.println(Config.getKey("charset"));
		 * System.err.println(Config.getKey("alipay_public_key"));
		 * System.err.println(Config.getKey("sign_type"));
		 */
		    //2、设置请求参数
		    AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		    //页面跳转同步通知页面路径
		    alipayRequest.setReturnUrl(Config.getKey("return_url"));
		    // 服务器异步通知页面路径
		    alipayRequest.setNotifyUrl(Config.getKey("notify_url"));
		    //封装参数
		    alipayRequest.setBizContent(JSON.toJSONString(alipayBean));
		    //3、请求支付宝进行付款，并获取支付结果
		    //String resultjsoninfo = JSON.toJSONString(alipayBean);
		    //System.out.println(resultjsoninfo);
		    String result = alipayClient.pageExecute(alipayRequest).getBody();
		    //返回付款信息
		    System.out.println(result);
		    return result;
	}
}
