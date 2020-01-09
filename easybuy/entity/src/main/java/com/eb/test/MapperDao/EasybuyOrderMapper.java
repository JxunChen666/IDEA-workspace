package com.eb.test.MapperDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.eb.test.model.EasybuyOrder;


/**
 * 
 * @author ChenYan
 *  订单mapper
 */
public interface EasybuyOrderMapper {
	
	//查询所有
	List<EasybuyOrder> selectMyOrder(@Param("userid") Integer userid); 
	
	//取消订单
	int updateOrderStatus(EasybuyOrder eo);
	
	//删除订单
	int delOrder(@Param("orderId")Integer orderId);
	
    int deleteByPrimaryKey(Integer id);

    int insert(EasybuyOrder record);

    int insertSelective(EasybuyOrder record);

    EasybuyOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EasybuyOrder record);

    int updateByPrimaryKey(EasybuyOrder record);
    
    /************************************dq***************************************/
    
    //查询所有订单信息
    List<EasybuyOrder> selectAllOrder();
    
    int updateOrderdq(
    		@Param("id")Integer id,
    		@Param("row")Integer row);
    
    /************************************dqEnd***************************************/
    
    
}