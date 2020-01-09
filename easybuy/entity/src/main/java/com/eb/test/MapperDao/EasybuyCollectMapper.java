package com.eb.test.MapperDao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.eb.test.model.EasybuyCollect;

/**
 * 
 * @author wz 19 12 16
 *
 */
public interface EasybuyCollectMapper {
	
	//根据userid 和 productid查收藏
	@Select("<script>"
			+ "select * from easybuy_collect"
			+ "<where>"
			+ "<if test='uid!=null'> and userid=#{uid}</if>"
			+ "<if test='productid!=null'> and productid=#{productid}</if>"
			+ "</where>"
			+ "</script>")
	List<EasybuyCollect> getCollect(@Param("uid") Integer uid,@Param("productid") Integer productid);
	
	//根据userid 和 productid删收藏
	@Delete("delete from easybuy_collect where userid=#{userid} and productid=#{productid}")
	Integer deleteCollectbyupid(Integer userid,Integer productid);
	
	
	//删除收藏根据主键
	@Delete("<script>"
			+ "delete from easybuy_collect"
			+ "<where>"
			+ "<if test='_parameter!=null'>id=#{id}</if>"
			+ "</where>"
			+ "</script>")
	int deleteCollect(Integer id);
	
    int deleteByPrimaryKey(Integer id);
    //新增收藏
    @Insert("insert into easybuy_collect values(default,#{userid},#{productid},#{productnum},#{type})")
    int insertCollect(EasybuyCollect ec);
    
    int insert(EasybuyCollect record);

    int insertSelective(EasybuyCollect record);

    EasybuyCollect selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EasybuyCollect record);

    int updateByPrimaryKey(EasybuyCollect record);
    
}