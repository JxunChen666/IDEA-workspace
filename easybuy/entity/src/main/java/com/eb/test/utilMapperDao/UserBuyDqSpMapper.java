package com.eb.test.utilMapperDao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.eb.test.dqutilmodel.easybuydqsp;

public interface UserBuyDqSpMapper {
	@Select("SELECT  p.id,p.`name`,p.`price`,p.`stock`,\r\n" + 
			"l1.`name` \r\n" + 
			"AS lname1,\r\n" + 
			"\r\n" + 
			"l2.`name` \r\n" + 
			"AS lname2,\r\n" + 
			"\r\n" + 
			"l3.`name` \r\n" + 
			"AS lname3\r\n" + 
			"FROM easybuy_product AS p,\r\n" + 
			"(SELECT `name`,id FROM easybuy_product_category WHERE TYPE=1) AS l1,\r\n" + 
			"(SELECT `name`,id FROM easybuy_product_category WHERE TYPE=2) AS l2,\r\n" + 
			"(SELECT `name`,id FROM easybuy_product_category WHERE TYPE=3) AS l3\r\n" + 
			"\r\n" + 
			"WHERE l1.id=p.categoryLevel1 \r\n" + 
			"AND l2.id=p.categoryLevel2\r\n" + 
			"AND l3.id=p.categoryLevel3")
	List<easybuydqsp> selectAlldqsp();
}
