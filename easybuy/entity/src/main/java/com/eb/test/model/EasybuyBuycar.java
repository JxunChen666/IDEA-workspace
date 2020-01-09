package com.eb.test.model;

import java.io.Serializable;

/**
 * 
 * @author weizhen
 *
 */
public class EasybuyBuycar  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//购物车信息表 记录一个用户的购物车内容
	private Integer id;//编号
	private Integer users;//用户id
	private Integer goods;//商品id
	private Integer coun;//数量
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUsers() {
		return users;
	}
	public void setUsers(Integer users) {
		this.users = users;
	}
	public Integer getGoods() {
		return goods;
	}
	public void setGoods(Integer goods) {
		this.goods = goods;
	}
	public Integer getCoun() {
		return coun;
	}
	public void setCoun(Integer coun) {
		this.coun = coun;
	}
	public EasybuyBuycar(Integer id, Integer users, Integer goods, Integer coun) {
		super();
		this.id = id;
		this.users = users;
		this.goods = goods;
		this.coun = coun;
	}
	public EasybuyBuycar() {
		super();
	}
	
}
