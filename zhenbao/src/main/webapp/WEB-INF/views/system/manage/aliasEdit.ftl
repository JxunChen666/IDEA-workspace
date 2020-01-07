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
                <input type="text" id="id" name="disId" <#if dis??>value="${dis.disId}"</#if> style="display:none"
                       class="coreData fullinputline"/>
                <div class="form-group">
                    <label>
                        <span><font class="red">*</font>区域名称：</span>
                        <input id="disName"  name="disName" placeholder="输入区域名称"
                               class="coreData fullinputline input"
                               value="<#if dis??>${dis.disName}</#if>"/>
                    </label>
                </div>

                <div class="form-group remove">
                    <label>
                        <span><font class="red">*</font>省级简称：</span>
                        <input id="disSimpleName"  name="disSimpleName" placeholder="输入省级简称"
                               class="coreData fullinputline input"
                               value="<#if dis??>${dis.disSimpleName}</#if>"/>
                    </label>
                </div>
                <div class="form-group remove">
                    <label>
                        <span><font class="red">*</font>当前级别：</span>
                        <select class="coreData fullinputline input" name="disLevel">
                            <option value="1" selected="selected">1级</option>
                            <option value="2">2级</option>
                            <option value="3">3级</option>
                            <option value="4">4级</option>
                        </select>

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
<script type="text/javascript" src="<@c.url value='/static/js/system/manage/aliasEdit.js'/>"></script>
</body>
</html>