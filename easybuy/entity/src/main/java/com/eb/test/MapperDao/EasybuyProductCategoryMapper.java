package com.eb.test.MapperDao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.eb.test.model.EasybuyProduct;
import com.eb.test.model.EasybuyProductCategory;

import io.lettuce.core.dynamic.annotation.Param;

public interface EasybuyProductCategoryMapper {
	//查询对应级别商品菜单
	@Select("SELECT * FROM `easybuy_product_category` WHERE type=#{type}")
	List<EasybuyProductCategory> selectProductBuyLevel(@Param("type") Integer type);
	
	//查询对应级别商品菜单id
	@Select("SELECT * FROM `easybuy_product_category` WHERE parentid=#{parentid}")
	List<EasybuyProductCategory> selectProductBuyLevelID(@Param("parentid") Integer parentid);
	
	
	
	
	// create by xu 12/5  
		@Select("Select * from easybuy_product_category")
		List<EasybuyProductCategory> selectAll();
		
	//create by xu 12/11
	@Select("select * from easybuy_product_category  where type=1")
	List<EasybuyProductCategory> selectl1();
		
	
    int deleteByPrimaryKey(Integer id);

    int insert(EasybuyProductCategory record);

    int insertSelective(EasybuyProductCategory record);

    EasybuyProductCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EasybuyProductCategory record);

    int updateByPrimaryKey(EasybuyProductCategory record);
    
    /*****************************dq****************************/
    List<EasybuyProductCategory> selectXiaLaKuang(int typeval);
    
    
    /*****************************dqEnd****************************/
}