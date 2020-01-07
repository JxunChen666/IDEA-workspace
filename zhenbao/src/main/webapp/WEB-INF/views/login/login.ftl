<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"] />
<#--
    #区分检测类型     新车下线0、新车登记1、在用汽车2、路检3 app传
    #test.type：0表示新车下线、1表示新车登记和在用汽车、3表示路检
-->
<#assign testType=1 />
<#--
    <#assign name=value [in namespacehash]>,这个用法用于指定一个名为name的变量,该变量的值为value
    首先,在你的ftl模板中添加jstl标签库的引用：<#assign c=JspTaglibs["/WEB-INF/taglib/c.tld"] />,
    c.tld是从 jakarta-tablibs-standard-XXX.jar 这个包的META-INF里面提取出来的，并且在你工程的lib路径下也需要有这个包。
    然后，在模板中按照freemarker方式使用引入的标签： <@c.set var="name" value="abc" />
-->
<!DOCTYPE html>

<html lang="en" class="no-js">

<head>
    <meta charset="utf-8">
    <title>重型车排放与能耗在线监控平台</title>
    <link rel="shortcut icon" type="image/x-icon" href="static/img/ico.ico"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="重型车排放与能耗在线监控平台">
    <meta name="author" content="">

    <!-- CSS -->
    <link rel="stylesheet" href="<@c.url value='static/login/reset.css'/>"/>
    <link rel="stylesheet" href="<@c.url value='static/login/supersized.css'/>"/>
    <link rel="stylesheet" href="<@c.url value='static/login/style.css'/>"/>
    <link rel="stylesheet" href="<@c.url value='static/css/ace/fonts.css'/>"/>

    <style type="text/css">
        .code {
            /*background: url("static/img/yzm/6.jpg") no-repeat;*/
            width: 80px;
            height: 33px;
            border: none;
            font-family: Arial;
            font-style: italic;
            color: white;
            border: 0;
            margin: 0 2px;
            letter-spacing: 3px;
            font-weight: bolder;
            /* 去掉圆角 */
            -moz-border-radius: 0px;
            -webkit-border-radius: 0px;
            border-radius: 0px;
        }
    </style>

    <style type="text/css">
        a {
            color: #FFFF00;
            text-decoration: none;
        }

        a:hover {
            color: #FFFFFF;
            text-decoration: underline;
        }
    </style>
<#--<#if testType=1>
    <style type="text/css">
        a {
            color: #FF0000;
            text-decoration: none;
        }

        a:hover {
            color: #00CD00;
            text-decoration: underline;
        }
    </style>
</#if>-->

    <script language="javascript" type="text/javascript">
        var code; //在全局 定义验证码
        function createCode() {
            code = "";
            var codeLength = 4;//验证码的长度
            var checkCode = document.getElementById("showCode");
            var selectChar = new Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
            for (var i = 0; i < codeLength; i++) {
                var charIndex = Math.floor(Math.random() * 33);
                code += selectChar[charIndex];
            }

            if (checkCode) {
                var index = Math.floor(Math.random() * 10);
                var img = "url(static/img/yzm/" + index + ".jpg)";
                checkCode.className = "code";
                checkCode.style.backgroundImage = img;
                checkCode.value = code;
            }
            //document.getElementsByName('username')[0].focus();
            $(".username").focus();
        }
    </script>
</head>

<body onload="createCode()" style="height: 100%">
<#--<img src="static/img/m.png" align="left" style="width: 120px;position: relative;left: 8%;top: 80px;"/><br/><br/>-->

<div class="page-container">
    <h1>重型车排放与能耗在线监控平台</h1><br/><br/>
    <small style="color:#FFFF00;font-weight: bold;font-size: 30px;font-family: 隶书;">
    <#if testType=0>新车下线</#if>
    <#if testType=1>新车登记 & 在用汽车</#if>
    <#if testType=3>路检系统</#if>
    </small>
    <form name='form' action="" method="post">
        <font color="black">账 号：</font><input type="text" name="username" maxlength="20" class="username"
                                              placeholder="账号"
                                              value="${(username)!''}"/><br/>
        <font color="black">密 码：</font><input type="password" name="password" maxlength="30" class="password"
                                              placeholder="密码"
                                              value="${(password)!''}"/><br/>

        <div>
            <font color="black">验 证：</font><input type="text" id="code" name="code" maxlength="6" placeholder="验证码"
                                                  style="width:120px;"/>
            <input type="button" id="showCode" readonly="readonly" onclick="createCode()" style="width:100px;"/>
        </div>
        <br/>

        <input type="checkbox" name="rememberMe" value="true" checked="checked" hidden/><br/>
        <button type="button" onclick="login()">立即登陆</button>
        <div class="error" style="display:block"><span>${(error)!''}</span></div>
    </form>
</div>

<div>
    <br/><br/><br/><br/><br/>
<#if testType=0>
    <a href="http://zb.tgour.com:9999/huanbao" target="_blank">重型车排放与能耗在线监控平台</a>&nbsp;&nbsp;
    <a href="http://zb.tgour.com:8090/huanbao" target="_blank">路检服务系统平台</a>
</#if>
<#if testType=1>
    <a href="http://zb.tgour.com:6699/huanbao" target="_blank">新车下线检测平台</a>&nbsp;&nbsp;
    <a href="http://zb.tgour.com:8090/huanbao" target="_blank">路检服务系统平台</a>
</#if>
<#if testType=3>
    <a href="http://zb.tgour.com:6699/huanbao" target="_blank">新车下线检测平台</a>&nbsp;&nbsp;
    <a href="http://zb.tgour.com:9999/huanbao" target="_blank">重型车排放与能耗在线监控平台</a>
</#if>
</div>
<div>
    <#--<img src="static/img/henan.png"
         style="width: 100px;vertical-align:top;position: fixed;left:73%;top:82.5%;"/>-->
    <table align="left" style="vertical-align:top;position: fixed;left:80%;top:86%;">
        <tr>
        <#-- <td rowspan="2"></td>-->
            <td>环境保护产业协会<br/><br/></td>
        </tr>
        <tr>
            <td>机动车污染监测与防治专业委员会</td>
        </tr>
    </table>
</div>

<!-- Javascript -->
<script type="text/javascript" src="<@c.url value='static/js/ace/jquery.min.js' />"></script>
<script type="text/javascript" src="<@c.url value='static/login/supersized.3.2.7.min.js' />"></script>

<#if testType=0>
<script type="text/javascript" src="<@c.url value='static/login/supersized-init0.js' />"></script>
<#elseif testType=1>
<script type="text/javascript" src="<@c.url value='static/login/supersized-init1.js' />"></script>
<#elseif testType=3>
<script type="text/javascript" src="<@c.url value='static/login/supersized-init3.js' />"></script>
</#if>

<script type="text/javascript" src="<@c.url value='static/login/scripts.js' />"></script>

<script type="text/javascript" src="<@c.url value='static/layer-v2.1/layer/layer.js'/>"></script>
</body>
<script>
    var Global = {
        webRoot: "${rc.getContextPath()}"
    };

    $(document).keypress(function (e) {
        if (e.keyCode == 13) {
            login();
        }
    });

    /*$(".password").bind('keydown', function (e) {
        var key = e.which;
        if (key == 13) {
            login();
        }
    });*/

    function login() {
        var form = document.getElementsByName("form")[0];
        var code = $("#code").val().toUpperCase();
        var showCode = $("#showCode").val().toUpperCase();
        if (code == showCode) {
            form.submit();
        } else {
            alert("验证码不对");
        }
    }

</script>
</html>

