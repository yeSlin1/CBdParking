
function show() {
	$("table tr:gt(0)").remove();
	var company = $("#companyId").text()
	$.ajax({
		url : "/CBDParkingMS/company/findAllCBDParking",
		data : {
			"companyId" : company
		},
		success : function(data) {
			var $JBDParkings = eval(data);
			for (var i = 0; i < $JBDParkings.length; i++) {
				//alert($JBDParkings.length)
				if ($JBDParkings[i].contract.length > 0) {
					for (var j = 0; j < $JBDParkings[i].contract.length; j++) {
						var $CBDParkingResult = $("<tr><td>"
								+ $JBDParkings[i].company.companyId
								+ "</td><td>"
								+ $JBDParkings[i].company.companyAddress
								+ "</td><td>" + $JBDParkings[i].cbdNo
								+ "</td><td>"
								+ $JBDParkings[i].contract[j].contractNo
								+ "</td><td>"
								+ $JBDParkings[i].contract[j].contractStart
								+ "</td><td>"
								+ $JBDParkings[i].contract[j].contractEnd
								+ "</td></tr>");
						$('#chewei').append($CBDParkingResult);
					}
				} else {
					var $CBDParkingResult = $("<tr><td> $JBDParkings[i].company.companyId </td><td>"
							+ $JBDParkings[i].company.companyAddress
							+ "</td><td>" + $JBDParkings[i].cbdNo
							+ "</td><td>空" + "</td><td>空</td><td>空</td></tr>");
					$('#chewei').append($CBDParkingResult);
				}

			}
		}
	})
}

// 通过企业ID查询空闲车位（未签约的）
function kongxianCBDParking() {
	$("table tr:gt(0)").remove();
	var company = $("#companyId").text()
	$.ajax({
		url : "/CBDParkingMS/company/kongxianCBDParking",
		data : {
			"companyId" : company
		},
		success : function(data) {
			var $JBDParkings = eval(data);
			for (var i = 0; i < $JBDParkings.length; i++) {

				var $CBDParkingResult = $("<tr><td>"
						+ $JBDParkings[i].cbdId + "</td><td>需修改数据库</td><td>"
						+ $JBDParkings[i].cbdNo + "</td><td>未签约"
						+ "</td><td>未签约</td><td>未签约</td></tr>");
				$('#chewei').append($CBDParkingResult);
			}
		}
	})
	
	$.ajax({
		url : "/CBDParkingMS/company/kongxianAllCBDParking",
		data : {
			"companyId" : company
		},
		success : function(data) {
			var $allpage = eval(data);
			alert($allpage)
			
			var $shouyepage= $("<li><a href='#'>&laquo;</a></li>")
			$('#kongxianpage').append($shouyepage);
			for (var i = 0; i < $allpage; i++) {
				alert("zhangsan")
				var $page= $("<li><a href='#'>"+(i+1)+"</a></li>")
								
				$('#kongxianpage').append($page);
			}
			var $weiyepage= $("<li><a href='#'>&raquo;</a></li>")
			$('#kongxianpage').append($weiyepage);
		}
	})
	
}








//已出租的车位
function contractCBDParking() {
	$("table tr:gt(0)").remove();
	var company = $("#companyId").text()
	$.ajax({
		url : "/CBDParkingMS/company/contractCBDParking",
		data : {
			"companyId" : company
		},
		success : function(data) {
			var $Contracts = eval(data);
			alert($Contracts.cbdparking)
			for (var i = 0; i < $Contracts.length; i++) {				
					for (var j = 0; j < $Contracts[i].cbdparking.length; j++) {
						alert($Contracts.length)
						var $CBDParkingResult = $("<tr><td>"
								+ $Contracts[i].cbdparking.cbdId + "</td></tr>");
						$('#chewei').append($CBDParkingResult);
					}
					}
				

			
		}
	})
}
