package com.fangjian.zhenbao.base.utils;

import java.util.HashMap;
import java.util.Map;


/**
 * 处理ajax请求的utils
 *  
 * @author yangsw
 *
 */
public class AjaxUtils {
	
	public static final String RESULT_KEY = "result";
	
	public static final String RESULT_MSG = "msg";
	
	public static final String SUCCESS_DATA = "data";
	
	public static final String SUCCESS = "success";
	
	public static final String FAILED = "fail";
	
	private AjaxUtils() {
		// 规避sonar检查
	}
	
	/**
	 * 构建一个返回的JSON对象
	 * @param result SUCCESS or FAILED
	 * @param msg 消息
	 * @return
	 */
	public static Map<String,Object> bulidJsonAjaxMsg(String result, String msg) {
		Map<String,Object> json = new HashMap<String,Object>();
		if (SUCCESS.equals(result)) {
			json.put(RESULT_KEY, SUCCESS);
		} else {
			json.put(RESULT_KEY, FAILED);
		}
		json.put(RESULT_MSG, msg);
		return json;
	}
	
	/**
	 * 构建一个成功的MSG
	 * @param msg
	 * @return
	 */
	public static Map<String,Object> buildSuccessJsonAjaxMsg(String msg) {
		return bulidJsonAjaxMsg(SUCCESS, msg);
	}
	
	/**
	 * 构建一个失败的MSG
	 * @param msg
	 * @return
	 */
	public static Map<String,Object> buildFailedJsonAjaxMsg(String msg) {
		return bulidJsonAjaxMsg(FAILED, msg);
	}
	
}
