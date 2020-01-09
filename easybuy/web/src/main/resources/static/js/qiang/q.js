var id;

function xiugai(code){
	id=code;
	jq("#xiugaidiv");
	jq("#demo").attr("style","display:block;");//显示div
}

function querenbaocun(){
	var row = jq("#baocunid").val();
	jq.ajax({
	      url: '/dingdanqueren',
	      type: 'POST',
	      data:{"id":id,"row":row},
	      error: function(){
	          alert("失败！");
	         },
	      success: function (data) {
	      	
	          jq(".myOrder").html(data);
	          jq("#xiugaidiv").attr("style","display:none;");//隐藏div
	      }
	  });	
}