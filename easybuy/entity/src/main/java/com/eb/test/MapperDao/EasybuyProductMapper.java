package com.eb.test.MapperDao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.eb.test.model.EasybuyProduct;


public interface EasybuyProductMapper {
	//xu 查询所有商品
	@Select("\r\n" + 
			"select DISTINCT p.*\r\n" + 
			"from easybuy_product p,(select id from easybuy_product_category  where type=1)  pc\r\n" + 
			"where p.categoryLevel1 in (select id from easybuy_product_category  where type=1) ")
	public List<EasybuyProduct> selectAll();

	//xu 根据菜单查询对应级别商品
	@Select("<script>"
			+ "select * from easybuy_product"
			+ "<where>"
			+ "<if test='la!=-1'> and categoryLevel1=#{la}</if>"
			+ "<if test='lb!=-1'> and categoryLevel2=#{lb}</if>"
			+ "<if test='lc!=-1'> and categoryLevel3=#{lc}</if>"
			+ "</where>"
			+ "</script>")
	List<EasybuyProduct> selectProductBuyLevel(@Param("la") Integer la,@Param("lb") Integer lb,@Param("lc") Integer lc);

	//weizhen 购物车信息
	@Select("<script>"
			+ "select *from easybuy_product"
			+ "<where>"
			+ "<if test='id!=null'>id=#{id}</if>"
			+ "</where>"
			+ "</script>")
	List<EasybuyProduct> getEasybuyProduct(@Param("id") Integer id);
	
    int deleteByPrimaryKey(Integer id);

    int insert(EasybuyProduct record);

    int insertSelective(EasybuyProduct record);

    EasybuyProduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EasybuyProduct record);

    int updateByPrimaryKey(EasybuyProduct record);
}