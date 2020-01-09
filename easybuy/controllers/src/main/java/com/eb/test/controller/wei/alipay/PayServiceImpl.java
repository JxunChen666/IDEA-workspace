package com.eb.test.controller.wei.alipay;

import org.springframework.stereotype.Service;

import com.alipay.api.AlipayApiException;

@Service(value="alipayOrderService")
public class PayServiceImpl implements PayService{

	@Override
	public String aliPay(AliBean alipayBean) throws AlipayApiException {
		// TODO Auto-generated method stub
		return AlipayUtil.connect(alipayBean);
	}

}
