package com.fangjian.zhenbao.business.system.entity;

import java.util.Map;


/** 
* @ClassName: PageBean 
* @Description: TODO 分页实体
* @author sun yafei
* @date 2015年12月2日 上午9:09:38 
*  
*/
public class PageBean {
	//分页起始量
	private int iDisplayStart;
	//每页长度
	private int iDisplayLength;
	//排序方式
	private String sSortDir_0;
	//表格所有列标识
	private String sColumns;
	//排序列索引
	private int iSortCol_0;

	/**
	 * @param iDisplayStart the iDisplayStart to set
	 */
	public void setiDisplayStart(int iDisplayStart) {
		this.iDisplayStart = iDisplayStart;
	}

	/**
	 * @param iDisplayLength the iDisplayLength to set
	 */
	public void setiDisplayLength(int iDisplayLength) {
		this.iDisplayLength = iDisplayLength;
	}

	/**
	 * @param sSortDir_0 the sSortDir_0 to set
	 */
	public void setsSortDir_0(String sSortDir_0) {
		this.sSortDir_0 = sSortDir_0;
	}

	/**
	 * @param sColumns the sColumns to set
	 */
	public void setsColumns(String sColumns) {
		this.sColumns = sColumns;
	}

	/**
	 * @param iSortCol_0 the iSortCol_0 to set
	 */
	public void setiSortCol_0(int iSortCol_0) {
		this.iSortCol_0 = iSortCol_0;
	}

	/**
	 * 获取分页的起始量
	 * @return
	 */
	public int getStart(){
		return iDisplayStart;
	}
	
	/**
	 * 获取每页长度
	 * @return
	 */
	public int getPageSize(){
		return iDisplayLength;
	}
	
	/**
	 * 获取排序列
	 * @return
	 */
	public String getSortcolumn(){
		return camelToUnderline(sColumns.split(",")[iSortCol_0]);
	}
	public static String camelToUnderline(String param){
		if (param==null||"".equals(param.trim())){
			return "";
		}
		int len=param.length();
		StringBuilder sb=new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c=param.charAt(i);
			if (Character.isUpperCase(c)){
				sb.append("_");
				sb.append(Character.toLowerCase(c));
			}else{
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	/**
	 * 获取排序字段
	 * @author TangLiang,2016年8月3日
	 * @return
	 */
	public String getSortCol(){
		return columnToString(sColumns.split(",")[iSortCol_0]);
	}
	public static String columnToString(String param){
		if (param==null||"".equals(param.trim())){
			return "";
		}
		return param;
	}
	/**
	 * 获取排序方式
	 * @return ASC DESC
	 */
	public String getSortWay(){
		return sSortDir_0;
	}
	
	/**
	 * 设置分页条件
	 * @return
	 */
	public void setCondition(Map<String, Object> params){
		params.put("start", iDisplayStart);
		params.put("pagesize", iDisplayLength);
		params.put("sortColumn", getSortcolumn());
		params.put("sortWay", sSortDir_0);
	}
}
