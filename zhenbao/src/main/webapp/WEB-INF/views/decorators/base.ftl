<#-- <!DOCTYPE html> HTML5 doctype 不区分大小写 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"] />
<#assign shiro=JspTaglibs["http://shiro.apache.org/tags"] />
<#include "./common.ftl" />
<#setting url_escaping_charset='UTF-8'>
<html lang="en"><!-- <html lang="en">英语   <html lang="zh">中文-->
<head>
    <#--
        <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
        属性解析:
        1、width : 控制viewport的大小,可以指定一个值,如600, 或者特殊的值,如device-width为设备的宽度(单位为缩放为100%的CSS的像素)
        2、height : 和width相对应,指定高度
        3、initial-scale : 初始缩放比例,页面第一次加载时的缩放比例
        4、maximum-scale : 允许用户缩放到的最大比例,范围从0到10.0
        5、minimum-scale : 允许用户缩放到的最小比例,范围从0到10.0
        6、user-scalable : 用户是否可以手动缩放,值可以是:①yes、 true允许用户缩放;②no、false不允许用户缩放

        向搜索引擎说明你的网页的关键词
        <meta  name="Keywords"    content="">
        告诉搜索引擎你的站点的主要内容
        <meta name="Description"  content="">
    -->
	<Link Rel="SHORTCUT ICON" type="image/x-icon" href="<@c.url value='../../static/img/ico.ico'/>">
    <meta charset="utf-8"/>
    <title>重型车排放与能耗在线监控平台</title>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<@baseStyle />
<@base_js />
</head>
<body>
<!--头部 -->
<#include "head.ftl" />

<div class="main-container" id="main-container">
    <script type="text/javascript">
        try {
            ace.settings.check('PrinterMain-container', 'fixed')
        } catch (e) {
        }
    </script>

    <div class="main-container-inner">
        <a class="menu-toggler" id="menu-toggler" href="#">
            <span class="menu-text"></span>
        </a>
        <!--菜单-->
    <#include "menu.ftl" />

        <div class="main-content">
            <div class="breadcrumbs" id="breadcrumbs">
                <script type="text/javascript">
                    try {
                        ace.settings.check('breadcrumbs', 'fixed')
                    } catch (e) {
                    }
                </script>

                <ul class="breadcrumb">
                    <li>
                        <i class="icon-home home-icon"></i>
                        <a href="#">首页</a>
                    </li>

                    <li>
                        <a href="#">${basePage.currentTitle}</a>
                    </li>
                    <li class="active">${basePage.currentMenu}</li>
                </ul>
                <!-- .breadcrumb -->

                <!-- <div class="nav-search" id="nav-search">
                    <form class="form-search">
                        <span class="input-icon">
                            <input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
                            <i class="icon-search nav-search-icon"></i>
                        </span>
                    </form>
                </div>--><!-- #nav-search -->
            </div>

            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <#--
                            @block : 定义块，可以被子模板用@override指令覆盖显示
                            @override :  覆盖@block指令显示的内容
                            @extends : 继承其它模板，必须放在模板的最后面（注：该指令完全等价于#include指令，只是为了提供统一的语义，即extends比include更好理解）
                        -->
                    <@block name="showBody" />
                        <!-- PAGE CONTENT ENDS -->
                    </div>
                    <!-- /.col -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.page-content -->
        </div>
        <!-- /.PrinterMain-content -->
      
    <!-- /.PrinterMain-container-inner -->

    <!--右下返回条 -->
    <!--<div style="display: none;" id="rocket-to-top">
        <div style="opacity:0;display: block;" class="level-2"></div>
        <div class="level-3"></div>
    </div>
    <div style="text-align:center;clear:both;">-->
</div>
<!-- /.PrinterMain-container -->
</body>
</html>
