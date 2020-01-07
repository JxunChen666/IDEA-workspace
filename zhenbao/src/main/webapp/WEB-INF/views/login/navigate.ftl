<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"] />
<!doctype html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>重型车排放与能耗在线监控平台</title>
    <link rel="shortcut icon" type="image/x-icon" href="static/img/ico.ico"/>
    <link rel="stylesheet" href="<@c.url value='static/login/navigate.css'/>"/>
    <link rel="stylesheet" href="<@c.url value='static/login/button.css'/>"/>
    <script type="text/javascript" src="<@c.url value='static/js/ace/jquery.min.js' />"></script>
    <script type="text/javascript" src="<@c.url value='static/login/bgstretcher.js' />"></script>
    <script type="text/javascript" src="<@c.url value='static/login/navigate.js' />"></script>
</head>

<body>
<div style="display: none_;">
    <div style=" margin-left: 80%;">
        <a href="<@c.url value='/logout'/>"><input type="button" class="btn24" value="${user.username} 退出"
                                        onmouseover="this.style.backgroundPosition='left -50px'"
                                        onmouseout="this.style.backgroundPosition='left top'"
                                        style="background-position: 0% 0%;"></a>
    </div>
    <ul id="ul1">

    <#list navigates as navigate>
        <li><a href="${rc.getContextPath()}${navigate.url}"><h2>${navigate.name}</h2></a></li>
    </#list>
    </ul>
</div>
</body>
</html>
