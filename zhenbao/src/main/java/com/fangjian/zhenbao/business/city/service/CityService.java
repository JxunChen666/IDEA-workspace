package com.fangjian.zhenbao.business.city.service;

import com.fangjian.zhenbao.business.city.dao.CityDao;
import com.fangjian.zhenbao.business.city.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author ChuJing
 *
 * @date 2015年12月31日
 */
@Service
public class CityService {
	@Autowired
	private CityDao cityDao;
	
	public List<City> getAllCities(){
		return cityDao.getAllCities();
	}
	/**
	 * 
	 * <p>
	 * @author ChuJing,2016年2月16日
	 * @param cityCode
	 * @return
	 */
	public City getByCityCode(String cityCode){
		return cityDao.getCityByCityCode(cityCode);
	}
	

	public City getByCityName(String cityName) {
	    return cityDao.getByCityName(cityName);	
	}
	
	/**
	 * 查询城市列表
	 * liuyu
	 * 2016年4月21日上午9:27:28
	 * @param withWholeContry 是否添加全国选项
	 * @param intelijentSort 是否开启智能排序，合肥位于第一，芜湖第二
	 * @return
	 */
	public List<City> getCityList(boolean withWholeContry, boolean intelijentSort) {
		
		List<City> allCity = cityDao.getAllCities();
		for (int i = allCity.size() - 1;i >= 0; i --) {
			City city = allCity.get(i);
			if (city.getCityCode().equals("00")) {
				allCity.remove(i);
			}
		}
		if (withWholeContry) {
			City city = new City();
			city.setId("");
			city.setCityCode("00");
			city.setName("全国");
			city.setStatus(1);
			allCity.add(0, city);
		}
		return allCity;
	}
	
	/**
	 * 根据cityCode查询指定城市，指定城市的账号只能查看指定城市列表
	 * liuyu
	 * 2016年4月21日上午9:56:38
	 * @return
	 */
	public List<City> getCityListByConfiguredCode(String cityCode) {
		City city = getByCityCode(cityCode);
		List<City> cityList = new ArrayList<City>();
		cityList.add(city);
		return cityList;
	}
	
	/**
	 * 根据name查询指定城市，指定城市的账号只能查看指定城市列表
	 * liuyu
	 * 2016年4月21日上午9:56:38
	 * @return
	 */
	public List<City> getCityListByConfiguredName(String cityName) {
		City city = getByCityName(cityName);
		List<City> cityList = new ArrayList<City>();
		cityList.add(city);
		return cityList;
	}
}
