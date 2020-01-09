package com.eb.test.servicesDao.wei;

import java.util.List;

import com.eb.test.model.*;

//servicedao层 wei 
public interface ServiceDaoWei {
	
	//根据商品id查 和查询所有商品
	List<EasybuyProduct> getEasybuyProduct(Integer id);
	//查询所有商品分类
	List<EasybuyProductCategory> getGoodsCategory();
	//根据用户id查询用户的购物车 
	List<EasybuyBuycar> getUserBuycar(Integer userid,Integer goodid);
	//统计用户购物车商品总数量 类别可用size获得
	Integer getBuycarCount(Integer userid);
	//统计用户购物车商品总价格
	Integer getBuycarMoney(Integer userid);
	//新增购物车
	boolean buyCarInsert(EasybuyBuycar eb);
	//修改购物车
	boolean buyCarUpdate(EasybuyBuycar eb);
	//删除他妈的个比的购物车
	boolean buyCarDelete(Integer id);
	boolean BuycarDeleteByUsers(Integer id);
	//根据id查用户
	List<EasybuyUser> selectUserbyId(Integer id);
	//根据id查用户默认地址
	List<EasybuyAddress> selectUserDefaultAddressbyId(Integer id);
	//新增订单
	boolean OrderInsert(EasybuyOrder eo);
	//新增收藏
	boolean collectAdd(EasybuyCollect ec);
	//根据uid pid查询收藏
	List<EasybuyCollect> selectCollect(Integer uid,Integer pid);
	//根据uid pid删除收藏
	boolean deleteCollectbyupid(Integer userid,Integer productid);
	//根据id删除收藏
	boolean deleteCollect(Integer id);
}
