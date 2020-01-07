
$(document).ready(function() {
	//如果需要物流信息，则把订单切换到发货状态时显示货运信息
	if (needExpress) {
		$("#status_select").change(function(d){
			var value = parseInt($("#status_select").val());
			if (value > 0) {
				$("#express_info_div").css("display", "block");
			} else {
				$("#express_info_div").css("display", "none");
			}
		});
	}
	
	$("#savebutton").click(function(){
		var objectStatus = parseInt($("#status_select").val());
		var expressInfo = null;
		if (needExpress) {
			expressInfo = $(".expressArea").val();
		}
		
		if (expressInfo != null && expressInfo.length == 0) {
			expressInfo = null;
		}
		$.ajax({
			async:true,
			type : "post",
			url :Global.webRoot + "/accumulate/modifyOrder.ajax",
			data:{
				orderId:orderId,
				status:objectStatus,
				expressInfo:expressInfo
			},
			success:function(data){
				if(data.result=="success"){
					parent.testtable.fnDraw();
					closeWindow(true);
				}else{
					layer.alert(data.msg);
				}
			},
			error:function(data) {
				layer.alert("无法保存订单");
			}
		})
	});
});

