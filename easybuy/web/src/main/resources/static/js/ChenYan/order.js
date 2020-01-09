
/*
 * 客服悬浮框
 */
/*---------返回顶部----------*/
$(function() {
	    $(".btn_top").hide();
		$(".btn_top").live("click",function(){
			$('html, body').animate({scrollTop: 0},300);return false;
		});
		$(window).bind('scroll resize',function(){
			if($(window).scrollTop()<=300){
				$(".btn_top").hide();
			}else{
				$(".btn_top").show();
			}
		});
		
		
});
	
/*---------返回顶部 end----------*/




/*
 * 收货地址新增   form非空验证
 */

/*$(function() {
	$("form").submit(function(){
		var i= 0;
		        $("form input").each(function(){
		             var value = $.trim($(this).attr("value"));
		             console.info($(this).attr("name")+": "+value);
		             if(value=='' || value == null){
		              i = 1;
		                 $(this).focus();
		    }
		    
		});  
		      if( i==1 ){
		          return false;
		        }
		        return true;
		     });

});*/


	
   



  



//取消订单
function UpdataOrderStatus(id,status,userid) {
	// 获取 CSRF Token
	  var csrfToken = $("meta[name='_csrf']").attr("content");
	  var csrfHeader = $("meta[name='_csrf_header']").attr("content");
	  
	Notiflix.Confirm.Init(); 
    Notiflix.Confirm.Show( '深情提示', '您敢取消此订单吗?', 'Yes', 'No', function(){ 
   
  $.ajax({
      url: '/upOrderStatus',
      type: 'POST',
      data:{"orderId":id,"status":status,"userId":userid},
      error: function(){
    	  Notiflix.Notify.Failure('你不行！出现异常！');
    	  Notiflix.Report.Failure( 'Notiflix Failure', '"Failure is simply the opportunity to begin again, this time more intelligently." - Henry Ford');
    	  
         },
         beforeSend: function(request) {
   		  request.setRequestHeader(csrfHeader, csrfToken); // 添加  CSRF Token
   	      },
      success: function (data) {
      	
          $(".myOrder").html(data);
          Notiflix.Notify.Success('好吧 算你狠！ 已取消！');
          Notiflix.Report.Success( 'Notiflix Success', '"Do not try to become ..." - Albert Einstein');
      }
  });	
    });
}


//删除订单
function delOrder(id,userid) {
	// 获取 CSRF Token
	var csrfToken = $("meta[name='_csrf']").attr("content");
	var csrfHeader = $("meta[name='_csrf_header']").attr("content");
	Notiflix.Confirm.Init(); 
    Notiflix.Confirm.Show( '深情提示', '您敢删除此订单吗?', 'Yes', 'No', function(){ 
    
  $.ajax({
      url: '/delMyOrder',
      type: 'POST',
      data:{"orderId":id,"userId":userid},
      error: function(){
    	  Notiflix.Notify.Failure('你不行！出现异常！');
    	  Notiflix.Report.Failure( 'Notiflix Failure', '"Failure is simply the opportunity to begin again, this time more intelligently." - Henry Ford');
         },
         beforeSend: function(request) {
   		  request.setRequestHeader(csrfHeader, csrfToken); // 添加  CSRF Token
		 }, 
      success: function (data) {
      	
          $(".myOrder").html(data);
          Notiflix.Notify.Success('好吧 算你狠！ 已删除！');
          Notiflix.Report.Success( 'Notiflix Success', '"Do not try to become ..." - Albert Einstein');
      }
  });	
    });
}


//设置默认收货地址
function defaultAddress(userid,id,da) {	
	// 获取 CSRF Token
    var csrfToken = $("meta[name='_csrf']").attr("content");
    var csrfHeader = $("meta[name='_csrf_header']").attr("content");
    
	Notiflix.Confirm.Init(); 
    Notiflix.Confirm.Show( '深情提示', '您敢设置为默认吗?', 'Yes', 'No', function(){ 	   	     
	    $.ajax({
    	    url: '/defaultAddress',
    	    type: 'POST',
    	    data:{"userid":userid,"id":id,"da":da},
    	    error: function(){
    	    	Notiflix.Notify.Failure('你不行！出现异常！');
    	    	Notiflix.Report.Failure( 'Notiflix Failure', '"Failure is simply the opportunity to begin again, this time more intelligently." - Henry Ford');
    	       },  
    	       beforeSend: function(request) {
    	    		  request.setRequestHeader(csrfHeader, csrfToken); // 添加  CSRF Token
    	    	   },
    	    success: function (data) {
    	    	var userid=$('.getUserId').val();
    	    	if(data.isUpDe==true){
    	    		var url="generalRefreshAddress?userid="+userid+"";
    	  	        $('.ajaxAddress').load(url);
    	    	   Notiflix.Notify.Success('好吧 算你狠！');
    	    	   Notiflix.Report.Success( 'Notiflix Success', '"Do not try to become ..." - Albert Einstein');
    	    	}
    	       
    	     }
    	 });	
	    
	      });  
        
 }

//删除地址
function delAddress(id) {	
	// 获取 CSRF Token
    var csrfToken = $("meta[name='_csrf']").attr("content");
    var csrfHeader = $("meta[name='_csrf_header']").attr("content");
	
	Notiflix.Confirm.Init(); 
    Notiflix.Confirm.Show( '深情提示', '您敢删除此地址吗?', 'Yes', 'No', function(){ 	   	 
        
	    $.ajax({
    	    url: '/delAddress',
    	    type: 'POST',
    	    data:{"id":id},
    	    error: function(){
    	    	Notiflix.Notify.Failure('你不行！出现异常！');
    	    	Notiflix.Report.Failure( 'Notiflix Failure', '"Failure is simply the opportunity to begin again, this time more intelligently." - Henry Ford');
    	       },
    	       beforeSend: function(request) {
           		  request.setRequestHeader(csrfHeader, csrfToken); // 添加  CSRF Token
        		 }, 
    	    success: function (data) {
    	    	var userid=$('.getUserId').val();
    	    	if(data.isDel==true){
    	        var url="generalRefreshAddress?userid="+userid+"";
	  	        $('.ajaxAddress').load(url);
    	        Notiflix.Notify.Success('好吧 算你狠！已删除！');
    	        Notiflix.Report.Success( 'Notiflix Success', '"Do not try to become ..." - Albert Einstein');
    	    	}
    	     }
    	 });	
	    
	      });  
        
 }

	


//修改地址
function upAddress() {
	// 获取 CSRF Token
    var csrfToken = $("meta[name='_csrf']").attr("content");
    var csrfHeader = $("meta[name='_csrf_header']").attr("content");
    
	Notiflix.Confirm.Init(); 
	var formData = new FormData($("#upform")[0]); 
	  $.ajax({
	  	    url: '/updateAddress',
	  	    type: 'POST',
	  	    dataType: "JSON",
	  	    data: formData,
	  	    processData: false,
	        contentType: false,
	  	    error: function(){
	  	    	Notiflix.Notify.Failure('你不行！出现异常！');
	  	    	Notiflix.Report.Failure( 'Notiflix Failure', '"Failure is simply the opportunity to begin again, this time more intelligently." - Henry Ford');
	  	       },
	  	     beforeSend: function(request) {
	  	   		  request.setRequestHeader(csrfHeader, csrfToken); // 添加  CSRF Token
	  	   	      },
	  	    success: function (data) {
	  	    	var isUp=data.isUp;	  	    	
	  	    	var userid=$('.getUserId').val();
	  	    		  	       
	  	        if(isUp==true){
	  	        	
	  	        	var url="generalRefreshAddress?userid="+userid+"";
	  	        	$('.ajaxAddress').load(url);
	  	        	/*window.location.reload();*/	  
	  	        	Notiflix.Notify.Success('好吧 算你狠！已修改！');
		        	Notiflix.Report.Success( 'Notiflix Success', '"Do not try to become ..." - Albert Einstein');
	  	        }
	  	        
	  	       
	  	     }
	  	 });	
}
	





//新增地址
function insertAddress() {
	// 获取 CSRF Token
    var csrfToken = $("meta[name='_csrf']").attr("content");
    var csrfHeader = $("meta[name='_csrf_header']").attr("content");
    
	Notiflix.Confirm.Init(); 
	var formData = new FormData($("#addform")[0]); 
	
	  $.ajax({
	  	    url: '/addMyAddress',
	  	    type: 'POST',
	  	    dataType: "JSON",
	  	    data: formData,
	  	    processData: false,
	        contentType: false,
	  	    error: function(){
	  	    	Notiflix.Notify.Failure('你不行！出现异常！');
	  	    	Notiflix.Report.Failure( 'Notiflix Failure', '"Failure is simply the opportunity to begin again, this time more intelligently." - Henry Ford');
	  	       },
	  	     beforeSend: function(request) {
	  	   		  request.setRequestHeader(csrfHeader, csrfToken); // 添加  CSRF Token
	  	   	      },
	  	    success: function (data) {
	  	    	var isAdd=data.isAdd;	  	    	
	  	    	var userid=$('.getUserId').val();
	  	    	  	       
	  	        if(isAdd==true){
	  	        	
	  	        	var url="generalRefreshAddress?userid="+userid+"";
	  	        	$('.ajaxAddress').load(url);
	  	        	/*window.location.reload();*/	  	        
	  	        	 Notiflix.Notify.Success('好吧 算你狠！已修改！');
	 	        	Notiflix.Report.Success( 'Notiflix Success', '"Do not try to become ..." - Albert Einstein');
	  	        }
	  	       
	  	       
	  	     }
	  	 });	
}



function jumpPage(pageNo){
    	
	var pageNo=$('#pageNo').val(pageNo);

	$('#pageForm').submit();
}







