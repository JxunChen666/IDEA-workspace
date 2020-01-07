<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"] />
<#assign shiro=JspTaglibs["http://shiro.apache.org/tags"] />
<#include "../../decorators/common.ftl" />
<#setting url_escaping_charset='UTF-8'>
<@baseStyle />
<@base_js />
<@common_js />
<@layer />

<!DOCTYPE html>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="<@c.url value='/static/js/huabo/role/testorResetPassword.js'/>"></script>
    <script type="text/javascript">
        document.documentElement.style.overflowY = "hidden";
    </script>
</head>
<body>
<div class="page-content">
    <div>
        <div>
            <div class="form-horizontal detailForm" role="form">
                <input type="hidden" id="id" name="id" value="${(u.id)!''}" class="coreData fullinputline"/>

                <div class="form-group">
                    <label>
                        <span><font class="red">*</font>用户名：</span>
                        <input type="text" id="username" name="username" placeholder="用户名"
                               class="coreData fullinputline" value="${(u.username)!''}" readonly="readonly">
                    </label>
                </div>
                <div class="form-group ">
                    <label>
                        <span><font class="red">*</font>新密码：</span>
                        <input type="password" id="password" name="password" placeholder="新密码"
                               class="coreData fullinputline" value="">
                    </label>
                </div>
                <div class="form-group ">
                    <label>
                        <span><font class="red">*</font>确认密码：</span>
                        <input type="password" id="rePassword" placeholder="确认密码" class="coreData fullinputline"
                               value="">
                    </label>
                </div>
                <div class="form-group" style="text-align: center;">
                    <input type="button" class="btn btn-primary saveForm" value="保存">&nbsp;&nbsp;
                    <input type="button" class="btn btn-danger closeWindow" value="取消">
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>