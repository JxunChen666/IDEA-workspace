var userTable;
$(document).ready(function () {
    userTable = $("#userTable").myDataTable({
        "sAjaxSource": Global.webRoot + "/huabo/role/getUserByCondition",
        paramSelector: $(".queryForm input,.queryForm select"),
        "aaSorting": [[7, 'desc']],
        "aoColumns": [{
            "sTitle": "用户名",
            "sName": "username"
        }, {
            "sTitle": "检测员",
            "sName": "name"
        }, {
            "sTitle": "电话",
            "sName": "phone"
        }, {
            "sTitle": "电子邮箱",
            "sName": "email"
        }, {
            "sTitle": "紧急电话",
            "sName": "emergency_phone"
        }, {
            "sTitle": "所属角色",
            "sName": "role_ids"
        }, {
            "sTitle": "账号状态",
            "sName": "locked"
        }, {
            "sTitle": "添加时间",
            "sName": "time"
        }, {
            "sTitle": "操作",
            "sName": "id",
            "bSortable": false
        }]
    });

    $("#btnAdd").click(function () {
        myOpenWindow({
            area: ['800px', '500px'],
            title: "添加检测员",
            content: Global.webRoot + "/huabo/role/toEditHuaboUser"
        });
    });
});

$("#nameClear").click(function () {
    $("#name").val("");
    userTable.fnDraw();
});

$("#phoneClear").click(function () {
    $("#phone").val("");
    userTable.fnDraw();
});

$("#btnQuery").click(function () {
    userTable.fnDraw();
});

/**
 * 点击编辑检测员
 */
$(document).on('click', '.u_edit_icon', function () {
    var id = $(this).attr("id");
    myOpenWindow({
        area: ['800px', '380px'],
        title: "修改检测站",
        content: Global.webRoot + "/huabo/role/toEditHuaboUser?id=" + id
    })
});


/**
 * 锁定账号
 */
$(document).on('click', '.u_lock_icon', function () {
    var id = $(this).attr("id");
    layer.confirm("锁定后此检测员不能登录APP，请慎重！<br/>确认锁定此账号？", function (isLock) {
        if (isLock) {
            layer.close(isLock);
            $.ajax({
                    type: 'post',
                    data: {"id": id, "locked": 1},
                    url: Global.webRoot + "/huabo/role/saveHuaboUser",
                    dataType: 'json',
                    success: function (data) {
                        if (data.flag) {
                            layer.msg("锁定账号成功", {time: 1000}, function () {
                                location.href = Global.webRoot + "/huabo/role/testor"
                            });
                        } else {
                            layer.alert("锁定账号失败");
                        }
                    }, error: function () {
                        layer.alert("锁定账号异常");
                        if (error == "parsererror") {
                            Login();
                        }
                    }
                }
            );
        }
    })
});

/**
 * 重置检测员密码
 */
$(document).on('click', '.u_password_icon', function () {
    var id = $(this).attr("id");
    myOpenWindow({
        area: ['800px', '300px'],
        title: "重置密码",
        content: Global.webRoot + "/huabo/role/toResetPassword?id=" + id
    })
});





