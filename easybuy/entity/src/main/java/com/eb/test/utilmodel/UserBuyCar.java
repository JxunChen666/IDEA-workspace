package com.eb.test.utilmodel;

import java.io.Serializable;

public class UserBuyCar implements Serializable{
	
	//product
	private Integer id;

    private String name;

    private String description;

    private Float price;

    private Integer stock;

    private Integer categorylevel1;

    private Integer categorylevel2;

    private Integer categorylevel3;

    private String filename;

    private Integer isdelete;
    
    //buycar
  //购物车信息表 记录一个用户的购物车内容
  	private Integer users;//用户id
  	private Integer goods;//商品id
  	private Integer coun;//数量
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getCategorylevel1() {
		return categorylevel1;
	}
	public void setCategorylevel1(Integer categorylevel1) {
		this.categorylevel1 = categorylevel1;
	}
	public Integer getCategorylevel2() {
		return categorylevel2;
	}
	public void setCategorylevel2(Integer categorylevel2) {
		this.categorylevel2 = categorylevel2;
	}
	public Integer getCategorylevel3() {
		return categorylevel3;
	}
	public void setCategorylevel3(Integer categorylevel3) {
		this.categorylevel3 = categorylevel3;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Integer getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
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
	
	
	@Override
	public String toString() {
		return "UserBuyCar [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", stock=" + stock + ", categorylevel1=" + categorylevel1 + ", categorylevel2=" + categorylevel2
				+ ", categorylevel3=" + categorylevel3 + ", filename=" + filename + ", isdelete=" + isdelete
				+ ", users=" + users + ", goods=" + goods + ", coun=" + coun + "]";
	}
    
  	
  	
  	
    
    
}
