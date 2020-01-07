<@layer />
<div class="navbar navbar-default" id="navbar">

    <div class="navbar-container" id="navbar-container">
        <div class="navbar-header pull-left">
            <font color=#FFFFFF style="font-size:16px;font-family: 'Microsoft YaHei'">
                <a href="#" class="navbar-brand">
                <small>
                    <i class="icon-flag"></i>
                ${menus[0].title_menu}
                </small>
                </a><!-- /.brand -->
                <label style="width:300px"></label>
                <span style="line-height:40px;height:40px">今天是：
                    <script language="JavaScript">
                        today = new Date();
                        function initArray() {
                            this.length = initArray.arguments.length;
                            for (var i = 0; i < this.length; i++)
                                this[i + 1] = initArray.arguments[i];
                        }
                        var d = new initArray(" 星期日", " 星期一", " 星期二", " 星期三", " 星期四", " 星期五", " 星期六");
                        document.write(today.getFullYear(), "年",
                                today.getMonth() + 1, "月",
                                today.getDate(), "日",
                                d[today.getDay() + 1]);
                    </script>
                    <label style="width:100px"></label>北京时间：</span></font><label id="time"></label><label style="width:100px"></label>
                    <#--<iframe allowtransparency="true" frameborder="0" width="500" height="20" scrolling="no" src="//tianqi.eastday.com/plugin/widget_v1.html?sc=3&z=1&t=0&v=0&d=3&bd=0&k=000000&f=ffffff&q=0&a=1&c=54511&w=500&h=20&align=center"></iframe>-->
                    <#--<iframe id="weather" allowtransparency="true" frameborder="0" width="500" height="20" scrolling="no" src="http://tianqi.2345.com/plugin/widget/index.htm?s=3&z=1&t=0&v=0&d=3&bd=0&k=000000&f=ffffff&q=1&e=1&a=1&c=54511&w=500&h=20&align=center"></iframe>-->
        </div>
        <!-- /.navbar-header -->

        <div class="pull-right navbar-header" role="navigation">
            <font color=#ffffff style="font-size:14px;font-family: 'Microsoft YaHei'">
                <ul class="nav ace-nav">

                    <li class="light-blue">
                        <a href="<@c.url value='/'/>">
                            <i class="icon-home"></i>主页
                        </a>
                    </li>
                <#--<li class="light-blue">
                    <a href="javascript:editUserAppRel();">
                                                                       微信公众号信息
                    </a>
                </li>-->
                    <li class="light-blue pull-right">
                        <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                            <img class="nav-user-photo" src="../../static/img/avatar.png" alt="" />
								<span class="user-info">
									<small>欢迎您</small>
                                <#if user??>${user.name!''}</#if>
								</span>

                            <i class="icon-caret-down"></i>
                        </a>

                        <ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">

                            <li>
                                <a href="#" id="userEdit">
                                    <i class="icon-user"></i>
                                    用户设置
                                </a>
                            </li>

                            <li class="divider"></li>

                            <li>
                                <a href="<@c.url value='/logout'/>">
                                    <i class="icon-off"></i>
                                    退出登录
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </font>
            <!-- /.ace-nav -->
        </div>
        <!-- /.navbar-header -->
    </div>
    <!-- /.container -->

    <script type="text/javascript">
        $(document).ready(function () {
            setInterval(function () {
                $("#time").html("<font color=#ffffff style=\"font-size:16px;font-family: 'Microsoft YaHei'\">" + (new Date()).toTimeString().substring(0, 8) + "</font>")}, 1000);
        });
        /***两种写法对比***/
        /*window.onload = function(){
            setInterval(function(){
              document.getElementById("time").innerHTML ="<font color=#ffffff style=\"font-size:16px;font-family: 'Microsoft YaHei'\">"+(new Date()).toTimeString().substring(0,8)+"</font>"}, 1000);
        };*/
    </script>

    <script type="text/javascript">
        try {
            ace.settings.check('navbar', 'fixed')
        } catch (e) {
        }
        $('#userEdit').click(function () {
            myOpenWindow({
                title: "编辑用户",
                content: Global.webRoot + "/system/user/editPasswordLayer.ajax",
            });
        });

        //弹出微信公众号信息编辑页面
        /* function editUserAppRel(){
             myOpenWindow({
                 title:"编辑微信公众号信息",
                 content: Global.webRoot + "/system/userAppRel/editUserAppRelLayer.ajax",
             });
         }*/
    </script>
</div>
