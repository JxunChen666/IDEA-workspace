package com.fangjian.zhenbao.business.city.dao;

import com.fangjian.zhenbao.business.city.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author ChuJing
 *
 * @date 2015年12月31日
 */
@Repository
public class CityDao {
	/*@Autowired
	@Qualifier("mongoTemplate")*/
	private MongoTemplate mongoTemplate;
	private static final String TABLE_NAME = "city";

	public List<City> getAllCities() {
		return mongoTemplate.findAll(City.class, TABLE_NAME);
	}
	/**
	 * 
	 * <p>
	 * @author ChuJing,2016年2月16日
	 * @param cityCode
	 * @return
	 */
	public City getCityByCityCode(String cityCode){
	   Criteria criatira = new Criteria();
	   criatira.andOperator(Criteria.where("cityCode").is(cityCode));
	   Query query = new Query(criatira);
	   return mongoTemplate.findOne(query, City.class, TABLE_NAME);
    }
	
	public City getByCityName(String cityName) {
		Criteria criteria = new Criteria();
		criteria.andOperator(Criteria.where("name").is(cityName));
		Query query = new Query(criteria);
		return mongoTemplate.findOne(query, City.class, TABLE_NAME);
	}
}
