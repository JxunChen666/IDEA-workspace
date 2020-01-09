package com.eb.test.model;

import java.io.Serializable;

public class EasybuyProduct implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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
        this.filename = filename == null ? null : filename.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

	@Override
	public String toString() {
		return "EasybuyProduct [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", stock=" + stock + ", categorylevel1=" + categorylevel1 + ", categorylevel2=" + categorylevel2
				+ ", categorylevel3=" + categorylevel3 + ", filename=" + filename + ", isdelete=" + isdelete + "]";
	}
    
    
}