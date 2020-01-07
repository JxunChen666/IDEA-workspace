package com.fangjian.zhenbao.base.filter;

import com.fangjian.zhenbao.base.realm.UserRealm;
import com.fangjian.zhenbao.base.utils.Constants;
import com.fangjian.zhenbao.business.system.entity.User;
import com.fangjian.zhenbao.business.system.service.AuthorityService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;


public class SysUserFilter extends PathMatchingFilter {

    @Autowired
    private AuthorityService authorityService;
    
    private static long proVer_time = new Date().getTime();

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response,
        Object mappedValue) throws Exception {

    	HttpServletRequest req = (HttpServletRequest) request;
    	
    	/*项目版本号，用来清除静态文件缓存*/
    	Object proVer = req.getSession().getAttribute("proVer");
    	if(proVer==null){
    		req.getSession().setAttribute("proVer", proVer_time);
    	}

    	//路径过滤器中将user对象保存到request的请求作用域中.这里最终才是使用@CurrentUser注解获取到用户对象
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        User user = authorityService.findUserByUsername(username);
        request.setAttribute(Constants.CURRENT_USER, user);

        //每次登陆成功后使用以下代码清理一下缓存
        /*RealmSecurityManager rsm = (RealmSecurityManager) SecurityUtils.getSecurityManager();
        UserRealm realm = (UserRealm) rsm.getRealms().iterator().next();
        realm.clearCachedAuthorization();*/

        /*UserAppRel userAppRel = null;
		if (user != null) {
			userAppRel = userAppRelService
					.findUserAppRelByUserId(user.getId());
		}
		request.setAttribute(Constants.CURRENT_USER_APP_REL, userAppRel);*/
        return true;
    }
}
