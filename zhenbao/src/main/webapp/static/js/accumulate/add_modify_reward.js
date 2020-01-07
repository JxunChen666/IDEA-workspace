
$(document).ready(function() {
	
	$(".saveform").click(function(){
		if (!$(this).parent().parent().myValidate(function(){
			return {
				debug:false
			};
		})) {
			return false;
		};
		var id = awardId;
		var name = $("#title_input").val();
		var description = $("#desciption_input").val();
		var indexInString = $("#index_input").val();
		var index = parseInt(indexInString);
		var reward_typeInString = $("#type_input").val();
		var reward_type = parseInt(reward_typeInString);
		var rewardStr = $("#reward_input").val();
		var reward = parseInt(rewardStr);
		var reward_limitStr = $("#rewardlimit_input").val();
		var reward_limit = parseInt(reward_limitStr);
		var periodStr = $("#period_input").val();
		var period = parseInt(periodStr);
		var period_reward_increamentStr = $("#period_reward").val();
		var period_reward_increament = parseInt( period_reward_increamentStr);
		var period_reward_limitStr = $("#period_limit").val();
		var period_reward_limit = parseInt(period_reward_limitStr);

		if (name == null && name.length == 0) {
			layer.alert("请输入标题！");
			return;
		}
		if (indexInString == null && indexInString.length == 0) {
			layer.alert("请输入索引值描述！");
			return;
		}
		if (index < 0) {
			layer.alert("索引大于0！");
			return;
		}
		if (rewardStr == null && rewardStr.length == 0) {
			layer.alert("请输入描述！");
			return;
		}
		if (reward_typeInString == null && reward_typeInString.length == 0) {
			layer.alert("请输入收益类型！");
			return;
		}
		if (isNaN(reward_type)) {
			layer.alert("收益类型是非法数字！");
			return;
		}
		if (rewardStr.length == 0) {
			layer.alert("请输入收益！");
			return;
		}
		if (isNaN(reward)) {
			layer.alert("收益是非法数字！");
			return;
		}
		if (reward_limitStr == null && reward_limitStr.length == 0) {
			layer.alert("请输入收益限制！");
			return;
		}
		if (isNaN(reward_limit)) {
			layer.alert("收益限制是非法数字！");
			return;
		}
		if (periodStr == null && periodStr.length == 0) {
			layer.alert("请输入周期！");
			return;
		}
		if (isNaN(period)) {
			layer.alert("周期是非法数字！");
			return;
		}
		if (period_reward_increamentStr.length == 0) {
			layer.alert("请输入周期收益！");
			return;
		}
		if (isNaN(period_reward_increament)) {
			layer.alert("周期收益是非法数字！");
			return;
		}
		if (period_reward_limitStr == null && period_reward_limitStr.length == 0) {
			layer.alert("请输入周期收益限制！");
			return;
		}
		if (isNaN(period_reward_limit)) {
			layer.alert("周期收益限制是非法数字！");
			return;
		}
		if (reward < 0) {
			layer.alert("收益必须大于等于零!");
			return;
		}
		if (reward_limit < 0) {
			layer.alert("收益限制必须大于等于零!");
			return;
		}
		if (reward_limit < reward) {
			layer.alert("收益限制必须大于收益!");
			return;
		}
		if (period < 0) {
			layer.alert("周期必须大于零!");
			return;
		}
		if (period_reward_increament < 0) {
			layer.alert("周期收益不能小于零!");
			return;
		}
		if (period_reward_limit < 0) {
			layer.alert("周期收益限制不能小于零!");
			return;
		}
		
		var data = {};
		var properties = ["id","name","description","index","reward", "reward_type","reward_limit", "period", "period_reward_increament", 
		                "period_reward_limit", "status"];
		for (i in properties) {
			var property = properties[i];
			data[property] = eval(property);
		}
		var dataInString = JSON.stringify(data);
		$.ajax({
			async:true,
			type : "post",
			contentType:"application/json",
			url :Global.webRoot + ((id==null)?"/accumulate/insertReward.ajax":"/accumulate/modifyReward.ajax"),
			data:dataInString,
			success:function(data){
				if(data.result=="success"){
					parent.testtable.fnDraw();
					closeWindow(true);
				}else{
					layer.alert(data.msg);
				}
			},
			error:function(data) {
				layer.alert("无法保存商品");
			}
		})
	});
});

