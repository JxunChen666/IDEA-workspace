$(document).ready(function () {
    $(".saveForm").click(function () {
        if (!$(this).parent().parent().myValidate({
                debug: false
            })) {
            return;
        }

        var id = $("#id").val();
        var password = $("#password").val();
        var rePassword = $("#rePassword").val();
        if (password != rePassword) {
            layer.alert("两次输入的密码不一致")
            return false;
        } else {
            $.ajax({
                type: 'post',
                /*data: {"id": id, "password": password},*/
                data: $(this).parent().parent().mySerialize(),
                url: Global.webRoot + "/huabo/role/resetPassword",
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
    });

});