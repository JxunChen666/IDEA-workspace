var testtable;
var sourceCodeMap = {};
$(document).ready(function() {
	
	$("#btnquery").click(function(){
		testtable.fnDraw();
	});
	
	$("#btnadd").click(function(){
		myOpenWindow({
			area: ['700px', '550px'],
			title:"新增Banner",
		    content: Global.webRoot + "/accumulate/addOrModifyBanner"
		});
	});
	
	testtable = $('#tableid').myDataTable({
		"sAjaxSource" : Global.webRoot + "/accumulate/allBanner.ajax",
		paramSelector:$(".queryform input,.queryform select"),
		"aaSorting": [[5,'desc']],
		"aoColumns" : [  {
			"sTitle" : "标题",
			"sName" : "title"
		}, {
			"sTitle" : "图片",
			"sName" : "images",
			"bSortable" : false,
			fnRender : function(obj) {
				var index=obj.iDataColumn;
				var url = obj.aData[index];
				var html = '<div style="width:110px;">';
				var imageSRC = "http://" + url;
				html += '&nbsp;&nbsp;<a href=\"' + imageSRC + '\" target="blank"><img src=\"' + imageSRC + '@0o_0l_40w_40q.src\" alt="点击预览" style= "width: 20px; height: 20px; cursor: pointer;text-decoration: none;" title="点击预览"/></a>';
				html += '</div>';
				return html;
			}
		},{
			"sTitle" : "开始时间",
			"sName" : "startTime"
		}, {
			"sTitle" : "结束时间",
			"sName" : "endTime"
		},{
			"sTitle" : "创建时间",
			"sName" : "createTime"
		},{
			"sTitle" : "更新时间",
			"sName" : "updateTime"
		}, {
			"sTitle" : "操作",
			fnRender: function(obj) {
				var index=obj.iDataColumn;
				var bannerId = obj.aData[index];
				var html = '<a style="width:110px;" href=\"'+Global.webRoot + "/accumulate/deleteBanner.ajax?bannerId="+ bannerId +'\" onclick="return confirm(\'删除后无法恢复,确定要删除吗\')">删除</a>' +
				'<a style="width:110px;margin-left:10px" href="javascript:void(0);" onclick="modifyProductInfo('+bannerId+')">编辑</a>' + 
				'<input id=\"'+bannerId+'\" style="display:none"/>';
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
				
				moveProduct(productId, destinationSortNum);
		    },100); 
		}
	});
});

function modifyProductInfo(productId) {

	myOpenWindow({
		area: ['700px', '550px'],
		title:"修改商品",
	    content: Global.webRoot + "/accumulate/addOrModifyBanner?id="+productId
	});
}

function moveProduct(id, desIndex) {

	$.ajax({
		"type" : "post",
		"url" : Global.webRoot + "/accumulate/moveBanner.ajax",
		"data" : {
			"id" : id,
			"destinationPosition":desIndex
		},
		"success" : function(data) {
			if (data.result == "success") {
			} else {
				testtable.fnDraw();
				alert(data.msg);
			}
		},
		"error":function(data) {
			testtable.fnDraw();
			alert("移动商品失败!");
		}
	});
}
