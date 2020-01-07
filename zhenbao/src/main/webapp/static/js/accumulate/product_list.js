var testtable;
var sourceCodeMap = {};
$(document).ready(function() {

	$("#btnquery").click(function(){
		testtable.fnDraw();
	});

	$("#btnadd").click(function(){
		myOpenWindow({
			area: ['900px', '700px'],
			title:"新增商品",
		    content: Global.webRoot + "/accumulate/addOrModifyProduct"
		});
	});

	testtable = $('#tableid').myDataTable({
		"sAjaxSource" : Global.webRoot + "/accumulate/productsByPage.ajax",
		paramSelector:$(".queryform input,.queryform select"),
		"aaSorting": [[6,'desc']],
		"aoColumns" : [  {
			"sTitle" : "商品名",
			"sName" : "id"
		},{
			"sTitle" : "积分额",
			"sName" : "price"
		}, {
			"sTitle" : "图片",
			"sName" : "images",
			"bSortable" : false,
			fnRender : function(obj) {
				var index=obj.iDataColumn;
				var url = obj.aData[index];
				var html = '<div style="width:110px;">';
				for(var i in url){
					html += '&nbsp;&nbsp;<a href="http://' + url[i] + '" target="blank"><img src="http://' + url[i]+
					'@0o_0l_40w_40q.src" alt=""'
					+'style="width: 20px; height: 20px; cursor: pointer;text-decoration: none;" title="点击预览"/></a>';
				}
				html += '</div>';
				return html;
			}
		}, {
			"sTitle" : "库存",
			"sName" : "inventory"
		}, {
			"sTitle" : "销量",
			"sName" : "sales"
		}, {
			"sTitle" : "最近购买时间",
			"sName" : "recentBuyTime"
		}, {
			"sTitle" : "是否上线"
		}, {
			"sTitle" : "是否需物流"
		}, {
			"sTitle" : "开始时间",
			"sName" : "startTime"
		}, {
			"sTitle" : "结束时间",
			"sName" : "endTime"
		}, {
			"sTitle" : "创建时间",
			"sName" : "createTime"
		},{
			"sTitle" : "更新时间",
			"sName" : "updateTime"
		},{
			"sTitle" : "操作",
			fnRender: function(obj) {
				var index=obj.iDataColumn;
				var productId = obj.aData[index];
				var html = '<a style="width:110px;" href=\"'+Global.webRoot + "/accumulate/deleteProduct.ajax?productId="+ productId +'\" onclick="return confirm(\'删除后无法恢复,确定要删除吗\')">删除</a>' +
				'<a style="width:110px;margin-left:5px" href="javascript:void(0);" onclick="modifyProductInfo('+productId+')">编辑</a>' +
				'<a style="width:110px;margin-left:5px" href="javascript:void(0);" onclick="moveProductToPreviousPage('+productId+')">移到上页</a>' +
				'<a style="width:110px;margin-left:5px" href="javascript:void(0);" onclick="moveProductToNextPage('+productId+')">移到下页</a>' +
				'<input id=\"'+productId+'\" style="display:none;"/>';
				return html;
			}
		}]
	});

	//排序相关
	$("#tableid > tbody").sortable({
		update:function(event, ui){

		    setTimeout(function(){

				var destinationIndex = $("#tableid > tbody").children().index(ui.item);
				if (destinationIndex < 0) {
					layer.alert("目标位置非法");
					return;
				}
				var productId = parseInt(ui.item.children().last().find("input").attr("id"));

				var currentPageIndex = parseInt($(".paginate_active").text()) - 1;
				var pageSize = parseInt($("#tableid_length select").val());

				var destinationSortNum = pageSize * currentPageIndex + destinationIndex;

				moveProduct(productId, destinationSortNum, false);
		    },100);
		}
	});
});

function modifyProductInfo(productId) {

	myOpenWindow({
		area: ['900px', '700px'],
		title:"修改商品",
	    content: Global.webRoot + "/accumulate/addOrModifyProduct?productId="+productId
	});
}

function moveProduct(id, desIndex, refreshAfterSuccess) {

	$.ajax({
		"type" : "post",
		"url" : Global.webRoot + "/accumulate/moveProduct.ajax",
		"data" : {
			"productId" : id,
			"destinationPosition":desIndex
		},
		"success" : function(data) {
			if (data.result == "success") {
				if (refreshAfterSuccess) {
					testtable.fnDraw();
				}
			} else {
				testtable.fnDraw();
				alert(data.msg);
			}
		},
		"error":function(data) {
			testtable.fnDraw();
			layer.alert("移动商品失败!");
		}
	});
}

function moveProductToPreviousPage(productId) {
	var currentPageIndex = parseInt($(".paginate_active").text()) - 1;
	var pageSize = parseInt($("#tableid_length select").val());

	if (currentPageIndex == 0) {
		layer.alert("该商品已经位于第一页");
		return;
	}
	var destinationSortNum = pageSize * (currentPageIndex - 1);
	moveProduct(productId, destinationSortNum, true);
}

function moveProductToNextPage(productId) {
	var currentPageIndex = parseInt($(".paginate_active").text()) - 1;
	var currentPageRightElement = $(".paginate_active").next();
	if (currentPageRightElement.hasClass("jumpnum")) {
		layer.alert("该商品已经位于最后一页");
		return;
	}
	var pageSize = parseInt($("#tableid_length select").val());
	var destinationSortNum = pageSize * (currentPageIndex + 1);
	moveProduct(productId, destinationSortNum, true);
}
