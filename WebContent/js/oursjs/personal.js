/**
 * 获得我的车位的分页显示按钮 和现实第一页的数据
 */
var totalPageO=1;
function fenyeparking(){
	var $personalId = $("#personalId").text();
	$("#myParkingTable tr:gt(0)").remove()
	$("#zuoyouyema").children().remove()
	$.ajax({
		   type: "POST",
		   url: "/CBDParkingMSs/personal/fenyeparking",
		   data:{personalId:$personalId}, 
		   success: function(d){	
			   totalPageO=d
			   var $firstPage=$("<li><a href='javascript:void(0)' class='pagebtton' value='jian'>&laquo;</a></li>")
		       $("#zuoyouyema").append($firstPage)
		       for(var i=1;i<=d;i++){
		    	   var $button=$("<li><a href='javascript:void(0)'  class='pagebtton' value='"+i+"'>"+i+"</a></li>");
		    	   $("#zuoyouyema").append($button)
		       } 
			   var $lasrPage=$("<li><a href='javascript:void(0)' class='pagebtton' value='add'>&raquo;</a></li>")
		       $("#zuoyouyema").append($lasrPage)
		     
		       $.ajax({
		   		type:"POST",
		   		url:"/CBDParkingMSs/personal/myparking",                                        
		   		data:{"personalId":$personalId,"button":1},
		   	    success:function(data){
		   	    	for(var i=0;i<data.length;i++){
		   	    		var $imformation=$("<tr><td>"+data[i].parkingId+
		   	    				"</td><td>"+data[i].parkingAddress+
		   	    				"</td><td>"+data[i].parkingNo+
		   	    				"</td><td>"+data[i].propertyNo+
		   	    				"</td><td><a href='/CBDParkingMSs/personal/delmyparking/"+data[i].parkingId+"'>删除</a></td></tr>");
		   	    				$("#myParkingTable").append($imformation)
		   	    	}
		   	    }
		   		
		   	})
		   }
		});
}

/**
 * 我的车位 点击页码 显示点击页码的数据
 */
var currentpageO=1;
$(".pagebtton").live("click",function(){
	
	var $buttnval=$(this).attr("value")
//	alert($(this).text())
//	alert($buttnval)
	if($buttnval=="add"){
		$buttnval=currentpageO+1;
		if($buttnval>totalPageO){
			$buttnval=totalPageO;
		}
	}else if($buttnval=="jian"){
		$buttnval=currentpageO-1;
		if($buttnval<1){
			$buttnval=1
		}
	}
	var $personalId = $("#personalId").text();
	$("#myParkingTable tr:gt(0)").remove()
	$.ajax({
		type:"POST",
		url:"/CBDParkingMSs/personal/myparking",
		data:{"personalId":$personalId,"button":$buttnval},
	    success:function(data){
	    	for(var i=0;i<data.length;i++){
	    		var $imformation=$("<tr><td>"+data[i].parkingId+
	    				"</td><td>"+data[i].parkingAddress+
	    				"</td><td>"+data[i].parkingNo+
	    				"</td><td>"+data[i].propertyNo+
	    				"</td><td><a href='/CBDParkingMSs/personal/delmyparking/"+data[i].parkingId+"'>删除</a></td></tr>");
	    				$("#myParkingTable").append($imformation)
	    	} 
	    }
		
	})
	
})
/**
 * 页面2 
 * 我要抢车位的 页码按钮生成和显示第一页的数据
 */
var totalPageOne=1;
function qiuzufun(){
	$("#zuoyouyemaone").children().remove()
	$.ajax({
		   type: "POST",
		   url: "/CBDParkingMSs/personal/qiangfenyeparking",
		   success: function(d){	
			   totalPageOne=d
			   var $firstPage=$("<li><a href='javascript:void(0)' class='pagebttonone' value='jian'>&laquo;</a></li>")
		       $("#zuoyouyemaone").append($firstPage)
		       for(var i=1;i<=d;i++){
		    	   var $button=$("<li><a href='javascript:void(0)'  class='pagebttonone' value='"+i+"'>"+i+"</a></li>");
		    	   $("#zuoyouyemaone").append($button)
		       } 
			   var $lasrPage=$("<li><a href='javascript:void(0)' class='pagebttonone' value='add'>&raquo;</a></li>")
		       $("#zuoyouyemaone").append($lasrPage)
		       $.ajax({
		type:"POST",
		url:"/CBDParkingMSs/personal/qiangfenyeparkingxianshi",
		data:{"button":1},
	    success:function(data){
	    	for(var i=0;i<data.length;i++){
	    		var $imformation=$("<tr><td>"+data[i].parking.parkingId+
	    				"</td><td>"+data[i].parking.parkingAddress+
	    				"</td><td>"+data[i].startTime+
	    				"</td><td>"+data[i].endTime+
	    				"</td><td>"+data[i].parking.personal.personalRealName+
	    				"</td><td>"+data[i].parking.personal.personalJob+
	    				"</td><td>"+data[i].parking.personal.tenantReputation+
	    				"</td><td>"+data[i].price+
	    				"</td><td><a href='/CBDParkingMSs/personal/del/"+data[i].parkingNo+"'>预定</a></td></tr>");
	    				$("#qiangcheweitab").append($imformation)
	    	} 
	    }
	})
		   }
	})
}
var currentpageOne=1;
$(".pagebttonone").live("click",function(){
	$("#qiangcheweitab tr:gt(0)").remove()
	alert($(this).text())
	var $buttnval=$(this).attr("value")
	if($buttnval=="add"){
		$buttnval=currentpageOne+1;
		if($buttnval>totalPageOne){
			$buttnval=totalPageOne;
		}
	}else if($buttnval=="jian"){
		$buttnval=currentpageOne-1;
		if($buttnval<1){
			$buttnval=1
		}
	}
	$.ajax({
		type:"POST",
		url:"/CBDParkingMSs/personal/qiangfenyeparkingxianshi",
		data:{"button":$buttnval},
	    success:function(data){
	    	for(var i=0;i<data.length;i++){
	    		var $imformation=$("<tr><td>"+data[i].parking.parkingId+
	    				"</td><td>"+data[i].parking.parkingAddress+
	    				"</td><td>"+data[i].startTime+
	    				"</td><td>"+data[i].endTime+
	    				"</td><td>"+data[i].parking.personal.personalRealName+
	    				"</td><td>"+data[i].parking.personal.personalJob+
	    				"</td><td>"+data[i].parking.personal.tenantReputation+
	    				"</td><td>"+data[i].price+
	    				"</td><td><a href='/CBDParkingMSs/personal/del/"+data[i].parkingNo+"'>删除</a></td></tr>");
	    				$("#qiangcheweitab").append($imformation)
	    	} 
	    }
		
	})
	
})

/**
 * 增加一个车位申请
 */
$("#addParking").live("click",function(){
	var $personalId = $("#personalId").text();
	
})
$("#shengqing").live("click",function(){
	var $personalId = $("#personalId").text();
	var $parkingpropertyNo=$("#parkingpropertyNo").val()
	var $parkingAddress=$("#parkingAddress").val()
	var $parkingNo=$("#parkingNo").val()
	var $parkingpicture=$("#parkingpicture").val()
	var personal=new Personal($personalId)
	var parking=new Parking($parkingpropertyNo,$parkingpicture,$parkingAddress,$parkingNo,personal)
alert($.toJSON(parking))
	$.ajax({
		   type: "POST",
		   url: "/CBDParkingMSs/personal/addparking",
		   data:$.toJSON(parking),
		   contentType:"application/json"
		});
})



function Parking(propertyNo,parkingPicture,parkingAddress,parkingNo,personal){
	this.propertyNo=propertyNo;
	this.parkingPicture=parkingPicture;
	this.parkingAddress=parkingAddress;
	this.parkingNo=parkingNo;
	this.personal=personal;
}
function Personal(personalId){
	    this.personalId=personalId
	    
}





/*
 * jx
 * --------------------------------------------------------------------------------------------------------
*/

/**
 * 动态加载当前有效待租信息分页
 *totalpage 分页总数
 */
 	var totalpage=1;
   function fenye(){
	   $(".parkingMes").css("display","block")
	   $("#fbtn").children().remove()
		$.ajax({
			   type: "POST",
			   url: "/CBDParkingMS/personal/pkfy",
			   success: function(data){
				   var d = eval(data);
				   totalpage=d;
                   var $start="<li><a href='javascript:void(0)' class='pmfbtn' value='cut'>&laquo;</a></li>"
                     $("#fbtn").append($start)
			       for(var i=1;i<=d;i++){
			    	   var $btn=$("<li><a href='javascript:void(0)' class='pmfbtn' value='"+i+"'>"+i+"</a></li>");
			    	   $("#fbtn").append($btn)
			                          }
			      var $end="<li><a href='javascript:void(0)' class='pmfbtn' value='add'>&raquo;</a></li>"
			      $("#fbtn").append($end)
			      $.ajax({
					 type:"post",
					 url:"/CBDParkingMS/personal/gmpm",
					 data:{"pageBtn":1},
					 dataType:"json",
					 success:function(data){
						var list=eval(data);
						for(var i=0;i<list.length;i++){
						      var $a=$("<tr><td>"+list[i].parkingMsgId+
									"</td><td>"+list[i].parking.parkingAddress+
									"</td><td>"+list[i].startTime+
									"</td><td>"+list[i].endTime+
									"</td><td><button class='btn btn-info infoBtn'>详情</button></td></tr>")
									$("#pmes").append($a);
						           }
						     	}
			            });
			      }
			});
      }
/**
 * 点击当前有效待租信息页数显示分页信息
 *currentpage当前页数
 */
 	var currentpage=1;
   $(".pmfbtn").live("click",function(){
	    var $btn=$(this).attr("value");
	    if($btn=="add"){
	    	$btn=currentpage+1;
	    	if($btn>totalpage){
	    		$btn=totalpage;
	    	}
	    }else if($btn=="cut"){
	    	$btn=currentpage-1;
	    	if($btn<1){
	    		$btn=1;
	    	}
	    }
	    currentpage=$btn;
	    $("#pmes tr:gt(0)").remove();
	    $.ajax({
			type:"post",
			url:"/CBDParkingMS/personal/gmpm",
			data:{"pageBtn":$btn},
			dataType:"json",
			success:function(data){
				var list=eval(data);
				for(var i=0;i<list.length;i++){
				var $a=$("<tr><td>"+list[i].parkingMsgId+
						"</td><td>"+list[i].parking.parkingAddress+
						"</td><td>"+list[i].startTime+
						"</td><td>"+list[i].endTime+
						"</td><td><button class='btn btn-info infoBtn'>详情</button></td></tr>")
						$("#pmes").append($a);
			           }
			     	}
			
             });
       })


/**
 * 
 * WLJ
 * ------------------------------------------------------------------------------------------------------
 */   
       
       
        function fenyeJilu(){
	  $.ajax({
		  type:"post",
		  url:"/CBDParkingMS/personal/tentfenye",
		  success:function	(data){
			  alert(data)
			  var d = eval(data);
		var $leftbtn=$("<li><a href='#'>&laquo;</a></li>")
		  $("#tentfenyeul").append($leftbtn)
			  for(var i=1;i<=d;i++){
				  var $tentfenyebtn=$("<li><a href='#'   class='yema'>"+i+"</a></li>");
				  $("#tentfenyeul").append($tentfenyebtn)
			  }
			var $rightbtn= $("<li><a href='#'>&raquo;</a></li>");
			 $("#tentfenyeul").append($rightbtn)
		  }
	  })
  } 
   
   $(".yema").live("click",function(){
	   alert("哈哈")
		var $btnval=$(this).text();
		  $.ajax({
			  type:"post",
			  url:"/CBDParkingMS/personal/tentJilu",
			  data:{"btnval":btnval},
		  	success:function(data){
		  		alert(data)
		  	   	for(var i=1;i<data.length;i++){
		    		var $info=$("<tr><td>"+data[i].parkingMsgId+
		    				"</td><td>"+data[i].parking.parkingNo+
		    				"</td><td>"+data[i].startTime+
		    				"</td><td>"+data[i].endTime+
		    				"</td><td>"+data[i].personalName+
		    				"</td></tr>");
		    				$("#Jilutable").append($info)
		    	}
		  }
		  })
	  }) 
       
	  
	   function checkPwd(){
      var pwdInput=document.getElementById("pwd");
      var pwd=pwdInput.value;
      var pwdMessage=pwdInput.nextSibling;
      if(pwd.length==0){
          pwdMessage.innerHTML="密码不能为空"
          return false;
      }else{
          pwdMessage.innerHTML="OK"
          return true;
      }
  }
  
  function checkPwd1(){
      var pwdInput=document.getElementById("pwd1");
      var pwd1=pwdInput.value;
      var pwd1Message=pwdInput.nextSibling;
      if(pwd1.length==0){
    	  pwd1Message.innerHTML="密码不能为空"
          return false;
      }else  if(pwd!=pwd1){
    	  pwd1Message.innerHTML="两次密码不一致"
      }else{
    	  pwd1Message.innerHTML="OK"
          return true;
      } 
  }
  
  function checkPhone(){
      var pwdInput=document.getElementById("phone");
      var phone=pwdInput.value;
      var phoneMessage=pwdInput.nextSibling;
      var reg= /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/
      if(pwd1.length==0){
    	  phoneMessage.innerHTML="电话号码不能为空"
          return false;
      }else if(!reg.test(phone)){
    	  phoneMessage.innerHTML="电话号码格式不正确"
      }
     else{
    	 phoneMessage.innerHTML="OK"
          return true;
      } 
  }
  
  function checkAddress(){
      var addressInput=document.getElementById("address");
      var address=pwdInput.value;
      var addressMessage=pwdInput.nextSibling;
      var reg= /[\u4e00-\u9fa5]/
      if(address.length==0){
    	  addressMessage.innerHTML="地址不能为空"
          return false;
      }else if(!reg.test(address)){
    	  addressMessage.innerHTML="地址格式不正确"
      }
     else{
    	 addressMessage.innerHTML="OK"
          return true;
      } 
  }
  
  function checkJob(){
      var jobInput=document.getElementById("job");
      var job=pwdInput.value;
      var jobMessage=pwdInput.nextSibling;
      var reg= /[\u4e00-\u9fa5]/
      if(job.length==0){
    	  jobMessage.innerHTML="职位描述不能为空"
          return false;
      }else if(!reg.test(job)){
    	  jobMessage.innerHTML="职位描述格式不正确"
      }
     else{
    	 jobMessage.innerHTML="OK"
          return true;
      } 
  }
  function check(){
      return checkPwd1()&&checkPwd()&&checkPhone()&&checkAddress()&&checkJob();
  }

