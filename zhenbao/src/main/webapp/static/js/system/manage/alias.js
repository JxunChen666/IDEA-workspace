/**
 * Created by ChenYan on 2020/1/2.
 */

/************************账号管理***********************/


/**
 * 加载省份信息
 */

var aliasTable;
$(document).ready(function () {
    aliasTable = $("#aliasTable").myDataTable({
        "sAjaxSource": Global.webRoot + "/system/manage/getDistrictList",
        paramSelector: $(".queryForm input,.queryForm select"),
        "aaSorting": [[5,'desc']],
            "aoColumns": [{
            "sTitle": "行政区域名称",
            "sName": "disName"
        }, {
            "sTitle": "省份简称",
            "sName": "disSimpleName"
        },{
            "sTitle": "操作",
            "sName": "disId",
            "bSortable": false
        }]
    });

    $("#btnAdd").click(function () {
        myOpenWindow({
            area: ['700px', '300px'],
            title: "添加省份",
            content: Global.webRoot + "/system/manage/toEditDistrict"
        });
    });

});


$("#nameClear").click(function () {
    $("#name").val("");
    aliasTable.fnDraw();
});

$("#phoneClear").click(function () {
    $("#phone").val("");
    aliasTable.fnDraw();
});

$("#btnQuery").click(function () {
    aliasTable.fnDraw();
});

/**
 * 点击编辑省份
 */
$(document).on('click', '.dis_edit_icon', function () {
    var id = $(this).attr("id");
    myOpenWindow({
        area: ['700px', '300px'],
        title: "修改省份信息",
        content: Global.webRoot + "/system/manage/toEditDistrict?id=" + id
    })

});


/**
 * 点击删除省份
 */
$(document).on('click', '.dis_del_icon', function () {
    var id = $(this).attr("id");
    layer.confirm("删除后不能恢复，请慎重！<br/>确认删除吗？", function (isLock) {
        if (isLock) {
            layer.close(isLock);
            $.ajax({
                    type: 'post',
                    data: {"id": id},
                    url: Global.webRoot + "/system/manage/delDistrict",
                    dataType: 'json',
                    success: function (data) {
                        if (data.flag) {
                            layer.msg("删除成功", {time: 1000}, function () {
                                location.href = Global.webRoot + "/system/manage/alias"
                            });
                        } else {
                            layer.alert("删除失败");
                        }
                    }, error: function () {
                        layer.alert("异常");
                    }
                }
            );
        }
    })
});


