package com.eb.test.servicesImpli.cheng;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eb.test.MapperDao.EasybuyUserAddressMapper;
import com.eb.test.model.EasybuyAddress;
import com.eb.test.model.Params;
import com.eb.test.servicesDao.cheng.Member_AddressDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @author ChenYan
 * 收货地址实现类
 */

@Service
public class Member_AddressDaoImpl implements Member_AddressDao {
    
	@Autowired
	private  EasybuyUserAddressMapper euam; 
	
	
	@Override
	public PageInfo<EasybuyAddress> finds(Params params,
            Integer userid) {	

		int pageNo = params.getPageNo();
		int pageSize = params.getPageSize();
		
		PageHelper.startPage(pageNo, pageSize);
		List<EasybuyAddress> blogs = euam.selectAddress(userid);

		PageInfo<EasybuyAddress> pageInfo = new PageInfo<EasybuyAddress>(blogs);
		
		return pageInfo;
    }
	
	@Override
	public List<EasybuyAddress> selectAddress(Integer userid) {
		// TODO Auto-generated method stub
		
		return this.euam.selectAddress(userid);
	}


	@Override
	public boolean updateisDefault_0(EasybuyAddress eba) {
		int count=euam.updateisDefault_0(eba);	 
		if(count>0) {
			return true;
		}
		return false;
	}


	@Override
	public boolean updateisDefault(EasybuyAddress eba) {
		int count=euam.updateisDefault(eba);
		if(count>0) {
			return true;
		}
		return false;
	}


	@Override
	public boolean delAddress(Integer id) {
		int count=euam.delAddress(id);
		if(count>0) {
			return true;
		}
		return false;
	}


	@Override
	public EasybuyAddress selectByIdAddress(Integer id) {

		return this.euam.selectByIdAddress(id);
	}


	@Override
	public boolean updateByIdAddress(EasybuyAddress eba) {
		int count=euam.updateByIdAddress(eba);
		if(count>0) {
			return true;
		}
		return false;
	}


	@Override
	public boolean insertAddress(EasybuyAddress eba) {
		int count=euam.insertAddress(eba);
		if(count>0) {
			return true;
		}
		return false;
	}

}
