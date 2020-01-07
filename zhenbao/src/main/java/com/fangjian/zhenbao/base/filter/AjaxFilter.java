package com.fangjian.zhenbao.base.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class AjaxFilter extends AccessControlFilter{
    private String unauthorizedUrl = "/unauthorized.ftl";
    private String loginUrl = "/login";

	@Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        //boolean isLoginRequest(ServletRequest request, ServletResponse response)//当前请求是否是登录请求
        if (isLoginRequest(request, response)) {
            return true;
        } else {
            //Subject getSubject(ServletRequest request, ServletResponse response) //获取Subject实例
            Subject subject = getSubject(request, response);
            return subject.getPrincipal() != null;
        }
    }

	@Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        //PrintWriter是向文本输出流打印对象的格式化表示形式  是字符类型的打印输出流
    	/*PrintWriter writer = WebUtils.toHttp(response).getWriter();
    	writer.println("{openError:900001}");
    	writer.flush();*/

        Subject subject = getSubject(request, response);
        if (subject.getPrincipal() == null) {//表示没有登录，重定向到登录页面
            saveRequest(request);
            WebUtils.issueRedirect(request, response, loginUrl);
        } else {
            if (StringUtils.hasText(unauthorizedUrl)) {//如果有未授权页面跳转过去
                WebUtils.issueRedirect(request, response, unauthorizedUrl);
            } else {//否则返回401未授权状态码
                WebUtils.toHttp(response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
            }
        }

        /*HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        Subject subject = getSubject(request, response);

        if (subject.getPrincipal() == null) {
            if (com.silvery.utils.WebUtils.isAjax(httpRequest)) {
                com.silvery.utils.WebUtils.sendJson(httpResponse, JsonUtils.toJSONString(new ViewResult(false,
                        "您尚未登录或登录时间过长,请重新登录!")));
            } else {
                saveRequestAndRedirectToLogin(request, response);
            }
        } else {
            if (com.silvery.utils.WebUtils.isAjax(httpRequest)) {
                com.silvery.utils.WebUtils.sendJson(httpResponse, JsonUtils.toJSONString(new ViewResult(false,
                        "您没有足够的权限执行该操作!")));
            } else {
                String unauthorizedUrl = getUnauthorizedUrl();
                if (StringUtils.hasText(unauthorizedUrl)) {
                    WebUtils.issueRedirect(request, response, unauthorizedUrl);
                } else {
                    WebUtils.toHttp(response).sendError(401);
                }
            }
        }*/
        return false;
    }
}
