$(document).ready(function(){
//	alert('okkk');
	var $userType = $("#userType").text();
	alert($userType);
	if($userType==0){
		$("#superManager").css("display","block");
	}else{
		$("#superManager").css("display","none");
	}
});