var testtable;
var sourceCodeMap = {};
$(document).ready(function() {
	
	$("#btnquery").click(function(){
		testtable.fnDraw();
	});
	$(".status_query").change(function(d){
		testtable.fnDraw();
	});
	
	testtable = $('#tableid').myDataTable({
		"sAjaxSource" : Global.webRoot + "/accumulate/orderByPage.ajax",
		paramSelector:$(".status_query"),
		"aaSorting": [[6,'desc']],
		"aoColumns" : [  {
			"sTitle" : "ID",
			"sName" : "id",
			"bSortable" : false,
			fnRender : function(obj) {
				var index=obj.iDataColumn;
				var id = obj.aData[0];
				var html = '<a onclick="showInfo(this)" href="#" style="display:block">'+id+'</a>';
				return html;
			}
		},{
			"sTitle" : "用户",
			"sName" : "id",
			"bSortable" : false,
		},{
			"sTitle" : "价格",
			"sName" : "id",
			"bSortable" : false,
		}, {
			"sTitle" : "商品标题",
			"sName" : "id",
			"bSortable" : false
		}, {
			"sTitle" : "下单时间",
			"sName" : "orderTime"
		}, {
			"sTitle" : "电话",
			"sName" : "id",
			"bSortable" : false
		}, {
			"sTitle" : "物流信息",
			"sName" : "id",
			"bSortable" : false
		}, {
			"sTitle" : "订单操作员",
			"sName" : "id",
			"bSortable" : false
		}, {
			"sTitle" : "订单状态",
			"sName" : "id",
			"bSortable" : false
		}]
	});
	
});

function modifyProductInfo(productId) {

	myOpenWindow({
		area: ['660px', '510px'],
		title:"修改商品",
	    content: Global.webRoot + "/accumulate/addOrModifyProduct?productId="+productId
	});
}

function showInfo(obj) {
	var id = $(obj).text();
	myOpenWindow({
		area: ['560px', '610px'],
		title:"修改商品",
	    content: Global.webRoot + "/accumulate/modifyOrder?orderId="+id
	});
}
