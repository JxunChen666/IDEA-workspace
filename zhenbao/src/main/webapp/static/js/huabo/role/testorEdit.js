$(document).ready(function () {
    var id = $("#id").val();
    if (id != null && id.length > 0) {
        $("#username").attr("readonly", "readonly");
        $(".remove").attr("style", "display:none");
    }
});

$(".saveForm").click(function () {
    if (!$(this).parent().parent().myValidate({
            debug: false
        })) {
        return;
    }
    submitData();
});

function submitData() {
    var id = $("#id").val();
    if (id == null || id.length == 0) {
        var password = $("#password").val();
        var rePassword = $("#rePassword").val();
        if (password != rePassword) {
            layer.alert("两次输入的密码不一致")
            return false;
        }
    }

    $.ajax({
        type: 'post',
        data: $(".detailForm").mySerialize(),
        url: Global.webRoot + "/huabo/role/saveHuaboUser",
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