package com.eb.test.servicesImpli.qiang;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eb.test.MapperDao.EasybuyOrderMapper;
import com.eb.test.model.EasybuyOrder;
import com.eb.test.servicesDao.qiang.IBackstageOrderService;

@Service
public class BackstageOrderImpl implements IBackstageOrderService{
	
	@Autowired
	private EasybuyOrderMapper eom;

	@Override
	public List<EasybuyOrder> selectAllOrder() {
		return eom.selectAllOrder();
	}

	@Override
	public boolean updateOrderdq(int id, int row) {
		int num = eom.updateOrderdq(id, row);
		if(num>1) {
			return true;
		}else {
			return false;
		}
	}
}
