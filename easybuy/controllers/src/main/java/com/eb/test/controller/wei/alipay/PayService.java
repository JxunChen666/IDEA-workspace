package com.eb.test.controller.wei.alipay;

import com.alipay.api.AlipayApiException;

public interface PayService {
	 String aliPay(AliBean alipayBean) throws AlipayApiException;
}
