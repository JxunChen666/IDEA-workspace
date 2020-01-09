package com.eb.test.servicesDao.cheng;


import java.util.List;


import com.eb.test.model.EasybuyOrder;



/**
 * 
 * @author ChenYan
 *  订单业务接口
 */


public interface Member_OrderDao {
     
	 
    //查询当前用户订单
	List<EasybuyOrder> selectMyOrder(Integer userid);
    
	//取消订单
	boolean updateOrderStatus(EasybuyOrder eo);
	
	//删除订单
	boolean delOrder(Integer orderId);
	
}
