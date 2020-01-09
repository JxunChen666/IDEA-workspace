
jq(document).ready(function(){

	jq('#buycarul').click(function(){
		jq('#thbuycar').load("/selectMycar");
	});
		
	
	
	
/*
	jq('#buycarul').hover(
			function () {
			     
		      	// 获取 CSRF Token
		      	var csrfToken = jq("meta[name='_csrf']").attr("content");
		        var csrfHeader = jq("meta[name='_csrf_header']").attr("content");
		        
		       // var q= jq('#common_top0').html();
		      //  alert(q);
		        jq('#thbuycar').load("/selectMycar");
		      
		      //  alert("加载完成");
		      
				jq.ajax({
			            url:"/selectMycar",
			            cache:false,        //这里
			            ifModified :true , //这里
			            type:'post',
			            dataType: 'json',
			            contentType: 'application/json',
			            data:JSON.stringify(),
			            //CSRF 
			            beforeSend: function(request) {
		              		  request.setRequestHeader(csrfHeader, csrfToken); // 添加  CSRF Token
		           		 }, 
			            success:function(data){
			            	
			            	jq('#common_top0').load();
			            	jq('#buycarul').load();
			            }
			        });
	
				//　var date = new Date();//获取当前日期时间
					
			
			//	
			//	alert("aaaa");
				jq('ul', this).slideDown(200);
			//	alert("aaaa");
			//	jq('#common_top0').load("/selectMycar?aaa="+new Date());
				}, 
			function () {jq('ul', this).slideUp(200);

		});
		
	*/	
		
		
});
