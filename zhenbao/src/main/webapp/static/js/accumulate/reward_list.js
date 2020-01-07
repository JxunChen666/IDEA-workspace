var testtable;
var sourceCodeMap = {};
$(document).ready(function() {

	$("#btnadd").click(function(){
		myOpenWindow({
			area: ['900px', '700px'],
			title:"新增收益规则",
		    content: Global.webRoot + "/accumulate/addOrModifyReward"
		});
	});
	
	testtable = $('#tableid').myDataTable({
		"sAjaxSource" : Global.webRoot + "/accumulate/allReward.ajax",
		paramSelector:$(".queryform input,.queryform select"),
		"aaSorting": [[6,'desc']],
		"aoColumns" : [  {
			"sTitle" : "标题",
		},{
			"sTitle" : "介绍",
		},{
			"sTitle" : "状态",
		}, {
			"sTitle" : "奖励类型",
		}, {
			"sTitle" : "奖励值",
		}, {
			"sTitle" : "奖励上限",
		}, {
			"sTitle" : "周期",
		}, {
			"sTitle" : "周期增益"
		}, {
			"sTitle" : "连续周期"
		}, {
			"sTitle" : "创建人和时间"
		}, {
			"sTitle" : "更新人和时间"
		}, {
			"sTitle" : "操作",
			fnRender: function(obj) {
				var index=obj.iDataColumn;
				var awardId = obj.aData[index];
				var html = '<a href="javascript:void(0);" onclick="modifyProductInfo(\''+awardId+'\')">编辑</a>';
				return html;
			}
		}]
	});
});

function modifyProductInfo(awardId) {
	myOpenWindow({
		area: ['900px', '700px'],
		title:"修改积分规则",
	    content: Global.webRoot + "/accumulate/addOrModifyReward?id="+awardId
	});
}