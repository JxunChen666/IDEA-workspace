package com.fangjian.zhenbao.base.filter;

import java.util.LinkedHashMap;

/**
 * @author fangjian
 * @date 2018/11/07 0007 上午 11:23
 */
public class FilterChainDefinitionMapBuilder {

    public LinkedHashMap<String, String> buildFilterChainDefinitionMap() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        map.put("*.ajax", "ajaxc");
        map.put("/static/**", "anon");
        map.put("/**/yj", "anon");
        map.put("/**/obdPrint", "anon");
        map.put("/**/yy", "anon");
        map.put("/**/testReport", "anon");
        map.put("/login", "authc");
        map.put("/logout", "logout"); //只需要这样配置下，不需要任何的controller 引用的地方的连接地址/logout即可
        map.put("/authenticated", "authc");
        map.put("/checkEmail", "anon");
        map.put("/pingpp/**", "anon");
        map.put("/favicon.ico", "anon");
        map.put("/**", "user,sysUser");

        return map;
    }
}
