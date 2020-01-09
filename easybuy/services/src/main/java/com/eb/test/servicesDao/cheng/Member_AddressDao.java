package com.eb.test.servicesDao.cheng;

import java.util.List;

import com.eb.test.model.EasybuyAddress;
import com.eb.test.model.Params;
import com.github.pagehelper.PageInfo;


/**
 * 
 * @author ChenYan
 * 收货地址接口
 */

public interface Member_AddressDao {
    
	//查询当前用户所有地址
	List<EasybuyAddress> selectAddress(Integer userid);
	
	//设置当前用户所有收货地址为非默认状态isDefault=0
	boolean updateisDefault_0(EasybuyAddress eba);
	
	//设置默认收货地址isDefault=1
	boolean updateisDefault(EasybuyAddress eba);
	
	//删除地址
	boolean delAddress(Integer id);
	
	//查询单条记录 修改所需
	EasybuyAddress selectByIdAddress(Integer id);
	
	//修改地址
	boolean updateByIdAddress(EasybuyAddress eba);
	
	//新增地址
	boolean insertAddress(EasybuyAddress eba);
	
	//分页查询
	public PageInfo<EasybuyAddress> finds(Params params,Integer userid);
}
