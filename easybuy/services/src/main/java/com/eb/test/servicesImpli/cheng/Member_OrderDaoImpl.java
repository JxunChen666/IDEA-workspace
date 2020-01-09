package com.eb.test.servicesImpli.cheng;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eb.test.MapperDao.EasybuyOrderMapper;
import com.eb.test.model.EasybuyOrder;
import com.eb.test.servicesDao.cheng.Member_OrderDao;

/**
 * 
 * @author ChenYan
 * 订单业务实现类
 */


@Service
public class Member_OrderDaoImpl  implements Member_OrderDao{
 
	@Autowired(required=false)
	private EasybuyOrderMapper order;
	
	
	
	public List<EasybuyOrder> selectMyOrder(Integer userId) {
		// TODO Auto-generated method stub
		
		return this.order.selectMyOrder(userId);
	}



	@Override
	public boolean delOrder(Integer orderId) {
		int count=this.order.delOrder(orderId);		 
		if(count>0) {
			return true;
		}
		return false;
	}


    
	@Override
	public boolean updateOrderStatus(EasybuyOrder eo) {
		// TODO Auto-generated method stub
		int count=this.order.updateOrderStatus(eo);
		if(count>0) {
			return true;
		}
		return false;
	}
 
	
}
