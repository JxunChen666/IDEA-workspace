var questionTable;
$(document).ready(function () {
    questionTable = $("#questionTable").myDataTable({
        "sAjaxSource": Global.webRoot + "/system/manage/getQuestionList",
        paramSelector: $(".queryForm input,.queryForm select"),
        "aaSorting": [[5, 'desc']],
        "aoColumns": [{
            "sTitle": "反馈问题",
            "sName": "queInfo"
        }, {
            "sTitle": "反馈时间",
            "sName": "quePosttime"
        }, {
            "sTitle": "联系方式",
            "sName": "linkStyle"
        },{
            "sTitle": "操作",
            "sName": "queId",
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
    questionTable.fnDraw();
});

$("#phoneClear").click(function () {
    $("#phone").val("");
    questionTable.fnDraw();
});

$("#btnQuery").click(function () {
    var quePosttime=$("#quePosttime").val();
    if(quePosttime.length==19){
        questionTable.fnDraw();
    }else{
        layer.alert("请输入19位完整的日期");
        return false;
    }

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





