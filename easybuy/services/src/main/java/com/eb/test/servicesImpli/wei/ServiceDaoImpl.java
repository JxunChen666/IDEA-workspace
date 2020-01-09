package com.eb.test.servicesImpli.wei;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eb.test.MapperDao.*;
import com.eb.test.model.*;
import com.eb.test.servicesDao.wei.ServiceDaoWei;

/**
 * 
 * @author weizhen 12/06
 *
 */
@Service
public class ServiceDaoImpl implements ServiceDaoWei{
	
	@Autowired
	private EasybuyProductMapper epm;//商品表mapper
	@Autowired
	private EasybuyProductCategoryMapper ecm;//商品分类表mapper
	@Autowired
	private EasybuyBuycarMapper eb;//购物车表mapper
	@Autowired
	private EasybuyCollectMapper ecl;//收藏表mapper
	@Override
	public List<EasybuyProduct> getEasybuyProduct(Integer id) {//查询商品 所有  根据id
		// TODO Auto-generated method stub
		if(epm.getEasybuyProduct(id).size()>0) {
			return epm.getEasybuyProduct(id);
		}else {
			System.out.println("查询不到商品");
			return null;
		}
	}

	@Override
	public List<EasybuyProductCategory> getGoodsCategory() {//根据分类id查询分类信息
		// TODO Auto-generated method stub
		if(ecm.selectAll().size()>0) {
			return ecm.selectAll();
		}else {
			System.out.println("查询不到商品分类");
			return null;
		}
	}

	@Override
	public List<EasybuyBuycar> getUserBuycar(Integer userid,Integer goodid) {//查询购物车
		// TODO Auto-generated method stub
		if(userid!=null) {
			return eb.getUserBuycar(userid,goodid);
		}else {
			System.out.println("查询用户购物车失败 用户id为null");
		}
		return null;
	}

	@Override
	public Integer getBuycarCount(Integer userid) {//查询商品数量
		// TODO Auto-generated method stub
		if(userid!=null) {
			return eb.getBuycarCount(userid);
		}else {
			System.out.println("查询用户购物车数量失败 用户id为null");
		}
		return null;
	}

	@Override
	public boolean buyCarInsert(EasybuyBuycar ebc) {
		// TODO Auto-generated method stub
		if(eb.BuycarInsert(ebc)>0) {
			System.out.println("添加成功");
			return true;
		}else {
			return false;
		}
	}
	//更改购物车
	@Override
	public boolean buyCarUpdate(EasybuyBuycar ebc) {//购物车修改
		// TODO Auto-generated method stub
		if(eb.BuycarUpdate(ebc)>0) {
			System.out.println("修改成功");
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Integer getBuycarMoney(Integer userid) {//计算总价格
		// TODO Auto-generated method stub
		System.out.println("计算购物车总价格");
		Integer money = eb.getBuycarMoney(userid);
		return money;
	}

	@Override
	public boolean buyCarDelete(Integer id) {
		// TODO Auto-generated method stub
		System.out.println("删除购物车");
		Integer count = eb.BuycarDelete(id);
		if(count>0) {
			return true;
		}else {
			return false;	
		}
	}

	@Override
	public List<EasybuyUser> selectUserbyId(Integer id) {
		// TODO Auto-generated method stub
		System.out.println("根据id查用户");
		return eb.selectUserbyId(id);
	}

	@Override
	public List<EasybuyAddress> selectUserDefaultAddressbyId(Integer id) {
		// TODO Auto-generated method stub
		System.out.println("根据id查用户地址");
		return eb.selectUseDefaultrAddressbyId(id);
	}

	@Override
	public boolean OrderInsert(EasybuyOrder eo) {
		// TODO Auto-generated method stub
		System.out.println("新增订单");
		if(eb.OrderInsert(eo)>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean BuycarDeleteByUsers(Integer id) {
		// TODO Auto-generated method stub
				System.out.println("删除购物车");
				Integer count = eb.BuycarDeleteByUsers(id);
				if(count>0) {
					return true;
				}else {
					return false;	
				}
	}

	@Override
	public boolean collectAdd(EasybuyCollect ec) {
		// TODO Auto-generated method stub
		if(ecl.insertCollect(ec)>0) {
			return true;
		}
		return false;
	}

	@Override
	public List<EasybuyCollect> selectCollect(Integer uid, Integer pid) {
		// TODO Auto-generated method stub
		return ecl.getCollect(uid, pid);
	}

	@Override
	public boolean deleteCollect(Integer id) {
		// TODO Auto-generated method stub
		if(ecl.deleteCollect(id)>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteCollectbyupid(Integer userid, Integer productid) {
		// TODO Auto-generated method stub
		if(ecl.deleteCollectbyupid(userid, productid)>0) {
			return true;
		}else {
			return false;
		}
	}
	

}
