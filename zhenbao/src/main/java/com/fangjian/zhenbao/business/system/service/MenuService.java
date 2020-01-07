package com.fangjian.zhenbao.business.system.service;

import com.fangjian.zhenbao.business.system.entity.Menu;
import com.fangjian.zhenbao.business.system.entity.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


/**
 * 菜单生成
 */
@Service
public class MenuService {

    @Autowired
    private AuthorityService authorityService;

    public List<Menu> findMenu(String str) {
        String[] url = str.split(",");
        List<Menu> menus = new ArrayList<Menu>();
        List<Resource> resourceList = authorityService.findResourceByUrl(url);
        List<Resource> parentResource = authorityService.findResourceByParentId(resourceList.get(0).getId());
        for (Resource resource : parentResource) {
            if(resourceList.get(0).getType().equals("menu")) {
                Menu menu = new Menu();
                menu.setTitle_menu(resourceList.get(0).getName());
                List<String> parentKey = new ArrayList<String>();
                parentKey.add(resource.getName());
                parentKey.add(findKeyWord(resource.getUrl()));
                parentKey.add(resource.getIcon());
                menu.setParent_menu(parentKey);
                List<Resource> childResource = authorityService.findResourceByParentId(resource.getId());
                LinkedHashMap<String, String[]> childMap = new LinkedHashMap<String, String[]>();
                for (Resource child : childResource) {
                    if(child.getType().equals("menu")) {
                        String[] childValue = {child.getUrl(), findKeyWord(child.getUrl()), child.getPermission()};
                        childMap.put(child.getName(), childValue);
                    }
                }
                menu.setChild_menu(childMap);
                menus.add(menu);
            }
        }
            return menus;
    }

    public static String findKeyWord(String url) {
        return url.substring(url.lastIndexOf("/") + 1, url.length());
    }
}
