package com.eb.test.servicesDao.qiang;

import java.util.List;

import com.eb.test.model.EasybuyOrder;

public interface IBackstageOrderService {
	
	//查找所有订单信息
	List<EasybuyOrder> selectAllOrder();
	
	boolean updateOrderdq(int id,int row);
}
