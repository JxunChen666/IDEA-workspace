
$(document).ready(function() {
		var myDropzone = new Dropzone("#dropzone", {
			url:Global.webRoot+"/common/uploadimage",
			method:'post',
		    paramName: "file",
			addRemoveLinks : true,
			uploadMultiple:false,//是否支持上传多张图片
			dictRemoveFile:"删除",
			previewsContainer:'#showhere',
			dictDefaultMessage:"上传",
			dictDefaultMessage :
			'<span class="bigger-150 bolder"><i class="icon-caret-right red"></i> Drop files</span> to upload \
			<span class="smaller-80 grey">(or click)</span> <br /> \
			<i class="upload-icon icon-cloud-upload blue icon-3x"></i>',
			dictResponseError: 'Error while uploading file!',
			init:function(){
				this.on("success", function(file,data) {
					var $element=$(file.previewElement);
					$element.find('.dz-details img').each(function(){
						if(data.result=="fail"){
							$('.dz-success-mark').hide();
							$('.dz-error-mark').css("opacity",1);
							//$(this).attr('src',"")
						}
						$(this).attr('src',data.url);
						$(this).attr('image_name',data.image_name);
					});
	            });
				this.on("maxfilesreached",function(file){
				});
				this.on("thumbnail",function(file,dataUrl){
				});
				this.on("error",function(file,dataUrl){
				});
				},
			//change the previewTemplate to use Bootstrap progress bars
			previewTemplate: "<div class=\"dz-preview dz-file-preview\">\n  <div class=\"dz-details\">\n <div class=\"dz-filename\"><span data-dz-name></span></div>\n  <div class=\"dz-size\" data-dz-size></div>\n<img data-dz-thumbnail name=\"images\" class=\"coreData\"/>\n  </div>\n  <div class=\"progress progress-small progress-striped active\"><div class=\"progress-bar progress-bar-success\" data-dz-uploadprogress></div></div>\n  <div class=\"dz-success-mark\"><span></span></div>\n  <div class=\"dz-error-mark\"><span></span></div>\n  <div class=\"dz-error-message\"><span data-dz-errormessage></span></div>\n</div>",
		});
	$('.dz-remove').click(function(){
		var $removeElement=$(this).parent();
		$removeElement.remove();
	});
	
	
	$(".saveform").click(function(){
		var id = parseInt(bannerId);
		var title = $("#title_input").val();
		var productId = parseInt($("#product_select").val());
		var startTime = $("#startTime_input").val();
		var endTime = $("#endTime_input").val();
		var imageViews = $(this).parent().parent().find('.dz-details img');
		var images = new Array();
		imageViews.each(function(index) {
			var $image = $(imageViews[index]).attr("image_name");
			images.push($image);
		});

		if (!$(this).parent().parent().myValidate({
			debug:false,
			imagesArray:function() {
				if (images.length != 1) {
					return "请上传一张图片";
				} else {
					return true;
				}
			},
		})) {
			return false;
		}
		
		
		if (title.length == 0) {
			layer.alert("请输入标题！");
			return;
		}
		if (productId == null || productId.length == 0) {
			layer.alert("请选择一个关联的商品！");
			return;
		}
		if (images.length == 0) {
			layer.alert("请上传Banner图片！");
			return;
		}
		var imageURL = images[0];
		if (startTime == null || startTime.length == 0) {
			layer.alert("请输入开始日期！");
			return;
		}
		if (endTime == null || endTime.length == 0) {
			layer.alert("请输入结束日期！");
			return;
		}
		var startTimeInDate = new Date(startTime);
		var endTimeInDate = new Date(endTime);
		if (startTimeInDate == null || isNaN(startTimeInDate)) {
			layer.alert("开始日期非法！");
			return;
		}
		if (endTimeInDate == null || isNaN(endTimeInDate)) {
			layer.alert("结束日期非法！");
			return;
		}
		if (new Date().getTime() > endTimeInDate.getTime()) {
			layer.alert("结束日期已经过去！");
			return;
		}
		if (startTimeInDate.getTime() > endTimeInDate.getTime()) {
			layer.alert("开始日期超过结束日期！");
			return;
		}
		
		startTime = startTimeInDate;
		endTime = endTimeInDate;
		var submitPath=null;
		if(bannerId == null){
			submitPath="insertBanner.ajax";
		} else {
			submitPath="modifyBanner.ajax";
		}

		var data = {};
		var properties = ["id", "title", "productId","startTime", "endTime", "imageURL"];
		for (index in properties) {
			var property = properties[index];
			data[property] = eval(property);
		}
		var dataInString = JSON.stringify(data);
		$.ajax({
			async:true,
			type : "post",
			contentType:"application/json",
			url :Global.webRoot + "/accumulate/"+submitPath,
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

