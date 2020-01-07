

$(".saveForm").click(function () {
    if (!$(this).parent().parent().myValidate({
            debug: false
        })) {
        return;
    }
    submitData();
});

function submitData() {

    $.ajax({
        type: 'post',
        data: $(".detailForm").mySerialize(),
        url: Global.webRoot + "/system/manage/saveDistrict",
        dataType: 'json',
        success: function (data) {
            if (data.flag) {
                layer.msg(data.msg, {time: 1000}, function () {
                    parent.location.reload();//刷新父窗口
                    closeWindow(true);
                });
            } else {
                layer.alert(data.msg);
            }
        },
        error: function (data) {
            layer.alert(data.msg);
        }
    });
}