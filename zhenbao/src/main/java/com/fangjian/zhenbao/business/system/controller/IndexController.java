package com.fangjian.zhenbao.business.system.controller;

import com.fangjian.zhenbao.base.bind.annotation.CurrentUser;
import com.fangjian.zhenbao.base.bind.annotation.RecordLog;
import com.fangjian.zhenbao.business.system.entity.Resource;
import com.fangjian.zhenbao.business.system.entity.User;
import com.fangjian.zhenbao.business.system.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class IndexController {

    @Autowired
    private AuthorityService authorityService;

    @RecordLog(remark = "login index")
    @RequestMapping("/")
    public String index(@CurrentUser User loginUser, Model model) {
        Set<String> permissions = authorityService.findPermissions(loginUser.getUsername());
        Set<String> permissionUrls = new HashSet<String>();
        for (String permission : permissions) {
            String url = "/";
            try {
                url += permission.split(":")[0];
            } catch (Exception e) {
            }
            permissionUrls.add(url);
        }
        String[] strSet = new String[permissionUrls.size()];
        permissionUrls.toArray(strSet);
        List<Resource> navigates = authorityService.findResourceByUrl(strSet);
        model.addAttribute("navigates", navigates);
        return "login/navigate";
    }
}
