<div class="sidebar" id="sidebar">
    <script type="text/javascript">
        try {
            ace.settings.check('sidebar', 'fixed')
        } catch (e) {
        }
    </script>
    <ul class="nav nav-list">

    <#list menus as menu>

        <li <#if basePage.title == '${menu.parent_menu[1]}'>class="active open"</#if>>
            <a href="#" class="dropdown-toggle">
                <i class='${menu.parent_menu[2]}'></i>
                <span class="menu-text"> ${menu.parent_menu[0]} </span>

                <b class="arrow icon-angle-down"></b>
            </a>

            <#--freemarker中迭代Map的写法?keys-->
            <ul class="submenu">
                <#list menu.child_menu?keys as childname>
                    <@shiro.hasPermission name="${menu.child_menu[childname][2]}" >
                        <li <#if basePage.menu == '${menu.child_menu[childname][1]}'>class="active"</#if>>
                            <a href="<@c.url value='${menu.child_menu[childname][0]}'/>">
                                <i class="icon-double-angle-right"></i>
                            ${childname}
                            </a>
                        </li>
                    </@shiro.hasPermission>
                </#list>
            </ul>
        </li>
    </#list>
    </ul>
    <!-- /.nav-list -->

    <div class="sidebar-collapse" id="sidebar-collapse">
        <i class="icon-double-angle-left" data-icon1="icon-double-angle-left"
           data-icon2="icon-double-angle-right"></i>
    </div>

    <script type="text/javascript">

        try {
            ace.settings.check('sidebar', 'collapsed')
        } catch (e) {
        }

        $(".submenu").each(function () {

            if ($(this).find("li").length == 0) {
                $(this).parent().hide();
            } else {
                $(this).parent().show();
            }
        });
    </script>
</div>
