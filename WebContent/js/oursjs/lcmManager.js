

function fun(){
	$.ajax({
		type:"post",
		url:"/CBDParkingMS/manager/findManagerByUserId",
		dataType:"json",
		success:function(data){
			var manager=eval(data);
			var list=manager.power;
			for(var i=0;i<list.length;i++){
				$("#powerName").val(list[i].powerName);
			}
		}
	})
}

$("#updateManagerInfoBtn").bind("click",function(){
	var userPassword=$("#newuserPassword").val();
	var managerPhone=$("#managerPhone").val();
	
	$.ajax({
		type:"post",
		url:"/CBDParkingMS/manager/updateManagerInfo",
		data:{userPassword:userPassword,managerPhone:managerPhone},
		dataType:"json",
		success : function(data) {
			
		}
		
	})
})
