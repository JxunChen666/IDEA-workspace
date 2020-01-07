<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"] />
<#assign shiro=JspTaglibs["http://shiro.apache.org/tags"] />
<#include "../../decorators/common.ftl" />
<#setting url_escaping_charset='UTF-8'>
<@baseStyle />
<@base_js />
<@common_js />
<@chosen />
<@layer />
<!DOCTYPE html>
<html>
<head>
    <tille></tille>
    <script type="text/javascript">
    document.documentElement.style.overflowY = "hidden";
</script>
</head>
<body>
<div class="page-content">
    <div>
        <div>
            <div class="form-horizontal detailForm" role="form">
                <input type="text" id="id" name="id" <#if u??>value="${u.id}"</#if> style="display:none"
                       class="coreData fullinputline"/>

                <div class="form-group">
                    <label>
                        <span><font class="red">*</font>用户名：</span>
                        <input type="text" id="username" name="username" placeholder="输入唯一用户名"
                               class="coreData fullinputline input"
                               value="<#if u??>${u.username}</#if>"/>
                    </label>
                </div>

                <div class="form-group remove">
                    <label>
                        <span><font class="red">*</font>密码：</span>
                        <input type="password" id="password" name="password" placeholder="输入密码"
                               class="coreData fullinputline input"
                               value="<#if u??>${u.password}</#if>"/>
                    </label>
                </div>
                <div class="form-group remove">
                    <label>
                        <span><font class="red">*</font>确认密码：</span>
                        <input type="password" id="rePassword" placeholder="确认密码"
                               class="coreData fullinputline input"
                               value="<#if u??>${u.password}</#if>"/>
                    </label>
                </div>

                <div class="form-group">
                    <label>
                        <span><font class="red">*</font>姓名：</span>
                        <input type="text" id="name" name="name" maxlength="30" placeholder="输入姓名"
                               class="coreData fullinputline input"
                               value="<#if u??>${u.name}</#if>"/>
                    </label>
                </div>

                <div class="form-group">
                    <label>
                        <span><font class="red">*</font>邮箱：</span>
                        <input type="text" id="email" name="email" maxlength="30" placeholder="输入邮箱"
                               class="coreData fullinputline input"
                               value="<#if u??>${u.email}</#if>"/>
                    </label>
                </div>

                <div class="form-group">
                    <label>
                        <span><font class="red">*</font>电话：</span>
                        <input type="text" id="phone" name="phone" maxlength="12" placeholder="输入手机号码"
                               class="coreData fullinputline input"
                               value="<#if u??>${u.phone}</#if>"/>
                    </label>
                </div>

                <div class="form-group">
                    <label>
                        <span><font class="red">*</font>紧急电话：</span>
                        <input type="text" id="emergency_phone" name="emergency_phone" maxlength="12" placeholder="输入紧急电话"
                               class="coreData fullinputline input"
                               value="<#if u??>${u.emergency_phone}</#if>"/>
                    </label>
                </div>

                <div class="hr hr-dotted"></div>
                <div class="form-group" style="text-align: center;">
                    <input type="button" class="btn btn-primary saveForm" value="保 存">&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="button" class="btn btn-danger closeWindow" value="取 消"><br/><br/>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="<@c.url value='/static/js/huabo/role/testorEdit.js'/>"></script>
</body>
</html>